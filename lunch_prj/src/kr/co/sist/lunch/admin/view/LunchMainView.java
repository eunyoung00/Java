package kr.co.sist.lunch.admin.view;

import java.awt.BorderLayout;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchMainController;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame {
	
	private JTabbedPane jtb;
	private DefaultTableModel dtmLunch,dtmOrder,dtmCalc;//메뉴,주문,정산.
	private JButton jbtAddLunch,jbtCalcOrder;
	private JComboBox<Integer> jcbYear,jcbMonth,jcbDay;
	private JTable jtLunch,jtOrder,jtCalc;//메뉴,주문
	private DefaultComboBoxModel<Integer> cbmYear,cbmMonth,cbmDay;
	private Calendar cal;
	
	public static String adminId;
	
	private JPopupMenu jpOrderMenu;
	private JMenuItem jmOrderRemove,jmOrderStatus;
	
	public LunchMainView(String adminName) {
		super("도시락 관리 [로그인 계정 : "+adminName+" ]");
		
		cal=Calendar.getInstance();
		jtb=new JTabbedPane();
		
		//////////////////도시락
		String[] lunchColumns= {"번호","도시락 코드","이미지","도시락 명","가격"};
		dtmLunch=new DefaultTableModel(lunchColumns,4) {
			@Override
			public boolean isCellEditable(int row, int column) {//편집 막기
				return false;//로 더블클릭을 할수 있게되었당..
			}//isCellEditable
		};
		jtLunch=new JTable(dtmLunch) {
			@Override
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {//이미지 넣기
				return getValueAt(0, column).getClass();
			}//getColumnClass
		};
		jtLunch.getTableHeader().setResizingAllowed(false);//컬럼의 크기 변경 막기
		jtLunch.getTableHeader().setReorderingAllowed(false);//컬럼의 이동 막기
		
		//도시락 테이블의 크기 설정 : 전체width 800,height /이미지 w122*h110
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(145);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(235);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(220);
		
		//테이블의 높이
		jtLunch.setRowHeight(110);
		
		//////////////////정산
		String[] clacColumns= {"번호","도시락명(도시락코드)","수량","가격"};
		dtmCalc=new DefaultTableModel(clacColumns, 4);
		jtCalc=new JTable(dtmCalc) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEdittable
		};
		JTable jtCalc=new JTable(dtmCalc);
		//정산테이블의 컬럼 넓이 설정 : 전체800,
		jtCalc.getColumnModel().getColumn(0).setPreferredWidth(100);
		jtCalc.getColumnModel().getColumn(1).setPreferredWidth(400);
		jtCalc.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtCalc.getColumnModel().getColumn(3).setPreferredWidth(150);
		//정산테이블의 높이 설정
		jtCalc.setRowHeight(25);
		
		///////////////주문
		String[] orderColumns = {"번호","주문 번호","도시락 코드","도시락명","주문자명","수량","가격","주문일","연락처","주문자 ip","제작 상태"};
		dtmOrder=new DefaultTableModel(orderColumns, 4){
			@Override
			public boolean isCellEditable(int row, int column) {//편집 막기
				return false;//로 더블클릭을 할수 있게되었당..
			}//isCellEditable
		};
		jtOrder=new JTable(dtmOrder);
		
		//주문 테이블 컬럼 넓이 설정 : 전체 800
		jtOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(1).setPreferredWidth(105);
		jtOrder.getColumnModel().getColumn(2).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(3).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(4).setPreferredWidth(55);
		jtOrder.getColumnModel().getColumn(5).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(6).setPreferredWidth(50);
		jtOrder.getColumnModel().getColumn(7).setPreferredWidth(130);
		jtOrder.getColumnModel().getColumn(8).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(9).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(10).setPreferredWidth(60);
		//테이블의 높이
		jtOrder.setRowHeight(23);

		
		jbtAddLunch=new JButton("도시락 추가");
		jbtCalcOrder=new JButton("정산");
		
		cbmYear=new DefaultComboBoxModel<>();
		jcbYear=new JComboBox<Integer>(cbmYear);
		
		cbmMonth=new DefaultComboBoxModel<>();
		jcbMonth=new JComboBox<Integer>(cbmMonth);
		
		cbmDay=new DefaultComboBoxModel<Integer>();
		jcbDay=new JComboBox<>(cbmDay);
		
		JScrollPane jspLunch=new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("도시락 목록"));
		
		JScrollPane jspOrder=new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("주문 목록"));
		
		JScrollPane jspCalc=new JScrollPane(jtCalc);
		jspCalc.setBorder(new TitledBorder("정산"));
		
		//처음텝에 들어갈 컴포넌트 배치
		JPanel jpLunchNorth=new JPanel();
		jpLunchNorth.add(jbtAddLunch);

		JPanel jpLunch=new JPanel();
		jpLunch.setLayout(new BorderLayout());
		jpLunch.add("Center",jspLunch);
		jpLunch.add("North",jpLunchNorth);
		
		jtb.add("도시락", jpLunch);
		
		//두번째 텝에 들어갈 컴포넌트 배치
		JPanel jpOrder=new JPanel();
		jpOrder.setLayout(new BorderLayout());
		jpOrder.add(jspOrder);
		
		jtb.add("주문", jpOrder);
		//세번째 텝에 들어갈 컴포넌트 배치
		JPanel jpCalc=new JPanel();
		jpCalc.setLayout(new BorderLayout());
		
		JPanel jpCalcNorth=new JPanel();
		jpCalcNorth.setBorder(new TitledBorder("정산 일자 선택"));
		jpCalcNorth.add(jcbYear);
		jpCalcNorth.add(new JLabel("년"));
		jpCalcNorth.add(jcbMonth);
		jpCalcNorth.add(new JLabel("월"));
		jpCalcNorth.add(jcbDay);
		jpCalcNorth.add(new JLabel("일"));
		jpCalcNorth.add(jbtCalcOrder);
		
		jpCalc.add("North", jpCalcNorth);
		jpCalc.add("Center",jspCalc);
		
		jtb.addTab("정산", jpCalc);
		
		//주문 우클릭 팝업메뉴 설정 
		jpOrderMenu=new JPopupMenu();
		jmOrderRemove=new JMenuItem("주문 삭제");
		jmOrderStatus=new JMenuItem("제작 완료");
		
		jpOrderMenu.add(jmOrderStatus);
		jpOrderMenu.addSeparator();
		jpOrderMenu.add(jmOrderRemove);
		
		//텝을 프레임에 배치
		add("Center",jtb);
		
		setYear();//JCB Year설정
		setMonth();//JCB Month설정
		setDay();//JCB Day설정
		
		//이벤트 등록
		LunchMainController lmc=new LunchMainController(this);//<this :컴포넌트나 인스턴스변수가 올라가 쓸수있게된다
		addWindowListener(lmc);

		jtb.addMouseListener(lmc);//탭에서 이벤트가 발생했을 때
		jtLunch.addMouseListener(lmc);
		jtOrder.addMouseListener(lmc);
		
		jbtAddLunch.addActionListener(lmc);
		jbtCalcOrder.addActionListener(lmc);
		
		jcbMonth.addActionListener(lmc);
		
		jmOrderRemove.addActionListener(lmc);
		jmOrderStatus.addActionListener(lmc);
		
		setBounds(100, 100, 800, 600);
		setVisible(true);
		
	}//LunchMainView
	
	private void setYear() {//현재년도의 4년전까지 
		int year =cal.get(Calendar.YEAR);
		for(int temp=0; temp<4;temp++) {
			cbmYear.addElement(year-temp);
		}//end for
		jcbYear.setSelectedItem(new Integer(year));
	}//setYear
	
	private void setMonth() {//월 1~12월
		int now_month=cal.get(Calendar.DAY_OF_MONTH)+1;
		for(int month=1;month<13;month++) {
			cbmMonth.addElement(month);
		}//end for
		jcbMonth.setSelectedItem(new Integer(now_month));
	}//setMonth
	
	private void setDay() {//그 월의 마지막날
		int lastDay=cal.getActualMaximum(Calendar.DATE);
		int nowDay=cal.get(Calendar.DAY_OF_MONTH);
		for(int day=1; day<lastDay+1; day++) {
			cbmDay.addElement(day);
		}//end for
		jcbDay.setSelectedItem(new Integer(nowDay));
	}//setDay
	
	public JTabbedPane getJtb() {
		return jtb;
	}
	public DefaultTableModel getDtmLunch() {
		return dtmLunch;
	}
	public DefaultTableModel getDtmOrder() {
		return dtmOrder;
	}
	public DefaultTableModel getDtmCalc() {
		return dtmCalc;
	}
	public JButton getJbtAddLunch() {
		return jbtAddLunch;
	}
	public JButton getJbtCalcOrder() {
		return jbtCalcOrder;
	}
	public JComboBox<Integer> getJcbYear() {
		return jcbYear;
	}
	public JComboBox<Integer> getJcbMonth() {
		return jcbMonth;
	}
	public JComboBox<Integer> getJcbDay() {
		return jcbDay;
	}
	public JTable getJtLunch() {
		return jtLunch;
	}
	public JTable getJtOrder() {
		return jtOrder;
	}
	public JTable getJtCalc() {
		return jtCalc;
	}
	public DefaultComboBoxModel<Integer> getCbmYear() {
		return cbmYear;
	}
	public DefaultComboBoxModel<Integer> getCbmMonth() {
		return cbmMonth;
	}
	public DefaultComboBoxModel<Integer> getCbmDay() {
		return cbmDay;
	}

	public JPopupMenu getJpOrderMenu() {
		return jpOrderMenu;
	}
	public JMenuItem getJmOrderRemove() {
		return jmOrderRemove;
	}
	public JMenuItem getJmOrderStatus() {
		return jmOrderStatus;
	}
}//class
