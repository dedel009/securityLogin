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
    <c:when test="${board.id == 1}">공지사항 목록</c:when>
    <c:when test="${board.id == 2}">FAQ 목록</c:when>
    <c:when test="${board.id == 3}">Q&A 목록</c:when>
    <c:otherwise>게시판</c:otherwise>
</c:choose>
</h2>
<c:forEach var="article" items="${articleList}" varStatus="status">
<p>번호 : ${article.id} / 작성자 : ${article.createdById}</p>
<br>
<p>제목 : ${article.title}</p>
<br>
<p>내용 : ${article.content}</p>
<br>
</c:forEach>
<h2>
--------------------------------------------------------
</h2>
<input type="button" value="글쓰기" onClick="addArticle()"/>
<br>
<script>
    function addArticle(){
        window.location.href = "${context}/article/${board.id}/insert";
    }
</script>
<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>