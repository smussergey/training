<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>


<html>
<head>
    <title>
        <fmt:message key="games.game.new.page.title"/>
    </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
        <%@ include file="/main.css" %>
    </style>
</head>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">--%>

<%--<head>--%>
<%--    <title th:text="#{games.game.new.page.title}"></title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>--%>
<%--    <link rel="stylesheet" type="text/css" href="../css/main.css" th:href="@{/css/main.css}">--%>
<%--</head>--%>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1 th:text="#{text.header}"></h1>
</div>

<%--<nav id="nav" class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">--%>
<%--    <button--%>
<%--            class="navbar-toggler"--%>
<%--            type="button"--%>
<%--            data-toggle="collapse"--%>
<%--            data-target="#collapsibleNavbar"--%>
<%--    >--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
<%--    <div class="collapse navbar-collapse" id="collapsibleNavbar">--%>
<%--        <!-- Links -->--%>

<%--        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">--%>
<%--            <li class="nav-item">--%>
<%--                <a th:text="#{navbar.link.home.page}" class="nav-link" th:href="@{/referee/home}"></a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" th:href="@{/referee/games/statistics}" th:text="#{navbar.link.games.statistics}"></a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--        <ul class="navbar-nav my-2 my-lg-0">--%>
<%--            <li class="nav-item"--%>
<%--                th:if="${lang.equals('en')}">--%>
<%--                <a class="nav-link" th:text="#{navbar.link.ua}" href="?lang=ua"></a>--%>
<%--            </li>--%>
<%--            <li class="nav-item"--%>
<%--                th:if="${lang.equals('ua')}">--%>
<%--                <a class="nav-link" th:text="#{navbar.link.en}" href="?lang=en"></a>--%>
<%--            </li>--%>
<%--            <li class="nav-item nav-link"--%>
<%--                th:text="#{navbar.text.you.logined.as}"></li>--%>
<%--            <li class="nav-item nav-link"--%>
<%--                th:if="${lang.equals('en')}"--%>
<%--                th:text="${userNameEn}">--%>
<%--            </li>--%>
<%--            <li class="nav-item nav-link"--%>
<%--                th:if="${lang.equals('ua')}"--%>
<%--                th:text="${userNameUa}">--%>
<%--            </li>--%>

<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" th:href="@{/logout}" th:text="#{navbar.text.logout}"></a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>
<nav id="nav" class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#collapsibleNavbar"
    >
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <!-- Links -->

        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <%--                <a class="nav-link" th:href="@{/referee/games/new}" th:text="#{navbar.link.games.new}"></a>--%>
                <a class="nav-link" href="${pageContext.request.contextPath}/referee/mainReferee">
                    <fmt:message key="navbar.link.games.new"/>
                </a>
            </li>
            <li class="nav-item">
                <%--                <a class="nav-link" th:href="@{/referee/games/statistics}"--%>
                <%--                   th:text="#{navbar.link.games.statistics}"></a>--%>
                <a class="nav-link" href="${pageContext.request.contextPath}/referee/gamesStatistics">
                    <fmt:message key="navbar.link.games.statistics"/>
                </a>
            </li>
            <li class="nav-item">
                <%--                <a class="nav-link" th:href="@{/referee/history/consideration}"--%>
                <%--                   th:text="#{navbar.link.history.consideration}"></a>--%>
                <a class="nav-link" href="${pageContext.request.contextPath}/referee/historyConsideration">
                    <fmt:message key="navbar.link.history.consideration"/>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav my-2 my-lg-0">
            <li class="nav-item">
                <%--                            th:if="${lang.equals('en')}">--%>
                <a class="nav-link" href="?lang=ua">
                    <fmt:message key="navbar.link.ua"/>
                </a>
            </li>
            <li class="nav-item">
                <%--                            th:if="${lang.equals('ua')}">--%>
                <a class="nav-link" href="?lang=en">
                    <fmt:message key="navbar.link.en"/>
                </a>
            </li>
            <%--            <li class="nav-item nav-link"--%>
            <%--                th:text="#{navbar.text.you.logined.as}"></li>--%>
            <%--            <li class="nav-item nav-link"--%>
            <%--                th:if="${lang.equals('en')}"--%>
            <%--                th:text="${userNameEn}">--%>
            <%--            </li>--%>
            <%--            <li class="nav-item nav-link"--%>
            <%--                th:if="${lang.equals('ua')}"--%>
            <%--                th:text="${userNameUa}">--%>
            <%--            </li>--%>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">
                    <fmt:message key="navbar.text.logout"/>
                </a>
            </li>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" th:href="@{/logout}" th:text="#{navbar.text.logout}"></a>--%>
            <%--            </li>--%>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:30px">
    <%--    <h2 class="panel-title" th:text="#{new.game.form.header}">--%>
    <h2 class="panel-title">
        <fmt:message key="new.game.form.header"/>
    </h2>
    <form action="${pageContext.request.contextPath}/referee/runNewGame"
          method="post">

        <div class="custom-control mb-3">
            <label for="player">
                <fmt:message key="games.new.game.team.label"/>
            </label>
            <select class="custom-select mb-3" id="player" th:name="playerid">
                <%--                <option th:if="${lang.equals('en')}"--%>
                <%--                        th:each="player : ${players}"--%>
                <%--                        th:value="${player.id}" th:text="${player.nameEn}">--%>
                <%--                </option>--%>
                <%--                <option th:if="${lang.equals('ua')}"--%>
                <%--                        th:each="player : ${players}"--%>
                <%--                        th:value="${player.id}" th:text="${player.nameUa}">--%>
                <%--                </option>--%>
            </select>
        </div>
        <div class="custom-control mb-3">
            <label for="opponent">
                <fmt:message key="games.new.game.opponent.label"/>
            </label>
            <select class="custom-select mb-3" id="opponent" >
<%--                <select class="custom-select mb-3" id="opponent" th:name="opponentid">--%>
                <!--                TODO move to property  th:value="0"-->
                <%--                <option--%>
                <%--                        th:value="0" th:text="#{games.new.game.option.label.opponent}">--%>
                <%--                </option>--%>
                <%--                <option th:if="${lang.equals('en')}"--%>
                <%--                        th:each="player : ${players}"--%>
                <%--                        th:value="${player.id}" th:text="${player.nameEn}">--%>
                <%--                </option>--%>
                <%--                <option th:if="${lang.equals('ua')}"--%>
                <%--                        th:each="player : ${players}"--%>
                <%--                        th:value="${player.id}" th:text="${player.nameUa}">--%>
                <%--                </option>--%>
            </select>
        </div>

        <div class="custom-control mb-3">
            <label for="quantity">
                <fmt:message key="games.new.game.max.scores.label"/>
            </label>
            <br>
            <input type="number" min="1" id="quantity" required/>
<%--            <input type="number" min="1" id="quantity"--%>
<%--                   th:name="maxscores" required>--%>
        </div>
        <button type="submit" class="btn btn-primary">
            <fmt:message key="games.game.new.label.button"/>
        </button>
    </form>
</div>

<footer>
    <h5>
        <fmt:message key="text.footer"/>
    </h5>
</footer>

</body>

</html>

