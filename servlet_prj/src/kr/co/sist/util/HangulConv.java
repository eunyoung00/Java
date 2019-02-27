package kr.co.sist.util;

import java.io.UnsupportedEncodingException;

public class HangulConv {
	public static String toUTF(String kor) {
		if(kor!=null || !"".equals(kor)) {
	//kor.equals("")변수자체가 null일때도 있어서 쓰던애는 문제가 나지만, 저렇게 고쳐쓰면 nullpointer발생하지 않는다.  
			try {
				kor=new String(kor.getBytes("8859_1"),"UTF-8");//3byte씩 조합
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return kor;
	}//toUTF
	public static String toEUC(String kor) {
		if(kor!=null || !"".equals(kor)) {
			try {
				kor=new String(kor.getBytes("8859_1"),"EUC-KR");//2byte씩 조합
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return kor;
	}//toUTF
}
