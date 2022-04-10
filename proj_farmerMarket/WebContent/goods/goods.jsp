<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/style/style_Goods.css">
<link rel="stylesheet" href="/style/style_ind.css">
<script src="/source/jquery-3.6.0.min.js"></script>
<script src="/script/script.js"></script>
</head>
<body>
	<div id="wrap">

		<!-- 헤더템플릿 시작 -->
		<%@ include file="/ind/headerTmp.jsp"%>
		<header id="header">
			<!-- 영역 구분용 임시 템플릿 -->
			<img src="/images/logo.png" alt="farmer market logo" />
			<hr>
		</header>
		<!-- 헤더템플릿 끝 -->

		<main id="main">

			<!-- 상품 리스트 시작 -->

			<!--  div#goodsList, 상품 목록 시작 -->

			<h1 id="todayGoods">오늘의 품목</h1>

			<div id="goodsList" class="dFlex">

				<nav id="mainLNB">
					<ul>
						<li>메인</li>
						<li>LNB</li>
						<li>템플릿</li>
						<li>삽입</li>
						<li>예정</li>
					</ul>
				</nav>

				<div id="goodsList_Contents" class="dFlex">
					<table>
						<tbody>
							<tr>
								<td class="goodsImg"><a href="#"><img
										src="/images/fish.jpg" alt="어류"></a></td>
							</tr>
							<tr>
								<td class="goodsTitle"><a href="#">[어부마을] 국내산 청어 2마리</a></td>
							</tr>
							<tr>
								<td class="goodsPrice"><a href="#">6,500원</a></td>
							</tr>
						</tbody>
					</table>

					<!-- DB 연결 후 지울 테이블 -->
					<table>
						<tbody>
							<tr>
								<td class="goodsImg"><a href="#"><img
										src="/images/fruit.jpg" alt="과일"></a></td>
							</tr>
							<tr>
								<td class="goodsTitle"><a href="#">[과수원 이야기] 수입산 블루베리
										300g</a></td>
							</tr>
							<tr>
								<td class="goodsPrice"><a href="#">10,160원</a></td>
							</tr>
						</tbody>
					</table>

					<table>
						<tbody>
							<tr>
								<td class="goodsImg"><a href="#"><img
										src="/images/meat.jpg" alt="육류"></a></td>
							</tr>
							<tr>
								<td class="goodsTitle"><a href="#">[도축대장] 호주산 소고기 600g</a></td>
							</tr>
							<tr>
								<td class="goodsPrice"><a href="#">25,590원</a></td>
							</tr>
						</tbody>
					</table>
					<!-- DB 연결 후 지울 테이블 -->
				</div>
				<!-- div#goodsList_Contents 끝 -->

			</div>
			<!--  div#goodsList, 상품 목록 끝 -->


			<!-- 상품 리스트 끝 -->



		</main>
		<!-- main#main -->

		<!-- 푸터템플릿 시작 -->
		<footer id="footer"> 푸터 템플릿 삽입 예정 </footer>
		<%@ include file="/ind/footerTmp.jsp"%>
		<!-- 푸터템플릿 끝 -->

	</div>
	<!-- div#wrap -->
</body>
</html>