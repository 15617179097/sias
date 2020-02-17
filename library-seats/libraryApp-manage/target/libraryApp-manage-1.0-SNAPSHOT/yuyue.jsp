<%--
  Created by IntelliJ IDEA.
  User: mm
  Date: 2020/1/26
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/subscribe" method="get">
<input type="number" value="用户id" name="userId">
<input type="number" value="教室id" name="classroonId">
<input type="number" value="座位id" name="seatsId">
<input type="date" value="开始时间" name="createTime">
<input type="date" value="结束时间" name="endTime">
    <input type="submit" value="预约">
</form>
</body>
</html>
