<?php
session_start();
include_once("./conf.php");
include('uni-auth.php');
if(!isset($keyword))$keyword='';
if(!isset($description))$description='';
if(!isset($title))$title='';
if(!isset($body))$body='';
?>
<!DOCTYPE HTML>

<html>
<head>
    <title><?php echo $title;?></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="<?php echo $description;?>"/>
    <meta name="keywords" content="<?php echo $keyword;?>"/>
    <link rel="icon" href="images/misc/favicon.ico" sizes="32x32">

    <link rel="stylesheet" href="css/style.css"/>
</head>
<body class ="<?php echo $body;?>">

<!-- Page Wrapper -->
<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="index.php">Animatronica</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="#" class="menuToggle"><span>Menu</span></a>

                    <div id="menu">
                        <ul class="icon">
                            <?php
                            if (USER_LOGGED) {
                                if (!check_user($UserID)) logout();
                                ?>
                                <li>Hi, <?php echo $UserName; ?>! | Your ID: <?php echo $UserID; ?></li>
                                <li><a href="?logout" class="actions button fit"> Log out</a></li>
                                <li><a href="admin-panel.php" class="icon fa-cogs"> Admin panel</a></li>
                            <?php
                            } else {
                                ?>
                                <li>Hi, guest!</li>
                                <li><a href="auth.php" class="actions button fit"> Log in</a></li>
                            <?php
                            }
                            ?>
                            <li><a href="/index.php" class="icon fa-home"> Home</a></li>
                            <li><a href="/news.php" class="icon fa-newspaper-o"> News</a></li>
                            <li><a href="/about.php" class="icon fa-star"> About</a></li>
                            <li><a href="/projects.php" class="icon fa-terminal"> Projects</a></li>
                            <li><a href="/download.php" class="icon fa-download"> Downloads</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </header>