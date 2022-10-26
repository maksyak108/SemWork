<!DOCTYPE html>
<html lang="en">
<title>Profile</title>
<#include "background.ftl">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<style>
    #real-estates-detail #author img {
        -webkit-border-radius: 100%;
        -moz-border-radius: 100%;
        -ms-border-radius: 100%;
        -o-border-radius: 100%;
        border-radius: 100%;
        border: 5px solid #ecf0f1;
        margin-bottom: 10px;
    }
    #real-estates-detail .sosmed-author i.fa {
        width: 30px;
        height: 30px;
        border: 2px solid #bdc3c7;
        color: #bdc3c7;
        padding-top: 6px;
        margin-top: 10px;
    }
    #real-estates-detail .slides li img {
        height: 450px;
    }
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
    .btn {
        display: block;
        width: 100%;
        padding: 8px 10px;

        border: 0;
        background-color: grey;
        cursor: pointer;

        font-family: inherit;
        font-size: 16px;
        color: #fff;
    }

    .btn:hover {
        background-color: black;
    }
</style>

<ul class="menu-bar">
    <li><a href="/mainPage">Главная</a></li>
    <li><a href="/whatToRead">Что почитать</a></li>
    <li><a href="/genre">Жанры</a></li>
    <li><a href="/forKids">Для детей</a></li>
    <li><a href="/search">Поиск</a></li>
    <li><a href="/logout">Выйти</a></li>
</ul>

<div class="container" style="color: white;
            position: absolute;
            top: 20%;
            left: 100px;
            padding: 10px;">
    <div id="main">
        <div class="row" id="real-estates-detail">
            <div class="col-lg-4 col-md-4 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center" id="author">
                            <img src="user.png" width="200" height="200">
                            <h3>${client.name}</h3>
                            <p>${client.email}</p>
                            Your id:
                            <p>${client.id}</p>
                            <p class="sosmed-author">
                            <form><button class="btn" type="submit" formaction="\review.html">Оставить отзыв на прочитанную книгу</button></form>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="color: white;
            position: absolute;
            top: 20%;
            right: 400px;
            padding: 10px;">
    Ваши отзывы:
    <br>
    <#list review as r>
        Название книги:
        <a>${r.book_name}</a>
        <br>
        Отзыв:
        <a>${r.review}</a>
        <br>
        Оценка:
        <a>${r.score}</a>
        <br>
        <br>
    </#list>
</div>