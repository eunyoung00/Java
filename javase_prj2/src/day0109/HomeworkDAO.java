package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

public class HomeworkDAO {
	
	private HomeworkView hv;
	
	public HomeworkDAO(HomeworkView hv) {
		this.hv = hv;
	}//HomeworkDAO

	public void createTable() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			
//			String tableName=JOptionPane.showInputDialog("������ ���̺� �� �Է�");
			String tableName=hv.getJtftabName().toString();
//			String constraintName=hv.getJtfConstraintName().toString();
			
			//3.//���̺��� �����ϴ��� ?
			StringBuilder selectTname=new StringBuilder();
			selectTname.append("select tname from tab where tname=?");
			//4.
			pstmt=con.prepareStatement(selectTname.toString());
			
			pstmt.setString(1, tableName.toUpperCase());
			//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, tableName+"���̺��� �����մϴ�");
			}//end if
			pstmt.close();//�׶��׶� ������ ������ �ݾ� �ش�.
			
		//3.
			StringBuilder createTable=new StringBuilder();
			try {
				//�ڸ��� �κ��� ������ ������ �ϼ����� ������ ;�� ã���� ���
			String sql=hv.getJtaQueryView().getText().substring(0,hv.getJtaQueryView().getText().lastIndexOf(";"));
			System.out.println(sql);
			//�ƹ��͵� ������ ������� ������ư�� ������ ���ƾ� �Ѵ�....
			createTable.append(sql);
			//<���Ѹ������� view�� �ó���� ����°͵� ���������� �Լ��� Ʈ���Ű��� ����� thin�� Ư���� �ȵ�.
			pstmt=con.prepareStatement(createTable.toString());
		//4.
		//5.
			pstmt.execute();//�ִµ� �÷��̸� �ߺ� ���⼭ �ɸ�...
			JOptionPane.showMessageDialog(null, "���̺��� �����Ǿ����ϴ�.");
			}catch (java.lang.StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(hv, "������ �ϼ����ּ���");
			}//end catch
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
	}//createTa
}//class
