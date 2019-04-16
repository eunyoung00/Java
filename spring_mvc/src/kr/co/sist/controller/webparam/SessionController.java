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
@SessionAttributes({"an_name","an_addr"})//���⿡ an_flag�� ���� ������ ���� ������
@Controller
public class SessionController {
	
	//��û�� Ư���̸����� ��� ó���Ϸ��� value="/���� �̸�/��û.do" �� �������� ����ϸ� �۾��� ���еȴ�.(������ �ƴϰ� ������ ��������)
	@RequestMapping(value="/session/use_session.do", method=GET)
	//���ǰ��� Controller���� �ޱ�: HttpSession�� �Ű������� �޾Ƽ� ó���Ѵ�. (���� �־��ִ°� �������̼� �޴°� �޴°� �Ű������θ� ���� �� �ִ�.)
	public String sessionForm(HttpSession session) {
		String name=(String) session.getAttribute("ses_name");
		String addr=(String) session.getAttribute("ses_addr");
		System.out.println("----Controller���� ���� ���� �� : ----"+name+"/"+addr);
		
		//�Է��� �����Ͱ� ������
		return "session/session_form";
	}//sessionForm
	
	@RequestMapping(value="/session/session_param.do", method=POST)
	//�ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	public String sessionParam( SessionVO s_vo, HttpSession session ) { //��ü�� ������ ��ũ�� ����� ��
		/*System.out.println("----param is----"+HangulConv.toUTF(s_vo.getName())+"/"+s_vo.getAddr());*/
		//System.out.println("----param is----"+s_vo.getName()+"/"+s_vo.getAddr());
		
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());
		
		String url="session/use_session";//ViewResolver�� ���ؼ� �̵�.
		session.setAttribute("flag", "forward�� �̵�");
		if(new Random().nextBoolean()) {
			session.setAttribute("flag", "redirect�� �̵�");
			url="redirect:use_session.jsp";//view Resolver�� ��ġ�� �ʾ� ��θ� �� �����־�� �Ѵ�.
		}//end if
		
		//return "session/session_form";
		return url;
	}//sessionForm
	
	@RequestMapping(value="/session/remove_session.do", method=GET)
	//������ ���� �� ����
	public String removeSession(HttpSession session) {
	
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");//�α׾ƿ��϶� ������ ��������.
		session.invalidate();//��ȿȭ
		
		return "session/session_form";
	}//removeSession
	
	///////////////////@SessionAttributes�� ����� ���� ó��/////////////////////////////
	@RequestMapping(value="/session/an_use_session.do", method=GET)
	//���ǰ��� Controller���� �ޱ�: HttpSession�� �Ű������� �޾Ƽ� ó���Ѵ�. (���� �־��ִ°� �������̼� �޴°� �޴°� �Ű������θ� ���� �� �ִ�.)
	public String anSessionForm(HttpSession session) {
		String name=(String) session.getAttribute("an_name");
		String addr=(String) session.getAttribute("an_addr");
		System.out.println("----Controller anSessionForm���� ���� ���� �� : ----"+name+"/"+addr);
		
		//�Է��� �����Ͱ� ������
		return "session/an_session_form";
	}//anSessionForm
	
	@RequestMapping(value="/session/an_session_param.do", method=POST)
	//�ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	//@SessionAttributes annotation(���� ���)�� ����ϸ� ������ ���� �ʰ� Model�� �޴´�. 
	public String anSessionParam( SessionVO s_vo, Model model ) { //��ü�� ������ ��ũ�� ����� ��
		
		//���ǿ��� ����� ���� Model��ü�� �����Ѵ�.
		//��, �̸��� ������ ������ �̸��� ���ƾ� �������� ���� �Ҵ� �ȴ�.
		//����� ���� requestScope�� sessionScope�� �����ϰ� �Ҵ� �ȴ�.
		model.addAttribute("an_name", s_vo.getName());
		model.addAttribute("an_addr", s_vo.getAddr());
		
		String url="session/an_session_value";//ViewResolver�� ���ؼ� �̵�.
		model.addAttribute("an_flag", "forward�� �̵�");
		
		return url;
	}//anSessionParam
	
	@RequestMapping(value="/session/an_remove_session.do", method=GET)
	//������ ���� �� ���� (HttpSession�� �Ű������� �޾Ƽ��� @SessionAttribute�� ������ ���� �������� �ʴ´�.
	//1.SessionStatus��� interface��ü�� �Ű������� �����Ͽ� �޾�
	public String anRemoveSession(SessionStatus ss) {
	
		//2.setComplete()�� ȣ���Ͽ� �����Ѵ�.(��� ��)
		ss.setComplete();//�� �ϴ� ����
		System.out.println("----���� ����=----");
		return "session/an_session_form";
	}//removeSession
}//class
