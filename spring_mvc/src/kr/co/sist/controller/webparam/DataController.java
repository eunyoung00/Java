package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.domain.Notice;
import kr.co.sist.service.NoticeService;

@Controller
public class DataController {
	
	@RequestMapping(value="/view_request.do", method=GET)
	//JSP로 전달하기 위해서 Scope객체를 매개변수로 받는다.
	//HttpServletRequest는 POJO형식의 클래스가 아니게 되므로 권장하지 않는다.
	public String useRequest(HttpServletRequest request) {
		
		//업무수행
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//공지사항을 조회하여 JSP로 전달한다.(Scope 객체 사용)
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletReqeust사용");
		
		return "data/use_data";
	}//useRequest
	
	@RequestMapping(value="/view_model.do", method=GET)
	//Model을 사용하여 데이터 전달(가장 권장하는 방법)
	public String useModel(Model m) {
		
		//업무수행
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//공지사항을 조회하여 JSP로 전달한다.(Scope 객체 사용)
		m.addAttribute("req_data", noticeList); //("req_data", noticeList) 키와 값의 쌍 Map- 을 활용한게 Session과 Cookies인것=>단점해결 storage
		m.addAttribute("msg", "Model 사용");
		
		return "data/use_data";
	}//useRequest
	
	@RequestMapping(value="/view_modelandview.do", method=GET)
	public ModelAndView useModelAndView() { 
		
		//업무수행
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//공지사항을 조회하여 JSP로 전달한다.(Scope 객체 사용)
		//1.객체 생성
		ModelAndView mav=new ModelAndView();
		//2.view 할 JSP명을 설정
		mav.setViewName("data/use_data");
		//3.데이터를 설정
		mav.addObject("req_data", noticeList);
		mav.addObject("msg","ModelAndView 사용");
		
		return mav;
	}//useModelAndView
	
	@RequestMapping(value="/use_redirect.do", method=GET)
	public String moveRedirect() {
		//redirect가 return값 앞에 붙어있으면 WEB_INF/views 폴더로 이동하는 것이 아닌 
		//Web Content내 폴더로 이동하게 된다. 또한 redirect이기 때문에 .jsp가 그대로 보여진다.
		return "redirect:day0415/use_redirect.jsp";
	}//moveRedirect
	
}//class
