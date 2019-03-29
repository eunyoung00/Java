<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
#container{width:800px; min-height: 600px; }
#footer{width:800px; height:120px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#btn").click(function(){
		 var name=$("#name").val();
		 //크롬은 URL을 자동처리해 준다(가->%AA%BB)
		 //하지만 IE는 처리해주지 않는다(가->가) 개발자가 직접 처리해주어야 한다.(안해주면 에러남)
		 //JavaScript의 encoding함수 encodeURI()
		 var queryString="name="+encodeURI(name); /* +"&age="+age 이렇게 연장가능*/
		 
		 $.ajax({ url:"text_result.jsp",/* 페이지주소가 오류나면 404,주소안의 데이터가 잘못되면 500 error함수로 간다. */
			 		type:"GET",
			 		data:queryString,
			 		dataType:"TEXT",
			 		error:function(xhr){/* xhr:xmlhttprequest */
			 			//XMLHttpRequest->xhr사용하면 error의 이유를 확인할 수 있다.
			 			//200-서버가 정상실행되어 응답성공 하였으나 응답의 형태가 처리가능한 데이터가 아닐 떄.
			 			//-ex){"이름":값, }이런경우..손으로 만들떄
			 			alert("에러코드: " +xhr.status+", 에러 메세지: "+xhr.statusText);
			 		},
			 		success:function(text_data){
			 			//alert(text_data);
			 			
			 			//서버에서 응답된 데이터를 받아 처리한다.
			 			var output="<strong>"+name+"</strong> 조장의 조원<ul>";
			 			var data=text_data.split(",");
			 			for(var i=0; i<data.length; i++){
			 				output+="<li>"+data[i]+
			 				(data[i]=="김건하"?"CEO":"")+"</li>";
			 			}//end for
			 			output+="</ul>";
			 			$("#memberDiv").html(output);
			 		}
		 });//ajax
	 });//click
 });//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px; ">
		<c:import url="../common/jsp/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	<div>
	<!-- 동기식일땐 <form action=""></form> 을 태워 보냈지만..지금은 필요없음.따라서 name도 x -->
		조장 : <input type="text" id="name" class="inputBox"/><br/>
		<input type="button" value="입력" class="btn" id="btn">
		<!-- ajax는 form으로 묶을 필요가 없다. 속성도 id 만 있으면 된다. -->
	</div>
	<div id="memberDiv">
	
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>
</body>
</html>
