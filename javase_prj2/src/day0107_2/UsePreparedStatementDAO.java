package day0107_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day0107.CpEmp2VO;


public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {
		
	}//UsePreparedStatementDAO
	
	//����̹��ε��� Ŀ�ؼǾ�⸦ �Ź����� �ʱ� ���ؼ�
	private Connection getConn() throws SQLException{
		Connection con = null;
		//1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.Connection ���
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		con = DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn ->������ Ŀ�ؼ��� �ʿ��ϸ� �θ��� ��
	
	/**
	 * ����, �߰��ϴ� ���
	 * @param cevo
	 * @throws SQLException
	 */
	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		//1.����̹��ε�
		//2.Connection���
			con = getConn();
		//3. ������ ���� ��ü ��� : PreparedStatment��ü�� ����Ǵ� �������� �˰� ���� 
			String insertCpEmp="insert into cp_emp2(empno, ename, hiredate, sal) values(?,?,sysdate,?)";
			pstmt=con.prepareStatement(insertCpEmp);
		//4. bind ������ �� ���� //���� ? �� ���� ���� �־��ִ� ��
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
		//5. ������ ���� �� ��� ���
			pstmt.executeUpdate();
			//pstmt.execute();�� �ᵵ �������
		}finally {
		//6. ���� ����
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if	
		}//end finally
	}//insertCpEmp2
	

	/**
	 * �����ȣ, �����, ������ �Է¹޾� �����ȣ�� �ش��ϴ� �����, ������ �����ϴ� ��
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
		//1.����̹� �ε�
		//2.connection ���
			con = getConn();
		//3.������ ���� ��ü ���
			//������ ''�� �Ⱥپ ��������
			String updateCpEmp2="update cp_emp2 set ename=?,sal=? where empno=?";
			pstmt = con.prepareStatement(updateCpEmp2);
		//4.���ε� ������ �� �ֱ�
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());
			
		//5.������ ���� �� ��� ���
			int cnt = pstmt.executeUpdate();
			if(cnt!=0) {
				flag =true;
			}//end if
		}finally {
		//6.���� ����
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if	
		}//end finally
		return flag;
	}//updateCpEmp2
	
	/**
	 * �����ȣ�� �Է¹޾� �����ȣ�� �ش��ϴ� ����� ����
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2(int empno) throws SQLException{
		boolean flag = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.����̹��ε�
		//2.connection����
			con = getConn();
		//3.������ ������ü ���
			String deleteCpEmp2 = "delete from cp_emp2 where empno=?";
			pstmt = con.prepareStatement(deleteCpEmp2);
		//4.���ε庯���� �� ����
			pstmt.setInt(1, empno);
			
		//5.���� ���� �� ��� ���
			int cnt = pstmt.executeUpdate();
			
			if(cnt !=0) {
				flag = true;
			}
		}finally {
		//6.���� ����
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//deleteCpEmp2
	
	
	/**
	 * ��� �μ� ��������� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException{
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1. ����̹��ε�
		//2. Connection���
			con = getConn();
		//3. ������ ������ü ���
			String selectAllCpEmp2="select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate from cp_emp2 ";
			pstmt=con.prepareStatement(selectAllCpEmp2);
		//4. ���ε庯���� �� �ֱ�
			//����ǥ�� �����Ƿ� ����
		//5. ������ ���� �� ��� ���
			rs = pstmt.executeQuery(); //rs�� Ŀ���� ������� ������ ����
			
			//��ȸ����� VO�� �Ҵ�
			CpEmp2AllVO cda_vo = null;
			while(rs.next()) {
				cda_vo = new CpEmp2AllVO(rs.getInt("empno"),rs.getInt("sal"), 
						rs.getString("ename"), rs.getString("hiredate"));
				//���� ������ ���ڵ常 ������ �� ����
				list.add(cda_vo);
			}//end while
			
		}finally {
		//6. ���� ����
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return list;
	}//selectAllCpEmp2
	
	
	
	/**
	 * �ԷµǴ� �����ȣ�� �ش��ϴ� ������� ��ȸ 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo = null;
		
		
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
		//1.����̹��ε�
		//2.Connection ���
			con = getConn();
		//3.������ ������ü ���
			//hiredate�� to_char�Ⱦ��� java�� Date�� �о����
			String selectOneCpEmp2="select ename, sal, hiredate from cp_emp2 where empno=?";
			pstmt = con.prepareStatement(selectOneCpEmp2);
		//4.���ε� ������ �� ����
			pstmt.setInt(1, empno);
		//5.������ ���� �� ������
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cevo=new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"), rs.getDate("hiredate"));
			}//end if
			
		}finally {
		//6.���� ����
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return cevo;
	}//selectOneCpEmp2
	
//	/**
//	 * �����׽�Ʈ : �޼ҵ尡 ����� �����ϴ��� �������� �޼ҵ�/Ŭ����/��� �׽�Ʈ
//	 * �ϰ� ������ ��
//	 * QA���� �ϴ� ������� �ַ� ��
//	 * (ȭ��Ʈ�ڽ��׽���: �ڵ带 � �߶� �м��ؼ� �����غ�(��������� ������ ���� - �ڵ带 ���� �� �ƴϱ�) / �����ڽ� : üũ����Ʈ�� ���� üũ)
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		try {
////		CpEmp2VO c = new CpEmp2VO(4545, 4000, "������");
////			List<CpEmp2AllVO> list= u.selectAllCpEmp2();
////			System.out.println(list);
//			CpEmp2OneVO c = u.selectOneCpEmp2(2222);
//			System.out.println(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}//main 
}//class