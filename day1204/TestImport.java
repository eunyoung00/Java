package day1204;

import java.util.Date;
import java.util.List;
import java.util.Random;
//import java.awt.List;
//��Ű���� �ٸ��� �̸��� ���� Ŭ����(or�������̽�)�� ���� �ϳ��� import ���� �� �ִ�.
//<�ѹ��̶� �� ���̾��� Ŭ������ ������ �ȴ�.

//import java.util.*;//��Ű�� ���� ��� class�Ǵ� interface�� �ѹ��� ����� �� �ִ�,but����...
/**
 * import : �ٸ� ��Ű���� Ŭ������ �����Ͽ� ����� ��.
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();
		//<���� ��Ű���� lang��Ű���� �ִ°�쿡�� ��밡���ϳ�, �ƴϹǷ� import.
		Random r1 = new Random();
		Random r2 = new Random();//import�Ǹ� ����̵� ���� �ִ�.
		
		Date d = new Date();
		//Ctrl+shift+o import�ѹ���.. ���� ���� ����.
		
//		List list = new ArrayList();	
		//�����̸��� Ŭ����(interface)�� �� �� ���� ���Ǵ� ���� import�� ó���ϰ�,
		//���� ���Ǵ� ���� full path �� ó���Ѵ�.
		java.awt.List list = null;  //awt.List
		List list1 = null;	//util.List
		List list2 = null;	//util.List

	}//main
}//class
