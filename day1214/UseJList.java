package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * JList)
 * MVC Pattern을 기반으로한 Component의 사용.
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener,MouseListener/*ListSelectionListener*/{

	private JList<String> jl;  //View
	private DefaultListModel<String> dlm;  //Model
	private JLabel jlOutput;
	private JButton jb;
	
	public UseJList() {
		super("JList의 사용");
		
		dlm=new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");
		
		jl=new JList<String>(dlm);
		
		//ScrollBar가 없는 JList에게 ScrollBar 설정
		JScrollPane jsp=new JScrollPane(jl);
		
		jlOutput=new JLabel("출력");
		jlOutput.setBorder(new TitledBorder("선택 아이템"));
		
		jb=new JButton("입력");
		
		add("North",jb);
//		add("Center",jl);
		add("Center",jsp);//컴포넌트를 가진 스트롤바 객체를 배치
		add("South",jlOutput);
		
		//이벤트
		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJList
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String lang= JOptionPane.showInputDialog("컴퓨터 개발관련 언어를 입력");
//		System.out.println(lang);
		//입력데이터이므로 Model객체를 사용한다.
		//확인은 mt"", 취소는 null
//		if(lang!=null && !lang.equals("")) {
//			dlm.addElement(lang);
//		}//end if//나ㅏㅏㅏㅏㅏㅏ
		
//		if(!lang.equals("") && lang!=null) {
//의 문제는 앞에것실행하고 뒤에것 실행하게됨. 문제는 취소하면 null이들어가는데,lang이 안만들어져서 인스턴스 변수를 갖고있지 않아서 
//객체가 만들어지지않았기 때문에 Error, null이면 메소드를 불러 일을 더 할수 있다...근데 앞에 쓰면 null일때 메소드를 부를수 없어 Error
		//mt일땐 ==으로는 비교할수 없다!
		
		if(lang!=null && !lang.equals("")) {
			dlm.addElement(lang);
		}
		
	}//actionPerformed
	
//	int i=0;//전역변수로 해서 하나일때 출력...21억번 넘으면 그뒤로는 처리를 못한다.(Error)한계가 있음.
//	private	boolean flag;//언어불문하고 다쓸수 있다..
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		//선택된 아이템(JList)의 값(DefaultListModel)을 얻어와서
//		////////
////		int i=0;//지역변수는 계속 초기화가 되기때문에
////		i++;
////		if(i%2==0) {
//		if(flag) {
//		////////
//			int idx=jl.getSelectedIndex();
//		String value=dlm.get(idx);
//		//JLabel에 추가
//		jlOutput.setText(value);//헉 누를때 하나 뗄떼 하나 =>불리는 자바의 동작은 개발자가 막을수 없다. 
//		//따라서 두번 실행되도 한번 출력되도록 만들어야 하는것...
////		System.out.println(value);//헉 누를때 하나 뗄떼 하나 2개가 출력된다...
//		//변수와 제어..?를 알면 할수 있다..어렵
//
//		//선택된 값을 삭제
//		dlm.removeElementAt(idx);//jl.getSelectedIndex();을 또하면 또 찾아 넣어야 하기 때문에 리스트에 접근을2번에서 1번으로 줄일수 있다.
//		//접근덜하면 효율성업업//but 2번 인출되면서 인덱스가 변경된다...Error.....
//
//		}//end if
//		flag=!flag;//끝이 안나는 코드! boolean이 더 낫다.
//	}//valueChanged


	@Override
	public void mouseClicked(MouseEvent e) {
		int idx=jl.getSelectedIndex();
		String value=dlm.get(idx);
		//JLabel에 추가
		jlOutput.setText(value);
		//선택된 값을 삭제
		dlm.removeElementAt(idx);
	}//mouseClicked
	
	@Override
	public void mousePressed(MouseEvent e) {
	}//눌릴때
	@Override
	public void mouseReleased(MouseEvent e) {
	}//뗄때?
	@Override
	public void mouseEntered(MouseEvent e) {
	}//특정영역에 들어갔을때
	@Override
	public void mouseExited(MouseEvent e) {
	}//마우스커서가 빠져나갔을때
	
	public static void main(String[] args) {
		new UseJList();
	}//main

}//class
