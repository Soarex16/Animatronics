<?php
$title='Animatronica';
include_once('header.php');
if(!USER_LOGGED) die();

if (isset($_POST['post-title']) && isset($_POST['post-text']) && !isset($_GET['edit'])) {
    $theme = $_POST['post-title'];
    $post = $_POST['post-text'];
    $news = new News();
    $news->createNews($theme, $post, true);
}
if (isset($_GET['post'])) {
    if (isset($_GET['edit']) && isset($_POST['post-title']) && isset($_POST['post-text'])) {
        $news = new News();
        $news->loadNews($_GET['post'])->editNews($_POST['post-title'],$_POST['post-text'])->saveNews();
        header('Location: manage-posts.php');
    } else {
        $news = new News();
        $news->loadNews($_GET['post']);
    }
}
?>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>Create new post</h2>
        </header>
        <div>
            <section class="wrapper style5">
                <div class="inner">
                    <section>
                        <form method="post" action="#">
                            <div class="row uniform">
                                <p class="align-center">You may use all HTML-tags and attributes</p>

                                <div class="12u$">
                                    <input type="text" name="post-title" id="post-title"
                                           value="<?php echo isset($news) ? $news->getTheme() : '' ?>" placeholder="Title"/>
                                </div>
                                <div class="12u$">
                                    <textarea name="post-text" id="post-text" placeholder="Enter your post"
                                              rows="8"><?php echo isset($news) ? $news->getPost() : '' ?></textarea>
                                </div>
                                <div class="12u$">
                                    <ul class="actions">
                                        <li><input type="submit" value="Save post" class="special"/></li>
                                        <li><input type="reset" value="Reset"/></li>
                                    </ul>
                                </div>
                            </div>
                        </form>
                    </section>
                </div>
            </section>
        </div>
    </article>

<?php include_once('footer.php');?>