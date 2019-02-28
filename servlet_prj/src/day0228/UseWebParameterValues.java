package day0228;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UseWebParameterValues extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();//MIME-Type잘못주면 다운로드가 된다,,
		
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
	      
	      //HTML Form Control의 값 받기
	      //이름이 유일한 경우 <input type="text
	      String name=request.getParameter("name");
	      //이름이 중복된 경우 <input type="checkbox"
	      String[] hobby =request.getParameterValues("hobby");
	      //인코딩이 안되면 알아볼수 없는 형태가 되고, 인코딩이 2번되면? ????로 나온다.지금은 8버전의 get방식이기 때문에 인코딩ㄴㄴㄴㄴ
	      
	      out.print("\t<strong>");
	      out.print(name);
	      out.println("</strong>님 께서 입력하신 취미는 아래와 같습니다.<br/>");
	      
	      out.println("\t<ul>");
	      try {//체크박스가 선택된것이 없다면 hobby배열에는 null이 할당되므로 length키워드를 사용하게 되면 NullPointerException이 발생하게 된다.
		      for(int i=0;i<hobby.length; i++) {
		    	  out.print("\t\t<li>");
		    	  out.print(hobby[i]);
		    	  out.println("</li>");
		      }//end for
	      }catch (NullPointerException npe) {
	    	  out.println("<li>취미 없음</li>");
	      }//end catch
	      out.println("\t</ul>");
	      out.println("\t<a href='day0228/test_param_value.html'>뒤로</a>");
	      
	      
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();//MIME-Type잘못주면 다운로드가 된다,,
		
		request.setCharacterEncoding("UTF-8");
		
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
	      
	      //HTML Form Control의 값 받기
	      //이름이 유일한 경우 <input type="text
	      String name=request.getParameter("name");
	      //이름이 중복된 경우 <input type="checkbox"
	      String[] hobby =request.getParameterValues("hobby");
	      //인코딩이 안되면 알아볼수 없는 형태가 되고, 인코딩이 2번되면? ????로 나온다.지금은 8버전의 get방식이기 때문에 인코딩ㄴㄴㄴㄴ
	      
	      out.print("\t<h2>POST방식의 요청 처리</h2>");
	      out.print("\t<strong>");
	      out.print(name);
	      out.println("</strong>님 께서 입력하신 취미는 아래와 같습니다.<br/>");
	      
	      out.println("\t<ul>");
	      if(hobby!=null) {//체크박스가 선택된것이 없다면 hobby배열에는 null이 할당되므로 length키워드를 사용하게 되면 NullPointerException이 발생하게 된다.
		      for(int i=0;i<hobby.length; i++) {
		    	  out.print("\t\t<li>");
		    	  out.print(hobby[i]);
		    	  out.println("</li>");
		      }//end for
	      }else {
	    	  out.println("<li>취미 없음</li>");
	      }//end else
	      ///////객체가 덜생성되어 if~else 추천!!///////
	      out.println("\t</ul>");
	      out.println("\t<a href='day0228/test_param_value.html'>뒤로</a>");
	      
	      
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
