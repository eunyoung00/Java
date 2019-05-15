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
	 $("#put").click(function(){
		 $.ajax({
			 url:"method/put/aaa",
			 type:"put",
			 dataType:"json",
			 data: JSON.stringify({name:'김정윤',age:31,job:'개발자'}),
			 contentType:"application/json",
			 error:function(xhr){
				 alert(xhr.status+"/"+xhr.statusText);
				 alert(xhr.responseText);
			 },
			 success:function(json){
				 /* alert(json.put); */
				 var output="";
				 output+="아이디 : <strong>"+json.id+"</strong>";
				 output+="비번 : <strong>"+json.password+"</strong>";
				 output+="이름 : <strong>"+json.name+"</strong>";
				 
				 $("#putView").html(output);
			 }//success
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
		</div>
	</div>
	<div id="container">
	<a href="method/get/?name=jinkyung">GET방식</a>
	<form action="method/post" method="post">
		<input type="submit" value="post전송"/>
	</form>
	<form action="" method="put">
		<input type="button" value="put전송"/>
	</form>
	<div id="putView"></div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>
</body>
</html>
