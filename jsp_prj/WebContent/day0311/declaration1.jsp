<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	/**
	라디오 버튼을 생성하는 method<br/>
	createRadio(라디오버튼갯수, 라디오버튼이름,기본체크 값(라디오버튼보다 크면 안된다.))
	*/
	public String createRadio(int rCnt, String rName, int rDefault){
		StringBuilder radio=new StringBuilder();
		if(rCnt<rDefault){
			rDefault=0;
		}//end if
		
		for(int i=0; i<=rCnt; i++){
			radio.append("<input type='radio'name='").append(rName)
			.append("' value='").append(i).append("'");
			if(i==rDefault){
				radio.append("checked='checked'");
			}//end if
			radio.append(">").append(i).append("점&nbsp;");
		}//end for
		return radio.toString();
	}//createRadio
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
#nameTitle{width:100px;}
#scoreTitle{width:500px;}
table{border-top:2px solid #333; }
th{height: 30px}
th,td{border-bottom:1px dotted #4F4F4F; }
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	
	<div id="container">
	<%
		String[] names={"공선의","김건하","이재찬","정택성","김희철"};
	%>
	<table>
		<tr>
			<th id="nameTitle">이름</th>
			<th id="scoreTitle">점수</th>
		</tr>
		<% for(int i=0; i<names.length; i++){%>
		<tr>
			<td><%=names[i] %></td>
			<td>
				<%-- <%for (int j=0; j<11; j++){ %>
				<input type="radio" name="score_<%=i%>"value="<%=j %>"/><%=j %>점 
				<%}//end for %>  --%>
				<%=createRadio(10,"name_"+i,5) %>
			</td>
		</tr>
		<% }//end for%>
	</table>
	전체 점수 : <%=createRadio(10,"total",0) %>
	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>