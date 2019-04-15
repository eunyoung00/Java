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
	//JSP�� �����ϱ� ���ؼ� Scope��ü�� �Ű������� �޴´�.
	//HttpServletRequest�� POJO������ Ŭ������ �ƴϰ� �ǹǷ� �������� �ʴ´�.
	public String useRequest(HttpServletRequest request) {
		
		//��������
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//���������� ��ȸ�Ͽ� JSP�� �����Ѵ�.(Scope ��ü ���)
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletReqeust���");
		
		return "data/use_data";
	}//useRequest
	
	@RequestMapping(value="/view_model.do", method=GET)
	//Model�� ����Ͽ� ������ ����(���� �����ϴ� ���)
	public String useModel(Model m) {
		
		//��������
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//���������� ��ȸ�Ͽ� JSP�� �����Ѵ�.(Scope ��ü ���)
		m.addAttribute("req_data", noticeList); //("req_data", noticeList) Ű�� ���� �� Map- �� Ȱ���Ѱ� Session�� Cookies�ΰ�=>�����ذ� storage
		m.addAttribute("msg", "Model ���");
		
		return "data/use_data";
	}//useRequest
	
	@RequestMapping(value="/view_modelandview.do", method=GET)
	public ModelAndView useModelAndView() { 
		
		//��������
		NoticeService ns=new NoticeService();
		List<Notice> noticeList=ns.searchMainNotice();
		
		//���������� ��ȸ�Ͽ� JSP�� �����Ѵ�.(Scope ��ü ���)
		//1.��ü ����
		ModelAndView mav=new ModelAndView();
		//2.view �� JSP���� ����
		mav.setViewName("data/use_data");
		//3.�����͸� ����
		mav.addObject("req_data", noticeList);
		mav.addObject("msg","ModelAndView ���");
		
		return mav;
	}//useModelAndView
	
	@RequestMapping(value="/use_redirect.do", method=GET)
	public String moveRedirect() {
		//redirect�� return�� �տ� �پ������� WEB_INF/views ������ �̵��ϴ� ���� �ƴ� 
		//Web Content�� ������ �̵��ϰ� �ȴ�. ���� redirect�̱� ������ .jsp�� �״�� ��������.
		return "redirect:day0415/use_redirect.jsp";
	}//moveRedirect
	
}//class
