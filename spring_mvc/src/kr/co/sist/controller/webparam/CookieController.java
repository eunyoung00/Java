package kr.co.sist.controller.webparam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.CookieService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
//@Controller가 없다면 찾을 수 없다.
public class CookieController {
	@RequestMapping(value="cookie/read_cookie.do", method=GET)
	public String readCookie(HttpServletRequest request, Model model) {
		
		//1.쿠키들 읽기
		Cookie[] cookies=request.getCookies();
		model.addAttribute("rCookie",cookies); //읽어들인 모든 쿠키의 모든 값을 jsp에서 사용할 수 있다.
		
		if(cookies !=null) { //읽어들인 쿠키 존재
			
			CookieService cs=new CookieService();
			int cnt=0;
			Cookie tempCookie=null;
			for(int i=0; i<cookies.length; i++) { //Controller에서 쿠키의 값으로 업무처리를 하기 위해서 for를 돌렸다.
				tempCookie=cookies[i];  /////쿠키의 값은 컨트롤러나 서비스에서 사용해야 한다면 for
				if("JSESSIONID".equals(tempCookie.getName())) {
					cnt++;
				}//end if 
				//쿠키는 name="ㅇㅇ", age=32 이렇게 들어가기 때문에...getName으로 name인지 age인지 비교하여 값을 가져와 model에 넣어주는것.
				if("name".equals(tempCookie.getName())) {
					model.addAttribute("name", cs.nameMsg(tempCookie.getValue()));
					cnt++;
				}//end if
				if("age".equals(tempCookie.getName())) {
					model.addAttribute("birth", cs.birth(Integer.parseInt(tempCookie.getValue())));
				}//end if
			}//end for
			
			if(cnt==1) { //JSESSIONID만 존재하는 경우
				model.addAttribute("rCookie",null);
			}//end if
		}//end if
		
		return "cookie/read_cookie";
	}//readCookie
	
	@RequestMapping(value="cookie/add_cookie.do", method=GET)
	public String addCookie(HttpServletResponse response, Model model) {
		
		//1.쿠키 생성
		Cookie nameCookie=new Cookie("name", "seonui.gong"); ////한글을 바로 넣어서는 쿠키에 들어가지 않는다. 
		Cookie ageCookie=new Cookie("age", "28");  
		//2.쿠키의 생존시간 설정 : 브라우저가 열려있으면 계속 유지가 되지만 브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(60*2);
		ageCookie.setMaxAge(60*2);
		//3.쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg", "접속자 컴퓨터로 쿠키 생성");
		
		return "cookie/read_cookie"; //심었으니 읽기로
	}//addCookie
	
	@RequestMapping(value="/cookie/remove_cookie.do", method=GET)
	public String removeCookie(HttpServletResponse response, Model model) {
		//1.같은이름의 쿠키를 생성한다.
		Cookie nameCookie=new Cookie("name", ""); //웹에서 제일 말을 안듣는 쿠키와 세션이라 혹시라도 값이 얻어지지 않도록 초기화
		Cookie ageCookie=new Cookie("age", "");  
		//2.쿠키의 생존시간 설정 : 0으로 설정
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		//3.쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg", "쿠키가 삭제되었습니다.");
		
		return "cookie/read_cookie";
	}//removeCookie
	
	
	//////////////////////////////////@CookieValue annotation 사용////////////////////////////////////////////
	@RequestMapping(value="/cookie/read_an_cookie.do", method=GET)
	public String anReadCookie(
						@CookieValue(value="an_name",defaultValue="")String an_name,
						@CookieValue(value="an_age",defaultValue="")String an_age, Model model) {
		
		System.out.println("쿠키의 값 이름 : "+an_name);//값 만 찍어볼 수 있다.
		System.out.println("쿠키의 값 나이 : "+an_age);//값 만 찍어볼 수 있다.
		
		model.addAttribute("an_name",an_name);
		model.addAttribute("an_age",an_age);
		
		return "cookie/an_read_cookie";
	}//anReadCookie
	
	@RequestMapping(value="cookie/an_add_cookie.do", method=GET)
	public String anAddCookie(HttpServletResponse response) {
		
		//1.쿠키 생성
		Cookie nameCookie=new Cookie("an_name", "jungyun"); ////한글을 바로 넣어서는 쿠키에 들어가지 않는다. 
		Cookie ageCookie=new Cookie("an_age", "30");  
		//2.쿠키의 생존시간 설정 : 브라우저가 열려있으면 계속 유지가 되지만 브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(60*60);
		ageCookie.setMaxAge(60*60);
		//3.쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		return "cookie/an_cookie_result"; //심었으니 읽기로
	}//addCookie
}//class
