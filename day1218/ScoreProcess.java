package day1218;

import static java.lang.Integer.parseInt;//parseInt만 쓰면 되게끔 만들어 준다.

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScoreProcess {
	private List<ScoreVO> listStu;
	private int totalScore;
	
	public static final int INPUT_DATA=1;
	public static final int VIEW_DATA=2;
	public static final int EXIT=3;
	
	public ScoreProcess() {
		listStu=new ArrayList<ScoreVO>();//인스턴스화
	}//ScoreProcess
	

	/**
	 * 선택메뉴를 제공하는 일
	 */
	public void inputMenu() {
		String selectMenu="",inputResult="";
		
		boolean exitFlag=false;//불린을 하나 만들어서 3일때만 나가게
		do {//계속 나와야 돌아야 하는지라 무조건 제시도 1번 되어야 하고
			selectMenu=JOptionPane.showInputDialog("메뉴 선택\n1.입력 2.출력 3.종료");
//			if(selectMenu.equals("3")) {
//				exitFlag=true;      //flag변수를 만들어서 3이면 ture로 ture일때 나가게 만들어도 된다.
////				break;//으로 반복문을 나가도 되지만
//			}
//			exitFlag=selectMenu.equals("3");//한줄로도 가능해 진다~!~!
			
			try {
				switch (parseInt(selectMenu/*String니까 integer로*/)) {
				case INPUT_DATA:
//					inputData();	break;
					inputResult="데이터의 갯수가 맞지 않거나, 점수는 숫자형태이어야 합니다.";
					if(inputData()) {
						inputResult="추가성공";
					}//end if
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case VIEW_DATA:
					printData();	break;
				case EXIT:
					exitFlag=true; break;
				default:
					JOptionPane.showMessageDialog(null, "메뉴는 1,2,3중 하나 이어야만 합니다.");
				}//end switch
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "메뉴는 숫자 이어야 합니다.");
			}//end catch
		}while(/*true*/!exitFlag);
		
	}//inputMenu
	
	/**
	 * 정보처리할 데이터를 입력받는 일
	 * @return 
	 */
	public boolean inputData() {
		boolean flag=false;
		
		String inputData=JOptionPane.showInputDialog("데이터 입력\n예) 이름, 자바점수, 오라클점수");
		try {//취소누르면 nullpoint떠...
		String[] data=inputData.replaceAll(" ", "").split(",");//<공백없애주고 컴마에서 잘라쥬
		if(data.length==3) { //입력형식에 맞을 때
			try {
				ScoreVO sv=new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
				listStu.add(sv);//정제된 데이터를 list에 추가
				flag=true;//실행 결과를 저장.
			//자바점수와 오라클점수는 숫자 이어야 한다.
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "자바점수와 오라클점수는 숫자 이어야 합니다.");
				flag=false;
			}//end catch
			
		}//end if
		}catch (NullPointerException npe) {
		
		}//end catch
		
		return flag;
	}//inputData
	
	/**
	 * 입력정보를 출력하는 일 
	 */
	public void printData() {
		if(listStu.size()==0) {
			JOptionPane.showMessageDialog(null, "출력할 데이터가 없습니다.");
			return;//아래로 흘러가지 않게
		}//end if
		
		StringBuilder viewData=new StringBuilder();
		viewData
			.append("-----------------------------------------\n")
			.append("번호\t이름\t자바\t오라클\t총점\t평균\n")
			.append("-----------------------------------------\n");
		int tempTotal=0;
		ScoreVO sv=null;
		for(int i=0;i<listStu.size();i++) {
			sv=listStu.get(i);
			tempTotal=sv.getJavaScore()+sv.getOracleScore();
			viewData.append(i+1).append("\t").append(sv.getName())
			.append("\t").append(sv.getJavaScore())
			.append("\t").append(sv.getOracleScore()).append("\t").append(tempTotal)
			.append("\t").append(tempTotal/2.0).append("\n");
			
			totalScore+=tempTotal;//한 학생의 자바점수와 오라클 점수를 더한 값을 누적합.
			tempTotal=0;//한 학생의 총점 변수를 초기화
		}//end for
//		DecimalFormat df = new DecimalFormat("00.00");
		viewData.append("-----------------------------------------\n")
		.append("\t\t\t\t총점").append(totalScore).append("\t평균")
		.append(String.format("%5.2f",totalScore/((double)listStu.size()*2)));
		//value Arguments 실수)	"%전체자릿수.실수자릿수f" 

		JTextArea jta=new JTextArea(7,50);
		jta.append(/*String.valueOf(viewData)*/viewData.toString());//화면을 구성한 데이터를 JTA에 붙여준다.
		JScrollPane jsp=new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
		
	}//printData
	
	public static void main(String[] args) {
		ScoreProcess sp =new ScoreProcess();
		sp.inputMenu();
	}//main

}//class
