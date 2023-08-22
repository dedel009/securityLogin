<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<header>
<div>
<c:if test="${admin != null}">${admin.name}님 환영합니다.</c:if>
<c:if test="${admin == null}">
    <a href="${context}/login">관리자 로그인</a>
</c:if>
</div>
<c:if test="${admin != null}"><a href="${context}/admin/logout">관리자 로그아웃</a></c:if>
<h1>
    ★관리자 메뉴 리스트★
    <br>
</h1>
</header>
</body>
</html>