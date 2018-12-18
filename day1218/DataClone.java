package day1218;

import java.util.Stack;

public class DataClone {

	private Stack<Data> historyStack;
	
	public DataClone() {
		historyStack=new Stack<Data>();
	}//DataClone
	
	public void useData() throws CloneNotSupportedException {
		Data d=new Data("쌍용 유치원");
		
		if(d instanceof Cloneable) {//자바에서 유일한 문자열(로된?) 연산자..! 거의진짜 안씀...
			
		d.setSchool("쌍용초등학교");
		Data d1=d.getData();//복제
		historyStack.push(d1);
		
		d.setSchool("쌍용중학교");
		Data d2=d.getData();
		historyStack.push(d2);
		
		d.setSchool("쌍용고등학교");
		Data d3=d.getData();
		historyStack.push(d3);
		
		d.setSchool("쌍용대학교");
		historyStack.push(d.getData());//이쁘게 보려고 d.getData()을 저장 해준것.
		
		getHistoryData();
		}else {
			System.out.println("Cloneable만 처리합니다.");
		}//end else
	}//useData
	
	public void getHistoryData() {

		Data temp=null;
		while(!historyStack.empty()) {
			temp=historyStack.pop();
			System.out.println(temp);//다 다른 주소를 가진다.
			System.out.println(temp.getSchool());
		}//end while
	}//getHistoryData
	
	public static void main(String[] args) {
		try {//getData부터 예외처리가 날라옴...
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.out.println("복제되지 않습니다.");
			e.printStackTrace();
		}//end catch
	}//main

}//class
