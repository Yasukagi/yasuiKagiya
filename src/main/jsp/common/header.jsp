<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安鍵.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="安い鍵屋を紹介します">

    <script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<header id="header" role="banner">
    <div class="top-logo-pane">
        <a href="/">安鍵.com</a>
    </div>
    <div class="top-menu-pane">
        <nav class="top-menu-nav">
            <ul role="">
                <li>
                    <a href="/">ホーム</a>
                </li>
                <li>
                    <a href="/register_store">鍵屋を知る</a>
                </li>
            </ul>
        </nav>
        <form class="top-menu-search" action="/search" method="get" role="search">
            <input type="search" placeholder="ゲームを検索" name="q" autocomplete="off">
            <button type="submit">検索</button>
        </form>
    </div>
</header>