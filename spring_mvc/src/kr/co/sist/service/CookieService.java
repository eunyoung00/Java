package kr.co.sist.service;

import java.util.Calendar;

public class CookieService {
	//DB�� ������� �ʴ� Service
	public String nameMsg(String name) {
		return "<marquee>"+name+"</marquee>";
	}//nameMsg
	
	public int birth(int age) {
		Calendar cal=Calendar.getInstance();
		
		return cal.get(Calendar.YEAR)-age+1;//�¾ ��
	}//birth
}//class