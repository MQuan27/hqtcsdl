<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Thêm Sản Phẩm - Admin</title>

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
				<a class="navbar-brand" href="${contextPage }/manage/manager">Thống Kê</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="${contextPage }/manage/manager"><i class="fa fa-dashboard"></i>
							Thống Kê</a></li>

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
							<li><a href="${contextPage }/manage/orderComplete">Đã thanh toán</a></li>
							<li><a href="${contextPage }/manage/orderInComplete">Chưa thanh toán</a></li>
						</ul></li>
					<li class="active"><a href="${contextPage }/manage/product"><i class="fa fa-edit"></i>
							Sản Phẩm</a></li>
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
			<h1>Thêm Sản Phẩm</h1>

			<form action="${contextPage}/manage/addProduct" method="post"
				data-toggle="validator">
				<div class="form-group has-feedback">
					<label for="productName" class="form-label">Tên sản phẩm *:</label>
					<input type="text" class="form-control" id="productName"
						name="productName" placeholder="productName" required="required"
						data-error="Trường tên sản phẩm không được để trống" />
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group">
					<label for="description">Mô tả sản phẩm:</label> <input type="text"
						class="form-control" name="description" />
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group">
					<label for="image">Ảnh trưng bày </label> <input name="imagePath"
						class="form-control" id="imagePath" type="file" />

					<div class="help-block with-errors"></div>
				</div>
				<div class="form-group">
					<label for="productType">Loại Sản Phẩm:</label> <select
						name="productType" class="form-control">
						<option value="">--Chọn--</option>
						<c:forEach items="${listProType }" var="list">
							<option value="${list.productTypeId }">${list.description }</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="price" class="form-label">Giá *: </label> <input
						class="form-control" type="text" name="price" required="required"
						data-error="Trường giá không được để trống" />
					<div class="help-block with-errors"></div>
				</div>

				<input class="btn btn-success form-control" type="submit"
					value="Thêm" />
			</form>
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
	<script src="<c:url value="/resources/front_end/js/validator.js"/>"></script>

</body>
</html>