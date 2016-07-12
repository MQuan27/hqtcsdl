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

<title>Trang Chủ</title>

<!-- Bootstrap core CSS -->
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/front_end/css/bootstrap.css"/>"
	rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link
	href="<c:url value="/resources/front_end/css/3-col-portfolio.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/front_end/css/carousel.css"/>"
	rel="stylesheet">
</head>

<body>
	<c:set value="${pageContext.request.contextPath	}" var="contextPage" />

	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPage }/home">Nhà Hàng
					Jamie Oliver's</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="home">Trang chủ</a></li>
					<li><a href="${contextPage }/menu">Thực Đơn</a></li>
					<li><a href="${contextPage }/feedBack">Liên Hệ</a></li>
					<li><a href="${contextPage }/cart">Giỏ Hàng</a></li>
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<h2>${message }</h2>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company 2015</p>
					<p>Design by DH11DT - Đại học Nông Lâm</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->
	<!-- JavaScript -->
	<script src="<c:url value="/resources/front_end/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/holder.js"/>"></script>
</body>
</html>