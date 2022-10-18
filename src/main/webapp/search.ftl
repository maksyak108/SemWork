<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Search Page</title>
    <meta charset="UTF-8">
    <style>
        body {
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        .menu-bar {
            border-radius: 25px;
            height: -webkit-fit-content;
            height: -moz-fit-content;
            height: fit-content;
            display: inline-flex;
            background-color: rgba(0, 0, 0, 0.4);
            -webkit-backdrop-filter: blur(10px);
            backdrop-filter: blur(10px);
            align-items: center;
            padding: 0 10px;
            margin: 50px 0 0 0;
        }
        .menu-bar li {
            list-style: none;
            color: white;
            font-family: sans-serif;
            font-weight: bold;
            padding: 12px 16px;
            margin: 0 8px;
            position: relative;
            cursor: pointer;
            white-space: nowrap;
        }
        .menu-bar li::before {
            content: " ";
            position: absolute;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            z-index: -1;
            transition: 0.2s;
            border-radius: 25px;
        }
        .menu-bar li:hover {
            color: black;
        }
        .menu-bar li:hover::before {
            background: linear-gradient(to bottom, #e8edec, #d2d1d3);
            box-shadow: 0px 3px 20px 0px black;
            transform: scale(1.2);
        }
        .background{
            background-size: cover;
            background-position: center center;
            background-attachment: fixed;

        }
        body {
            margin: 0;
            padding: 0;

        }
        .search-box {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            height: 40px;
            border-radius: 40px;
            padding: 10px;
        }
        .search-box:hover > .search-txt {
            width: 240px;
            padding: 0 6px;
        }
        .search-box:hover > .search-btn {
            background: white;
            color: black;
        }
        .search-btn {
            color: #eeeeee;
            float: right;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background: #2f3640;
            display: flex;
            justify-content: center;
            align-items: center;
            transition: 0.4s;
            color: white;
            cursor: pointer;
            text-decoration:none;
        }
        .search-btn > i {
            font-size: 20px;
        }
        .search-txt {
            border: none;
            background: none;
            outline: none;
            float: left;
            padding: 0;
            color: white;
            font-size: 16px;
            transition: 0.4s;
            line-height: 40px;
            width: 0px;
            font-weight: bold;
        }

    </style>
</head>
<body class="background" background="книги.jpeg">

<ul class="menu-bar">
    <li><a href="/mainPage">Главная</a></li>
    <li><a href="/whatToRead">Что почитать</a></li>
    <li><a href="genre.html">Жанры</a></li>
    <li><a href="/forKids">Для детей</a></li>
    <li><a href="/search">Поиск</a></li>
    <li><a href="main.jsp">Профиль</a></li>
</ul>

<form class="form" action="search" method="post">
<div class="search-box">
    <input type="text" name="name" class="search-txt" placeholder="Введите название"/>
    <button class="btn" type="submit" style="border-radius: 30px">
    <a class="search-btn" href="#">
        <i class="fa fa-search" aria-hidden="true"></i>
    </a>
    </button>
    <br>
    Автор:
    <a>${book.author}</a>
    <br>
    Название:
    <a>${book.name}</a>
    <br>
    Жанр:
    <a>${book.ganre}</a>
    <br>
    Описание:
    <a>${book.description}</a>
</div>
</form>

</body>
</html>