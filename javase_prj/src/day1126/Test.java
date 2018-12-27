package day1126;

public class Test {
	int i ;
	public void temp(int i) {
		System.out.println(i);
//		i=i;
		
	}
	public void temp(int i,Test t){
		//매개변수 parameter 복사, 주소 //지역변수의 일종
	    System.out.println(i);//1000
//	    i=i//지역변수=지역변수
	    t.i=i;//지역변수오 ㅏ인트턴스 변수이름이 같아 지역변수 껄 먼저쓴다.
	    //10번지의 값을 그대로 가져와 주소를
	    
	}

	public static void main(String[] args) {
		Test t = new Test();
//	    t.temp=1000;
		t.temp(1000, t);
	    System.out.println(t.i);//0->1000
	}
//매개변수와 인스턴스 변수와 이름이 같을때 heap과 stack의 변수임을 정확히 해주어야하는데,
//heap에는 항상 주소를 붙여사용하게 된다.
//
}
