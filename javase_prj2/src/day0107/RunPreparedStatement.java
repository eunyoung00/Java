package day0107;

import java.sql.SQLException;
import javax.swing.JOptionPane;


public class RunPreparedStatement {
	
	private UsePreparedStatementDAO ups_dao;
	
	public RunPreparedStatement() {
		ups_dao=new UsePreparedStatementDAO();
	}//RunPreparedStatement

	public void addCpEmp2() {
		String tempData=JOptionPane.showInputDialog("사원 정보 추가 \n입력 예)사원번호,사원명,연봉");
		if(tempData!=null && !tempData.equals("")) {//데이터가 있다면  null.equals이니까 후항은 실행되지 않아서 Error발생하지 않는다.
			String[] data=tempData.split(",");
			if(data.length!=3) {//잘못들어간 데이터
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;
			}//end if
			
			int empno=0,sal=0;
			String ename="";
			
			try {
				empno=Integer.parseInt(data[0]);
				ename=data[1];
				sal=Integer.parseInt(data[2]);
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원 번호나 연봉은 숫자입니다.");
				return;
			}//end catch
			
			//처리된 입력데이터를 VO에 설정하고
			CpEmp2VO cevo =new CpEmp2VO(empno,sal,ename);
			
			//VO의 값을 DB에 insert한다.
			try {
				ups_dao.insertCpEmp2(cevo);//추가성공
				JOptionPane.showMessageDialog(null, empno+"번 사원 정보가 입력되었습니다.");
			} catch (SQLException se) {//예외
				
				String errMsg="";
				switch (se.getErrorCode()) {
//				case 1:	errMsg=deptno+"번 부서는 이미 존재합니다."; break;
				case 1438:	errMsg="사원 번호는 4자리 이고, 연봉은 5자리 입니다."; break;//업데이트할때에도 나온다.
				case 12899:	errMsg="사원명이 너무 깁니다."; break;

				default: errMsg="뎨둉합니다.시스템에 문제가 발생했습니다. 잠시 후 다시 시도해 주세요.";	
				}//end switch
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}//end catch
		}//end if
	}//addCpEmp2
	
	public void modifyCpEmp2() {
		
	}//modifyCpEmp2
	public void removeCpEmp2() {
		
	}//removeCpEmp2
	public void searchAllCpEmp2() {
		
	}//searchAllCpEmp2
	public void searchOneCpEmp2() {
		
	}//searchOneCpEmp2
	
	public static void main(String[] args) {
		RunPreparedStatement rps=new RunPreparedStatement();
		
		boolean exitFlag=false;
		String inputMenu="";
		do {
			inputMenu=JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if (inputMenu!=null/* && !inputMenu.equals("")*/) {
				switch (inputMenu) {//JDK 1.7이상부터 문자열 비교 가능 
				case "1":
					rps.addCpEmp2();
					break;
				case "2":
					rps.modifyCpEmp2();
					break;
				case "3":
					rps.removeCpEmp2();
					break;
				case "4":
					rps.searchAllCpEmp2();
					break;
				case "5":
					rps.searchOneCpEmp2();
					break;
				case "6":
					exitFlag=true;
					break;
	
				default:
					JOptionPane.showMessageDialog(null, inputMenu+"는 제공되는 서비스가 아닙니다.");
					break;
				}//end switch
			}else{
				exitFlag=true;
			}//end if
			
		}while(!exitFlag);
		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다.");
	}//main

}//class
