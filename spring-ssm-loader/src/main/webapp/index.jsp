<%--
  Created by IntelliJ IDEA.
  User: setsunayang
  Date: 2022/1/29
  Time: 08:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
<input class="button" type="button" onclick="window.location.href='${pageContext.request.contextPath}/web/loader';"
       value="请求成功页面">
<input class="button" type="button"
       onclick="window.location.href='${pageContext.request.contextPath}/user/getUserInfoById';"
       value="请求用户页面">
<input class="button" type="button" onclick="window.location.href='${pageContext.request.contextPath}/env/toEnv';"
       value="测试Environment实例">
<input class="button" type="button" onclick="window.location.href='${pageContext.request.contextPath}/jvm/test';"
       value="jvm 简单测试，配合 jvisualvm 实验">
<input class="button" type="button" onclick="window.location.href='${pageContext.request.contextPath}/user/getUserVO'"
       value="关联查询">
<input class="button" type="button" onclick="window.location.href='${pageContext.request.contextPath}/transaction/test'"
       value="事务：TEST">
<input class="button" type="button"
       onclick="window.location.href='${pageContext.request.contextPath}/transaction/insert'"
       value="插入一批user数据">
<input class="button" type="button"
       onclick="window.location.href='${pageContext.request.contextPath}/transaction/insertBooks'"
       value="插入一批book数据">
<br/><br/>
<input class="button" type="button"
       onclick="window.location.href='${pageContext.request.contextPath}/deadLock/transactionOne'"
       value="死锁演示：事务一">
<input class="button" type="button"
       onclick="window.location.href='${pageContext.request.contextPath}/deadLock/transactionTwo'"
       value="死锁演示：事务二">
<input class="button" type="button"
       onclick="window.location.href='${pageContext.request.contextPath}/user/compareMybatisVersion';"
       value="比较mybatis版本差异">
</body>
</html>
