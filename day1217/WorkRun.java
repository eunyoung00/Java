package day1217;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WorkRun {
	
	private List<stuVO> listStu;
	private String inputnum,stu;
	private String[] tempData;
	private JTextArea jta;
	
	public WorkRun() {
//		System.out.println(listStu);//null
		listStu=new ArrayList<stuVO>();
//		System.out.println(listStu);//""
	
	}//WorkRun
	
	public void selectNum() {
		inputnum=JOptionPane.showInputDialog("메뉴선택\n1.입력 2.출력 3.종료");
		
		switch (inputnum) {
		case "1"://입력
			inputData();
			break;
		case "2":
			printData();
			break;
		case "3":
			break;
		default:
			JOptionPane.showMessageDialog(null, "메뉴의 번호를 입력해 주세요");
			selectNum();
		}

	}//selectNum
	
	public void inputData() {//입력->저장->입력창 띄우기
		stu=JOptionPane.showInputDialog("데이터 입력\n예) 이름, 자바점수, 오라클점수");
		stuVO svo=new stuVO();
		tempData=stu.split(",");

		if(tempData.length !=3 ) {//컴마 2개로 데이터가 나누어있지 않으면,다시 첫화면 호출
			JOptionPane.showMessageDialog(null, "입력 데이터의 형태는 \n이름, 자바점수, 오라클점수 이어야 합니다.","입력 오류", JOptionPane.ERROR_MESSAGE);
		}//end if
		svo.setName(tempData[0]);
		svo.setJavaScore(Integer.parseInt(tempData[1]));
		svo.setOracleScore(Integer.parseInt(tempData[2]));//저장
		System.out.println(listStu);//여기에 들어가지 않았다..[]
		selectNum();//다시 입력창 띄우기
	}//inputData
	
	public void printData() {//출력
		//1.JTextArea 생성( 행수, 컬럼수)
		if(listStu.size()==0) {//아예들어간게 없으니까 방의 크기가 0인걸로
			JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
			selectNum();//다시 입력창 띄우기
		}else{//있으면 T.A창에 정보담아서.
			jta = new JTextArea(10,40);
			jta.setEditable(false);
			jta.append(String.valueOf(listStu));
		//2.
		JScrollPane jsp=new JScrollPane(jta);
		//3.MessageDialog의 두번쨰 매개변수에 컴포넌트를 할당
		JOptionPane.showMessageDialog(null, jsp);
		}
	}//printData

	public static void main(String[] args) {
		WorkRun wr = new WorkRun();
		wr.selectNum();
	}//main

}//class
