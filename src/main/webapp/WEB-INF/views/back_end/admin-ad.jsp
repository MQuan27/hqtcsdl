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
<link href="<c:url value="/resources/back_end/css/bootstrap.css"/>" rel="stylesheet">

<!-- Add custom CSS here -->
<link href='<c:url value="/resources/back_end/css/sb-admin.css"/>' rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/back_end/font-awesome/css/font-awesome.min.css"/>">
<!-- Page Specific CSS -->
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
</head>

<body>
<c:set value="${pageContext.request.contextPath	}" var="contextPage" />
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
				<a class="navbar-brand" href="manage/manager">Thống
					Kê</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a
						href="manage/manager"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Người Dùng <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="staff">Nhân Viên</a></li>
							<li><a href="customer">Khách Hàng</a></li>
						</ul></li>
					<li><a href="order"><i class="fa fa-table"></i> Hóa
							Đơn</a></li>
					<li><a href="product"><i class="fa fa-edit"></i>
							Sản Phẩm</a></li>
					<li><a href="feedBack"><i class="fa fa-edit"></i>
							Phản Hồi</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Cài đặt <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="image">Hình ảnh</a></li>
							<li class="active"><a href="ad">Quảng cáo</a></li>
						</ul></li>
				</ul>

				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h1>
						Dashboard <small>Statistics Overview</small>
					</h1>
					<ol class="breadcrumb">
						<li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
					</ol>
				</div>
			</div>
			<!-- /.row -->
			<%-- <div class="row">
				<%
					for (Ads a : list) {
				%>
				<p><%=a.getName()%></p>
				<p><%=a.getLink()%></p>
				<p><%=a.getContent()%></p>
				<img alt="Ảnh" src=<%=a.getImagePath()%>"> <a
					href=Manage/AdDetail?ad=<%=a.getId()%>">Chỉnh
					Sửa</a> <br> <br>

				<%
					}
				%>
			</div> --%>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- JavaScript -->
	<script src="<c:url value="/resources/back_end/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/back_end/js/bootstrap.js"/>"></script>

	<!-- Page Specific Plugins -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
	<script src="<c:url value="/resources/back_end/js/morris/chart-data-morris.js"/>"></script>
	<script
		src="<c:url value="/resources/back_end/js/tablesorter/jquery.tablesorter.js"/>"></script>
	<script src="<c:url value="/resources/back_end/js/tablesorter/tables.js"/>"></script>

</body>
</html>
