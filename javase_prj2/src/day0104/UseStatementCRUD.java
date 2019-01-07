package day0104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import oracle.jdbc.driver.DMSFactory;

/**
 * Statement��ü�� ����Ͽ� CRUD�� �����ϴ� Ŭ����
 * CRUD�� Create Read Update Delete �� ����.
 *  
 * @author owner
 */
public class UseStatementCRUD {

	/**
	 * VO�� �Է¹޾� VO�� ���� CP_DEPT���̺� �߰�
	 * @param cdvo �μ���ȣ,�μ���,��ġ�� ���� VO
	 * @throws SQLException
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException{
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		
		try { //���⼭���ʹ� ������ �ݵ�� ���� �־�� �Ѵ�.
		//2.Connection ���  
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//<�ݵ�� �� �˾Ƶξ�� �Ѵ�.�ܿ�~!
			String id="scott";
			String pwd="tiger";
			
			con=DriverManager.getConnection(url, id, pwd);
		//3.������ ������ü ���
			stmt=con.createStatement();
		//4.�������� �� ��� ���
//			String insertCpdept="insert into cp_dept(deptno,dname,loc) values("+
//								cdvo.getDeptno()+",'"+cdvo.getDname()+"','"+cdvo.getLoc()+"')";//����Ŭ�� ���ڿ��� '�� ������ �Ѵ�.
//			insertCpDept.append(str);
			StringBuilder insertCpDept=new StringBuilder();
			insertCpDept.append("insert into cp_dept(deptno,dname,loc) values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt=stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);//���� �ƴ� ����
			
		}finally {
			//5.���� ����
			if(stmt!=null) {stmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//end finally
		
	}//insertCpDept
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException{
		boolean flag = false;
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch

		Connection con=null;
		Statement stmt=null;
		try {
		//2.Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.������ ������ü ���
			stmt=con.createStatement();
		//4.������ ������ ��� ���
			StringBuilder updateCpDept=new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt=stmt.executeUpdate(updateCpDept.toString());
			//���̺��� ������ �μ���ȣ�� PK�̹Ƿ� �� �ุ ����ȴ�.(�׷��������� ������)
			if(cnt!=0) {//�ٲ�� �������� ���
				flag=true;
			}//end if
		}finally {
			//5.���� ����
			if(stmt!=null) {stmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//end finally
		
		return flag;
	}//updateCpDept
	public boolean deleteCpDept(int deptno) throws SQLException{
		boolean flag=false;
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con =null;
		Statement stmt =null;
		try {
		//2.Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.������ ���� ��ü ���
			stmt=con.createStatement();
		//4.���� ���� �� ��� ���
			StringBuilder deleteCpDept=new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			int cnt=stmt.executeUpdate(deleteCpDept.toString());
			if(cnt==1) {//cnt !=0 �� �������.
				flag=true;
			}//end if
			
		}finally {
			//5.���� ����
			if(stmt !=null) {stmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//deleteCpDept
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException{
		List<CpDeptVO> list=new ArrayList<CpDeptVO>();
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		try {
		//2.Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.������ ���� ��ü ���
			stmt=con.createStatement();
		//4.������ ���� �� ��� ���
			String selectCpDept="select deptno,dname,loc from cp_dept";
			
			rs=stmt.executeQuery(selectCpDept);//������� ����
			CpDeptVO cdvo=null;
			
			while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
				//�÷��� �ε����� ��ȸ    ���������� ���� ���������� �˼� ��� ����õ
//				System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3));//<�������� ������.�ε����� �Ἥ ����ϴ°��� ��Ȯ�� �ε����� �˾ƾ��ϰ� ..
				//�÷������� ��ȸ
//				System.out.println(rs.getInt("deptno")+" "+rs.getString("dname")+" "+rs.getString("loc"));
				//<���ν����Ҷ��� ��¿������ �ε����� ������ �׿ܿ��� �� �÷������� ��ȸ!
				
				cdvo=new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				//<�����Ͱ� ���������� ��ü ����?
				//���� �̸����� ������ cdvo��ü�� ��������ʵ��� �����ϱ� ���� List�� �߰�
				list.add(cdvo);//���ڵ尡 ������ cdvo�� ������ ���� ������.
				
			}//end while
			
		}finally {
			//5.���� ����
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}
		return list;
	}//selectAllCpDept
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo=null;
		//1.����̹� <�ε�>
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//������
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.������ ���� ��ü ���
			stmt=con.createStatement();
		//4.���� <������> ��� ���
			StringBuilder selectCpDept=new StringBuilder();
			selectCpDept.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);
			
			rs=stmt.executeQuery(selectCpDept.toString());
			
			if(rs.next()) {//��ȸ�� ���ڵ尡 ���� �Ѵٸ�  //<<��¥�� ���ڵ�� �ϳ��̹Ƿ� while�� �ƴ϶� if �� �ص� �ȴ�.�Ѱ� �Ǵ� 0����� rs.next();�� ���⿡�� �ǰ� ���� (������������ ���������� �ϸ� Error)
				ocdvo=new OneCpDeptVO(rs.getString("dname"),rs.getString("loc"));
			}//end while
			
		}finally {
			//5.���� ����
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return ocdvo;
	}//selectCpDept
	
	/**
	 * CP_DEPT ���̺��� ��� �μ���ȣ�� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException{
		List<Integer> list=new ArrayList<Integer>();
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.
			stmt=con.createStatement();
		//4.
			StringBuilder selectDeptNo=new StringBuilder();
			selectDeptNo.append("select deptno from cp_dept order by deptno");
			
			rs=stmt.executeQuery(selectDeptNo.toString());
			
			while(rs.next()) {//��ȸ�� ���ڵ尡 ���� �Ѵٸ�  //<<��¥�� ���ڵ�� �ϳ��̹Ƿ� while�� �ƴ϶� if �� �ص� �ȴ�.�Ѱ� �Ǵ� 0����� rs.next();�� ���⿡�� �ǰ� ���� (������������ ���������� �ϸ� Error)
				list.add(Integer.parseInt(rs.getString("deptno")));//autoboxing�� �Ǽ� Integer.parseInt ��� new Integer����?
			}//end while
		}finally {
			//5.
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}
		return list;
	}//selectAllCpDeptNo

}//class
