<?php
$title='Animatronica';
include_once('header.php');
$page = isset($_GET['page']) ? (int)$_GET['page'] : 0;
$news_ids = News::getAllNews($page, News::$countNewsOnPage);
$pages = News::getPagesCount();
$pageOnPage = 2;
$i = ($page - $pageOnPage) > 0 ? $page - $pageOnPage : 0;
$_pages = ($i + $pageOnPage + 2) < $pages ? ($i + $pageOnPage + 2) : $pages;
//echo $page."/".$pages."-".$i."-".$_pages;
?>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>News</h2>

            <p>Here are all the news of our development team</p>
        </header>
        <div>
            <section class="wrapper style5">
                <div class="inner">
                    <section>
                        <section>
                            <?php
                            foreach ($news_ids as $key => $value) {
                                $news = new News();
                                $news->loadNews($key);
                                echo <<<HTML
                            <div id={$news->getId()}>
                               <h4>{$news->getTheme()}</h4>
                               <div>{$news->getPost()}</div>
                               <h6 class="align-right">Posted {$news->getData()}</h6>
                            </div>
                            <hr />
HTML;
                            }
                            ?>
                            <div id="page-buttons" class="align-center">
                                <?php
                                if ($pages > 1) {

                                    if ($page > 0) {
                                        $page_prev = $page - 1;
                                        echo "<a href='?page={$page_prev}' class='button'>Prev</a>\n";
                                    }
                                    for (; $i < $_pages; $i++) {
                                        if ($i == $page) {
                                            echo "<a class='button special'>{$i}</a>\n";
                                        } else {
                                            echo "<a href='?page={$i}' class='button'>{$i}</a>\n";
                                        }
                                    }
                                    if ($page < $pages-1) {
                                        $page_next = $page + 1;
                                        echo "<a href='?page={$page_next}' class='button'>Next</a>\n";
                                    }
                                }
                                ?>
                            </div>
                        </section>
                    </section>
                </div>
            </section>
        </div>
    </article>
<?php include_once('footer.php'); ?>