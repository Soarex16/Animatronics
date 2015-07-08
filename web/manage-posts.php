<?php
$title='Animatronica';
include_once('header.php');
if(!USER_LOGGED) die();

$news_ids= News::getAllNews(0,News::getCountNews());
if(DEBUG)var_dump($news_ids);
if (isset($_GET['delete']) && isset($_GET['post'])){
    News::deleteNews($_GET['post']);
    header('Location: manage-posts.php');
}

?>
    <!-- Main -->
    <article id="main">
        <header>
            <h2>List of all posts</h2>
        </header>
        <div>
            <section class="wrapper style5">
                <div class="inner">
                    <section class="table-wrapper">
                        <table class="alt">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Thread</th>
                                    <th>Date</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                            <?php
                               foreach($news_ids as $key=>$value){
                                    $news = new News();
                                    $news->loadNews($key);
                                    echo <<<HTML
                                    <tr>
                                        <td>{$news->getId()}</td>
                                        <td>{$news->getTheme()}</td>
                                        <td>{$news->getData()}</td>
                                        <td>
                                            <a href="/new-post.php?post={$news->getId()}&edit=true" class="button fit icon fa-edit">Edit</a>
                                            <a href="?delete=true&post={$news->getId()}" class="button fit icon fa-trash">Delete</a></td>
                                    </tr>
HTML;
                                }
                            ?>
                            </tbody>
                        </table>
                    </section>
                </div>
            </section>
        </div>
    </article>

<?php include_once('footer.php');?>
