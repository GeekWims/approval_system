<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>결재 리스트</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<ul class="nav nav-pills">
				<li><a href="#"><sec:authentication property="principal.name" /> 님</a></li>
				<li><a href="/">내 문서 리스트</a></li>
				<li><a href="/j_spring_security_logout">로그아웃</a></li>
			</ul>
		</div>

		<div class="row">
			<h1>내가 결재 해야할 문서들</h1>

			<table class="table">
				<tr>
					<td>번호</td>
					<td>문서명</td>
					<td>작성자</td>
					<td>등록일</td>
					<td>최종수정일</td>
					<td>상태</td>
				</tr>
				<c:forEach var="doc" items="${docList}">
					<tr>
						<td>${doc.id}</td>
						<td><a href="/doc/view/${doc.id }">${doc.title}</a></td>
						<td>${doc.writerName}</td>
						<td>${doc.regDate}</td>
						<td>${doc.modDate}</td>
						<td>${doc.status}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="row">
			<a href="/doc/insert"><button class="btn btn-default">작성하기</button></a>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>