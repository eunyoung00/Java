package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {
		
	}//UsePreparedStatementDAO
	
	private Connection getConn() throws SQLException{
		Connection con =null;
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="Scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass);
				
		return con;
	}//getConn
	
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con =null;
		PreparedStatement pstmt=null;
		
		try {
		//1.����̹� �ε�
		//2.Connection ���
			con=getConn();
		//3.������ ���� ��ü��� : PreparedStatement ��ü�� ����Ǵ� �������� �˰��ֽ��ϴ�.
			String insertCpEmp="insert into cp_emp2(empno,ename,hiredate,sal) values(?,?,sysdate,?)";
			pstmt=con.prepareStatement(insertCpEmp);
		//4.���ε� ������ �� ����//�� �������� ?�� ���� ���� ������ �ִ°�
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
			
		//5.���� ������ ��� ���
			pstmt.executeUpdate();//update�� �ַ� �ҷ��ش�.?
			
			
		}finally {
			//6.���� ����
			if(pstmt!=null) { pstmt.close();}//end if;
			if(con!=null) { con.close();}//end if;
		}//end finally
		
	}//insertCpEmp2
	
//	/**
//	 * ���� �׽�Ʈ : ����� �����ϴ��� test�ϴ°� �ϰ� �� ������ !(��ť�� �ڵ�)
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		//QA ǰ�� ����
//		//ȭ��Ʈ �ڽ� �׽�Ʈ : �ڵ带 � �ݺ��� �������� �� ���־�� �ڵ� �м��� �׽�Ʈ(����� �����ϴ���)
//		//�� �ڽ� �׽�Ʈ  : üũ ����Ʈ�� �־ �� �����ϰ� üũ�Ͽ� �Űܺ��°�.
//		//�ڵ带 �м��ϴϱ� ��������� ȭ��Ʈ �ڽ��׽�Ʈ�� ���� �ִ�. ���ڽ��� �˹ٵ� ���� 
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		CpEmp2VO c = new CpEmp2VO(9876, 3000, "����ö");
//		try {
//			u.insertCpEmp2(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch
//	}
	
	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag=false;
		
		
		return flag;
	}//updateCpEmp2
	
	public boolean deleteCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag=false;
		
		
		return flag;
	}//deleteCpEmp2
	
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException {
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();
		
		return list;
	}//selectAllCpEmp2
	
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo=null;
		
		return cevo;
	}
	
	
}//class
