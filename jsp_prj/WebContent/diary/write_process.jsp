<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="d_vo" class="kr.co.sist.diary.vo.DiaryVO" scope="page"/>
<jsp:setProperty property="*" name="d_vo"/>
<jsp:setProperty property="ip" name="d_vo" value="<%=request.getRemoteAddr()%>"/>
<script type="text/javascript">
$(window).load(function(){
	<%
	/* d_vo.setWriter(HangulConv.toUTF(d_vo.getWriter()));
	d_vo.setSubject(HangulConv.toUTF(d_vo.getSubject()));
	d_vo.setContents(HangulConv.toUTF(d_vo.getContents()));
	 */
	d_vo.setPass(ShaUtil.shaEncoding(d_vo.getPass()));
	 
	//새로고침(F5)로 중복 실행 방지 세션
	Boolean flag=(Boolean)session.getAttribute("writeFlag");
	if(flag!=null && !flag){
		DiaryDAO d_dao=DiaryDAO.getInstance();
		try{
			d_dao.insertEvent(d_vo);
			session.setAttribute("writeFlag", true);
			%>
			alert("이벤트가 정상적으로 등록되었습니다.성공");
			location.href="diary.jsp?param_year=${param.param_year}&param_month=${param.param_month}";
			<%
		}catch(SQLException se){
			%>
			alert("ㅈㅅㅈㅅ.이벤트가 정상적으로 등록 안됨..");
			<%
			se.printStackTrace();
		}//end catch
	}//end if
	%>
});//ready
</script>