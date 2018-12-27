package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

@SuppressWarnings("serial")
public class Work27 extends Frame{
	
	private TextField tfName,tfAge,tfAdress;
	private List list;
	private Button btnadd,btndelete,btnupdate,btnexit;
	
	private Work27() {
		super("숙제");
		
		Label lblName=new Label("이름");
		Label lblAge=new Label("나이");
		Label lblAdress=new Label("주소");
		
		tfName=new TextField();
		tfAge=new TextField();
		tfAdress=new TextField();
		
		list=new List();
		list.add("박은영/25/서울시");
		
		btnadd=new Button("추가");
		btndelete=new Button("삭제");
		btnupdate=new Button("변경");
		btnexit=new Button("닫기");
		
		setLayout(null);
		
		lblName.setBounds(40,80,25,25);
		lblAge.setBounds(40,120,25,25);
		lblAdress.setBounds(40,160,25,25);
		
		tfName.setBounds(80,80,100,25);
		tfAge.setBounds(80,120,100,25);
		tfAdress.setBounds(80,160,100,25);
		
		list.setBounds(210,80,150,120);

		btnadd.setBounds(80,250,50,40);
		btndelete.setBounds(155,250,50,40);
		btnupdate.setBounds(230,250,50,40);
		btnexit.setBounds(305,250,50,40);
		
		add(lblName);
		add(lblAge);
		add(lblAdress);
		add(tfName);
		add(tfAge);
		add(tfAdress);
		add(list);
		add(btnadd);
		add(btndelete);
		add(btnupdate);
		add(btnexit);
		
		//이벤트 설정
		Work27Evt hwe = new Work27Evt(this);
		btnadd.addActionListener(hwe);
		btndelete.addActionListener(hwe);
		btnupdate.addActionListener(hwe);
		btnexit.addActionListener(hwe);

		list.addItemListener(hwe);
		addWindowListener(hwe);
		
		//6.윈도우 크기 설정
		setBounds(100, 100, 400, 350);
		//7.가시화
		setVisible(true);

	}//Work27
	
	public TextField getTfName() {
		return tfName;
	}
	public TextField getTfAge() {
		return tfAge;
	}
	public TextField getTfAdress() {
		return tfAdress;
	}
	public List getList() {
		return list;
	}
	public Button getBtnadd() {
		return btnadd;
	}
	public Button getBtndelete() {
		return btndelete;
	}
	public Button getBtnupdate() {
		return btnupdate;
	}
	public Button getBtnexit() {
		return btnexit;
	}


	public static void main(String[] args) {
		new Work27();
	}//main

}//class
