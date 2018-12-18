package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * (JTable)
 * MVC Pattern이 적용된 class 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener{

	private JButton btnAdd;
	private DefaultTableModel dtm;
	private JTable jt;//<테이블에서의 동작으로 값을 얻기 위해 올려줌.
	private UseJTable ujt;//<null상태.(자동 초기화)
	
	public UseJTable() {
		super("JTable 연습");
		ujt=this;//<나를? 주소를 밖에서 쓰고싶으면 객체화(인스턴스 변수로 만들어 준다.)
		//1.데이터를 관리하는 Model 클래스를 생성
		String[] columnNames = {"번호","이름","주소","이메일"};
		String[][] rowData= {
					{"1","이재찬","인천시 소래동","chan@test.com"},
					{"2","정택성","서울시 구로동","teack@test.com"},
					{"3","이재현","경기도 안양시","hyun@test.com"}
		};
//		dtm = new DefaultTableModel(rowData, columnNames);
		dtm = new DefaultTableModel(rowData, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//<메소드를 오버라이딩해 사용! 기본값이 true기 때문에! 메소드 하나때문에 만들기 번거로우니까 anonymous inner class로 사용. 
				//<얘로 데이터의 추가 삭제 다함.
				//<매개변수중 벡터는 동시 접근이 되지 않는ㄷ다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏarrayList는 접근가능..
		//<클릭해서 특정값을 빼오려면 테이블이 먼저 올라가야한다=>빼오는건 JTable의 할일이므로 그땐 인스턴스 변수로 같이 만들어주는게 옳음.
		//<근데 지금은 값을 넣어주니까?????
		//<버튼을 추가했을때 값을 관리하는객체라서 버튼보다 위로올라가야 버튼의 값이 넣어진다
		
		
		//2.데이터를 보여주는 View 클래스 생성.
		jt=new JTable(dtm);//<데이터는 모델이 관리하는 view가 된다.
		
		//테이블 컬럼의 크기 변경 :컬럼은 하나의 넓이를 변경하면 하위 모든 컬럼은 동일한 크기를 적용받는다. 
		//<하나만 바꾸면 그아래 해당컬럼은 다 똑같이 변경된다.테이블의 0번째 값을 가져와 변경
		//<컬럼객체로 얻어 변경..!  getColumnModel()  =>javax.swing.JTable에 존재.
		//< getColumn(Object identifier)  
		//컬럼크기 변경 1)컬럼을 얻는다.
		TableColumn tc =jt.getColumnModel().getColumn(0);
		//컬럼크기 변경 2)컬럼의 크기 변경.
		tc.setPreferredWidth(30);
		
		//테이블 행의 높이 변경
		jt.setRowHeight(25);//< setRowHeight(int rowHeight)  
		
		//더블클릭으로 컬럼값의 수정이 가능한데, 막기위해서~!~!또 이동~!=>테이블에서는 마우스 이벤트를 사용함.inner class로 이동.
		
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt.getColumnModel().getColumn(3).setPreferredWidth(170);//<총 합산한 넓이는 window의 넓이~!=500
		
		btnAdd = new JButton("데이터 추가");
		
		//Column의 이름과 ScrollBar를 사용할 수 있도록 JScrollPane에 배치
		JScrollPane jsp=new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd);
		
		//배치
		add("Center",jsp);
		add("South",jp);
		
		//이벤트 등록
		btnAdd.addActionListener(this);//<인풋다이어로그로 데이터를 추가할것.
		UseJTable.TableEvt te=this.new TableEvt();//inner class의 객체화~!~!
		jt.addMouseListener(te);//inner class의 객체화..?
//		jt.addMouseListener(new this.innerclass명?);
		//jtable의 값을 얻는 method는? 선택한 행을 알때~! jt.getSelectedRow();
		
		setBounds(100,100,500,300);
		setVisible(true);//<window component의 필수~!~!가시화해주지 않으면 보여주지 않는다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseJTable
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData=JOptionPane.showInputDialog("데이터 입력\n예)번호, 이름, 주소, 이메일");
		
		String[] tempData=inputData.split(",");
				//<String Toknizer도 Split도 가능.이대로 넣지 않으면 잘못들어온것으로 간주
		//검증
		if(tempData.length !=4 ) {
			JOptionPane.showMessageDialog(this, "입력 데이터의 형태는 \n번호,이름,주소,이메일 이어야 합니다.",
					"입력 오류", JOptionPane.ERROR_MESSAGE);
			return;//<void일때 리턴은 호출된곳으로 그냥 내려가지말고 돌아가 벼려~!~!
		}//end if
		
		//입력된 데이터를 화면에 보여주기 위해 DefaultTableModel에 추가=>(행추가)
		//<record,row,tuple,추가~!~!
		//< addRow(Vector rowData)  
		dtm.addRow(tempData);
		//<String[]을 넣을수 있을까요? Object에??있어여 tempdata! object이 String의 부모이므로 들어가는것~!~!자식이니까 가능~!
		//<Default table model에 넣는것~!~!

		//<컬럼의 넓이를 바꾸고 싶은건 view인 Jtable의 영역으로 jt쪽에서 해야한다.(위로위로)
		//<setPreferredWidth(int preferredWidth) //특정 컬럼의 객체를 받아와야한다.
		//<컬럼의 객체를 저장하는게javax.swing.table.TableColumn 인데, 인덱스로 관리
		
	}//actionPerformed
	////////////////////////////////inner class 시작////////////////////////////////////////////////
	public class TableEvt extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent me) {//이벤트로 비교하는건 아니지만 me
//			System.out.println("행선택 : "+jt.getSelectedRow()+",열선택 : "+jt.getSelectedColumn());
			//<선택한 컬럼값의 행과 열을 알수 있다.
//			System.out.println(jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));
			//<값얻기~!
//			String selectedValue=jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());//위에거랑다를게 없으니까
			//<getValueAt 은 반환형이 object이 나와 String에 못들어간다. 부모는 자식이 누군지 알수 없으니까~! 못들어간다.
			String selectValue=(String)jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());//형?변환
			//<하나만 빠지는데 모든값을 얻고싶다...!
