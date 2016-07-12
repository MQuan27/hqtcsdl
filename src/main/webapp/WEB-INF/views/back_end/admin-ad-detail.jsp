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

<title>Trang Quản Lý - SB Admin</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/manage/css/bootstrap.css"/>" rel="stylesheet">

<!-- Add custom CSS here -->
<link href='<c:url value="/manage/css/sb-admin.css"/>' rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/manage/font-awesome/css/font-awesome.min.css"/>">
<!-- Page Specific CSS -->
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
</head>

<body>

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
				<a class="navbar-brand" href="manage.jsp">Thống Kê</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li><a href="${contextPage}/manage/admin/user"><i
							class="fa fa-bar-chart-o"></i> Người Dùng</a></li>
					<li><a href="${contextPage}/manage/admin/order"><i
							class="fa fa-table"></i> Hóa Đơn</a></li>
					<li><a href="${contextPage}/manage/admin/product"><i
							class="fa fa-edit"></i> Sản Phẩm</a></li>
					<li><a href="${contextPage}/manage/admin/feedback"><i
							class="fa fa-edit"></i> Phản Hồi</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Cài đặt <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${contextPage}/manage/admin/image">Hình ảnh</a></li>
							<li><a href="${contextPage}/manage/admin/ad">Quảng cáo</a></li>
						</ul>
				</ul>

				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h1>
						Thống Kê <small>Statistics Overview</small>
					</h1>
					<ol class="breadcrumb">
						<li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
					</ol>
				</div>
			</div>
			<!-- /.row -->

			<form action="Manage/EditAd" method="post">
				<input type="hidden" name="id" value="">
				<div class="form-group">
					<label for="name">Tên</label> <input class="form-control"
						type="text" name="name" id="name" value="">
					<p class="help-block"></p>
				</div>

				<div class="form-group">
					<label for="link">Đường dẫn</label> <input class="form-control"
						type="text" name="link" id="link" value="">
					<p class="help-block"></p>
				</div>

				<div class="form-group">
					<label for="content">Nội dung</label>
					<textarea class="form-control" name="content" id="content" rows="4"></textarea>
					<p class="help-block"></p>
				</div>

				<div class="form-group">
					<label for="img">Hình Ảnh</label> <input class="form-control"
						type="file" name="image" id="img">
					<p class="help-block">Kích thước hình ảnh phải có kích cỡ là
						140x140px</p>
				</div>

				<input class="form-control" type="submit" value="Lưu">
			</form>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- JavaScript -->
	<script src="<c:url value="/manage/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/manage/js/bootstrap.js"/>"></script>

	<!-- Page Specific Plugins -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
	<script src="<c:url value="/manage/js/morris/chart-data-morris.js"/>"></script>
	<script
		src="<c:url value="/manage/js/tablesorter/jquery.tablesorter.js"/>"></script>
	<script src="<c:url value="/manage/js/tablesorter/tables.js"/>"></script>

</body>
</html>
