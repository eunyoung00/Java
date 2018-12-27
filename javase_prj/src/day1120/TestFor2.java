package day1120;

/**
 * 다양한 for의 형태
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
		//무한 loop
//		for( ; ; ) {
//			System.out.println("무한 loop");
//			//자원이 고갈될때까지
//		}//end for
//		System.out.println("");//Error

		//증가하는 수를 세는 무한loop
//		for(int i=0;;i++){
//			System.out.println("무한 loop" + i);
//		}//end for
//		//마찬가지로 여기에 코드오면 Error
		
		//증가하는 수를 세는 무한loop일때 break
		for(int i=0; ;i++) {
			System.out.println("무한 loop" + i);
			if(i==50) {
				break;	//가장 인근에 존재하는 반복문을 빠져 나간다.
			}//end if
		}//end for
		System.out.println("");	//여기는와도 에러나지 않는다.
		//break를 쓸떄는 if문이 붙어 있지 않으면 그냥 막 나가 버려서 => break는 꼭 조건문과 함께 사용!!
		//특정 조건을 만족하면 나가라~~그런,
		
		
		//증가하는 수를 세는 무한loop일때, if위치 바꾸어 보고, i변수가 밖으로 나가지 않는걸 봄..
		//int i=0;
		for(int i=0; ;i++) {
			System.out.println("무한 loop" + i);
		//}//end for
			if(i==50) {
				break;	//가장 인근에 존재하는 반복문을 빠져 나간다.=>Error if만이면 반복문없어서?
			}//end if
		System.out.println("");
		}//end for
		//for 에 i를 쓸때는 선언하지 않는다. HDD가 워낙에 빨라 ???
		
		//여러개의 초기값을 사용하는 for
		for(int i=0,j=10,k=30; i<10 && j==30; i++,j++,k--) {
			//<그냥은(컴마로는) 쓸수없고 &&연산자로 i<10 && j==30 붙여줄수 있다.
			System.out.println(i+" "+j+" "+k);
		}//end for
	
	
		//조건식을 잘못 설정하면 무한loop
//		for(int i=0; i<10; i--) {
//			System.out.println(i);
//		}//end for 조건은 주었으나 조건에 맞는 코드가 아니라 무한루프.
		
		
		int i=0;
		for(i=0;i<10;i++);{	//<세미콜론이 들어있어 가장 마지막 값을 보긴한다.(지역변수라 가능한듯)
			System.out.println("반복문 " +i);//이렇게 세미콜론을 잘못 쓰는 경우가 발생하기도 한다.
		}//<중괄호가 인스턴스 영역이라는걸 나중에 알게된다.
	
	
		
	}//main
}//class
