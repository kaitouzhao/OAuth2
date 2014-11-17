<%--
  Created by IntelliJ IDEA.
  User: zhao
  Date: 2014/5/29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OAuth2 Login</title>
</head>
<body>
<form action="/oauth2/login.action" method="post">
    <input type="hidden" name="loginDTO.unauthorizedRequestToken" value="${unauthorizedRequestToken}">
    <input type="hidden" name="loginDTO.appKey" value="${appKey}">
    <input type="hidden" name="loginDTO.appSecret" value="${appSecret}">

    <div><label>LoginName:<input name="loginDTO.loginName" type="text"></label></div>
    <div><label>Password:<input name="loginDTO.password" type="text"></label></div>
    <div><input type="submit" value="submit"></div>
</form>
</body>
</html>
