<%--
  Created by IntelliJ IDEA.
  User: qinaichen
  Date: 2019-06-06
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>${errorMsg}</h2>
<form method="post">
    username: <input type="text" name="username"> <br>
    password: <input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
