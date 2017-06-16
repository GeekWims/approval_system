<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>문서 보기</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="panel panel-defualt">
			<div class="col-md-12 panel-body">
				<div class="row">
					<h1>제목 : ${doc.title }</h1>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label>작성자</label>
						<div>
							<p>${doc.writerName}</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label>문서 종류</label>
						<div>
							<p>${doc.type }</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<label>내용</label>
						<div>
							<p>${doc.content }</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-8">
						<h3>결재 기록</h3>
						<table class="table">
							<tr>
								<td>번호</td>
								<td>상태</td>
								<td>담당자</td>
								<td>문서명</td>
								<td>요청일시</td>
								<td>결재일시</td>
							</tr>
							<c:forEach items="${approvalList}" var="approval">
								<tr>
									<td>${approval.id }</td>
									<td>${approval.status }</td>
									<td>${approval.personInChargeName }</td>
									<td>${approval.docTitle }</td>
									<td>${approval.regDate }</td>
									<td>${approval.modDate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<c:choose>
					<c:when test="${isAllowed}">
						<a href="/doc/update/${doc.id }"><button class="btn btn-warning">수정</button></a>
						<a href="/doc/delete/${doc.id }"><button class="btn btn-danger">삭제</button></a>
						<button onclick=" window.history.back();"  class="btn btn-default">취소</button>
					</c:when>
					<c:when test="${isInCharge }">
						<a href="/approval/${doc.id }"><button class="btn btn-default btn-success">결재</button></a>
						<a href="/reject/${doc.id }"><button class="btn btn-danger">반려</button></a>
						<button onclick=" window.history.back();" class="btn btn-default">취소</button>
					</c:when>
					<c:otherwise>
						<button onclick=" window.history.back();"  class="btn btn-default">취소</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>