//			String selectValue0=(String)jt.getValueAt(jt.getSelectedRow(), 0);
//			String selectValue1=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//			String selectValue2=(String)jt.getValueAt(jt.getSelectedRow(), 2);
//			String selectValue3=(String)jt.getValueAt(jt.getSelectedRow(), 3);//이렇게 해도 상관은 없다!
			//<몇개 안되는데 굳이 for를 할 필요까지는 없다.
			//<중복코드가 많아 for문으로=>
			StringBuilder viewData=new StringBuilder();
			int selectedRow=jt.getSelectedRow();
			int columnCount=jt.getColumnCount();
			
			//선택한 행 삭제
			int flag=JOptionPane.showConfirmDialog(ujt, "\"예\"를 누르면 조회, \"아니요\"를 누르면 삭제를 수행합니다.");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				for(int i=0; i<columnCount; i++) {
					viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}//end for
				JOptionPane.showMessageDialog(ujt, viewData);
				break;
			case JOptionPane.NO_OPTION:
				switch (JOptionPane.showConfirmDialog(ujt, "정말 삭제하세겠습니까?")) {//변경과 삭제는 반드시 물어보고 해야한다.
				case JOptionPane.OK_OPTION: 
					dtm.removeRow(selectedRow);
				}//end switch
			}//end switch
			
//			for(int i=0; i<columnCount; i++) {
//				viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
//			}//end for
////////위로 옮겨서 주석
//			JOptionPane.showMessageDialog(/*부모 컴퍼넌트 객체=>여기서 this는 mouseAdapter가 되어x,
//			view가 아니라 window가 부모니까 jt도 들어가지만 올바른 방법이 아니다.
//			위에서 객체화를 해서 넣어주면 된다...null해도 되긴된다...나중에 한번씩 오류가 나긴해..*/ujt, viewData);
			
			//<클릭하면 뜨니까 잠깐 막아두고...더블클릭막을방법
			//<isCellEditable(int row,int column) 선택한 행과열이 수정가능하다고 true가 나온다.
			//은 ture가 나오는데 무조건 false로 내보내야한다.=>위로위로 DefaultTableModel
			
			//javax.swing.table.DefaultTableModel에 있는 method: removeRow(int row)  선택한 행 삭제
			
			
		}//mouseClicked
		
	}//class
	////////////////////////////////inner class 끝//////////////////////////////////////////////////
	public static void main(String[] args) {
		new UseJTable();
		//<인스턴스화는 객체를 생성하기 위해서 한것 생성자라는게 호출되고 객체는 그럼 자기가 가지고 있는 인스턴스 변수를 Heap에 올리고 가장첫주소를 반환.
	}//main

}//class
