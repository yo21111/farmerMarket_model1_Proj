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
<link rel="stylesheet" href="/style/style_Common.css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/ind/headerTmp.jsp" />
		<main id="index">
			<h1>메인페이지 입니다.</h1>
		</main>
		<jsp:include page="/ind/footerTmp.jsp" />
	</div>
	<!--div#wrap-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>