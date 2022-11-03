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
<c:if test="${user != null}">${user.name}님 환영합니다.</c:if>
<c:if test="${user == null}">
   <a href="${context}/login">사용자 로그인</a>
</c:if>
</div>
<c:if test="${user != null}"><a href="${context}/logout">사용자 로그아웃</a></c:if>
<h1>
    <a href="${context}/">
        메인
    </a>
</h1>
<h1>
    ★게시판 메뉴★
    <br>
    <c:forEach var="boardList" items="${boardList}" varStatus="status">
    <a href="${context}/article/${boardList.id}">
        ${boardList.name}
    </a>
    <br>
    </c:forEach>
</h1>
</header>
</body>
</html>