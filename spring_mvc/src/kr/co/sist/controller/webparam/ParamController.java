package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
	//GET 방식으로 요청을 처리할 때에는 URL만 넣어도 된다.
	//value="URL", method=RequestMethod.GET)
	@RequestMapping(value="/request_form.do")
	public String requestForm() {
		return "param/request_form";
	}//requestForm
	
	
	@RequestMapping(value="/use_request_process.do", method=GET)
	//HttpServletRequest를 사용한 파라메터 처리 : 권장x
	public String requestFormProcess(HttpServletRequest request) {
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String[] lang=request.getParameterValues("lang");
		
		System.out.println(name+"/"+age+"/"+Arrays.toString(lang));
		request.setAttribute("lang", lang);
		
		return "param/request_process";
	}//requestFormProcess
	
   @RequestMapping("/vo_form.do")
   public String voForm() {
      return "param/vo_form";
   }
	
	//vo를 사용한 Parameter 처리
	@RequestMapping(value="/vo_process.do", method=GET)
	public String voProcess(ParamVO pv, Model m) {
		
		m.addAttribute("langData", pv.getLang()); //이 값은 JSP로 전달된다.포워드형식으로
		m.addAttribute("nameData", pv.getName()); //이 값은 JSP로 전달된다.포워드형식으로
		m.addAttribute("ageData", pv.getAge()); //이 값은 JSP로 전달된다.포워드형식으로
		//객체화를 프레임워크가 해주고 서비스는 내가 함..DI배우면 서비스객체화 내가x
		//System.out.println("----"+pv);
		return "param/vo_process";
	}//voProcess
	
	@RequestMapping(value="/request_string.do", method=GET)
	//단일형으로 매개변수를 받을 때에는 Web parameter명(HTML Form Control명) 과 method의 매개변수명이 같아야 한다.
/*	public String requestString(String name, Model m) {*/
	public String requestString(@RequestParam(defaultValue="anonymous") String name, Model m) {
		// String name,int age, Model m 이렇게 몇개도 받을 수 있지만 vo가 효율적.
		
/*		//문자열인 경우 Parameter의 유효성 검증 가능
		if(name==null || "".equals(name)) { //파라메터 자체가 없을때 가 null. //파라메터가 있으나 값이 없는게 ""
			//파라메터는 존재하나 값이 없을 때 
			name="guest";
		}//end if //코드를 줄일 수 있다.
*/		
		m.addAttribute("name",name+"님 안녕하세용");
		return "param/string_param";
	}//requestString
	
	@RequestMapping(value="/request_int.do", method=GET)
/*	public String requestInt(int age, Model m) { //에러가 나기 시작...널일때 값이 없을때 기본형인경우 Error*/		
	public String requestInt(@RequestParam(name="age",defaultValue="1") int age, Model m) {
		
		m.addAttribute("age",age+"살");
		return "param/int_param";
	}//requestString
}//class
