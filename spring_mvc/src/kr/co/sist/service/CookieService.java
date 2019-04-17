package kr.co.sist.service;

import java.util.Calendar;

public class CookieService {
	//DB를 사용하지 않는 Service
	public String nameMsg(String name) {
		return "<marquee>"+name+"</marquee>";
	}//nameMsg
	
	public int birth(int age) {
		Calendar cal=Calendar.getInstance();
		
		return cal.get(Calendar.YEAR)-age+1;//태어난 해
	}//birth
}//class
