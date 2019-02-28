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
		PrintWriter out=response.getWriter();//MIME-Type設公爽檎 陥錘稽球亜 吉陥,,
		
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
	      out.write("#headerTitle{ font-family: HY胃壱拒, 壱拒; font-size: 30px; font-weight: bold;text-align: center;\r\n");
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
	      
	      //HTML Form Control税 葵 閤奄
	      //戚硯戚 政析廃 井酔 <input type="text
	      String name=request.getParameter("name");
	      //戚硯戚 掻差吉 井酔 <input type="checkbox"
	      String[] hobby =request.getParameterValues("hobby");
	      //昔坪漁戚 照鞠檎 硝焼瑳呪 蒸澗 莫殿亜 鞠壱, 昔坪漁戚 2腰鞠檎? ????稽 蟹紳陥.走榎精 8獄穿税 get号縦戚奄 凶庚拭 昔坪漁いいいい
	      
	      out.print("\t<strong>");
	      out.print(name);
	      out.println("</strong>還 臆辞 脊径馬重 昼耕澗 焼掘人 旭柔艦陥.<br/>");
	      
	      out.println("\t<ul>");
	      try {//端滴酵什亜 識澱吉依戚 蒸陥檎 hobby壕伸拭澗 null戚 拝雁鞠糠稽 length徹趨球研 紫遂馬惟 鞠檎 NullPointerException戚 降持馬惟 吉陥.
		      for(int i=0;i<hobby.length; i++) {
		    	  out.print("\t\t<li>");
		    	  out.print(hobby[i]);
		    	  out.println("</li>");
		      }//end for
	      }catch (NullPointerException npe) {
	    	  out.println("<li>昼耕 蒸製</li>");
	      }//end catch
	      out.println("\t</ul>");
	      out.println("\t<a href='day0228/test_param_value.html'>及稽</a>");
	      
	      
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
		PrintWriter out=response.getWriter();//MIME-Type設公爽檎 陥錘稽球亜 吉陥,,
		
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
	      out.write("#headerTitle{ font-family: HY胃壱拒, 壱拒; font-size: 30px; font-weight: bold;text-align: center;\r\n");
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
	      
	      //HTML Form Control税 葵 閤奄
	      //戚硯戚 政析廃 井酔 <input type="text
	      String name=request.getParameter("name");
	      //戚硯戚 掻差吉 井酔 <input type="checkbox"
	      String[] hobby =request.getParameterValues("hobby");
	      //昔坪漁戚 照鞠檎 硝焼瑳呪 蒸澗 莫殿亜 鞠壱, 昔坪漁戚 2腰鞠檎? ????稽 蟹紳陥.走榎精 8獄穿税 get号縦戚奄 凶庚拭 昔坪漁いいいい
	      
	      out.print("\t<h2>POST号縦税 推短 坦軒</h2>");
	      out.print("\t<strong>");
	      out.print(name);
	      out.println("</strong>還 臆辞 脊径馬重 昼耕澗 焼掘人 旭柔艦陥.<br/>");
	      
	      out.println("\t<ul>");
	      if(hobby!=null) {//端滴酵什亜 識澱吉依戚 蒸陥檎 hobby壕伸拭澗 null戚 拝雁鞠糠稽 length徹趨球研 紫遂馬惟 鞠檎 NullPointerException戚 降持馬惟 吉陥.
		      for(int i=0;i<hobby.length; i++) {
		    	  out.print("\t\t<li>");
		    	  out.print(hobby[i]);
		    	  out.println("</li>");
		      }//end for
	      }else {
	    	  out.println("<li>昼耕 蒸製</li>");
	      }//end else
	      ///////梓端亜 旗持失鞠嬢 if~else 蓄探!!///////
	      out.println("\t</ul>");
	      out.println("\t<a href='day0228/test_param_value.html'>及稽</a>");
	      
	      
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
