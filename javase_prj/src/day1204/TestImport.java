package day1204;

import java.util.Date;
import java.util.List;
import java.util.Random;
//import java.awt.List;
//패키지는 다르나 이름이 같은 클래스(or인터페이스)는 둘중 하나만 import 받을 수 있다.
//<한번이라도 더 많이쓰는 클래스를 받으면 된다.

//import java.util.*;//패키지 내의 모든 class또는 interface를 한번에 사용할 수 있다,but별로...
/**
 * import : 다른 패키지의 클래스를 참조하여 사용할 때.
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();
		//<같은 패키지나 lang패키지에 있는경우에는 사용가능하나, 아니므로 import.
		Random r1 = new Random();
		Random r2 = new Random();//import되면 몇번이든 쓸수 있다.
		
		Date d = new Date();
		//Ctrl+shift+o import한번에.. 거의 쓸일 없다.
		
//		List list = new ArrayList();	
		//같은이름의 클래스(interface)는 둘 중 많이 사용되는 것을 import로 처리하고,
		//적게 사용되는 것을 full path 로 처리한다.
		java.awt.List list = null;  //awt.List
		List list1 = null;	//util.List
		List list2 = null;	//util.List

	}//main
}//class
