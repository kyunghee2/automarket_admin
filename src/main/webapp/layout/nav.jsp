<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center"
				href="${pageContext.request.contextPath}/index.do">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					Auto Market <sup>admin</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/index.do"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>
			<!-- Nav Item - 차량관리 -->
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/car/list.do">
					<i class="fas fa-fw fa-chart-area"></i> <span>차량 관리</span>
			</a></li>

			<!-- Nav Item - 식품관리 -->
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/prod/alllist.do">
					<i class="fas fa-fw fa-chart-area"></i> <span>상품 관리</span>
			</a></li>

			<!-- Nav Item - 사용자 관리 -->
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/list.do">
					<i class="fas fa-fw fa-table"></i> <span>사용자 관리</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->
</body>
</html>