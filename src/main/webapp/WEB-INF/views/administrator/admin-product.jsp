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

<title>Trang Quản Lý - Hóa Đơn</title>

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
					<li class="active"><a href="${contextPage }/manage/product"><i
							class="fa fa-edit"></i> Sản Phẩm</a></li>
					<li><a href="feedBack"><i class="fa fa-edit"></i> Phản Hồi</a></li>

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
					<h1>
						Sản Phẩm <small>Sort Your Data</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Sản Phẩm</li>
					</ol>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-10">
					<h2>Sản Phẩm</h2>
					<div class="table-responsive">
						<table
							class="table table-bordered table-hover table-striped tablesorter">
							<thead>
								<tr>
									<th>Tên<i class="fa fa-sort"></i></th>
									<th>Mô tả<i class="fa fa-sort"></i></th>
									<th>Giá<i class="fa fa-sort"></i></th>
									<th>Loại<i class="fa fa-sort"></i></th>
									<th>Hình Ảnh<i class="fa fa-sort"></i></th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${not empty listProduct}">
									<c:forEach items="${listProduct }" var="list">
										<tr>

											<td>${list.productName }</td>
											<td>${list.description }</td>
											<td>${list.price }</td>
											<td>${list.productType.description }</td>
											<td>${list.imagePath }</td>
											<td><a
												href="${contextPage }/manage/editProductPage/Product?productId=${list.productId}"
												class="label label-primary">Sửa</a><a
												href="${contextPage }/manage/delete/Product?productId=${list.productId}"
												class="label label-danger"
												onclick="return confirm('Bạn chắc chắn muốn xóa trường này chứ? \nThao tác này không thể undo')">Xóa</a></td>
									</c:forEach>
								</c:if>
								<c:if test="${empty listProduct}">
									<tr>
										<td colspan="6"><h5>Hiện chưa có sản phẩm</h5></td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<div>
							<a class="btn btn-success"
								href="${contextPage }/manage/addProductPage"> Thêm sản phẩm
							</a>
						</div>
					</div>
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