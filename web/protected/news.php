<?php

class News
{
    private static $db;
    public static $countNewsOnPage = 5;

    /**
     * @return goDB
     */
    static private function getDB()
    {
        if (empty(static::$db)) {
            static::$db = new goDB(array(
                'host' => DBHOST,
                'username' => DBUSER,
                'passwd' => DBPASSWD,
                'dbname' => DBDBNAME,
                'prefix' => PREFIX,
                'charset' => DBCHARSET
            ));;
        }
        return static::$db;
    }

    static public function getAllNews($offset = 0, $count = 5)
    {
        $news = static::getDB()->query("SELECT id FROM {news} ORDER BY id DESC LIMIT ?i,?i", array($offset*$count, $count), "vars");
        return $news;
    }

    static public function getCountNews()
    {
        $news = static::getDB()->query("SELECT id FROM {news}", array(), "num");
        return $news;
    }

    static public function getPageNews($page)
    {
        return static::getAllNews($page * static::$countNewsOnPage, static::$countNewsOnPage);
    }

    static public function getPagesCount()
    {
        return 1 + (int)(static::getCountNews() / static::$countNewsOnPage);
    }

    public function createNews($theme, $post, $load = false)
    {
        $news = static::getDB()->query(
            "INSERT INTO {news} (thread,post,date) VALUES (?,?,?)",
            array($theme, $post, date("Y-m-d \\A\\T H:i")),
            "id");
        return $this->loadNews($news);
    }

    public function editNews($theme, $post)
    {
        $this->theme = $theme;
        $this->post = $post;
        return $this;
    }

    public function saveNews()
    {
        $news = static::getDB()->query(
            " UPDATE {news} SET thread=?, post=? WHERE id =?i ",
            array($this->theme, $this->post, $this->id),
            "id"
        );
        return $this->loadNews($news);
    }

    public static function deleteNews($id)
    {
        static::getDB()->query("DELETE FROM {news} WHERE id = ?i", array($id), 'ar');
    }

    /**
     * @param $id
     * @return $this|bool
     */
    public function loadNews($id)
    {
        $news = static::getDB()->query("SELECT * FROM {news} WHERE  id = ?", array($id), "rowassoc");
        if (!$news) return false;
        $this->theme = $news['thread'];
        $this->post = $news['post'];
        $this->data = $news['date'];
        $this->id = $news['id'];
        return $this;
    }

    private $theme;
    private $post;
    private $data;
    private $id;

    public function getTheme()
    {
        return $this->theme;
    }

    public function getPost()
    {
        return $this->post;
    }

    public function getData()
    {
        return $this->data;
    }

    public function getId()
    {
        return $this->id;
    }
}