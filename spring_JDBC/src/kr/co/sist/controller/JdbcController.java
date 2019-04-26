package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberDetail;
import kr.co.sist.service.JdbcService;

@Controller
public class JdbcController {
	
	@Autowired
	private JdbcService js;
	
	/*@RequestMapping("/index.do")
	public String test() {
		js.daoPrint();
		return "test";
	}*/
	
	@RequestMapping(value="/index.do", method= {GET,POST})
	public String main() {
		return "index";
	}//main
	
	@RequestMapping(value="/add_form.do", method=GET)
	public String memberUploadForm() {
		return "member/add_form";
	}//memberUploadForm
	
	@RequestMapping(value="/addmember_process.do", method=POST)
	public String uploadProcess(HttpServletRequest request) {
		String moveURL="redirect:err/err.html";
		try {
			if(js.fileUploadProcess(request)) {
				moveURL="member/upload_success";
			}//end if
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return moveURL;
	}//uploadProcess
	
	
	@RequestMapping(value="/search_member.do", method=GET)
	public String searchAllMember(Model model) {
		List<Member> list=null;
		list=js.searchAllMember();
		
		model.addAttribute("memberList", list); //requestScope에 들어간다//Session을 받으려면 위에 HttpSession을 사용해야한다..
		
		return "member/member_list";
	}//searchAllMember
	
	@RequestMapping(value="/detail_member.do", method=GET)
	public String searchOneMember(@RequestParam(defaultValue="0") int num, Model model) {
		MemberDetail md=js.searchOneMember(num);
		model.addAttribute("memberData", md);
		return "member/member_detail";
	}//searchOneMember
	
}//class
