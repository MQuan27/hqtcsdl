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

<title>Thông tin cá nhân</title>

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
					<li><a href="home">Trang chủ</a></li>
					<li><a href="${contextPage }/menu">Thực Đơn</a></li>
					<li><a href="${contextPage }/cart">Giỏ Hàng</a></li>
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<c:set value="${user}" var="u"></c:set>
	<div class="container">
		<div class="well">
			<legend>Thông tin cá nhân</legend>
			<form action="${contextPage }/editProfile" method="post"
				class="form-horizontal" data-toggle="validator">
				<div class="form-group">
					<label for="username2">Username:</label> <input
						class="form-control" id="username2" type="text" name="username2"
						value="${u.getUsername()}" disabled="disabled">
				</div>
				<input type="hidden" value="${u.getUserId() }" name="userId"
					id="userId" /> <input type="hidden" value="${u.getUsername()}"
					name="username" id="username" />
				<div class="form-group">
					<label for="oldpass">Password cũ:</label> <input type="password"
						name="oldpassword" class="form-control" id="oldpass"
						required="required">
					<div class="help-block with-errors" style="color: red"></div>
				</div>

				<div class="form-group">
					<label for="pass1">Password mới:</label> <input type="password"
						name="password1" class="form-control" id="pass1"
						required="required">
					<div class="help-block with-errors" style="color: red"></div>

				</div>

				<div class="form-group">
					<label for="pass2">Nhập lại Password mới:</label> <input
						type="password" name="password2" class="form-control" id="pass2"
						required="required">
					<div class="help-block with-errors" style="color: red"></div>

				</div>

				<div class="form-group">
					<label for="fullname">Họ và tên:</label> <input type="text"
						name="fullname" value="${u.getFullname()}" class="form-control"
						id="fullname">
					<p class="help-block"></p>

				</div>

				<div class="form-group">
					<label for="phone">Số điện thoại:</label> <input type="text"
						name="phonenumber" value="${u.getPhoneNumber()}"
						class="form-control" id="phone">
					<p class="help-block"></p>
				</div>

				<div class="form-group">
					<label for="gend" class="col-sm-2 control-label">Giới Tính:</label>
					<div class="col-sm-6" id="gend">
						<label class="radio-inline"> <input type="radio"
							checked="checked" name="gender" value="Nam" />Nam
						</label> <label class="radio-inline"> <input type="radio"
							name="gender" value="Nu" />Nữ
						</label>
					</div>
				</div>

				<div class="form-group">
					<label for="email">Địa chỉ Email:</label> <input type="text"
						name="email" value="${u.getEmail()}" id="email"
						required="required" class="form-control">
					<div class="help-block with-errors" style="color: red"></div>
				</div>
				<div class="form-group">
					<label for="address">Địa chỉ:</label> <input type="text"
						name="address" value="${u.getAddress()}" id="address"
						class="form-control">
					<p class="help-block"></p>
				</div>
				<div class="form-group">
					<label for="payment">Hình thức thanh toán:</label> <select
						class="form-control" name="payment" id="payment">
						<c:forEach items="${payment }" var="p">
							<option value="${p.paymentMethodId }">${p.description }</option>
						</c:forEach>
					</select>
					<p class="help-block"></p>
				</div>

				<input type="submit" value="Lưu">
			</form>
		</div>
	</div>
	<div class="container">
		<hr>
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



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/front_end/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/holder.js"/>"></script>
	<script src="<c:url value="/resources/front_end/js/validator.js"/>"></script>


</body>

</html>