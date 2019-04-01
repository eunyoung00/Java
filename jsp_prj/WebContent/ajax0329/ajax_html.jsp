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
td{text-align: center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#group").change(function(){
		 var name=$("#group").val();
		 if(name !="none"){
			 var queryString="name="+encodeURI(name);
			 $.ajax({
				 url:"html_result.jsp",
				 type:"get",
				 data:queryString,
				 dataType:"html",
				 error:function(xhr){
					 $("#memberView").html("<img src='../common/images/img.png'/>");
					 for(vari=0; i<3; i++){
						 $("#memberView").fadeOut(1000).fadeIn(2000);
					 }//end for
				 },
				 success:function(html_data){
					 /* 김건하 뒤에 CEO를 붙이고 싶은데... */
					 var temp=html_data.replace("김건하", "김건하CEO");
					 $("#memberView").html(temp);
					 /* 클라이언트가 할수있는게 없고 무언가 하기가 어려움(일이커짐)그래서 html은 좋은일이 아님-서버에서 일을 다해 가져오니깐. */
				 }//success
			 });//ajax
		 }//enhd if
		 
	 });//change
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
		<select id="group">
			<option value="none">--조 선택--</option>
			<option value="이봉현">1조</option>
			<option value="박영민">2조</option>
			<option value="오영근">3조</option>
			<option value="김건하">조기취업</option>
		</select>
	</div>
	<div id="memberView"></div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>
</body>
</html>
