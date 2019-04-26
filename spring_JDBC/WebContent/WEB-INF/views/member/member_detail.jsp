<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_jdbc/common/css/main_v190130.css" />
<style type="text/css">
#wrap{margin:0px auto; width:1000px; height:860px;}
#header{width:1000px; height:140px; background: url(http://localhost:8080/spring_JDBC/common/images/header_bg.png) repeat-x; position: relative;}
#headerTitle{font-family:HY견고딕, 고딕; font-size:35px; font-weight: bold; text-align:center; position: absolute; top:40px; left: 350px;}
#container{width:1000px; min-height:600px; }
#footer{width:1000px; height:120px;}
#footerTitle{float:right; font-size: 14px; padding-top: 20px; padding-right: 20px}
td{padding: 3px}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">
   $(function(){
      
   });//ready
</script>
</head>
<body>
<div id="wrap">
<div id="header">
   <div id="headerTitle">SIST Class4</div>
   <div style ="padding-top: 100px">
   <c:import url="/common/jsp/main_menu.jsp"/> 
   </div>
	</div>
	<div id="container">
	
	<div>
		<a href="add_form.do">정보추가</a>
   		<a href="search_member.do">정보조회</a>
	</div>
	<div>
	  <c:choose>
	  <c:when test="${empty memberData}">
	  		조회된 회원이 존재하지 않습니다. 
		</c:when>
		<c:otherwise>
			<ul>
				<li>이름 : <c:out value="${memberData.name}"/></li>
				<li>출신고 : <c:out value="${memberData.highschool}"/></li>
				<li>위치 : <c:out value="${memberData.loc}"/></li>
			</ul>
		</c:otherwise>
		</c:choose>
		
	  </div>
	  
	</div>
	<div id="footer">
	   <div id="footerTitle">copyright&copy; all right reserved class4</div>
	</div>
</div>
</body>
</html>