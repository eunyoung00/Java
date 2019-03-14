<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="redirect의 사용"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto;width:800px; height:860px;}
#header{width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position: relative; }
#headerTitle{font-family: HY견고딕,고딕; font-size:35px; font-weight:bold; text-align:center; 
			/* padding-top: 35px */ position:absolute; top:40px; left:290px; }
#container{width:800px; height:600px; }
#footer{width:800px; height:120px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }

</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	
	<div id="container">
	<%
	//정상적인 요청으로 이 페이지를 방문하면 정상적인 응답을 해 주지만
	//비정상적인 요청이 있다면 다른페이지로 이동할 때 사용한다.(가릴수 없어서 난수발생으로 보여줄 예정)
	if(new Random().nextBoolean()){//비정상적인 요청
		//response 내장객체를 사용하여 이동
		response.sendRedirect("redirect_b.jsp");//URL을 받으므로 외부 site로 이동도 가능하다.
		return;
	}//end if
	%>
	<img src="../common/images/img.png" title="내 목뼈는 정상임...아마도"/>
		
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>