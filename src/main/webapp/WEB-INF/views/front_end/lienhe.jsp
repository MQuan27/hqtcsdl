<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Liên Hệ</title>


<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
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
				<a class="navbar-brand" href="home.jsp">Nhà Hàng Jamie Oliver's</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li class="active"><a href="lienhe.jsp">Liên Hệ</a></li>
					<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>
					<!--<li class="dropdown-header">Nav header</li>-->
					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<br> <br> <br>
		<div class="row">
			<div class="col-md-7">
				<h2>Địa chỉ:</h2>
				<hr>
			</div>

			<div class="col-md-5">

				<h2>Liên Hệ</h2>
				<form action="Feedback" method="post" class="form-horizontal">
					<div class=" form-group">
						<label for="fullname" class="col-sm-3 control-label">Họ và
							Tên:</label>
						<div class="col-sm-7">
							<input type="text" name="fullname" id="fullname"
								class="form-control" value="">
						</div>
					</div>
					<div class=" form-group">
						<label for="email" class="col-sm-3 control-label">Email:</label>
						<div class="col-sm-7">
							<input type="email" name="email" id="email" value=""
								class="form-control">
						</div>
					</div>
					<div class=" form-group">
						<label for="content" class="col-sm-3 control-label">Nội
							dung:</label>
						<div class="col-sm-7">
							<textarea rows="6" class="form-control" name="content"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 col-md-offset-5">
							<input type="submit" value="Gửi" class="form-control btn btn-success">
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
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/holder.js"></script>


</body>

</html>