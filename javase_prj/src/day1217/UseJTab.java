package day1217;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import day1217.UseJTable.TableEvt;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {
	
	private JPanel tab4;
	private ImageIcon ii2;
	private JTabbedPane jtp;
	private JLabel jl4;
	
	public UseJTab() {
		super("Tab");
		
		//1.탭을 추가할 수 있는 객체 생성.
		jtp=new JTabbedPane();
		
		//2.각 탭에 들어갈 컴포넌트 생성.
		//처음 탭에 들어갈 컴포넌트
		ImageIcon ii=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img1.png");
		JLabel jl=new JLabel(ii);
		
		//두번째 텝에 들어갈 컴포넌트
		JPanel jp=new JPanel();
		jp.add(new JLabel("이름"));//이벤트를 발생시키지 않을거라 그냥 넣어주었다..
		jp.add(new JTextField(30));
		jp.add(new JButton("입력")); 
		
		JPanel tab2=new JPanel();
		tab2.setLayout(new BorderLayout());
		
		jp.setBorder(new TitledBorder("입력 데이터"));
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("결과창"));
		
		tab2.add("North",jp);
		tab2.add("Center",jsp);
		
		ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img6.png");
		tab4=new JPanel();
		jl4=new JLabel();
//		add()

		
		
		jtp.addTab("처음 탭", jl);
		jtp.addTab("두번째 탭", tab2);
		jtp.addTab("세번째 탭", new JButton("클릭")/*new UseJTable()=>패널이면 가능한데 프레임이라 안됬다..*/);
//		jtp.add("네번째 탭", new JOptionPane().showInputDialog("비밀번호를 입력하세요."));
		//네번째 탭을 누르면 비밀번호를 누르라는 showinputdialog가 뜨고, 123인지 확인하여 맞으면 아니면 첫번째 탭으로
//		jtp.addTab("네번째 탭", jl4);
		jtp.addTab("네번째 탭", tab4);
		
		//배치
		add("Center",jtp);
		
		//이벤트 등록
		TabEvt te=this.new TabEvt();//inner class의 객체화~!~!
		jtp.addMouseListener(te);
		
		setBounds(100, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}//UseJTab
	
////////////////////////////////inner class 시작////////////////////////////////////////////////
	public class TabEvt extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent me) {//이벤트로 비교하는건 아니지만 me
			int index = jtp.getSelectedIndex();
			if(index==3) {
				String inputpass=JOptionPane.showInputDialog("비밀번호를 입력하세요.");
				
				if(inputpass.equals("123")) {
					tab4.add("Center", new JLabel(ii2));
//					jl4.setIcon(ii2);
				}else{
					jtp.setSelectedIndex(0);
				}//end else
			}//end if
		}//mouseClicked
	
	}//TabEvt

	public static void main(String[] args) {
		new UseJTab();
	}//main

}//class
