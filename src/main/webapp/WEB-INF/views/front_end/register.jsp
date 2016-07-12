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
<link href="<c:url value="/resources/css/bootstrap.css"/>"  rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="<c:url value="/resources/css/3-col-portfolio.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">


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
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-lg-7">
				<form method="post" action="register" class="form-horizontal">
					<legend>
						<h2>Đăng Ký:</h2>
					</legend>
					<h4>Thông tin tài khoản:</h4>
					<div class="well">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">Username:</label>
							<div class="col-sm-5">
								<input type="text" class=" form-control" id="username"
									placeholder="Username" name="username" value="">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">Password:</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" id="password"
									placeholder="Password" name="password">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="fullname" class="col-sm-2 control-label">Họ
								và tên:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="fullname"
									placeholder="Họ và tên" name="fullname" value="">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email:</label>
							<div class="col-sm-5">
								<input type="email" class="form-control" id="email"
									placeholder="Email" name="email" value="">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">Số Điện
								Thoại:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="phone"
									placeholder="Số Điện Thoại" name="phoneNumber"
									value="">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="gend" class="col-sm-2 control-label">Giới
								Tính:</label>
							<div class="col-sm-6" id="gend">
								<label class="radio-inline"> <input type="radio"
									value="Nam" name="gender" checked="checked"> Nam
								</label> <label class="radio-inline"> <input type="radio"
									value="Nu" name="gender" checked="checked"> Nữ
								</label>
							</div>
						</div>
					</div>
					<h4>Thông tin liên hệ</h4>
					<div class="well">
						<div class="form-group">
							<label for="buildingnumber" class="col-sm-2 control-label">Số
								Nhà:</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="buildingnumber"
									placeholder="Số Nhà" name="buildingnumber"
									value="">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="street" class="col-sm-2 control-label">Đường:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="street"
									placeholder="Tên đường" name="street" value="">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="city" class="col-sm-2 control-label">Thành
								Phố:</label>
							<div class="col-sm-3">
								<select id="city" class="form-control" name="city">
									<%-- <%
										for (City c : list) {
									%>
									<option value="<%=c.getId()%>"><%=c.getName()%></option>
									<%
										}
									%> --%>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="payment" class="col-sm-2 control-label">Hình
								thức thanh toán:</label>
							<div class="col-sm-3">
								<select id="payment" name="payment" class="form-control">
								<%-- 	<%
										for (PaymentMethod p : paymentList.listObject()) {
									%>
									<option value="<%=p.getPaymentMethodId()%>"><%=p.getDescription()%></option>
									<%
										}
									%> --%>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 col-sm-offset-2">
								<input type="submit" class="form-control" value="Đăng Ký">
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
	<div class="container">

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
	<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/js/holder.js"/>"></script>


</body>