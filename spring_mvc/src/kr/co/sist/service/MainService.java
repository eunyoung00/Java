package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.Notice;

@Component
public class MainService {
	@Autowired
	private MyBatisDAO mb_dao; //instanse를 내가 하지 않는다~~
	
	public List<Notice> noticeList(){
		List<Notice> list=mb_dao.selectMainNotice();
		return list;
	}//noticeList
	
}//class
