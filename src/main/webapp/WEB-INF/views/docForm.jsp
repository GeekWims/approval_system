<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문서 작성</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>문서 작성/수정 페이지</h1>
		</div>
		<div class="">
			<form:form commandName="doc">
				<form:hidden path="writer" />
				<form:errors />
				<div class="row">
					<div class="form-group col-md-6">
						<label>제목</label>
						<div>
							<form:input path="title" cssClass="form-control" />
						</div>
						<div>
							<form:errors path="title" element="div" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label>작성자</label>
						<div>
							<p class="form-control-static">
								<sec:authentication property="principal.name" />
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label>문서 종류</label>
						<div>
							<form:select path="type" cssClass="form-control">
								<form:options items="${docTypeList}"></form:options>
							</form:select>
						</div>
						<div>
							<form:errors path="type" element="div" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label>내용</label>
						<div>
							<form:textarea path="content" cssClass="form-control" />
						</div>
						<div>
							<form:errors path="content" element="div" cssClass="error" />
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-success">작성</button>
				<button type="button" class="btn btn-default"
					onclick=" window.history.back();">취소</button>
			</form:form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>