<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="memberDao" class="pack_Member.MemberDao" />
<%
request.setCharacterEncoding("UTF-8");
String uId_Session = (String)session.getAttribute("uId_Session");
String goodsCode = request.getParameter("goodsCode");
if (uId_Session == null) {
	%>
		<script>
			alert("로그인 후 이용 가능합니다!");
			let url = "/member/login.jsp?to=/mainPage/updateBasketProc.jsp&goodsCode=" + <%=goodsCode %> ;
			location.href = url;
		</script>
	<%
} else {
	// goodsCode를 goodsDao로 이동시켜서 장바구니 Bean에 담은 다음
	// 해당 Bean을 insert하고
	
%>
	<!-- insert한 결과를 받아서 성공했으면 장바구니 페이지로 location.href -->	

	<!-- 실패했으면 alert("실패") 이후 index.jsp로 돌아가기 -->	
<%
}
%>
