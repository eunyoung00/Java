package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����ڰ� �Է��� Ű������ ���� ó���ϴ� System.in
 * @author owner
 */
public class UseKeyboardInput {
	public UseKeyboardInput() {
	
		System.out.println("�ƹ�Ű�� ������ ����");
		//3.�Էµ� ��� ���ڿ� �� �ް� �ʹ�!!
		//3.8bit Stream�� 16bit Stream�� ����
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//���� Stream����
		
		try {
			//1.�Է°��� ���� �Է� ���� �ϳ� �ޱ�
//			int input=System.in.read();
			//<read �� ���method ���� �������־�� �Ʒ��� �����̵Ǵ� method�̴�.
			//read�� 8bit�� �ѹ��� �ϳ�..(�³�?)
//			System.out.println("�Է°� : "+input);//<a�� ������ Ű����� �𸥴�?Ű�ڵ� ��65�� �˻�. 
			//Ű�ڵ忡���� �����ڵ�?�о��ִ°Ŷ��?
			//Ű���� ���۴� Ű�ڵ� ���� ������ ���µ�, os���� key�� ���������� key������ ������ ���ڷ� ������ �����ڵ尪���� �ڹٰ���ӽ��� �аԵȴ�.
			//�׷��� �빮�� �ҹ��ڰ� �ٸ� �����ڵ带 �����⶧���� �ٸ������ �����°�.
			//Ű�� ������ os�� ���ٰ� �ڹٰ� �����°�?��
			
			//2.�Էµ� ��� ���ڿ� �ޱ� : �ѱ��� ������ ����.
//			int input=0;
//			while(true) {
//				input =System.in.read();
//				System.out.print((char)input);//char�� ĳ�����ϸ� ������� ���´�..������ �ѱ��� �ȉ�..
//				if(input==13/*Enter�� ��*/) {
//					break;
//				}//end if
//				//if���� ������ 13�� 10�� �����µ�, \n�� \r�� ��µǴ°�. window���� �ٴ´�?
//			}//end while
			
			//16bit Stream�� ����Ͽ� �Էµ� �����͸� �ٴ����� �о� ���δ�.
			String str=br.readLine();
			System.out.println(str);
			//��Ʈ�� ����� �������� ��Ʈ���� ������ ���´�.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//UseKeyboardInput

	public static void main(String[] args) {
		new UseKeyboardInput();
	}//main

}//class
