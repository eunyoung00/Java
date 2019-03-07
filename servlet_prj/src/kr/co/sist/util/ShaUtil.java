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
				//1.�˰����� ����� �� �ִ� ��ü ���
				MessageDigest md=MessageDigest.getInstance("SHA-1");
				//2.��(plainText)�� ��ȣ��(cipherText)�� ��ȯ
				md.update(plaintext.getBytes());
				//�Ϲ��� �ؽ��� Ű�� �������� ������ ��ȣȭ����? �ִ�..?
				//3.��ȯ�� ��ȣ��(ciphertext)���
				cipertext=new String(base64.encode(md.digest()));
				
			} catch (NoSuchAlgorithmException e) {//����� �� ���� �˰����� �־��� ��
				e.printStackTrace();
			}//end catch
		}//end if
		return cipertext;
	}//shaEncoding
	
//	public static void main(String[] args) {
//		System.out.println(shaEncoding("1234567890"));
//	}//main
}//class
