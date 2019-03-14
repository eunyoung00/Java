<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="접속자에게 응답되지않고 데이터처리를 목적으로 하는 페이지"%>
<%
	//응답화면을 만들지 않아 업무로직에 집중할 수 있다.
	String[] names={"공선의","이재현","김건하","최혜원","오영근","박정미"};
	//처리한 결과를 내가가지는것이 아니라 VIEW-화면 구성 페이지로 전달하게 된다(이때, Scope객체를 사용하는데, 값의 사용범위를 정하는 객체)
	//request내장객체는 값을 forward로 이동한 페이지에서 사용할 수 있다.
	request.setAttribute("gruop2", names);
	
	//1.이동할 페이지의 URI 설정(도메인+port번호가 빠진경로)
	RequestDispatcher rd=request.getRequestDispatcher("forward_b.jsp");
	//2.이동
	rd.forward(request, response);

%>