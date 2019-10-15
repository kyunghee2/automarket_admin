<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>AutoMarket - Admin</title>

<!-- Custom fonts for this template-->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../css/sb-admin-2.min.css" rel="stylesheet">

<script type="text/javascript">
	function prodCreate() {
		f.action = "./prod/add.do";
		f.method = "post";
		f.submit();
	}
</script>
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<jsp:include page="/layout/nav.jsp"></jsp:include>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">


				<jsp:include page="/layout/header.jsp"></jsp:include>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">상품 정보</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								${map.count }개의 상품이 있습니다.
								<table class="table table-bordered dataTable" id="dataTable"
									width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">

									<thead>
										<tr>
											<th>상품명</th>
											<th>상품개수</th>
											<th>카테고리명</th>
											<th>상품 가격</th>
											<th>원가</th>
											<th>할인율</th>
											<th>유통기한</th>
											<th>이미지</th>
										</tr>
									</thead>
									
									<tbody>
										<!-- 사용자 리스트를 클라이언트에게 보여주기 위하여 출력. -->
										<c:forEach var="pdata" items="${map.list}">
											<tr>
												<td><a
													href="${pageContext.request.contextPath}/api/prod/detail.do?pid=${pdata.prodid}">
														${pdata.prodnm}</a></td>
												<td>${pdata.prodcnt}</td>
												<td><c:choose>
														<c:when test="${pdata.cateid eq 1}">과일</c:when>
														<c:when test="${pdata.cateid eq 2}">야채</c:when>
														<c:when test="${pdata.cateid eq 3}">정육</c:when>
														<c:otherwise> 기타 </c:otherwise>
													</c:choose></td>
												<td>${pdata.prodprice}</td>
												<td>${pdata.costprice}</td>
												<td>${pdata.discount}</td>
												<td>${pdata.expirydate}</td>
												<td>${pdata.imgpath}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div class="form-group row justify-content-center">
						<div class="w100" style="padding-right: 10px">
							<form name="form1" method="post"
								action="${pageContext.request.contextPath}/prod/alllist.do">
								<select class="form-control form-control-sm" name="searchOption"
									id="searchOption">
									<option value="prodnm"
										<c:out value="${map.searchOption=='prodnm'?'selected':' '}"/>>상품명</option>
									<option value="catenm"
										<c:out value="${map.searchOption=='catenm'?'selected':' ' }"/>>카테고리명</option>
								</select> <input name="keyword" value="${map.keyword }"> <input
									type="submit" value="검색">
							</form>
						</div>
					</div>


					<tr>
						<td><button
								onclick="location.href='${pageContext.request.contextPath}/prod/add.do'"
								class="btn btn-primary">상품 등록</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath}/index.do'"
								class="btn btn-primary">Home</button></td>
					</tr>
				</div>
			</div>
			<!-- End of Main Content -->

			<jsp:include page="/layout/footer.jsp"></jsp:include>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.jsp">Logout</a>
				</div>
			</div>
		</div>
	</div>




	<!-- Bootstrap core JavaScript-->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="../vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../js/demo/chart-area-demo.js"></script>
	<script src="../js/demo/chart-pie-demo.js"></script>
</body>
</html>