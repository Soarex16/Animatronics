<?php
define('SID',session_id());

function logout() {
    unset($_SESSION['uid']);
}
function login($username,$password) {
    global $DB;
    $hash=md5($password);
    //$hash=$password;
    $USER = $DB->query(
        "SELECT * FROM {users} WHERE `username`=? AND `password`=?;",
        array($username,$hash),
        "rowassoc"
    );
    if(!empty($USER)) {
        $_SESSION = array_merge($_SESSION,$USER);
        $_SESSION['sid']=SID;
        $DB->query("UPDATE {users} SET `sid`=? WHERE `uid`=?i;",array(SID,$USER['uid']));
        return true;
    }
    else {
        return false;
    }
}
function check_user($uid) {
    global $DB;
    $sid = $DB->query(
        "SELECT `sid` FROM {users} WHERE `uid`=?i;",
        array($uid),
        "el"
    );
    return $sid===SID;
}

##Действия - если пользователь авторизирован
if(isset($_SESSION['uid'])) { //Если была произведена авторизация, то в сессии есть uid
    //Константу удобно проверять в любом месте скрипта
    define('USER_LOGGED',true);
    //Создаём удобные переменные
    //Все поля таблицы пользователей записываются в сесси (см. стр. 35-37)
    //Таким образом, после добавления нового поля в таблицу надо дописть лишь одну строку
    $UserName = $_SESSION['username'];
    $UserPass = $_SESSION['password'];
    $UserID   = $_SESSION['uid'];
}
else {
    define('USER_LOGGED',false);
    $UserName = '';
    $UserPass = '';
    $UserID   = '';
}

##Действия при попытке входа
if (isset($_POST['user'])) {
    if(get_magic_quotes_gpc()) { //Если слеши автоматически добавляются
        $_POST['user']=stripslashes($_POST['user']);
        $_POST['pass']=stripslashes($_POST['pass']);
    }
    $user = $_POST['user'];
    $pass = $_POST['pass'];
    if(login($user,$pass)) {
        header('Location: index.php');
        die();
    }
    else {
        header('Refresh: 3');
        die('Incorrect password!');
    }

}

##Действия при попытке выхода
if(isset($_GET['logout'])) {
    logout();
}
