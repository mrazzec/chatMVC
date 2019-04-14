<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>New Post</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">LOGUS</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:if test="${sessionScope.currentUser == null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/reg">Регистрация</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/log">Авторизация</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.currentUser != null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user">Кабинет</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout?out=true">Выйти</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/newpost">Новое сообщение</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
<div class="container w-25">
    <div class="row">
        <form action="${pageContext.request.contextPath}/newpost" method="post">
            <input class="form-control form-control-sm" type="text" name="text">
            <button class="btn btn-success" type="submit">Опубликовать</button>
        </form>
    </div>
</div>
</body>
</html>
