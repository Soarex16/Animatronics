<?php
$title='Animatronica';
include_once('header.php');
?>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>Administration panel</h2>
        <?php
            if(USER_LOGGED) {
                if(!check_user($UserID)) logout();
            ?>
        </header>
        <!--bla bla bla admin panel-->
        <section class="wrapper style4">
            <div class="inner">
                <h1>Yes, it's the admin panel. Yes, it is empty</h1>
                <table class="table-wrapper alt">
                    <tr>
                        <td><a href="about.html">About</a></td>
                    </tr>
                    <tr>
                        <td><a href="download.html">Downloads</a></td>
                    </tr>
                    <tr>
                        <td><a href="elements.html">Elements</a></td>
                    </tr>
                    <tr>
                        <td><a href="generic.html">Generic</a></td>
                    </tr>
                    <tr>
                        <td><a href="projects.html">Projects</a></td>
                    </tr>
                    <tr>
                        <td>
                            <a href="news.php">News</a>
                            <a href="new-post.php">Create new post</a>
                            <a href="manage-posts.php">Manage posts</a>
                        </td>
                    </tr>
                </table>
            </div>
        </section>
    </article>
    <?php
    }
    else { ?>
        <p>Only for site administrators</p>
        <?php
    }
    ?>
<?php include_once('footer.php');?>