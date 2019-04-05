<%@page import="kr.co.sist.exam.domain.Zipcode"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.dao.MyBatisDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MyBatisService1 mbs=new MyBatisService1();
	
	String dong=request.getParameter("dong");
	
	if(dong!=null){
		List<Zipcode> list=mbs.like(dong);
		pageContext.setAttribute("zipList", list);
	}//end if
%>
<form name="frm" action="main.jsp">
<input type="hidden" name="page" value="day0405/like"/>
<label>동</label>
<input type="text" name="dong" class="inputBox"/>
<input type="submit" value="조회", class="btn"/><br/>
예) 상도동, 역삼동
</form>
<div>
<c:if test="${not empty param.dong}">
	<div>
		${param.dong} 의 조회
	</div>
	<table border="1">
		<tr>
			<th width="80">우편번호</th>
			<th width="400">주소</th>
		</tr>
		<c:if test="${empty zipList}">
		<tr>
			<td colspan="7" align="center">
				<strong>${param.dong}</strong> 은 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="zip" items="${zipList}">
		<tr>
			<td><c:out value="${zip.zipcode}"/></td>
			<td><c:out value="${zip.sido} ${zip.gugun} ${zip.dong} ${zip.bunji}"/></td>
		</tr>
		</c:forEach>
	</table>
</c:if>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=acbead349136da6f3bb665febdb9861f&libraries=services"></script>
<script type="text/javascript">
$(function(){
/* var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new daum.maps.LatLng(37.499448, 127.033151), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴 */
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new daum.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 강남구 역삼동 테헤란로 132', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">쌍용교욱센터</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
});//만약 javaScript가 없다면 onload로 넣어준다.
</script>
<div id="map" style="width:500px;height:400px;"></div>



</div>