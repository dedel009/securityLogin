<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<jsp:include page="../template/header.jsp"></jsp:include>
<h2>
--------------------------------------------------------
<br>
메인섹션 유저 정보 출력
</h2>
<c:forEach var="user" items="${users}" varStatus="status">
<p>id : ${user.id}</p>
<p>name : ${user.name}</p>
<p>phoneNumber : ${user.phone}</p>
</c:forEach>
<h2>
--------------------------------------------------------
</h2>
<br>
<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>