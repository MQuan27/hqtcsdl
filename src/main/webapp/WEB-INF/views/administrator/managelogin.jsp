<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Đăng nhập - Admin</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/back_end/css/bootstrap.css"/>"
	rel="stylesheet">

<!-- Add custom CSS here -->
<link href='<c:url value="/resources/back_end/css/sb-admin.css"/>'
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/back_end/font-awesome/css/font-awesome.min.css"/>">
<!-- Page Specific CSS -->
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
<link href="<c:url value="/resources/back_end/css/formsignin.css"/>"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<form action="manageLogin" method="post" role="form"
			data-toggle="validator" class="form-signin" role="form">
			<div class="form-group has-feedback">
				<label for="inputSuccess2" class="control-label">Username:</label> <input
					name="username" id="inputSuccess2" type="text" class="form-control"
					required data-error="Tên đăng nhập không được để trống" />
				<div class="help-block with-errors" style="color: red">${errName }</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label">Password:</label> <input
					type="password" name="password" class="form-control" required
					data-error="Password không được để trống" />
				<div class="help-block with-errors" style="color: red">${errPass }</div>
			</div>
			<div class="form-group">
				<input class="form-control btn btn-success" type="submit"
					value="Đăng Nhập">
			</div>
		</form>
		<hr>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/back_end/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/back_end/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/back_end/js/holder.js"/>"></script>
	<script src="<c:url value="/resources/back_end/js/validator.js"/>"></script>

</body>
</html>