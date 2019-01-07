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
		//1.드라이버 로딩
		//2.Connection 얻기
			con=getConn();
		//3.쿼리문 생성 객체얻기 : PreparedStatement 객체는 실행되는 쿼리문을 알고있습니다.
			String insertCpEmp="insert into cp_emp2(empno,ename,hiredate,sal) values(?,?,sysdate,?)";
			pstmt=con.prepareStatement(insertCpEmp);
		//4.바인드 변수에 값 설정//위 쿼리문에 ?에 대해 값을 설정해 주는것
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
			
		//5.쿼리 수행후 결과 얻기
			pstmt.executeUpdate();//update를 주로 불러준다.?
			
			
		}finally {
			//6.연결 끊기
			if(pstmt!=null) { pstmt.close();}//end if;
			if(con!=null) { con.close();}//end if;
		}//end finally
		
	}//insertCpEmp2
	
//	/**
//	 * 단위 테스트 : 제대로 동작하는지 test하는것 하고 꼭 지워야 !(씨큐어 코딩)
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		//QA 품질 보증
//		//화이트 박스 테스트 : 코드를 까서 반복문 돌려보고 막 값넣어보고 코드 분석해 테스트(제대로 동작하는지)
//		//블랙 박스 테스트  : 체크 리스트가 있어서 쭉 실행하고 체크하여 매겨보는것.
//		//코드를 분석하니까 기술적으로 화이트 박스테스트가 위에 있다. 블랙박스는 알바도 가능 
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		CpEmp2VO c = new CpEmp2VO(9876, 3000, "김희철");
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
