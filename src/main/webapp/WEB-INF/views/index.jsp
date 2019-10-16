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
<link href="./vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="./css/sb-admin-2.min.css" rel="stylesheet">

<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349880fb3af4130c17f186008ba162e1"></script>

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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">▷ 차량 위치</h1>
					</div>
					<div id="map" style="width: 500px; height: 400px;"></div>
					

					<br>

					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">▷ 차량 정보</h1>
					</div>
					<div class="card shadow mb-4">
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
											<th>차량상태</th>
											<th>오류</th>
										</tr>
									</thead>
									<tbody>
										<!-- 사용자 리스트를 클라이언트에게 보여주기 위하여 출력. 
										00 : 기본값
										01 : 이동중(예약)
										02 : 배송완료
										03 : 회수중
										04 : 회수완료-->
										<c:forEach var="cdata" items="${carlist}">
											<tr>
												<td>${cdata.carid}</td>
												<td>${cdata.carstart}</td>
												<td>${cdata.battery}</td>
												<td><c:choose>
														<c:when test="${cdata.carstatus eq '00'}">대기</c:when>
														<c:when test="${cdata.carstatus eq '01'}">이동중</c:when>
														<c:when test="${cdata.carstatus eq '02'}">배송완료</c:when>
														<c:when test="${cdata.carstatus eq '03'}">회수중</c:when>
														<c:when test="${cdata.carstatus eq '04'}">회수완료</c:when>
													</c:choose></td>
												<td><c:choose>
														<c:when test="${cdata.carerror eq '00'}">정상</c:when>
														<c:when test="${cdata.carerror eq '01'}">고장1</c:when>
														<c:when test="${cdata.carerror eq '02'}">고장2</c:when>
												</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">▷ 차량별 재고 부족 현황</h1>
					</div>
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered dataTable" border="1"
									width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info">
									<thead>
										<tr>
											<th>차량명</th>
											<th>카테고리</th>
											<th>제품명</th>
											<th>수량</th>
										</tr>
									</thead>
									<tbody id="prodList">
									</tbody>
								</table>
							</div>
						</div>
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
		<script src="./vendor/jquery/jquery.min.js"></script>
		<script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="./vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="./js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="./vendor/chart.js/Chart.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="./js/demo/chart-area-demo.js"></script>
		<script src="./js/demo/chart-pie-demo.js"></script>
		
		<!-- Kakao api and 상품 부족 현황 -->
		<script type="text/javascript">
$(function() {
	$.ajax({
		url : "${pageContext.request.contextPath}/api/car/lackprodlist.do",
		type : "GET",
		success : function(data) {
			console.log(data);
			$('#prodList').html(" ");
			$.each(data, function () {
                $('#prodList').append("<tr><td>" + this.carid + "</td><td>"+this.catenm+"</td><td>"+this.prodnm+"</td><td>" + this.carprodcnt + "</td></tr>");
            });
            
		},
		error : function(e) {
			console.log(e);
		}
	});
	
	var container = document.getElementById('map');
	var options = {
		center : new kakao.maps.LatLng(37.501818,
				127.039675),
		level : 5
	};
	var map = new kakao.maps.Map(container, options);
	var positions = new Array();
	<c:forEach var="item" items="${carlist}">
	positions.push({
		title : '${item.carid}',
		latlng : new kakao.maps.LatLng('${item.destlati}',
				'${item.destlong}')
	})
	</c:forEach>

	// 마커 이미지의 이미지 주소입니다
	var imageSrc = "${pageContext.request.contextPath}/img/marker.png";

	for (var i = 0; i < positions.length; i++) {
		// 마커 이미지의 이미지 크기 입니다
		var imageSize = new kakao.maps.Size(24, 35);

		// 마커 이미지를 생성합니다    
		var markerImage = new kakao.maps.MarkerImage(
				imageSrc, imageSize);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			map : map, // 마커를 표시할 지도
			position : positions[i].latlng, // 마커를 표시할 위치
			title : "차량" + positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			image : markerImage
		// 마커 이미지 
		});
	}
	
});



</script>
		
</body>



</html>
