<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Index</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">LOGUS</a>
    <div>
        <ul class="navbar-nav mr-auto">
            <c:if test="${currentUser == null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/reg">Регистрация</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/log">Авторизация</a>
                </li>
            </c:if>
            <c:if test="${currentUser != null}">
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
<div class="container w-50">
    <div class="row">
        <ul class="list-group">
            <li class="list-group-item disabled" aria-disabled="true">Чат</li>
            <c:forEach items="${postList}" var="post">
                <li class="list-group-item">${post.author.name}: ${post.text}
                    <c:if test="${sessionScope.currentUser != null}">
                        <a href="${pageContext.request.contextPath}/newcomment?id=${post.id}">Написать комментарий</a>
                    </c:if>
                    <c:forEach items="${post.commentList}" var="comment">
                        <p>${comment.author.name}: ${comment.text}</p>
                    </c:forEach>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<script>
    setInterval(function () {
        location.reload(true);
    }, 5000)
</script>
</body>
</html>
