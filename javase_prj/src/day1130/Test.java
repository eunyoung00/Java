package day1130;

import java.awt.Dialog;
import java.awt.Frame;

public class Test extends Dialog{
//Implicit super constructor Dialog() is undefined for default constructor.
//	public Test() {
//		super();//다이어로그에는 부모생성자가 없어서? Error
	//부모클래스에 기본생성자에 부모생성자?super?가 없다면 API를 보고 가장 적합한 것 찾아넣어?
//	}
	
	public Test() {
		super(new Frame(),"다이얼로그",true);
		//제일큰 창을 프레임/ 그위에 창을 다이얼로그 / 다이얼로그창이 떳을때 부모창이 작동안되는걸 modal, 되는걸 비modal
	}

	
}
