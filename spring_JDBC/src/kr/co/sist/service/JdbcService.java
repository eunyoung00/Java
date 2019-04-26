package kr.co.sist.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.dao.JdbcDAO;
import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberDetail;
import kr.co.sist.vo.MemberVO;

@Component
public class JdbcService {
	@Autowired(required=false)
	private JdbcDAO jdao;
	
/*	public void daoPrint() {
		System.out.println("쿼리 실행 객체(JDBC Template) : " + jdao.getJt());
	}*/
	
	public boolean fileUploadProcess(HttpServletRequest request) throws IOException {
		boolean flag=false;
		MultipartRequest mr=new MultipartRequest(request, "C:/dev/workspace/spring_JDBC/WebContent/upload/",
				1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		//System.out.println(mr.getFilesystemName("upfile")+"/"+mr.getOriginalFileName("upfile"));
		MemberVO mv=new MemberVO(mr.getParameter("name"), mr.getFilesystemName("upfile"),
					mr.getParameter("loc"),mr.getParameter("highschool"));
		
		try {
			jdao.insertMember(mv);
			request.setAttribute("inputData", mv);//모덜을 받아다 넣어야 ..
			flag=true;
		}catch (DataAccessException das) {
			das.printStackTrace();
		}//end catch
		
		return flag;
	}//fileUploadProcess
	
	public List<Member> searchAllMember(){
		List<Member> list=null;
		
		try {
			list=jdao.selectAllMember();
		}catch(DataAccessException dae){
			dae.printStackTrace();
		}//end catch
		
		return list;
	}//searchAllMember
	
	//번호에 따른 회원을 조회하는 일
	public MemberDetail searchOneMember(int num) {
		MemberDetail md=null;
		
		try {
			md=jdao.selectOneMember(num);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}//end catch
		
		return md;
	}//searchOneMember
	
	
	
}//class
