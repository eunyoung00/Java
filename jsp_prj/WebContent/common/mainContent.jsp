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
#wrap{margin:0px auto;width:1100px; height:860px;}
#header{width:1100px; height:140px; background:#A7C9C9; position: relative; }
#headerTitle{font-family: HY견고딕,고딕; font-size:35px; font-weight:bold; text-align:center; 
			/* padding-top: 35px */ position:absolute; top:40px; left:290px; }
#container{width:1100px; min-height:600px; }
#footer{width:1100px; height: 140px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }

/* 컨테이너 */
#category{height:300px; position: relative;}
#recomnend{height:300px; position: relative;}
#review{height:300px; position: relative;}
#cgTitle{float: left; position:absolute; top:8px; left:8px;font-size: 20px; font-weight: bold;}
#cg01,#rc01,#rv01{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:150px;}
#cg02,#rc02,#rv02{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:435px;}
#cg03,#rc03,#rv03{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:720px;}
#cg04,#rc04,#rv04{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:2150px;}
#cg05,#rc05,#rv05{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:2430px;}
#cg06,#rc06,#rv06{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:2715px; }
#cg07,#rc07,#rv07{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:4150px; }
#cg08,#rc08,#rv08{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:4430px;}
#cg09,#rc09,#rv09{float: left; width:240px;height:250px; border:1px solid #FF0088; position:absolute; top:10px; left:4720px;}
#cglbtn,#rvlbtn,#rclbtn{float: left; position:absolute; top:140px; left:120px;}
#cgrbtn,#rvrbtn,#rcrbtn{float: left; position:absolute; top:140px; left: 1028px;}
#rcTitle{float: left; position:absolute; top:8px; left:8px; font-size: 20px; font-weight: bold;}
#rvTitle{float: left; position:absolute; top:8px; left:8px;	font-size: 20px; font-weight: bold;}
#showcg{float: left;width:780px;height:250px;position:absolute; }
	
#TitleImg1{border:1px solid #FF0088; top:10px; left:150px; width:1075px;height: 470px; float: left;}
#TitleImg2{border:1px solid #FF0088; top:10px; left:1500px; width:1075px;height: 470px; float: left;}
#TitleImg3{border:1px solid #FF0088; top:10px; left:3000px; width:1075px;height: 470px; float: left;}
#tilbtn{float: left; position:absolute; top:420px; left:95px;}
#tirbtn{float: left; position:absolute; top:420px; left: 1240px;}

	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="http://localhost:8080/spring_mvc/common/touchslider.js"></script>
<script type="text/javascript">
 $(function(){
	 
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
	<div id="headImg" style="width:1100px;height:500px;border:1px solid #333;margin-top: 15px;margin-bottom: 15px;">
		<div class='swipe' style='margin:10px ;height:350px;width:2000px;'>
			<ul id='slider4'>
			    <li style='display:block'>
			    <div id="TitleImg1">
			    	1번 이미지
				</div></li>
			    <li><div id="TitleImg2">
					2번 이미지
				</div></li>
			    <li><div id="TitleImg3">
					3번 이미지
				</div></li>
			  </ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="tilbtn" onclick="t00.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="tirbtn" onclick="t00.next();"/>
		<br/><div id="pagenavi"></div>
	</div>
	<c:import url="../common/jsp/main_menu.jsp"></c:import>
	<div id="content">
		<div id="category">
		<span id="cgTitle">카테고리</span>
		<div class='swipe' style='margin:10px ;height:350px;width:2000px;'>
			<ul id='slider3'>
			    <li style='display:block'><div>
					<div id="cg01">음악</div>
					<div id="cg02">아트</div>
					<div id="cg03">핸드메이드</div>
				</div></li>
			    <li><div>
					<div id="cg04">뷰티/헬스</div>
					<div id="cg05">쿠킹</div>
					<div id="cg06">가드닝</div>
				</div></li>
			    <li><div>
					<div id="cg07">액티비티</div>
					<div id="cg08">자기계발</div>
					<div id="cg09">취미</div>
				</div></li>
			  </ul>
		</div>
		<input type="button" value="&lt;" class="lbtn" id="cglbtn" onclick="t01.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="cgrbtn" onclick="t01.next();"/>
		<br/><div id="pagenavi"></div>
		</div>
		
		<div id="recomnend">
		<span id="rcTitle">추천 클래스</span>
		<div class='swipe' style='margin:10px ;height:350px;width:2000px;'>
			<ul id='slider2'>
				<li style='display:block'><div>
					<div id="rc01">
					
					</div>
					<div id="rc02"></div>
					<div id="rc03"></div>
				</div></li>
				<li><div>
					<div id="rc04"></div>
					<div id="rc05"></div>
					<div id="rc06"></div>
				</div></li>
			    <li><div>
					<div id="rc07"></div>
					<div id="rc08"></div>
					<div id="rc09"></div>
				</div></li>
			</ul>
		<input type="button" value="&lt;" class="lbtn" id="rclbtn" onclick="t02.prev();"/>
		<input type="button" value="&gt;" class="rbtn" id="rcrbtn" onclick="t02.next();"/>
		<br/><div id="pagenavi"></div>
		</div>
		</div>
		
	
		<div id="review">
			<span id="rvTitle">최신 리뷰</span>
			<div class='swipe' style='margin:10px;width:2000px;'>
			  <ul id='slider1'>
			    <li style='display:block'><div>
					<div id="rv01">
						리뷰1
					</div>
					<div id="rv02"></div>
					<div id="rv03"></div>
				</div></li>
			    <li><div>
					<div id="rv04"></div>
					<div id="rv05"></div>
					<div id="rv06"></div>
				</div></li>
			    <li><div>
					<div id="rv07"></div>
					<div id="rv08"></div>
					<div id="rv09"></div>
				</div></li>
			  </ul>
			</div>
			<button id="rvlbtn" onclick="t03.prev();">&lt;</button>
			<button id="rvrbtn" onclick="t03.next();">&gt;</button>
			<br/>
			<div id="pagenavi"></div>
		</div>
<!-- 		<input type="button" value="letf" class="lbtn" id="rvlbtn"/>
		<input type="button" value="right" class="rbtn" id="rvrbtn"/> -->

	</div>
	</div>

<script type="text/javascript">
console=window.console || {dir:new Function(),log:new Function()};
var active=0,
	as=document.getElementById('pagenavi').getElementsByTagName('a');
for(var i=0;i<as.length;i++){
	(function(){
		var j=i;
		as[i].onclick=function(){
			t4.slide(j);
			return false;
		}
	})();
}

var t00=new TouchSlider('slider4',{duration:1000, interval:1000, direction:0, autoplay:false, align:'center', mousewheel:false, mouse:false, fullsize:true});
var t01=new TouchSlider('slider3',{duration:1000, interval:3000, direction:0, autoplay:true, align:'center', mousewheel:false, mouse:false, fullsize:true});
var t02=new TouchSlider('slider2',{duration:1000, interval:3000, direction:0, autoplay:true, align:'middle', mousewheel:false, mouse:false, fullsize:true});
var t03=new TouchSlider('slider1',{duration:1000, interval:3000, direction:0, autoplay:true, align:'center', mousewheel:false, mouse:false, fullsize:true});
t4.on('before',function(m,n){
    as[m].className='';
	as[n].className='active';
})
</script>

	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>
</body>
</html>
