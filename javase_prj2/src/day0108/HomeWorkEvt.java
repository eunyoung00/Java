package day0108;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeWorkEvt extends WindowAdapter implements ActionListener {

	private HomeWorkView hwv;
	private String[] tab;
	List<String> list;
	
	public HomeWorkEvt(HomeWorkView hwv) {
		this.hwv=hwv;
		try {
			selectTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//HomeWorkEvt
	
	public List<String> selectTable() throws SQLException{
		List<String> list=new ArrayList<String>();
		//1.����̹� <�ε�>
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con =null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection ���
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		//3.������ <����> ��ü ���
			stmt=con.createStatement();
		//4.���� <���� ��> ��� ��� 
			StringBuilder selectZipcode=new StringBuilder();
			selectZipcode
			.append(" select tname  ")//null�̸� whitespace�ְ� alias�� �̸� �ٽ� 
			.append(" from tab ");
			
			rs=stmt.executeQuery(selectZipcode.toString());
			
			String tabname=null;
			while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
				//VO�� ���� �Ҵ��ϰ� 
				//���� �̸��� ��ü�� ������ �����ϱ� ���� List�� �߰�
				tabname=new String(rs.getString("TNAME"));
				list.add(tabname);
				hwv.getJcbTab().addItem(tabname);
			}//end while
			
			//list���� �迭�� �Ҵ�
			tab= new String[list.size()];
		    list.toArray(tab);
				
		}finally {
			//5.���� ����
			if(rs!=null) {rs.close(); }//end if
			if(stmt!=null) {stmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//end finally
		
		return list;
	}//selectZipcode
	
	@Override
	public void windowClosing(WindowEvent we) {
		hwv.dispose();
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==hwv.getJbtOk()) {
			
		}//end if
		
	}//actionPerformed

}
