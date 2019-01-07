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
 * Statement객체를 사용하여 CRUD를 구현하는 클래스
 * CRUD는 Create Read Update Delete 의 약자.
 *  
 * @author owner
 */
public class UseStatementCRUD {

	/**
	 * VO를 입력받아 VO의 값을 CP_DEPT테이블에 추가
	 * @param cdvo 부서번호,부서명,위치를 가진 VO
	 * @throws SQLException
	 */
	public void insertCpDept(CpDeptVO cdvo) throws SQLException{
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		
		try { //여기서부터는 연결을 반드시 끊어 주어야 한다.
		//2.Connection 얻기  
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//<반드시 잘 알아두어야 한다.외워~!
			String id="scott";
			String pwd="tiger";
			
			con=DriverManager.getConnection(url, id, pwd);
		//3.쿼리문 생성객체 얻기
			stmt=con.createStatement();
		//4.쿼리수행 후 결과 얻기
//			String insertCpdept="insert into cp_dept(deptno,dname,loc) values("+
//								cdvo.getDeptno()+",'"+cdvo.getDname()+"','"+cdvo.getLoc()+"')";//오라클의 문자열은 '로 묶여야 한다.
//			insertCpDept.append(str);
			StringBuilder insertCpDept=new StringBuilder();
			insertCpDept.append("insert into cp_dept(deptno,dname,loc) values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt=stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);//성공 아님 예외
			
		}finally {
			//5.연결 끊기
			if(stmt!=null) {stmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//end finally
		
	}//insertCpDept
	public boolean updateCpDept(CpDeptVO cdvo) throws SQLException{
		boolean flag = false;
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch

		Connection con=null;
		Statement stmt=null;
		try {
		//2.Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.쿼리문 생성객체 얻기
			stmt=con.createStatement();
		//4.쿼리문 수행후 결과 얻기
			StringBuilder updateCpDept=new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());
			
			int cnt=stmt.executeUpdate(updateCpDept.toString());
			//테이블의 구조상 부서번호는 PK이므로 한 행만 변경된다.(그렇지않으면 여러행)
			if(cnt!=0) {//바뀐게 여러개란 얘기
				flag=true;
			}//end if
		}finally {
			//5.연결 끊기
			if(stmt!=null) {stmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//end finally
		
		return flag;
	}//updateCpDept
	public boolean deleteCpDept(int deptno) throws SQLException{
		boolean flag=false;
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con =null;
		Statement stmt =null;
		try {
		//2.Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.쿼리문 생성 객체 얻기
			stmt=con.createStatement();
		//4.쿼리 수행 후 결과 얻기
			StringBuilder deleteCpDept=new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			int cnt=stmt.executeUpdate(deleteCpDept.toString());
			if(cnt==1) {//cnt !=0 도 상관없다.
				flag=true;
			}//end if
			
		}finally {
			//5.연결 끊기
			if(stmt !=null) {stmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//deleteCpDept
	
	public List<CpDeptVO> selectAllCpDept() throws SQLException{
		List<CpDeptVO> list=new ArrayList<CpDeptVO>();
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		try {
		//2.Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.쿼리문 생성 객체 얻기
			stmt=con.createStatement();
		//4.쿼리문 수행 후 결과 얻기
			String selectCpDept="select deptno,dname,loc from cp_dept";
			
			rs=stmt.executeQuery(selectCpDept);//제어권을 가짐
			CpDeptVO cdvo=null;
			
			while(rs.next()) {//조회된 레코드가 존재한다면
				//컬럼의 인덱스로 조회    가능하지만 뭐를 가져오는지 알수 없어서 비추천
//				System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3));//<가독성이 떨어짐.인덱스를 써서 출력하는것은 정확한 인덱스를 알아야하고 ..
				//컬럼명으로 조회
//				System.out.println(rs.getInt("deptno")+" "+rs.getString("dname")+" "+rs.getString("loc"));
				//<프로시져할때는 어쩔수없이 인덱스로 쓰지만 그외에는 다 컬럼명으로 조회!
				
				cdvo=new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				//<데이터가 있을때에만 객체 생성?
				//같은 이름으로 생성된 cdvo객체를 사라지지않도록 관리하기 위해 List에 추가
				list.add(cdvo);//이코드가 없으면 cdvo는 마지막 값만 가진다.
				
			}//end while
			
		}finally {
			//5.연결 끊기
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}
		return list;
	}//selectAllCpDept
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo=null;
		//1.드라이버 <로딩>
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		//빼먹음
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pwd="tiger";
			con=DriverManager.getConnection(url, id, pwd);
		//3.쿼리문 생성 객체 얻기
			stmt=con.createStatement();
		//4.쿼리 <수행후> 결과 얻기
			StringBuilder selectCpDept=new StringBuilder();
			selectCpDept.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);
			
			rs=stmt.executeQuery(selectCpDept.toString());
			
			if(rs.next()) {//조회된 레코드가 존재 한다면  //<<어짜피 레코드는 하나이므로 while이 아니라 if 로 해도 된다.한개 또는 0개라면 rs.next();만 쓰기에는 되게 위험 (있지도않은데 가져오려고 하면 Error)
				ocdvo=new OneCpDeptVO(rs.getString("dname"),rs.getString("loc"));
			}//end while
			
		}finally {
			//5.연결 끊기
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return ocdvo;
	}//selectCpDept
	
	/**
	 * CP_DEPT 테이블의 모든 부서번호를 조회
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
			
			while(rs.next()) {//조회된 레코드가 존재 한다면  //<<어짜피 레코드는 하나이므로 while이 아니라 if 로 해도 된다.한개 또는 0개라면 rs.next();만 쓰기에는 되게 위험 (있지도않은데 가져오려고 하면 Error)
				list.add(Integer.parseInt(rs.getString("deptno")));//autoboxing이 되서 Integer.parseInt 대신 new Integer가능?
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
