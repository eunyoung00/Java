package day1130;

public class SuperConstr {
	int i;
	
	public SuperConstr() {
//		super();
		this(100);//2번
		System.out.println("부모의 기본 생성자");
	}//기본생성자가 없으면 자식생성자에서 Error 인자만 있으면..?
	//생성자 오버로딩
	public SuperConstr(int i) {
//		this();//1번
		this.i=i;
		System.out.println("부모의 인자 생성자"+i);
	}
}
