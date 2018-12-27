package day1130;

/**
 * Override(Overriding)
 * 부모클래스가 제공하는 기능이 자식클래스에 맞지 않는다면 자식클래스에서 부모클래스의 method와 동일한 method를 
 * 정의하여 사용하는것.
 * @author owner
 */
public class OverrideToString {
	
	@Override//헐 이거 그런기능이었군...대박...
	public String toString() {
//		toString();//Error, 부모의 toString 이야,,,,
		
		return "주소가 아니라 OverrideToString 클래스"+super.toString();//super.toString() 부모의 주소
		//그냥썻더니 재귀호출
	}//toString

	
}//class
