<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="scriptlet 연습"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto;width:800px; height:860px;}
#header{width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position: relative; }
#headerTitle{font-family: HY견고딕,고딕; font-size:35px; font-weight:bold; text-align:center; 
			/* padding-top: 35px */ position:absolute; top:40px; left:290px; }
#container{width:800px; height:600px; }
#footer{width:800px; height:120px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }
td:hover{font-size:10px; background-color:#FF0055}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".t").click(function() {
		alert($(this).children().val());
	});
	
	var d=new Date();
	var time="";
	time+=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "
			+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
	
	$("#c_time").text(time);
	
});//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	
	<div id="container">
	<%
	//scriptlet은 _jspService method내에 코드가 생성된다.
		int i=3;	//지역변수  : 자동초기화가 되지 않는다.(초기화 하지 않으면 Error) 
		//에러의 줄이 일치하지 않으면 자바 파일을 열어 확인해 고쳐준다.
	%>
	<%= i %>
	<%	for(int j=1; j<7; j++){	%>
	<h<%= j %>>오늘은 불금입니다.</h<%= j %>>
	<%  }//end for	%>
	<%
		String[] names={"노진경","김정윤","박영민","김희철","박소영","이지수"};
	%>
	<table border="1">
	<tr>
		<th width="100">이름</th>
	</tr>
	<%for(int j=0; j<names.length; j++){ %>
	<tr>
		<td><%=names[j] %></td>
	</tr>
	<%}//end for %>
	</table>	

	<!-- 1~100까지 합만 출력 -->
	<% 
	int total=0;
	for(int cnt=1; cnt<=100; cnt++ ){
		total=total+cnt;
	}//end for
	%>
	<div>
	1에서 100까지의 합은 <%=total%>입니다.
	</div>
	
	<div>
	<!-- 구구단 3단 출력 -->
	<table border="1">
	<tr>
		<th>구구단 3단</th>
	</tr>
	<% for(int j=1; j<10; j++){ %>
	<tr>
		<td>3*<%=j %>=<%=3*j %></td>
	</tr>
	<%}//end for %>
	</table>
	<table border="1">
	<tr>
		<th colspan="9">구구단 3단</th>
	</tr>
	<tr>
	<% for(int j=1; j<10; j++){ %>
		<td>3*<%=j %>=<%=3*j %></td>
	<%}//end for %>
	</tr>
	</table>
	
	<!-- 2~9구구단 클릭/호버 -->	
	<table border="1">
	<tr>
		<th colspan="9">구구단</th>
	</tr>
	<% for(int j=1; j<10; j++){ %>
	<tr>
		<%for(int z=2; z<10; z++){ %>
		<td id="gugu" value=<%=z*j %>><%=z %>*<%=j %></td>
		<%-- <%z*j %> --%>
		<%}//end for %>
	</tr>
	<%}//end for %>
	</table>
	</div>
	
	<!-- 강사님 부분 -->
	<!-- 구구단 출력 전체-->
   <div>
   <table border="1">
   <% for(int k=1; k<10; k++) {%>
   <tr>
   <% for(int l=2; l<10; l++) {%>
      <%-- <td width=40; align="center" id="dan" onclick="alert('<%=l*m%>')">  --%>
      <td width=40; align="center" class="t">
      <%= k %> * <%= l %> 
      <input type="hidden" name="sum" value="<%=k*l%>">
      </td>
   <% }//end for %>
   </tr>
   <% }//end for %>
   </table>
   </div>
	
	<!-- 년-월-일 요일 시:분 을 서버의 시간으로 얻어와서 문자열로 처리해주세요. 버튼을 클릭하면 해당일자가 3총동안 서서히 사라지도록 만들어 주세요. -->
	<%
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss");
	String date =sdf.format(new Date());
	%>
	<div><!-- sss:asp+jsp+,,, -->
		서버시간 : <span id="s_time"><%=date %></span>
		접속자시간 : <span id="c_time"></span>
		<input type="button" id="btn" class="btn"/>	
		<!-- date는 클라이언트의 시간으로 되어있어 서버의 시간으로 설정해야 한다. -->
	</div>
	
	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>