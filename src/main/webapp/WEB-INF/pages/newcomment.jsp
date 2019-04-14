<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Comment</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/newcomment" method="post">
    <input type="hidden" name="id" value="${requestScope.id}">
    <input type="text" name="text">
    <button type="submit">Добавить комментарий</button>
</form>
</body>
</html>
