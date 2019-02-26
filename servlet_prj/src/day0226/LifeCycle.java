package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//1.HttpServlet ���
public class LifeCycle extends HttpServlet {
	
	//�����ֱ� method
	public void init() {
		System.out.println("============>init method ���� �����ڿ� ���� 1�� ȣ��(������ ����)");
	}//init

	public void destroy() {
		System.out.println("============>Web Container�� ����ɶ� ��ü�� ������鼭 1���� ȣ��.");
	}//destroy
	
	//2.�����Ŀ� ���� ó�� method�� Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3.������ ����(MIME-TYPE����)
		response.setContentType("text/html;charset=UTF-8");
		//4.��½�Ʈ�� ���
		PrintWriter out=response.getWriter();
		//5.���䳻�� ����
		out.println("<strong>�湮�� ����</strong><br/>");
		out.println("<strong>������ ip :</strong>");
		out.println(request.getRemoteAddr());
		out.println("���� ���� �ϼ̽��ϴ�.");
		
		System.out.println("--------->service,doGet,doPost ��� �����ڿ��� ȣ��Ǿ�, ������ ȣ�� : "+request.getRemoteAddr());
		//http://211.63.89.130:8080/servlet_prj/life_cycle
		
		//Consoleâ���� ���������Ḧ �ϸ� destroy�� �Ҹ��� ������ servers�� ������ �������Ḧ �ϸ� ��µȴ�.
	}//doGet

}//class
