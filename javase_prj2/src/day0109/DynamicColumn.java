package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * �÷����� �������� ����Ǵ� ��� <br>
 * �÷����� �Է¹޾� �ش� �÷������� ��ȸ<br>
 * EMP���̺��� ��ȸ-�����ȣ�� �÷���(�� �Է¹޾� ��ȸ<br>
 * joptionpane���� String�� �޾� bind������ �������� �־� ��ȸ
 * @author owner
 */
public class DynamicColumn {
	
	public DynamicColumn() throws SQLException{
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String[] columnName= {"ename","job","mgr","hiredate","sal","comm","deptno"};
		//<db�� ���߾� �빮�ڷ� �ϴ°� ������ ������ �ߺ����� �����Ƿ� �ҹ��ڷ� �Է��� �ξ��ٰ� �빮�ڷ� ��ȯ���� �̿��ϱ⵵ �Ѵ�.

		String input=JOptionPane.showInputDialog("�����ȣ�� �÷��� �ϳ��� �Է��� �ּ���.\n��)�����ȣ, �÷���");//CSV�ĸ����۷���Ƽ��value
		String [] temp=input.split(",");
		
		if(temp.length!=2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���ϼ���.");
			return;
		}//end if
		
		try {
		int empno=Integer.parseInt(temp[0].trim());
		String inputColumn=temp[1].trim();
		
		boolean columnFlag=false;
		for(String column : columnName) {
			if(column.equals(inputColumn.toLowerCase())) {//DB�� �÷���� ���� �÷����̶�� �� �ҹ��ڷ� ó���Ͽ� �޾Ƶ���
				columnFlag=true;
			}//end if
		}//end for
		
		if(!columnFlag) {
			JOptionPane.showMessageDialog(null, inputColumn+"�� EMP���̺� �÷����� �������� �ʽ��ϴ�.");
			//<���̺��� Ư���������� ������ �׳� �÷����� �־ ����
			return;
		}//end if
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			//<�ð����پ� ������ ���� �ִ�.�� ������ db�� ������=> DBCP?(����->���)
		//3.
			//�÷����� hiredate�� ��� ���ڿ��� ó���ϱ� ���� to_char �Լ� ���.
			//<hiredate�ΰ�� tochar�� �����°� ���ڴ�.
			if(inputColumn.equals("hiredate")){
				inputColumn="to_char(hiredate,'yyyy-mm-dd day hh24:mi:ss') hiredate";
			}//end if
			
			StringBuilder selectEmp=new StringBuilder();
			//�÷���, ���̺���� bind ������ ó������ �ʴ´�.�������� �����־� ����Ѵ�.
			selectEmp.append("select ").append(inputColumn/*?�ƴϰ�*/).append(" from emp ")
//			selectEmp.append("select ? from emp ")
			.append(" where empno=?");
			
			pstmt=con.prepareStatement(selectEmp.toString());
		//4.
//			//<bind������ �÷����ڸ��� �������� �Ǹ� �ν��� ���Ѵ�.Error�������� ��(�÷�) �̸�
//			pstmt.setString(1, inputColumn);
//			pstmt.setInt(2, empno);
			pstmt.setInt(1, empno);
		//5.
			rs=pstmt.executeQuery();
			boolean f=rs.next();
			System.out.println( f +" " +selectEmp+ " "+ inputColumn);
		
			
			if(f) {//�����ȣ�� ��ȸ�� ���ڵ尡 �����Ѵٸ�

				String stringData="";
				int intData=0;
				if(temp[1].trim().equals("ename")||temp[1].trim().equals("job")||
						temp[1].trim().equals("hiredate")) {
//					stringData=rs.getString(1);//���Ծ��̳� ù��°�÷��� ������ �ִ°�? �������� �� �̸� ������ �Ȱɷ�����..
					stringData=rs.getString(temp[1].trim());
					
				}else {
					intData=rs.getInt(temp[1].trim());
				}//end else
				JOptionPane.showMessageDialog(null,temp[1]+"���� ��ȸ�� �� : "+(intData==0? stringData:intData));
			}else {
				JOptionPane.showMessageDialog(null,"�Է��� �����ȣ�� �������� �ʽ��ϴ�.");
			}//end else
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		}catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾�� �մϴ�.");
		}//end catch
	}//DynamicColumn

	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
