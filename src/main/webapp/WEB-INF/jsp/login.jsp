<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
    <h1>관리자 로그인</h1>
    <form action="/qazx" method="post">
        <span>id : </span><input type="text" name="adminId"/>
        <span>password : </span><input type="text" name="password"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="로그인" />
    </form>
</body>
</html>