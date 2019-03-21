@@ -1,9 +1,5 @@
<%@page import="java.util.Date"%>
<%@page import="com.sun.xml.internal.ws.api.Cancelable"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
@ -19,275 +15,23 @@
#container{width:800px; height:600px; }
#footer{width:800px; height:120px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }
/* 달  력     설  정 */
#diaryTab{margin:0px auto; border-spacing: 0px; border: 1px solid #CECECE; }
.sunTitle{width : 100px; height:25px; border:1px solid #CECECE; font-weight:bold; 
			color:#FFFFFF; background-color:#ff6b81}
.weekTitle{width : 100px; height:25px; border:1px solid #CECECE}
.satTitle{width : 100px; height:25px; border:1px solid #CECECE; font-weight:bold; 
			color:#FFFFFF; background-color:#3498db}
#diaryTitle{text-align: center; margin-bottom: 10px; margin-top: 20px;}
#diaryToday{width:100px; font-family:고딕체; font-size:28px; font-weight:bold;vartical-align:bottom;}
.diaryTd{width:100px; height: 60px; border: 1px solid #CECECE; text-align: right; 
			vertical-align: top; font-size: 14px;font-weight: bold;}
.todayTd{width:100px; height: 60px; border: 1px solid #d7e2e9; text-align: right; 
			vertical-align: top; font-size: 14px;font-weight: bold; background-color: #e9f4fb; }
.blankTd{width:100px; height: 60px; border: 1px solid #CECECE; color:#CCCCCC; text-align: right; 
			vertical-align: top; font-size: 14px;font-weight: bold;}
.sunColor{font-size: 15px; color:#DE4F44; }
.weekColor{color:#222222; }
.satColor{font-size: 15px; color:#141744; }
.toDay{font-size: 18px; color:#FF55FF; font-weight: bold;}
/* 달  력     설  정    끝 */
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( document ).tooltip({
      position: {
        my: "center bottom-20",
        at: "center top",
        using: function( position, feedback ) {
          $( this ).css( position );
          $( "<div>" )
            .addClass( "arrow" )
            .addClass( feedback.vertical )
            .addClass( feedback.horizontal )
            .appendTo( this );
        }
      }
    });
  } );
</script>
<style>
  .ui-tooltip, .arrow:after {
    background: black;
    border: 2px solid white;
  }
  .ui-tooltip {
    padding: 10px 20px;
    color: white;
    border-radius: 20px;
    font: bold 14px "Helvetica Neue", Sans-Serif;
    text-transform: uppercase;
    box-shadow: 0 0 7px black;
  }
  .arrow {
    width: 70px;
    height: 16px;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -35px;
    bottom: -16px;
  }
  .arrow.top {
    top: -16px;
    bottom: auto;
  }
  .arrow.left {
    left: 20%;
  }
  .arrow:after {
    content: "";
    position: absolute;
    left: 20px;
    top: -20px;
    width: 25px;
    height: 25px;
    box-shadow: 6px 5px 9px -9px black;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
  }
  .arrow.top:after {
    bottom: -20px;
    top: auto;
  }
</style>
<script type="text/javascript">
	function moveMonth(month,year){
		//location.href="diary.jsp?param_year="+year+"&param_month="+month;
/* 		var obj=document.diaryFrm;
		obj.param_month.value=month;
		obj.param_year.value=year;
		obj.submit(); */
		
		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='diaryFrm']").submit();
	}//moveMonth

</script>
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	
	<div id="diaryWrap">
	<%!//declaration
		public static final int START_DAY=1;
	%>
	<%
		Calendar cal=Calendar.getInstance();
	
		//오늘을 저장
		StringBuilder todate=new StringBuilder();
		todate.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)+1).append(cal.get(Calendar.DAY_OF_MONTH));
		
		int nowYear=0;
		int nowMonth=0;
		int nowDay=cal.get(Calendar.DAY_OF_MONTH);
		//1 2 3 4 5
		//0 1 2 3 4
		String param_month=request.getParameter("param_month");
		if(param_month !=null && !"".equals(param_month)){//파라메터 월이 존재하면 현재 캘린더 객체의 월을 변경
			cal.set(Calendar.MONTH, Integer.parseInt(param_month)-1);
		}//end if
		
		nowMonth=cal.get(Calendar.MONTH)+1;
		String param_year=request.getParameter("param_year");
		if(param_year !=null && !"".equals(param_year)){//파라메터 년이 존재하면 현재 캘린더 객체의 년을 변경
			cal.set(Calendar.YEAR, Integer.parseInt(param_year));
		}//end if
		nowYear=cal.get(Calendar.YEAR);
		
		//오늘 플래그
		boolean toDayFlag=false;
		StringBuilder nowDate=new StringBuilder();
		nowDate.append(nowYear).append(nowMonth).append(nowDay);
		
		if(todate.toString().equals(nowDate.toString())){
			toDayFlag=true;
		}//end if
		log(todate+"/"+nowDate+"/"+toDayFlag);
		
		pageContext.setAttribute("nowYear", nowYear);
		pageContext.setAttribute("nowMonth", nowMonth);
		pageContext.setAttribute("nowDay", nowDay);
	%>
		
	<form action="diary.jsp" name="diaryFrm" method="post">
		<input type="hidden" name="param_month"/>
		<input type="hidden" name="param_year"/>
	</form>
	
	
	<div id="diaryTitle">
<%-- 		<a href="diary.jsp?param_month=${nowMonth-1==0?12:nowMonth-1}&param_year=${nowMonth-1==0?nowYear-1:nowYear}"><img src="images/btn_prev.png" title="이전 월"/></a> --%>
		<a href="#void" onclick="moveMonth(${nowMonth-1==0?12:nowMonth-1},${nowMonth-1==0?nowYear-1:nowYear})"><img src="images/btn_prev.png" title="이전 월"/></a>
		<span id="diaryToday" title="${nowYear}년 ${nowMonth}월"><c:out value="${nowYear}"/>.<c:out value="${nowMonth}"/></span>
		<a href="#void" onclick="moveMonth(${nowMonth+1==13?1:nowMonth+1},${nowMonth+1==13?nowYear+1:nowYear})"><img src="images/btn_next.png" title="다음 월"/></a>
		<a href="diary.jsp" onclick="moveMonth('','')"><img src="images/btn_today.png" title="오늘"/></a>
	</div>
	<div id="diaryContent">
		<table id="diaryTab">
		<tr>
			<th class="sunTitle">일</th>
			<th class="weekTitle">월</th>
			<th class="weekTitle">화</th>
			<th class="weekTitle">수</th>
			<th class="weekTitle">목</th>
			<th class="weekTitle">금</th>
			<th class="satTitle">토</th>
		</tr>
		<tr>
			<!-- <td class="diaryTd">1</td> -->
			<%
			String dayClass="";//요일별 색
			String todayCss="";//오늘이거나 평일의 TD색
			
			//매월마다 끝나는 날짜가 다르기 때문에 무한 루프(마지막날 까지)를 사용한다.
			for(int tempDay=1; tempDay<33 ; tempDay++){
				cal.set(Calendar.DAY_OF_MONTH, tempDay);//임시일자를 설정한다.
				if(cal.get(Calendar.DAY_OF_MONTH) != tempDay){
					//설정된 날짜가 현재 일자가 아니라면 마지막 일자 다음달 1일이므로 공백을 출력한 후 반복문을 빠져나간다.
					int week=cal.get(Calendar.DAY_OF_WEEK);
					if(week!=Calendar.SUNDAY){//마지막일이 일요일이 아니면 출력
						int nextDay=1;
						int nextMonth=cal.get(Calendar.MONTH)+1;
						for(int blankTd=week; blankTd<8; blankTd++){
							
							/* //만약 마지막날이 토요일이라면 + 설정된 날짜가 현재 일자가 아니고
							if(cal.get(Calendar.DAY_OF_MONTH) != tempDay&& cal.get(Calendar.DAY_OF_MONTH) == cal.get(Calendar.SATURDAY)){
								break;
							}//end if */
						%>
							<td class="blankTd"><div><%=nextMonth%>/<%=nextDay %></div></td>
						<%
						nextDay++;
						}//end for
					}//end if
					//설정된 날짜가 현재 일자가 아니라면 마지막 일자 다음달 1일이므로 공백을 출력한 후 반복문을 빠져나간다.
					break;/* 나갔을때의 날짜는 다음달 1일  */
				}//end if
				//1일을 출력하기 전에 공백 출력. 딱떨어지는 숫자라면 Switch case추쳔
				
				switch(tempDay){
				case START_DAY:
					//전달의 마지막날 구하기
					cal.set(Calendar.MONTH,nowMonth-2);
					int prevMonth=cal.get(Calendar.MONTH)+1;//이전 월
					int prevLastDay=cal.getActualMaximum(Calendar.DATE);//이전월의 마지막일
					
					cal.set(Calendar.MONTH,nowMonth-1);//다시 현재월로 변경하여 현재월 1일에 맞는 공백 출력
					int week=cal.get(Calendar.DAY_OF_WEEK);
					System.out.println(week);
					for(int blankTd=1; blankTd<cal.get(Calendar.DAY_OF_WEEK); blankTd++){
					%>
						<td class="blankTd"><%=prevMonth%>/<%=prevLastDay-week+blankTd+1 %></td>		
					<%
					}//end for
				}//end switch
				
				//요일별 색 설정
				switch(cal.get(Calendar.DAY_OF_WEEK)){
				case Calendar.SUNDAY:	dayClass="sunColor";	break;
				case Calendar.SATURDAY:	dayClass="satColor";	break;
				default:				dayClass="weekColor";
				}//end switch
				
				todayCss="diaryTd";//평일의 CSS설정
				if(toDayFlag){//요청한 년월일과 오늘의 년월일이 같다면
					if(nowDay==tempDay){//오늘의 일자에만 다른 CSS를 적용한다.
						todayCss="todayTd";
					}//end if
				}//end if
				
/* 				//오늘
				Date date=new Date();
				if(date.getDate()==tempDay && Calendar.MONTH+1==cal.get(Calendar.MONTH)+1){
					 dayClass="toDay";
				}//end switch */
				%>
				<td class="<%=todayCss%>">
					<div><a href="#void"><span class="<%=dayClass%>"><%= tempDay %></span></a></div>
				</td>
				<%
				
				//토요일이라면 줄 변경
				switch(cal.get(Calendar.DAY_OF_WEEK)){
				case Calendar.SATURDAY:
						out.println("</tr><tr>");
				}//end switch
			}//end for			
			%>
		</tr>
		</table>
	</div>

	</div>

	<div id="container">

	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>

</body>
</html>