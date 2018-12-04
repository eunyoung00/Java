package day1130;

public class SubConstr extends SuperConstr {
	int i;
	public SubConstr() {
//		super(300);
//		this(200);//1번
		System.out.println("자식의 기본생성자");
	}//SubConstr
	
	public SubConstr(int i) {
//		super(300);//1번
		this();//2번
		System.out.println("자식의 인자생성자"+i);
	}//SubConstr
}
