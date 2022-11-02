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
<c:choose>
    <c:when test="${board.id == 1}">공지사항 추가/수정</c:when>
    <c:when test="${board.id == 2}">FAQ 추가/수정</c:when>
    <c:when test="${board.id == 3}">Q&A 추가/수정</c:when>
    <c:otherwise>게시판</c:otherwise>
</c:choose>
</h2>
<p><c:if test="${article.id != null}">번호 : ${article.id} /</c:if>  작성자 : <c:if test="${article.id != null}">${article.createdById}</c:if><c:if test="${article.id == null}">${admin.id}</c:if></p>
<br>
<p>제목 : <input type="text" name="title" /></p>
<br>
<p>내용 : <textarea name="content"></textarea></p>
<br>
<h2>
--------------------------------------------------------
</h2>
<br>
<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>