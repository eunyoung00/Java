package day1127;

/**
 * 1차원 배열 : 행하나의 열로만 구성된 배열<br>
 * 배열 - 메모리에 동일 데이터형으로 나열된 데이터형.<br>
 * 참조형 데이터형, 고정길이형<br>
 * 일괄처리시 사용(배치처리랑 같은말)<br>
 * 방의 수를 얻기(배열명.length)
 * 
 * @author owner
 */
public class UseArray1 {
	
	/**
	 * 1차원 배열을 참조형 형식으로 사용.
	 */
	public UseArray1() {
//		System.out.println("생성자");
		//1.배열 선언) 데이터형[] 배열명 =null;
		int[] arr=null;
//		System.out.println("arr");
		//2.배열 생성) 배열명=new 데이터형[방의갯수];
		//배열을 생성하면 모든 방의 값이 초기화 된다.
		arr=new int[6];
		//1+2 선언과 생성) 데이터형[] 배열명=new 데이터형[방의갯수];
		int[] arr1 = new int[8];
		System.out.println(arr+"/"+arr1);
		
		System.out.println("arr 배열 방의 갯수 "+arr.length+", arr1배열방의 갯수 : "
							+arr1.length);
		//3.값할당) 배열명[방의 인덱스]=값;
		arr[0]= 11;
		arr[1]= 27;
		arr[2]= 14;
		arr[3]= 46;
		//4.값 사용)
		System.out.printf("arr[0]=%d, arr[1]=%d,arr[2]=%d\n"
							,arr[0],arr[1],arr[2]);
		//배열에 없는 인덱스를 사용하면 Error
//		arr[6]=10;//Error
		System.out.println("arr[5]="+arr[5]);
	
		System.out.println("-----------------------------------------");
		//일괄 처리
		for(int i=0; i<arr.length; i++) {//length는 keyword라 ()없이 가능.
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}

	

	}//UseArray1
	
	/**
	 * 1차원 배열의 기본형 형식의 사용. new 사용x
	 */
	public void arrayPrimitive() {
		System.out.println("====================기본형 형식의 사용========================");
		//1.선언 : 데이터형[] 배열명 = {값,,,};
		int[] arr= {2019,11,27,15,20};
		System.out.println("방의 수 : "+arr.length);
//		int[] arr1 = new int[6] {1,2,3,4,5,6,7};//방의 갯수를 정의하면 Error
		int[] arr1 = new int[] {1,2,3,4,5,6,7};
		System.out.println("arr1의 방의 수 : "+arr1.length);
		
		arr[0]=  2019;
		System.out.println(arr[0]+"/"+arr[1]);
		//초기화된 방에 값을 집어넣는건 전혀 상관이 없다.
		
		//모든방의 값
		for(int i = 0;i<arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}//end for
		/*
		개선된 또는 향상된 for :배열이나 Collection(List,Set)의 처음 방부터 끝방까지
		모든방의 값을 순차적으로 손쉽게 출력 할 때, 사용.
		for(배열방의 값을 저장한 변수 : 배열 (list,set)){
			변수명
		}*/
		for(int value :arr1) {
			System.out.println(value);
		}//end for//디컴파일 해보면 원래의 for문 처럼 보여진다.
		//생성될때마다 int가 생성됬다 사라지다 하기때문에 병목. 느려진다.
		
		//arr1배열의 마지막 방부터 처음 방까지 출력
		int idx = arr1.length-1;
		for(int i=0;i<arr1.length; i++) {
				System.out.print("arr1["+idx+"]="+arr1[idx]+" ");
				idx=idx-1;
		}//end for 
		System.out.println();
		for(int i=arr1.length-1; i>=0; i--) {
			System.out.print("arr1["+i+"]="+arr1[i]+" ");
		}
		
		
	}//arrayPrimitive
	
	
	

//	public void method() {
//		System.out.println("method");		
//	}//method
	
	
	public static void main(String[] args) {
//		UseArray1 ua1 = new UseArray1();
//		//생성자가 만들다 말아 저장할 필요가 없음
		new UseArray1();
		new UseArray1().arrayPrimitive();
		//<인스턴스를 저장하지 않고 쓰는방법.
//		new UseArray1().method();//객체화
		
		
	}//main
}//class
