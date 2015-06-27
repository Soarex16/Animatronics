<?php
// Определение констант
define('DEBUG', !true);
define('ROOT_DIR',dirname(__FILE__));

define('DBUSER', 'shumaff');
//define('DBUSER', 'root');
define('DBPASSWD', "Fghh3fpTTn70");
//define('DBPASSWD', "9087263341");
define('DBDBNAME', "animatronica");
define('DBHOST', "localhost");
define('DBCHARSET', 'cp1251');
define('PREFIX', "");

// Подключение классов
include_once("./protected/lib/godb.php");
include_once("./protected/news.php");
// отладка
if (defined('DEBUG') && DEBUG === true) {
    error_reporting(E_ALL & ~E_STRICT);
    ini_set('display_errors', true);
    ini_set('display_startup_errors', true);
} else {
    ini_set('display_errors', false);
    ini_set('display_startup_errors', false);
}

// Переменные
$DB = new goDB(array(
    'host' => DBHOST,
    'username' => DBUSER,
    'passwd' => DBPASSWD,
    'dbname' => DBDBNAME,
    'prefix' => PREFIX,
    'charset' => DBCHARSET
));