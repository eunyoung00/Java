package kr.co.sist.lunch.user.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;
import oracle.jdbc.internal.OracleTypes;

/**
 * 도시락 주문자에 대한 DB처리 
 * @author owner
 */
public class LunchClientDAO {
	private static LunchClientDAO lc_dao;
	
	private LunchClientDAO() {
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchClientDAO
	
	public static LunchClientDAO getInstance() {
		if(lc_dao==null) {
			lc_dao=new LunchClientDAO();
		}//end if
		return lc_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		//2.
		Connection con =null;
		
		String url="jdbc:oracle:thin:@211.63.89.150:1521:orcl";
		String id="scott";
		String pass="tiger";
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConn
	
	/**
	 * DB에 추가된 모든 도시락 목록을 조회.
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList() throws SQLException{
		List<LunchListVO> list=new ArrayList<LunchListVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch="SELECT LUNCH_CODE,LUNCH_NAME,IMG,SPEC FROM LUNCH ORDER BY LUNCH_CODE DESC";
			pstmt=con.prepareStatement(selectLunch);
		//4.
		//5.
			rs=pstmt.executeQuery();
			LunchListVO llv=null;
			
			while(rs.next()){
				llv=new LunchListVO(rs.getString("img"), rs.getString("lunch_Code"), rs.getString("lunch_Name"),
										rs.getString("Spec"));
				list.add(llv);
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return list;
	}//selectLunchList
	
	/**
	 * 도시락의 상세정보 조회
	 * @param lunchCode
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String lunchCode) throws SQLException{
		LunchDetailVO ldvo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch="select img, lunch_name,spec,price from lunch where lunch_code=?";
			pstmt=con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, lunchCode);
		//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ldvo=new LunchDetailVO(lunchCode, rs.getString("lunch_Name"), rs.getString("spec"),
										rs.getString("img"), rs.getInt("price"));
			}//end if
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return ldvo;
	}//selectDetailLunch
	
	public void insertOrder(OrderAddVO oavo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			//orderName,phone,ipAddress,lunchCode;			private int quan;
			String insertOrder="insert into ordering(ORDER_NUM,QUAN,ORDER_NAME,PHONE,IP_ADDRESS,LUNCH_CODE) "
					+ "values(order_code,?,?,?,?,?)";
			pstmt=con.prepareStatement(insertOrder);
		//4.
			pstmt.setInt(1, oavo.getQuan());
			pstmt.setString(2, oavo.getOrderName());
			pstmt.setString(3, oavo.getPhone());
			pstmt.setString(4, oavo.getIpAddress());
			pstmt.setString(5, oavo.getLunchCode());
		//5.
			pstmt.executeUpdate();
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
	}//insertOrder
	
	public List<OrderListVO> selectOrderList(OrderInfoVO oivo) throws SQLException{
		List<OrderListVO> list=new ArrayList<OrderListVO>();
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			cstmt=con.prepareCall(" {call lunch_order_select(?,?,?)} ");
		//4.
			//in parameter 값을 넣어주는것
			cstmt.setString(1, oivo.getOrderName());
			cstmt.setString(2, oivo.getOrderTel());
			//out parameter 처리된 값을 받는것
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
		//5.퀴리 실행(프로시저실행)
			cstmt.execute();
			//프로시저를 실행하면 out parameter에 저장된 값을 자바의 변수(rs)로 저장 얻는다.
			rs=(ResultSet)cstmt.getObject(3);
			
			OrderListVO olvo=null;
			while(rs.next()) {
//				olvo=new OrderListVO(rs.getString(1), rs.getString(2), rs.getInt(3));
				olvo=new OrderListVO(rs.getString("LUNCH_NAME"), rs.getString("ORDER_DATE"), rs.getInt("QUAN"));
				list.add(olvo);
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(cstmt!=null) {cstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return list;
	}//selectOrderList
	
	
//	public static void main(String[] args) {
//		try {
////			System.out.println(LunchClientDAO.getInstance().selectLunchList());
////			System.out.println(LunchClientDAO.getInstance().selectDetailLunch("L_000008"));
//			System.out.println(LunchClientDAO.getInstance().selectOrderList(new OrderInfoVO("김정윤", "010-3456-4567")));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch
//	}//main
}//class
