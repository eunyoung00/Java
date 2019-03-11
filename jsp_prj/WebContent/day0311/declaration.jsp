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
	<%!//느낌표를 지우면 지역변수가 되서 초기화를 꼭 해주어야 되게 된다.
		int i;//instance 변수(자동초기화)
		
		public String name(){
			return "공선의";
		}//name
		
		/* public String ip(){
			//declaration에서는 내장객체를 사용할 수 없다.
			String ip=request.getRemoteAddr();
			return ip;
		}//ip */
	%>
	
	<%!/* 선언부분에서는 출력도 할수 없음.. */
		public void test(){
			int j=0;
	%>
	<%-- <%=j %> :declaration사이에서 정의된 코드지만 생성되는 위치가 달라 출력할 수 없다.--%>
	<%!	/* 닫을때도 선언 부분이어야 method가 잘만들어 진다. */
		}//test
	%>
	
	i=<%=i %><br/>
	이름 :<%=name() %>
	<%
	//request : 내장(내제) 객체- _jspService method안에서 자동으로 선언되어있는 객체
		String ip=request.getRemoteAddr();
	%>
	접속자 IP Address : <%=ip %>
	<%-- <%
	/* public void test(){
		//메소드는 중첩정의가 안되기 때문에~x
	} */
	%>  아예 문서로 바꿔주질 않는다. 태그의 실행자체를 막는것--%>
	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>