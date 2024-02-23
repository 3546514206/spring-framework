<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户页面</title>
</head>
<body>
<%System.out.println("跳转到用户页面");%>
<p>请求成功！用户信息：</p>${user.toString()}
</body>
</html>
