<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String goodsCode = request.getParameter("goodsCode");
	// goodsCode를 goodsDao로 이동시켜서 select한 상품 데이터를
	// 상품Bean에 담아 Bean을 반환받고 
	// request.setAttribute("상품", 상품);으로 request에 담아서
	// goodsDetail.jsp 로 이동
	
%>
<!-- insert한 결과를 받아서 성공했으면 장바구니 페이지로 location.href -->	

<!-- 실패했으면 alert("실패") 이후 index.jsp로 돌아가기 -->	
