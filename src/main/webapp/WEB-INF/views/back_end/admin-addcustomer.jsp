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
							<li class="active"><a href="${contextPage }/manage/customer">Khách Hàng</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Hoá đơn <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${contextPage }/manage/orderComplete">Đã thanh toán</a></li>
							<li><a href="${contextPage }/manage/orderInComplete">Chưa thanh toán</a></li>
						</ul></li>
					<li ><a href="${contextPage }/manage/product"><i class="fa fa-edit"></i>
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
			<form method="post" action="${contextPage }/manage/addCustomer" class="form-horizontal"
				data-toggle="validator">
				<legend>
					<h2>Đăng Ký:</h2>
				</legend>
				<h4>Thông tin tài khoản:</h4>
				<div class="well">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">Username
							(*):</label>
						<div class="col-sm-5">
							<input type="text" class=" form-control" id="username"
								placeholder="Username" name="userName" value=""
								required="required"
								data-error="Trường username không được để trống">
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Password
							(*)</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Password" required
								data-error="Trường password không được để trống">
						</div>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="password2"
								data-match="#password"
								data-match-error="Trường nhập lại không giống"
								placeholder="Nhập lại password" required
								data-error="Trường nhập lại password không được để trống">
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="fullname" class="col-sm-2 control-label">Họ và
							tên:</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="fullname"
								placeholder="Họ và tên" name="fullName" value="">
							<p class="help-block"></p>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email
							(*):</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="email"
								placeholder="Email" name="email" required="required"
								data-toggle="Trường email không được để trống">
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">Số Điện
							Thoại:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="phone"
								placeholder="Số Điện Thoại" name="phoneNumber" value="">
							<p class="help-block"></p>
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2 control-label">Địa
							chỉ:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="address"
								placeholder="Số Điện Thoại" name="address" value="">
							<p class="help-block"></p>
						</div>
					</div>
					<div class="form-group">
						<label for="gend" class="col-sm-2 control-label">Giới
							Tính:</label>
						<div class="col-sm-6" id="gend">
							<label class="radio-inline"> <input type="radio"
								value="Nam" name="gender" required="required"
								data-error="Hãy chọn giới tính!"> Nam
							</label> <label class="radio-inline"> <input type="radio"
								value="Nu" name="gender" required="required"> Nữ
							</label>
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="payment" class="col-sm-2 control-label">Địa
							chỉ:</label>
						<div class="col-sm-4">
							<select class="form-control">
								<c:forEach items="${paymentList}" var="list">
									<option value="${list.paymentMethodId }" class="form-control">${list.description}
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-2 col-sm-offset-2">
						<input class="btn btn-success" type="submit" class="form-control"
							value="Đăng Ký">
					</div>
				</div>
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