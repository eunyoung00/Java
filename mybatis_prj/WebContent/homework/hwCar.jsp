<%@page import="homework.hwCar"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//히든태그로 이전상태를 기억하면서 하려면~~두가지 세션 or 히든태그!
	MyBatisService1 mbs =new MyBatisService1();
	//List<hwCar> carList=
	//pageContext.setAttribute("carList", carList);

%>

<table style="border-top: 2px solid #333; border-bottom: 1px solid #333; ">
<tr>
	<th width="80" style="border-bottom: 1px solid #333;">이미지</th>
	<th width="400" style="border-bottom: 1px solid #333;">차량정보(옵션)</th>
	<th width="150" style="border-bottom: 1px solid #333;">연식</th>
</tr>

<c:if test="${empty carList}">
<tr>
	<td colspan="3" style="text-align: center">등록된 차량이 존재하지 않습니다.</td>
</tr>
</c:if>
<c:forEach var="car" items="${carList}">
<tr>
	<td><img src="http://localhost:8080/mybatis_prj/day0409/images/${car.img}" style="width:80px; height: 50px"/></td>
	<td>
		<div>
		<c:out value="${car.maker}"/><c:out value="${car.model}"/>
		</div>
		<div>
			 <c:out value="${car.price}"/> <c:out value="${car.hiredate}"/>
		</div>
		<div>
			<c:out value="${car.carOption}"/>
		</div>
	</td>
	<td>
		<c:out value="${car.carYear}"/>년식
	</td>
</tr>
</c:forEach>

</table>