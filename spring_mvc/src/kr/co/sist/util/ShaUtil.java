package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class ShaUtil {
	
	private static Base64 base64=new Base64();

	public static String shaEncoding(String plaintext) {
		String cipertext="";
		if(plaintext!=null||"".equals(plaintext)) {
			
			try {
				//1.알고리즘을 사용할 수 있는 객체 얻기
				MessageDigest md=MessageDigest.getInstance("SHA-1");
				//2.평문(plainText)를 암호문(cipherText)로 변환
				md.update(plaintext.getBytes());
				//일반형 해쉬는 키가 존재하지 않지만 암호화에만? 있다..?
				//3.변환된 암호문(ciphertext)얻기
				cipertext=new String(base64.encode(md.digest()));
				
			} catch (NoSuchAlgorithmException e) {//사용할 수 없는 알고리즘을 넣었을 때
				e.printStackTrace();
			}//end catch
		}//end if
		return cipertext;
	}//shaEncoding
	
//	public static void main(String[] args) {
//		System.out.println(shaEncoding("1234567890"));
//	}//main
}//class
