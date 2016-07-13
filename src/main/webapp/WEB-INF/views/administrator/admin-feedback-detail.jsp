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

<title>Trang Quản Lý - Phản hồi</title>

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
</head>

<body>
	<c:set value="${pageContext.request.contextPath	}" var="contextPage" />
	<c:set value="${feedback }" var="feed" />
	<div id="wrapper">

		<!-- Sidebar -->

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPage }/manage/manager">Thống
					Kê</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="${contextPage }/manage/manager"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Người Dùng <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${contextPage }/manage/staff">Nhân Viên</a></li>
							<li><a href="${contextPage }/manage/customer">Khách Hàng</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Hoá đơn <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${contextPage }/manage/orderComplete">Đã
									thanh toán</a></li>
							<li><a href="${contextPage }/manage/orderInComplete">Chưa
									thanh toán</a></li>
						</ul></li>
					<li><a href="${contextPage }/manage/product"><i
							class="fa fa-edit"></i> Sản Phẩm</a></li>
					<li class="active"><a href="${contextPage }/manage/feedBack"><i
							class="fa fa-edit"></i> Phản Hồi</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Cài đặt <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${contextPage }/manage/image">Hình ảnh</a></li>
							<li><a href="${contextPage }/manage/ad">Quảng cáo</a></li>
						</ul></li>
				</ul>

				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<ol class="breadcrumb">
						<li><a href="Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Phản hồi</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-7">
					<h2>Khách Hàng</h2>
					<p>
					<h2 class="label label-info">
						<c:out value="${feed.getFullname() }" />
					</h2>
					</p>
					<h2>Nội dung:</h2>
					<p>
					<h3>- ${feed.getContent() }</h3>
					</p>
					<h2>Email:</h2>
					<p>
					<h3>
						<a href="">${feed.getEmail() }</a>
					</h3>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- JavaScript -->
	<script src="<c:url value="/resources/back_end/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/back_end/js/bootstrap.js"/>"></script>

	<!-- Page Specific Plugins -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
	<script
		src="<c:url value="/resources/back_end/js/morris/chart-data-morris.js"/>"></script>
	<script
		src="<c:url value="/resources/back_end/js/tablesorter/jquery.tablesorter.js"/>"></script>
	<script
		src="<c:url value="/resources/back_end/js/tablesorter/tables.js"/>"></script>
</body>
</html>