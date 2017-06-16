<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<c:if test="${param.error eq 'true'}">
	<strong>아이디와 암호가 일치하지 않습니다.</strong>
</c:if>
<form action='<c:url value='/user/login'/>' method="post">
	<label for="username"></label>
</form>
</body>
</html>