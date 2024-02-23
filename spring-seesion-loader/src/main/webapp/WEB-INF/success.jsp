<%--@elvariable id="date" type="date"--%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>成功页面</title>
</head>
<body>
<%System.out.println("跳转到成功页面");%>
<p>请求成功！服务器时间：</p>${date}
</body>
</html>
