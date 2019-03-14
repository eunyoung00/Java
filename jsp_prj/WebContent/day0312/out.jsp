<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="브라우저로 출력하는 내장객체"
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
		//out 내장객체의 사용.(장점은 scriptlet안에서 끊지 않고 브라우저로 출력할 수 있다.)
		String subject="JSP(Java Server Page)-SSS(Server Side Script)중 하나";
		out.println(subject);
	
		String[] link={"http://daum.net","http://youtube.com","http://naver.com"};
		String[] link_name={"공선의","이재찬","김건하"};
	%>
	<table border="1">
	<tr>
		<th width="100">out사용</th>
	</tr>
<%
		for(int i=0; i<link.length; i++){ 
			out.println("\t\t<tr>");
			out.print("\t\t\t<td><a href='");
			out.print(link[i]);
			out.print("'>");
			out.print(link_name[i]);
			out.println("</a></td>");
			out.println("\t\t</tr>");		
		}//end for 
%>
	</table>
	
	<table border="1">
	<tr>
		<th width="150">Expression사용</th>
	</tr>
<%	for(int i=0; i<link.length; i++){%> 
		<tr>
			<td><a href="<%=link[i] %>"><%=link_name[i] %></a></td>
		</tr>
<%	}//end for %>
	</table>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>