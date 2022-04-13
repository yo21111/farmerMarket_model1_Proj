<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FarmerMarket</title>
<!-- favicon 설정 -->
<link rel="icon" type="image/x-icon" href="../images/favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/style/style_Common.css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/ind/headerTmp.jsp" />

		<main id="index">
			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////////////////////////////메인 이미지 슬라이드 시작////////////////////////////////////////////////// -->
			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<div id="mainSlide">

				<!-- Slideshow container -->
				<div class="slideshow-container">

					<!-- Full-width images with number and caption text -->
					<div class="mySlides fade">
						<div class="numbertext">1 / 3</div>
						<a href="#"><img src="/images/mainSlide/mainSlide_img1.png"
							style="width: 100%"></a>
						<div class="text"></div>
					</div>

					<div class="mySlides fade">
						<div class="numbertext">2 / 3</div>
						<a href="#"><img src="/images/mainSlide/mainSlide_img2.png"
							style="width: 100%"> </a>
						<div class="text"></div>
					</div>

					<div class="mySlides fade">
						<div class="numbertext">3 / 3</div>
						<a href="#"><img src="/images/mainSlide/mainSlide_img3.png"
							style="width: 100%"> </a>
						<div class="text"></div>
					</div>

					<!-- Next and previous buttons -->
					<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a
						class="next" onclick="plusSlides(1)">&#10095;</a>
				</div>
				<br>

				<!-- The dots/circles -->
				<div style="text-align: center">
					<span class="dot" onclick="currentSlide(1)"></span> <span
						class="dot" onclick="currentSlide(2)"></span> <span class="dot"
						onclick="currentSlide(3)"></span>
				</div>
			</div>
			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////////////////////////////메인 이미지 슬라이드 끝//////////////////////////////////////////////////// -->
			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////////////////////////////////메인 상품리스트 시작////////////////////////////////////////////////// -->
			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<div class="mainList">
				<div class="goods_title">
					<a href="#">육류 : 이 달의 추천목록</a>
				</div>
				<div class="goods_container dFlex">

					<!-- ///////////////////////////// 반복되는 부분 시작 /////////////////////////////-->
					<!-- ///////////////////////////// 반복되는 부분 시작 /////////////////////////////-->
					<!-- ///////////////////////////// 반복되는 부분 시작 /////////////////////////////-->
					<div class="goods">
						<div class="hidden">
							<input type="hidden" value="!!!!!! 상품코드를 여기에 입력 !!!!!!">
						</div>
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->
					<!-- ///////////////////////////// 반복되는 부분 끝 /////////////////////////////-->
					<!-- ///////////////////////////// 반복되는 부분 끝 /////////////////////////////-->
					<!-- ///////////////////////////// 반복되는 부분 끝 /////////////////////////////-->



					<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->
					<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
					<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->

				</div>
				<!-- div#goods_container -->
			</div>
			<!-- div#mainList -->


			<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 시작 /////////////////////////////-->
			<div class="mainList">
				<div class="goods_title">
					<a href="#">해산물 : 이 달의 추천목록</a>
				</div>
				<div class="goods_container dFlex">

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->


					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->


				</div>
				<!-- div#goods_container -->
			</div>
			<!-- div#mainList -->


			<div class="mainList">
				<div class="goods_title">
					<a href="#">과일 : 이 달의 추천목록</a>
				</div>
				<div class="goods_container dFlex">

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->


					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->


				</div>
				<!-- div#goods_container -->
			</div>
			<!-- div#mainList -->


			<div class="mainList">
				<div class="goods_title">
					<a href="#">채소 : 이 달의 추천목록</a>
				</div>
				<div class="goods_container dFlex">

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->


					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->

					<div class="goods">
						<div class="goodsImg">
							<a href="#"> <img src="/images/beef1_main.png" alt="상품이미지">
							</a>
						</div>

						<div class="goodsBtn">
							<!-- a태그 href를 장바구니 담기 Proc.jsp로 변경 -->
							<a href="/goods/goods_basket.jsp"> <i
								class="fa fa-fw fa-shopping-cart"></i>
							</a>
						</div>

						<div class="goodsPrice">
							<span class="salePer">10%</span> <span class="price">10,000</span>
						</div>
						<div class="beforePrice">9,000</div>
					</div>
					<!-- div#goods -->
				</div>
				<!-- div#goods_container -->
			</div>
			<!-- div#mainList -->
			<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->
			<!-- ///////////////////////////// 삭제할 부분 끝 /////////////////////////////-->


			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ///////////////////////////////////////////메인 상품리스트 끝//////////////////////////////////////////////////// -->
			<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		</main>

		<jsp:include page="/ind/footerTmp.jsp" />
	</div>
	<!--div#wrap-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>