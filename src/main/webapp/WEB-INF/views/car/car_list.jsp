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

<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349880fb3af4130c17f186008ba162e1"></script>
<script type="text/javascript">
	function save() {
		
	}
	
	$(function() {
		$("button[name='checkBtn']").each(function(i) {
			$(this).click(function() {
				var checkBtn = $(this);
				console.log("1");
				// checkBtn.parent() : checkBtn의 부모는 <td>이다.
				// checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkBtn.parent().parent();
				console.log("tr : " + tr.text());
				var carid = tr.attr('cid');
				console.log(carid);
				if (carid != "") {
					
					$("#save").css({
			            display: "inline"
			        });

					$.ajax({
						url : "${pageContext.request.contextPath}/car/prodlist.do?carid=" + carid,
						type : "GET",
						success : function(data) {
							console.log(data);
							$('#prodList').html(" ");
							$.each(data, function () {
		                        $('#prodList').append("<tr><td>" + this.prodid + "</td><td>"+this.prodnm+"</td><td>"+this.prodcnt+"</td><td><input type='text' class='form-control' name='prodcnt' placeholder='수량입력'></td><td>" + this.carprodcnt + "</td></tr>");
		                    });
		                    
						},
						error : function(e) {
							console.log(e);
						}
					});
				}
			});
		});
		
		
		$("button[name='mapBtn']").each(function(i) {
			$(this).click(function() {
				var mapBtn = $(this);
				console.log("1");
				// checkBtn.parent() : checkBtn의 부모는 <td>이다.
				// checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = mapBtn.parent().parent();
				console.log("tr : " + tr.text());
				var carid = tr.attr('cid');
				console.log(carid);
				if (carid != "") {
					$.ajax({
						url : "${pageContext.request.contextPath}/car/location.do?carid=" + carid,
						type : "GET",
						success : function(data) {
							console.log(data.destlati);
							console.log(data.destlong);
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						    mapOption = { 
						        center: new kakao.maps.LatLng(data.destlati, data.destlong), // 지도의 중심좌표
						        level: 3 // 지도의 확대 레벨
						    };

							var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

							// 마커가 표시될 위치입니다 
							var markerPosition  = new kakao.maps.LatLng(data.destlati, data.destlong); 

							// 마커를 생성합니다
							var marker = new kakao.maps.Marker({
						 	   position: markerPosition
							});

							// 마커가 지도 위에 표시되도록 설정합니다
							marker.setMap(map);
							
		                    
						},
						error : function(e) {
							console.log(e);
						}
					});
				}
			});
		});
		
	});
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
							<h6 class="m-0 font-weight-bold text-primary">차량 정보</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered dataTable" id="dataTable"
									width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">
									<thead>
										<tr>
											<th>차량명</th>
											<th>시동</th>
											<th>배터리</th>
											<th>오류</th>
											<th>위치확인</th>
											<th>상품등록</th>
										</tr>
									</thead>

									<tbody>
										<!-- 사용자 리스트를 클라이언트에게 보여주기 위하여 출력. -->
										<c:forEach var="cdata" items="${carlist}">
											<tr cid="${cdata.carid}">
												<td>${cdata.carid}</td>
												<td>${cdata.carstart}</td>
												<td>${cdata.battery}</td>
												<td><c:choose>
														<c:when test="${cdata.carerror eq '00'}">정상</c:when>
														<c:when test="${cdata.carerror eq '01'}">고장1</c:when>
														<c:when test="${cdata.carerror eq '02'}">고장2</c:when>
												</c:choose></td>
												<td><button id="mapBtn" name="mapBtn" class="btn btn-primary">위치확인</button></td>
												<td><button class="btn btn-primary" id="checkBtn"
														name="checkBtn">상품등록</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								<table class="table table-bordered dataTable"  border="1" 
								width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info">
									<thead>
										<tr>
											<th>제품ID</th>
											<th>제품명</th>
											<th>본사 재고 수량</th>
											<th>등록 수량</th>
											<th>차량 현재 수량</th>
										</tr>
									</thead>
									<tbody id="prodList">
									</tbody>
								</table>
							</div>
						</div>
					</div>
					
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">차량 정보</h6>
						</div>
						<div id="map" style="width: 500px; height: 400px;"></div>
					</div>
					
					
					<button
						onclick="location.href='${pageContext.request.contextPath}/index.do'"
						class="btn btn-primary">Home</button>
						
					<button id="save" onclick="save()" class="btn btn-primary" style="display:none">저장</button>


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