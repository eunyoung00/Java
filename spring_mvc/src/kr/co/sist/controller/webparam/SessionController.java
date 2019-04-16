package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.vo.SessionVO;
@SessionAttributes({"an_name","an_addr"})//여기에 an_flag가 없기 때문에 들어가지 않은것
@Controller
public class SessionController {
	
	//요청을 특정이름으로 묶어서 처리하려면 value="/묶을 이름/요청.do" 의 형식으로 사용하면 작업이 구분된다.(실제는 아니고 하위의 성격으로)
	@RequestMapping(value="/session/use_session.do", method=GET)
	//세션값을 Controller에서 받기: HttpSession을 매개변수로 받아서 처리한다. (값을 넣어주는건 에노테이션 받는건 받는건 매개변수로만 받을 수 있다.)
	public String sessionForm(HttpSession session) {
		String name=(String) session.getAttribute("ses_name");
		String addr=(String) session.getAttribute("ses_addr");
		System.out.println("----Controller에서 받은 세션 값 : ----"+name+"/"+addr);
		
		//입력한 데이터가 폼으로
		return "session/session_form";
	}//sessionForm
	
	@RequestMapping(value="/session/session_param.do", method=POST)
	//입력되는 매개변수를 세션에 할당한다.
	public String sessionParam( SessionVO s_vo, HttpSession session ) { //객체를 프레임 워크가 만들어 줌
		/*System.out.println("----param is----"+HangulConv.toUTF(s_vo.getName())+"/"+s_vo.getAddr());*/
		//System.out.println("----param is----"+s_vo.getName()+"/"+s_vo.getAddr());
		
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());
		
		String url="session/use_session";//ViewResolver를 통해서 이동.
		session.setAttribute("flag", "forward로 이동");
		if(new Random().nextBoolean()) {
			session.setAttribute("flag", "redirect로 이동");
			url="redirect:use_session.jsp";//view Resolver를 거치지 않아 경로를 다 적어주어야 한다.
		}//end if
		
		//return "session/session_form";
		return url;
	}//sessionForm
	
	@RequestMapping(value="/session/remove_session.do", method=GET)
	//세션이 가진 값 삭제
	public String removeSession(HttpSession session) {
	
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");//로그아웃일때 세션이 지워진다.
		session.invalidate();//무효화
		
		return "session/session_form";
	}//removeSession
	
	///////////////////@SessionAttributes을 사용한 세션 처리/////////////////////////////
	@RequestMapping(value="/session/an_use_session.do", method=GET)
	//세션값을 Controller에서 받기: HttpSession을 매개변수로 받아서 처리한다. (값을 넣어주는건 에노테이션 받는건 받는건 매개변수로만 받을 수 있다.)
	public String anSessionForm(HttpSession session) {
		String name=(String) session.getAttribute("an_name");
		String addr=(String) session.getAttribute("an_addr");
		System.out.println("----Controller anSessionForm에서 받은 세션 값 : ----"+name+"/"+addr);
		
		//입력한 데이터가 폼으로
		return "session/an_session_form";
	}//anSessionForm
	
	@RequestMapping(value="/session/an_session_param.do", method=POST)
	//입력되는 매개변수를 세션에 할당한다.
	//@SessionAttributes annotation(맨위 상단)을 사용하면 세션을 받지 않고 Model만 받는다. 
	public String anSessionParam( SessionVO s_vo, Model model ) { //객체를 프레임 워크가 만들어 줌
		
		//세션에서 사용할 값을 Model객체에 설정한다.
		//단, 이름은 위에서 정의한 이름과 같아야 세션으로 같이 할당 된다.
		//저장된 겂은 requestScope과 sessionScope에 동일하게 할당 된다.
		model.addAttribute("an_name", s_vo.getName());
		model.addAttribute("an_addr", s_vo.getAddr());
		
		String url="session/an_session_value";//ViewResolver를 통해서 이동.
		model.addAttribute("an_flag", "forward로 이동");
		
		return url;
	}//anSessionParam
	
	@RequestMapping(value="/session/an_remove_session.do", method=GET)
	//세션이 가진 값 삭제 (HttpSession을 매개변수로 받아서는 @SessionAttribute에 설정된 값이 삭제되지 않는다.
	//1.SessionStatus라는 interface객체를 매개변수로 선언하여 받아
	public String anRemoveSession(SessionStatus ss) {
	
		//2.setComplete()를 호출하여 삭제한다.(모든 값)
		ss.setComplete();//값 싹다 지움
		System.out.println("----세션 삭제=----");
		return "session/an_session_form";
	}//removeSession
}//class
