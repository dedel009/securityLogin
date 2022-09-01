<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<h1>안녕하세요22222</h1>
<c:forEach var="user" items="${users}" varStatus="status">
<p>id : ${user.id}</p>
<p>name : ${user.name}</p>
<p>phoneNumber : ${user.phone}</p>
</c:forEach>
<script>
</script>
</body>
</html>