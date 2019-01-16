package day0111;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TestSite extends JFrame {

	private JTable jtab;
	private DefaultTableModel dtmtab;
	
	public TestSite() {
		super("웹사이트 테이블");
		String[] columnNames= {"로고","URL","특징"};
		
		//강사님부분
		Object[][] rowData=new Object[3][3];
		rowData[0][0]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
		rowData[0][1]="https://www.daum.net/";
		rowData[0][2]="카카오";
		rowData[1][0]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
		rowData[1][1]="https://www.naver.com/";
		rowData[1][2]="웹툰";
		rowData[2][0]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
		rowData[2][1]="https://www.google.com/";
		rowData[2][2]="검색";
		
		dtmtab=new DefaultTableModel(rowData, columnNames);
//		jtab=new JTable(dtmtab);//입력된 객체의 toString() 호출하는 기능을 가졌는데 그대로 나오게 고쳐야함.
		//<들어간 클래스가 문자열이 아니라 그 클래스 그대로 나와야 한다.
		//<입력된 객체가 그대로 출력 =>ovrride 하여 부모의 기능을 수정
		
		//입력된 클래스가 그대로 Cell(columns)에 표현되도록 method Override
		//getColumnclass(int column)
		jtab=new JTable(dtmtab) {//ananymous class
			@Override
			public Class getColumnClass(int column) {//column : 들어오는 모든 컬럼
				//getValueAt:지정한 값
				//row-JTable에 입력된 이차원 배열의 행에 속한다면 어떤행이던간에 
				//모든 컬럼의 값을 입력된 형으로 반환한다.
				return getValueAt(0, column).getClass();
//				return getValueAt(3, column).getClass();//있는행이어야만 바꾸어주고 없어서 Error
				//뒤에 컬럼을 지정해줄 경우에는 그 줄만 바뀌어 나온다...
				//<입력된 객체의 원래 값 return
				//<0행인 이유는? : jtable에 입력된 모든 행에 대해 받아들임???지정한 특정행?
			}//getColumnClass
		};
		JScrollPane jsp = new JScrollPane(jtab);
		
		jtab.getTableHeader().setResizingAllowed(false);//컬럼의 크기 변경 막기
		jtab.getTableHeader().setReorderingAllowed(false);//컬럼의 이동 막기
		
		jtab.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(160);
		jtab.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
		jtab.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
		///강사님끗
		
		//나
//		dtmtab=new DefaultTableModel(0,0);
//		jtab=new JTable(dtmtab);
//		String[] rogo={"C:/dev/workspace/javase_prj2/src/day0111/images/daum.png",
//						"C:/dev/workspace/javase_prj2/src/day0111/images/naver.png",
//						"C:/dev/workspace/javase_prj2/src/day0111/images/google.png"};
////		ImageIcon rogo0= new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
////		ImageIcon rogo1= new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
////		ImageIcon rogo2= new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");
//		String[] url= {"https://www.google.com","https://www.naver.com/","https://www.daum.net/"};
//		String[] feature= {"카카오","웹툰","검색"};
//		
//		dtmtab.addColumn(columnNames[0],rogo);
//		dtmtab.addColumn(columnNames[1], url);
//		dtmtab.addColumn(columnNames[2], feature);
//		jtab.getTableHeader().setReorderingAllowed(false);//컬럼 이동 막기
		
		jtab.setRowHeight(50);//레코드 높이	
		
		add(jsp);
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//TestSite

	public static void main(String[] args) {
		new TestSite();
	}//main
}//class
