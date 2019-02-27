package day0227;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.util.HangulConv;

/**
 * HTML Form Control의 값 받기
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWebParameter extends HttpServlet {
	//만약 파일의 이름은 있으나 요청방식의 처리메소드가 잘못정의되어있을때 405 get으로 불렀는데, doget이 없을때!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	      out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	      out.write("\t\t\tposition: relative; }\r\n");
	      out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	      out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	      out.write("#container{  width:800px; height: 600px; }\r\n");
	      out.write("#footer{  width:800px; height: 120px; }\r\n");
	      out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div\tid=\"wrap\">\r\n");
	      out.write("\t<div id=\"header\">\r\n");
	      out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"container\">\r\n");
	      	
	      //parameter 값 받기 : Tomcat 8.0부터는 GET방식의 Parameter는 한글이 깨지지 않는다.(post는 깨짐)
	      String name=request.getParameter("name");//text
	      String age=request.getParameter("age");//password
	      String mailing=request.getParameter("mailing");//checkbox
	      String gender=request.getParameter("gender");//radio
	      String addr=request.getParameter("addr");//hidden//parameter와 변수의 이름은 달라도 상관없다!
	      String email=request.getParameter("email");//select
	      String greeting=request.getParameter("greeting");//textarea

	      out.println("\t<div>");
	      out.println("\t<h2>GET방식으로 요청한 파라메터 값 처리</h2>");
	      out.println("\t<div>");
	      out.println("\t<ul>");
	      
	      out.print("\t<li> 이름 : <strong>");
	      //out.print(HangulConv.toUTF(name));//HangulConv.toUTF()->tomcat8.5에는 필요가 없음..자동 변환
	      //Tomcat 8.x 이하 일때는 한글처리를 해야 한다.
	      out.print(name);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 나이 : <strong>");
	      out.print(age);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 메일링 여부 : <strong>");
	      out.print(mailing);//value속성이 없는 checkbox는 체크되면 on, 체크되지 않으면 null
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 성별 : <strong>");
	      //out.print(HangulConv.toUTF(gender));
	      out.print(gender);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 주소 : <strong>");
	      //out.print(HangulConv.toUTF(addr));
	      out.print(addr);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 이메일 : <strong>");
	      out.print(email);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 가입인사 : <strong>");
	      //out.print(HangulConv.toUTF(greeting));
	      out.print(greeting);
	      out.println("</strong></li>");
	      //get방식은 항목마다 변환해주지만 post는 항목마다X
	      
	      out.println("\t</ul>");
	      out.println("\t</div>");
	      out.println("\t<a href='day0227/test_param.html'>뒤로</a>");
	      out.println("\t</div>");
	      	
	      out.write("\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"footer\">\r\n");
	      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post한글처리
		request.setCharacterEncoding("UTF-8");//따라서 영향을 받지 않게  위쪽에 존재해야 한다.
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>Insert title here</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
	      out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
	      out.write("\t\t\tposition: relative; }\r\n");
	      out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
	      out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
	      out.write("#container{  width:800px; height: 600px; }\r\n");
	      out.write("#footer{  width:800px; height: 120px; }\r\n");
	      out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
	      out.write("</style>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div\tid=\"wrap\">\r\n");
	      out.write("\t<div id=\"header\">\r\n");
	      out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"container\">\r\n");
	      
	      //post방식의 한글 처리(Tomcat의 모든 버전에 동일하게 적용)
	      //request.setCharacterEncoding("UTF-8");//따라서 영향을 받지 않게  위쪽에 존재해야 한다.
	      
	      //parameter 값 받기 : Tomcat 8.0부터는 GET방식의 Parameter는 한글이 깨지지 않는다.(post는 깨짐)
	      //인코딩을 거쳐 한자에 3byte인 한글을 1패킷 8byte씩 잘라 값 앞에는 %를 붙여 넘어가게 
	      String name=request.getParameter("name");//text
	      String age=request.getParameter("age");//password
	      //request.setCharacterEncoding("UTF-8");//이렇게 중간에 들어가면 일을 하지 않는다.
	      String mailing=request.getParameter("mailing");//checkbox
	      String gender=request.getParameter("gender");//radio
	      String addr=request.getParameter("addr");//hidden//parameter와 변수의 이름은 달라도 상관없다!
	      String email=request.getParameter("email");//select
	      String greeting=request.getParameter("greeting");//textarea

	      out.println("\t<div>");
	      out.println("\t<h2 style='color:#0000FF;'>POST방식으로 요청한 파라메터 값 처리</h2>");
	      out.println("\t<div>");
	      out.println("\t<ul>");
	      
	      out.print("\t<li> 이름 : <strong>");
	      out.print(name);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 나이 : <strong>");
	      out.print(age);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 메일링 여부 : <strong>");
	      out.print(mailing);//value속성이 없는 checkbox는 체크되면 on, 체크되지 않으면 null
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 성별 : <strong>");
	      out.print(gender);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 주소 : <strong>");
	      out.print(addr);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 이메일 : <strong>");
	      out.print(email);
	      out.println("</strong></li>");
	      
	      out.print("\t<li> 가입인사 : <strong>");
	      out.print(greeting);
	      out.println("</strong></li>");
	      
	      
	      out.println("\t</ul>");
	      out.println("\t</div>");
	      out.println("\t<a href='day0227/test_param.html'>뒤로</a>");
	      out.println("\t</div>");
	      	
	      out.write("\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("\t<div id=\"footer\">\r\n");
	      out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
	}//doPost

}//class
