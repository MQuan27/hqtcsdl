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

<title>Trang Quản Lý - Khách Hàng</title>

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
	<c:set value="${product }" var="p" />
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
			<h1>Chỉnh sửa Sản Phẩm</h1>
			<form method="post" action="${contextPage }/manage/editProduct">
				<input type="hidden"
					value='<c:out value="${p.getProductId() }"></c:out>'
					name="productId" />
				<div class="form-group">
					<label for="name">Tên Sản Phẩm:</label> <input type="text"
						name="productName"
						value='<c:out value="${p.getProductName() }"></c:out>'
						class="form-control" id="name">
				</div>

				<div class="form-group">
					<label for="des">Mô Tả Sản Phẩm:</label> <input type="text"
						name="description" value="${p.getDescription() }"
						class="form-control" id="des">
				</div>

				<div class="form-group">
					<label for="price">Giá:</label> <input type="text" name="price"
						value="${p.getPrice()}" class="form-control" id="price">
				</div>
				<div class="form-group">
					<label for="img">Ảnh Sản Phẩm</label> <input type="file"
						accept=".jpg" name="image" class="form-control" id="img"
						value="${p.getImagePath() }">
				</div>


				<div class="form-group">
					<label for="type">Loại Sản Phẩm:</label> <select
						name="productType" class="form-control" id="type">
						<c:forEach items="${listProductType }" var="list">
							<option value="${list.productTypeId}">${list.description }
							</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" class="form-control" value="Lưu">
			</form>
		</div>
	</div>
	<!-- JavaScript -->
	<script
		src="<c:url value="/resources/back_end/manage/js/jquery-1.10.2.js"/>"></script>
	<script
		src="<c:url value="/resources/back_end/manage/js/bootstrap.js"/>"></script>

	<!-- Page Specific Plugins -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
	<script
		src="<c:url value="/resources/back_end/manage/js/morris/chart-data-morris.js"/>"></script>
	<script
		src="<c:url value="/resources/back_end/manage/js/tablesorter/jquery.tablesorter.js"/>"></script>
	<script
		src="<c:url value="/resources/back_end/manage/js/tablesorter/tables.js"/>"></script>
</body>
</html>