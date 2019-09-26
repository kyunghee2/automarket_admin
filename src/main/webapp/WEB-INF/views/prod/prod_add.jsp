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
	var log = console.log;

	$(function() {
		$("#prod_img_upload").on("change", addfiles);

		$("#add_prod_img").click(function() {
			var c = confirm("상품을 등록하시겠습니까?");
			if (c) {
				return true;
			} else {
				return false;
			}
		});
	});

	/*파일추가*/
	function addfiles(e) {
		var files = e.target.files;
		var fileArr = Array.prototype.slice.call(files);

		fileArr.forEach(function(f) {
			if (!f.type.match("image.*")) {
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			sel_file = f;

			var reader = new FileReader();
			reader.onload = function(e) {
				$("#input_img").attr("src", e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}
</script>
</head>

<body>
	<!-- Page Wrapper -->
	<div id="wrapper">

		<jsp:include page="/layout/nav.jsp"></jsp:include>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">


				<jsp:include page="/layout/header.jsp"></jsp:include>


				<!-- Begin Page Content -->
				<section>
					<div class="container">
						<h2 id="app">상품 등록</h2>
						<form name="f" method="post" action="" class="form-horizontal"
							class="needs-validation" enctype="multipart/form-data">

							<div id="out_imgbox">
								<div id="in_imgbox">
									<img id="input_img">
								</div>
							</div>

							<div class="form-group">
								<label for="prod_img_upload">이미지 등록</label> <input type="file"
									class="form-control-file" id="prod_img_upload" name="file"
									required>
							</div>

							<div id="application">

								<div id="a1">
									<div class="prodnm" style="width: 50%">
										<div>
											<label>상품명</label>
											<input class="form-control" type="text" id="prodnm"
												placeholder="Enter title" name="prodnm" required="required"
												value="${prod.prodnm}">
										</div>
									</div>
									<div class="prodcnt">
										<div id="prodcnt">
											<label>상품 개수</label>
											<input min="1" max="1000" type="number" id="prodcnt"
												placeholder="0" name="prodcnt" value="${prod.prodcnt}">
										</div>
									</div>
								</div>

								<div id="a2">
									<div class="acategory">
										<div id="c1">
										<label>상품 카테고리</label>
											<select name="cateid" id="cateid">
												<option id="big" value="default" selected="selected">카테고리</option>
												<c:forEach var="scateData" items="${catelist}">
													<option value="${scateData.cateid}">${scateData.catenm}</option>
												</c:forEach>
											</select>
										</div>
										<div id="c2">
											<label>상품 가격</label>
											<div class="prodprice">
												<div id="prodprice">
													<input min="1" max="10000000" type="number" id="prodprice"
														placeholder="0" name="prodprice" value="${prod.prodprice}">
												</div>
											</div>
											
											<label>상품 원가</label>
											<div class="costprice">
												<div id="costprice">
													<input min="1" max="10000000" type="number" id="costprice"
														placeholder="0" name="costprice" value="${prod.costprice}">
												</div>
											</div>

											<label>할인율</label>
											<div class="discount">
												<div id="discount">
													<input min="1" max="100" type="number" id="discount"
														placeholder="0" name="discount" value="${prod.discount}">
												</div>
											</div>
										</div>
									</div>
								</div>

								<div id="a3">
									<div class="alocation">
										<div id="l1">

											<div>
												<label>유통기한</label>
												<input class="form-control" type="text" id="expirydate"
													placeholder="Enter expirydate" name="expirydate"
													required="required" value="${prod.expirydate}">
											</div>

										</div>
										<div id="l2">
											<div>
												<label>등록 날짜</label>
												<input class="form-control" type="text" id="regdate"
													placeholder="Enter regdate" name="regdate"
													required="required" value="${prod.regdate}">
											</div>
										</div>

										<div id="l3">
											<div>
												<label>상품 삭제 여부</label>
												<input class="form-control" type="text" id="delflag"
													placeholder="Enter delflag" name="delflag"
													required="required" value="${prod.delflag}">
											</div>
										</div>
									</div>
								</div>


								<div id="a6">
									<div class="col-sm-10">
										<button id="add_prod_img" type="submit"
											class="btn btn-primary">상품 등록하기</button>
										<input type="button" class="btn btn-primary"
											id="go_to_myCloth_list"
											onclick="location.href='${pageContext.request.contextPath}/clothes/myCloth_list.do'"
											value="상품 리스트보기"></input>
									</div>
								</div>
							</div>

						</form>
					</div>


				</section>
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
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
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