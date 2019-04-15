package kr.co.sist.service;

import java.util.List;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.Notice;

public class NoticeService {
	
	public List<Notice> searchMainNotice(){
		List<Notice> list=null;
		
		MyBatisDAO mb_dao=MyBatisDAO.getInstance();
		list=mb_dao.selectMainNotice();//pojo형 o
		//공지사항은 15자까지만 보여준다.
		for(Notice temp: list) {
			if(temp.getSubject().length() > 15) {
				temp.setSubject(temp.getSubject().substring(0, 14)+"...");
			}//end if
		}//end for
		
		return list;
	}//searchMainNotice

	public static void main(String[] args) {
		//단위테스트는 dao든 서비스든 ok 서비스에있으면 dao+서비스의 단위테스트
		NoticeService ns=new NoticeService();
		ns.searchMainNotice();
		//System.out.println(ns.searchMainNotice());
	}//main
}//class
