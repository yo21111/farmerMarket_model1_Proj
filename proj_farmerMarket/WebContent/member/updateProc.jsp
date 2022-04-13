<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String uId_session = (String)session.getAttribute("uId_Session");
%>
<jsp:useBean id="memberDao" class="pack_Member.MemberDao" />
<jsp:useBean id="mBean" class="pack_Member.MemberBean" />
<%

String uPw = request.getParameter("uPw");
String uName = request.getParameter("uName");
String uEmail = request.getParameter("uEmail");
String uPhone = request.getParameter("uPhone");
String uAddr = request.getParameter("uAddr");
String uGender = request.getParameter("uGender");
String uBirth = request.getParameter("uBirth");

mBean.setuPw(uPw);
mBean.setuName(uName);
mBean.setuEmail(uEmail);
mBean.setuPhone(uPhone);
mBean.setuAddr(uAddr);
mBean.setuGender(uGender);
mBean.setuBirth(uBirth);

boolean result = memberDao.updateMember(mBean, uId_session);

if (result) {
%>
<script>
	alert("회원정보 수정을 완료하였습니다.");
	location.href = "/myPage/update_Info.jsp";
</script>
<%
} else {
%>
<script>
	alert("회원정보 수정에 실패하였습니다. 입력하지 않은 정보가 있는지 확인해주세요.");
	history.back();
</script>
<%
}
%>