<?php
$title='Animatronica';
include_once('header.php');
?>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>Log in</h2>
            <p>Only for site administrators</p>
        </header>
        <div style="width: 100%; text-align: center;">
            <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" style="width: 18em; margin: 0.4em auto;">
                <div>
                    <div class="12u 12u$(xsmall)" style="margin: 2% 0%;">
                        <input type="text" name="user" id="usr-login" value="" placeholder="Login">
                    </div>
                    <div class="12u 12u$(xsmall)" style="margin: 2% 0%;">
                        <input type="password" name="pass" id="usr-pass" value="" placeholder="Password">
                    </div>
                    <div>
                        <ul class="actions align-center">
                            <li><input type="submit" value="Login" /></li>
                            <li><input type="reset" value="Reset" /></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </article>

<?php include_once('footer.php');?>