<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
<ul class="nav navbar-nav navbar-right navbar-user">
	<li class="dropdown user-dropdown"><a href="#"
		class="dropdown-toggle" data-toggle="dropdown"><i
			class="fa fa-user"></i>&nbsp;${name} <b class="caret"></b></a>
		<ul class="dropdown-menu">
			<li><a href="${contextPath}/profile"> Tài Khoản</a></li>
			<li><a href="${contextPath}/home" title="Quay lại trang chính"> Trang Chính</a></li>
			<li class="divider"></li>
			<li><a href="backPage"><i class="fa fa-power-off"></i> Thoát</a></li>
		</ul></li>
</ul>

