package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//1.HttpServlet 상속
public class LifeCycle extends HttpServlet {
	
	//생명주기 method
	public void init() {
		System.out.println("============>init method 최초 접속자에 의해 1번 호출(생성자 역할)");
	}//init

	public void destroy() {
		System.out.println("============>Web Container가 종료될때 객체가 사라지면서 1번만 호출.");
	}//destroy
	
	//2.응답방식에 대한 처리 method를 Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3.응답방식 설정(MIME-TYPE설정)
		response.setContentType("text/html;charset=UTF-8");
		//4.출력스트림 얻기
		PrintWriter out=response.getWriter();
		//5.응답내용 생성
		out.println("<strong>방문자 정보</strong><br/>");
		out.println("<strong>접속자 ip :</strong>");
		out.println(request.getRemoteAddr());
		out.println("에서 접속 하셨습니다.");
		
		System.out.println("--------->service,doGet,doPost 모든 접속자에게 호출되어, 여러번 호출 : "+request.getRemoteAddr());
		//http://211.63.89.130:8080/servlet_prj/life_cycle
		
		//Console창에서 비정상종료를 하면 destroy가 불리지 않지만 servers를 끊으며 정상종료를 하면 출력된다.
	}//doGet

}//class
