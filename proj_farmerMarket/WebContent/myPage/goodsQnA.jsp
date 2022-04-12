<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품문의</title>
    <link rel="stylesheet" href="/style/style_Common.css">
    <link rel="stylesheet" href="/style/style__MyPage.css">
    <script src="/source/jquery-3.6.0.min.js"></script>
    <script src="/script/script_MyPage.js"></script>
</head>
<body>
	<div id="wrap">
		<!-- 마이페이지를 누르면 제일 먼저 orderList 화면이 나와야 함 -->
		<jsp:include page="/ind/headerTmp.jsp" />
		<%@ include file="/ind/mainLnbTmp.jsp" %>
		<!-- LNB템플릿 영역 -->

		<main id="main" class="dFlex">

			<div id="mainlnb" class="dFlex">
				<nav id="mainlnb_M">
					<h2>마이 마켓</h2>
					<ul>
						<li class="main_MLi"><a href="/myPage/orderList.jsp">주문 내역</a></li>
						<li class="main_MLi"><a href="/myPage/wishList.jsp">찜한 상품</a></li>
						<li class="main_MLi"><a href="/myPage/addrUpdate.jsp">배송지 관리</a></li>
						<li class="main_MLi"><a href="/myPage/goodsComments.jsp">상품 후기</a></li>
						<li class="main_MLi"><a href="#">상품 문의</a></li>
						<li class="main_MLi"><a href="/myPage/update_Info.jsp">개인 정보 수정</a></li>
						<li class="main_MLi"><a href="/myPage/withdraw_Info.jsp">회원 탈퇴</a></li>
					</ul>
				</nav>
			</div>
						<div id="contentsArea">
			<table id="pageTbl">
				<tbody>
					<th class="th1"><h2>상품 문의</h2></th>
					<th class="th2"><p>상품에대한 문의를 남기는 곳입니다.</p></th>

				</tbody>
			</table>
				<hr class = "sepLine">
				<div id="contents">
				
				<p>작성한 문의 내역이 없습니다.</p>
				
				</div>



			</div>
		</main>

		<jsp:include page="/ind/footerTmp.jsp" />

	</div>
</body>
</html>