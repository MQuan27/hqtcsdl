<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<li class="dropdown"><a href="" class="dropdown-toggle"
	data-toggle="dropdown">${userName}<b class="caret"></b></a>
	<ul class="dropdown-menu">
		<c:if test="${empty userName }">
			<li><a href="goLogin">Đăng Nhập</a></li>
			<li><a href="goRegister">Đăng Ký</a></li>
		</c:if>
		<c:if test="${not empty listRole }">
			<li><a href="Manage">Trang Quản Lý</a></li>
		</c:if>
		<li><a href="feedback.jsp">Gửi Phản Hồi</a></li>
		<li><a href="Logout">Thoát</a></li>

	</ul></li>
<li>
	<form action="#" class="navbar-form navbar-right" role="form">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Tìm Kiếm Món Ăn"
				name="search">
		</div>
		<input type="submit" value="Tìm" class="btn btn-success">
	</form>
</li>
