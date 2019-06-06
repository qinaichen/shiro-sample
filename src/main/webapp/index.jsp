
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Shiro</title>
</head>
<body>

<h1>Hi, <shiro:principal defaultValue="游客"/></h1>
<shiro:guest>
    <a href="/login">用户登录</a>
</shiro:guest>
<shiro:user>
    <a href="/user/list.jsp">用户列表</a>
    <shiro:hasPermission name="user:add">
        <a href="/user/add.jsp">用户添加</a>
    </shiro:hasPermission>
    <shiro:hasRole name="admin">
        <a href="/admin/index.jsp">管理界面</a>
    </shiro:hasRole>
     <a href="/logout">退出系统</a>
</shiro:user>

<br><br>


</body>
</html>
