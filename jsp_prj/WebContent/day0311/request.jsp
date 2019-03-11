<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<ul>
		<li><strong>요청 URL</strong> : <%= request.getRequestURL() %></li>
		<li><strong>요청 Protocol</strong> : <%= request.getProtocol() %></li>
		<li><strong>요청 서버명</strong> : <%= request.getServerName() %></li>
		<li><strong>요청 서버 Port</strong> : <%= request.getServerPort() %></li>
		<li><strong>요청 URI</strong> : <%= request.getRequestURI() %></li>
		<!-- uri=Uniform Resource Identifier -->
		<li><strong>요청 서블릿 Path</strong> : <%= request.getServletPath() %></li>
		<li><a href="request.jsp?name=jinkyung&addr=gangseogu&age=30">JSP QueryString요청</a></li>
		<li><strong>QueryString</strong> : <%= request.getQueryString() %></li>
		<li><strong>요청 Parameter</strong> : <%= request.getParameter("name") %></li>
		<li><strong>요청 방식</strong> : <%= request.getMethod() %></li>
		<li><strong>접속자 IP</strong> : <%= request.getRemoteAddr() %></li>
		<li><strong>접속자 PORT</strong> : <%= request.getRemotePort() %></li>
	</ul>
	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>