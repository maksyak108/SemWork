<!DOCTYPE html>
<html lang="en">
<head>
    <title>Main Page</title>
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
<div style="color: white;
position: absolute;
            top: 20%;
            left: auto;
            padding: 10px;">
    <#list book as b>
        <p><img width="100" height="100" src="bookPng.png"></p>
        Автор:
        <a>${b.author}</a>
        <br>
        Название:
        <a>${b.name}</a>
        <br>
        Жанр:
        <a>${b.ganre}</a>
        <br>
        Описание:
        <a>${b.description}</a>
        <br>
    </#list>
</div>

</body>
</html>