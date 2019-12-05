<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. User: user Date: 2019/11/28 Time: 2:12 오후 To
change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

    <title>던파.GG</title>
    <style>
        .character {
            display: inline-block;
            text-align: center;

        }
        .footer {
            background-color: #f5f5f5;
            position:fixed;
            left:0px;
            bottom:0px;
            width: inherit;
            text-align: center;
        }
        .content {
            margin-bottom: 120px;
        }
        .main-search {
            margin-top: 5%;
            margin-bottom: 5%;
        }

        .search-form {
            display: inline-block;
        }

        .btn-primary a {
            color: white;
            text-decoration: none;
        }

        .btn-write {
            margin-block-end: 1rem;
        }

        .character-view {
            font-weight: bold;
        }

        .loader {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="main container">
    <nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="#">던파.GG</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/">메인으로</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board">커뮤니티</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/member/register">회원가입</a>
                </li>
            </ul>

        </div>
    </nav>


