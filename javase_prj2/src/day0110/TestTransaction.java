package day0110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.connection.GetConnection;

/**
 * Transaction ó�� <br>
 * insert�� �ι� �����Ҷ�, �ι��� �� ������ commit�ǰ�, �ȵǸ� rollback
 * @author owner
 */
public class TestTransaction {
	//Commit �� Rollback�� DB�۾� �ܺο��� ó���� �� �ֵ��� �ν��Ͻ� ������ class field�� �� ����
	private Connection con;
//	private PreparedStatement pstmt=null;
//	PreparedStatement pstmt1=null;
	
	public boolean insert(TransactionVO tv) throws SQLException{
		//Ʈ�����ǿ� ����� ������ �� ��ŭ ���� ���� ��ü ����
		PreparedStatement pstmt=null;//���� �ø��� ��� ����
		PreparedStatement pstmt1=null;//�ϳ��� ���ܹ�����...
		
		boolean flag=false;

		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			//auto commit ����
			con.setAutoCommit(false);//����
		//3.
			String sql="insert into test_transaction1(subject,writer)values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, tv.getSubject());
			pstmt.setString(2, tv.getWriter());
		//4.
			int cnt=pstmt.executeUpdate();
			//3.
			String sql1="insert into test_transaction2(subject,writer)values(?,?)";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, tv.getSubject());
			pstmt1.setString(2, tv.getWriter());
			//4.
			int cnt1=pstmt1.executeUpdate();
			//Ʈ�����ǿ� �ش��ϴ� ��� ������ ��ǥ����� ���Ͽ� Ŀ�԰� �ѹ鿩�θ� �����Ѵ�.
			if(cnt==1&&cnt1==1) {
				flag=true;
//				con.commit();
//				System.out.println("Commit!!!");
//			}else {
//				con.rollback();
//				System.out.println("Rollback!!!");
			}//end else
		//5.
		}finally {
			//6.
//			if(pstmt !=null) {pstmt.close();}//end if
//			if(con !=null) {con.close();}//end if
			//������ ��������Ǿ� commit��.
		}//end finally
		return flag;//�Ѵ�1�϶� true
	}//insert
	
	public void add() {
		String inputData=JOptionPane.showInputDialog("����� �ۼ��ڸ� �Է��� �ּ���\n��)����-�ۼ���");
		
		String[] data=inputData.split("-");
		
		if(data.length!=2) {
			JOptionPane.showMessageDialog(null, "�Է� ������ Ȯ���� �ּ���.");
			return;
		}//end if
		TransactionVO tv=new TransactionVO(data[0], data[1]);
		
		try {
			//DB������ ����ϴ� ������ �������� �޾� 
			boolean flag=insert(tv);
			if(flag) {
				//Ŀ���ϰų�
				con.commit();
				System.out.println("Ŀ��!!!");//����  �ᵵ�� ����,
			}else {
				//�ѹ��Ѵ�.
				con.rollback();//�ϳ� ���� ���� �ƴϸ� ���ܶ� else�� �鸣�� �ʴ´�.update�� delete�� transaction�� ������ �鸧.
				System.out.println("update�� delete�� �ѹ�!!!");
			}//end else
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("insert�� �ѹ�!!!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.close();//�������� pstmt�� ��������...
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end catch
	}//add

	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.add();
	}//main
}//class
