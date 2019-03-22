<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dr_vo" class="kr.co.sist.diary.vo.DiaryRemoveVO" scope="page"/>
<jsp:setProperty name="dr_vo" property="*"/>
<%
	dr_vo.setPass(ShaUtil.shaEncoding(dr_vo.getPass()));
%>

<div id="readFrm">
<% 
	/* System.out.println(du_vo); */
	DiaryDAO d_dao=DiaryDAO.getInstance();
	String img="",msg="";
	try{
		int cnt=d_dao.deleteEvent(dr_vo);
		if(cnt==0){//삭제된 행이 없음 : 글 번호를 조작했거나, 비밀번호가 틀렸을 떄
			img="pass_fail.png";
			msg="비밀번호를 확인해 주세요.";
		}else{
			img="success_update.png";
			msg="이벤트을 삭제하였습니다.";
		}//end if
	}catch(SQLException se){
		se.printStackTrace();
		img="construction.jpg";
		msg="죄송합니다. 장애처리에 최선을 다하고 있습니다.";
	}//end catch
%>

<img src="images/<%=img%>"/><br/>
<%=msg%><br/>
<a href="#void" id="btnCloseFrm">닫기</a>
</div>





