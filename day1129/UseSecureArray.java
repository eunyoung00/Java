package day1129;

import java.util.Arrays;

/**
 * 
 * @author owner
 */
public class UseSecureArray {

	public static void main(String[] args) {
		SecureArray sa= new SecureArray();
		int[] tempArr=sa.getArr();
		//배열 방의 값을 손쉽게 출력 할려면 Array클래스
		//<Arrays.toString로 for없이 손쉽게 출력 가능
		System.out.println(Arrays.toString(tempArr));
		tempArr[0]=190;
		System.out.println(Arrays.toString(tempArr));
		
		//<원래값을 쓰고 싶어서 원래값 다시 받았는데,
		int[] tempArr1=sa.getArr();
		System.out.println(Arrays.toString(tempArr1));
		//<다르다고 생각했지만 주소는 하나라서 변경되고, 변경된 값이 나옴(원본이 리턴될때)
		
		//<SecureArray()클래스의 변경후에는 원본이 변경되지않고 나오는 것을 알수 있다.
		//부를때마다 temp를 생성하여 (복사) 넣기 때문에 복사본이 생성됬다 사라져 유지되는것.
		
		
		
	}//main
}//class
