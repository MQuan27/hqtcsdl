<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Chủ</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/front_end/css/bootstrap.css"/>"
	rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link
	href="<c:url value="/resources/front_end/css/3-col-portfolio.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/front_end/css/carousel.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/front_end/css/formsignin.css"/>"
	rel="stylesheet">
</head>

<body>



	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home">Nhà Hàng Jamie Oliver's</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home">Home</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li><a href="lienhe.jsp">Liên Hệ</a></li>
					<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>
					<!--<li class="dropdown-header">Nav header</li>-->
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<form action="login" method="post" class="form-signin" role="form">
			<div class="form-group">
				<label style="font-size: 20px;" for="username">Username:</label> <input
					class="form-control" type="text" id="username" name="userName"
					placeholder="Username"></input> <input type="hidden" id="userId"
					name="userId" />
				<p class="help-block"></p>
			</div>
			<div class="form-group">
				<label style="font-size: 20px;" for="password">Password:</label> <input
					class="form-control" placeholder="Password" id="password"
					type="password" name="password"></input>
				<p class="help-block"></p>
			</div>
			<div class="form-group">
				<input class="form-control btn btn-success " type="submit"
					value="Đăng Nhập">
			</div>
			<div class="form-group" style="margin-top: -10px;">
				<a href="goRegister" class="form-control btn btn-primary">Đăng
					Ký</a>
			</div>
			<div class="form-group">
				<a style="font-size: 18px;" href="goResetPass">Quên mật khẩu?</a>
			</div>

		</form>
		<hr>

		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company 2013</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/front_end/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/holder.js"/>"></script>


</body>
</html>