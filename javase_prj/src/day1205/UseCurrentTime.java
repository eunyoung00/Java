package day1205;

/**
 * 1970년01월01일 00시00분00초로 부터 현재 날짜의 시간을 ms로 얻어내는
 * System.currentTimeMillis() 사용
 * @author owner
 */
public class UseCurrentTime {

	public void test() {
//		long st=System.currentTimeMillis();
		long sum=0;
			for(int i=0; i<10000; i++) {
				sum=sum+i;
				System.out.println(i);//속도가 엄청 느려진다.
				//그래서 나중에 프로그램을 만들땐 사용하지 않는다.
			}
//		long et=System.currentTimeMillis();
//		System.out.println((et-st)+"ms");
	}//test
	
	
	public static void main(String[] args) {
		UseCurrentTime uct = new UseCurrentTime();
		long[] avgTime=new long[15];//10번돌려 평균 수행시간 .
		long st=0;//절대 코드 안에서 변수를 생성하면 안된다.
		//가급적..!병목현상이 발생할 위험이 있기때문!
		long et=0;
		for(int i=0;i<avgTime.length; i++) {
			st=System.currentTimeMillis();
			uct.test();
			et=System.currentTimeMillis();
			avgTime[i]=(et-st);
		}
		System.out.println((et-st)+"ms");
		
		
		
	}//main
}//class
