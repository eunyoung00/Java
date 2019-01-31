package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchAdminDAO {

	private static LunchAdminDAO la_dao; 
	
	public LunchAdminDAO() {
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchAdminDAO
	
	public static LunchAdminDAO getInstance() {
		if(la_dao==null) { //����ȣ�� �Ǵ� ����� ����
			la_dao=new LunchAdminDAO();
		}//end if
		return la_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		//2.
		String url="jdbc:oracle:thin:@211.63.89.150:1521:orcl";
		String id="scott";
		String pass="tiger";
		Connection con=DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn

	/**
	 * ID�� PASSWORD�� �Է¹޾� lunch_admin���� �̸��� ��ȸ�ϴ� ��
	 * @param alvo 
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO alvo) throws SQLException{
		String adminName="";

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectName="SELECT NAME FROM LUNCH_ADMIN WHERE ID=? AND PASS=?";
			pstmt=con.prepareStatement(selectName);
		//4.
			pstmt.setString(1, alvo.getId());
			pstmt.setString(2, alvo.getPass());
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				adminName=rs.getString("NAME");
			}//end if
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return adminName;
	}//login
	
	/**
	 * �Էµ� ���ö��� �ڵ�,�̹���,���ö���,�ܰ� ��ȸ
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch() throws SQLException{
		List<LunchVO> list=new ArrayList<LunchVO>();
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectAllLunch="SELECT LUNCH_CODE,LUNCH_NAME,IMG,PRICE FROM LUNCH ORDER BY LUNCH_CODE DESC";
			pstmt=con.prepareStatement(selectAllLunch);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			LunchVO lv=null;
			
			while(rs.next()) {
				lv=new LunchVO(rs.getString("LUNCH_CODE"), rs.getString("LUNCH_NAME"), 
										rs.getString("IMG"), rs.getInt("PRICE"));
				list.add(lv);
			}//end while
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return list;
	}//selectLunch
	
	/**
	 * �ԷµǴ� �ڵ忡 ���� ���ö� �������� ��ȸ
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String code) throws SQLException{
		LunchDetailVO ldvo=null;//new �� ���� �����ڵ� /�ʿ��Ҷ� ��ü�� ����°��� �ʿ���µ� ������ �ʴ´�.
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch=
				"SELECT LUNCH_NAME,IMG,SPEC,TO_CHAR(INPUT_DATE,'YYYY-MM-DD') INPUT_DATE,PRICE,REQUEST FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt=con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, code);
		//5.
			rs=pstmt.executeQuery();
			//�Էµ� �ڵ�� ��ȸ�� ���ڵ尡 ������ �� VO�� �����ϰ� �� �߰�
			if(rs.next()) {
				ldvo=new LunchDetailVO(code, rs.getString("lunch_name"), rs.getString("img"),
						rs.getString("spec"), rs.getString("input_date"), rs.getInt("price"),rs.getString("request"));
				
			}//end if
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return ldvo;
	}//selectDetailLunch
	
	/**
	 * ���ö� ������ �߰��ϴ� ��
	 * @param lav
	 * @throws SQLException
	 */
	public void insertLunch(LunchAddVO lav) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder insertLunch=new StringBuilder();
			insertLunch.append("insert into lunch(lunch_code,lunch_name,img,price,spec,id) ")
			.append("values(lunch_code,?,?,?,?,? )");
			pstmt=con.prepareStatement(insertLunch.toString());
		//4.���ε庯�� ���ֱ�
			pstmt.setString(1, lav.getLunch_name());
			pstmt.setString(2, lav.getImg());
			pstmt.setInt(3, lav.getPrice());
			pstmt.setString(4, lav.getSpec());
			pstmt.setString(5, LunchMainView.adminId);
		//5.
			pstmt.executeUpdate();
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
	}//insertLunch
	
	public boolean deleteLunch(String code) throws SQLException{
		boolean flag=false;

		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String deleteLunch="DELETE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt=con.prepareStatement(deleteLunch);
		//4.
			pstmt.setString(1, code);
		//5.
			int cnt =pstmt.executeUpdate();
			if(cnt==1) {
				flag=true;//<������ �� �Ǿ���~
			}//end if
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//deleteLunch
	
	/**
	 * ���ö��� �ڵ�,���ö��̸�,�̹���,����,Ư������ �ӷ¹޾� ���ö��ڵ忡 �ش��ϴ� ���ö��� ����, �̹����� ""��� ,�̹����� �������� �ʴ´�.
	 * Dynamic quary? �̹����� "" select���� ���� ����..
	 * @param luvo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateLunch(LunchUpdateVO luvo) throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder updateLunch=new StringBuilder();
			updateLunch
			.append("    update lunch   ")
			.append("    set lunch_name=?, ")
			.append("       price=?,spec=? ");
			if(!luvo.getImg().equals("")) {	//������Ʈ�� �̹����� �־��
				updateLunch.append(", img=?"  );
			}//end if
			updateLunch.append("   where lunch_code=?");
			
			pstmt=con.prepareStatement(updateLunch.toString());
		//4.
			pstmt.setString(1, luvo.getLunch_name());
			pstmt.setInt(2, luvo.getPrice());
			pstmt.setString(3, luvo.getSpec());
			
			int index=4;
			if(!luvo.getImg().equals("")) {	//������Ʈ�� �̹����� �־��
				pstmt.setString(index++, luvo.getImg());//3�̸� ++index
			}//end else
			pstmt.setString(index, luvo.getLunch_code());
			
//			if(!luvo.getImg().equals("")) {	//������Ʈ�� �̹����� �־��
//				pstmt.setString(4, luvo.getImg());
//				pstmt.setString(5, luvo.getLunch_code());
//			}else {
//				pstmt.setString(4, luvo.getLunch_code());
//			}//end else
		//5.
			int cnt=pstmt.executeUpdate();
			if(cnt==1) {
				flag=true;
			}//end if
			
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//updateLunch
	
	/**
	 * ����! ���ö� �̸����� ������ ������ ���ȴ���! �̸����� �Ѱ����� ���� �׿����� ���� ���´�.
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public List<CalcVO> selectCalc(String date) throws SQLException{
		List<CalcVO> list=new ArrayList<CalcVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder selectCalc=new StringBuilder();
			selectCalc
			.append("	select l.Lunch_name,l.lunch_code, sum(o.quan) total, sum(o.quan)*l.price price	")
			.append("	from lunch l, ordering o	")
			.append("	where o.lunch_code=l.lunch_code	")
			.append("	and  to_char(o.order_date,'yyyy-mm-dd')=to_char(to_date(?,'yyyy-mm-dd'),'yyyy-mm-dd')	")
			.append("	and o.status='Y'	")//���ۻ��°� �Ϸ��ΰͿ� ���ؼ��� ����
			.append("	group by l.lunch_code,l.lunch_name,l.price	")
			.append("	order by l.lunch_code	");
			
			pstmt=con.prepareStatement(selectCalc.toString());
		//4.
			pstmt.setString(1, date);
		//5.
			rs=pstmt.executeQuery();
			
			CalcVO cvo=null;
			while(rs.next()) {
				cvo=new CalcVO(rs.getString("lunch_Code"), rs.getString("lunch_Name"),
									rs.getInt("price"), rs.getInt("total"));
				list.add(cvo);
			}//end while
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return list;
	}//selectCalc
	
	/**
	 * ������ 13�� ������ �ֹ� ��Ȳ
	 * @return
	 * @throws SQLException
	 */
	public List<OrderVO> selectOrderList() throws SQLException{
		List<OrderVO> list=new ArrayList<OrderVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder selectOrder=new StringBuilder();
			selectOrder
			.append("	select o.order_num, l.lunch_code, l.lunch_name, o.order_name, o.quan,l.price*o.quan price,	")
			.append("	to_char(o.order_date,'yyyy-mm-dd hh:mi:ss') order_date, o.phone, o.ip_address,o.status,o.request	")
			.append("	from  lunch l, ordering o	")
			.append("	where o.lunch_code=l.lunch_code	")
			.append("	and to_char(order_date,'yyyy-mm-dd') = to_char(sysdate,'yyyy-mm-dd')	")
//			.append("	and to_char(order_date,'yyyy-mm-dd') = '2019-01-15'	")
//			.append("	and to_char(order_date,'hh24')<=13	")
			.append("	order by o.order_num	");
	 		
			pstmt=con.prepareStatement(selectOrder.toString());
		//4.
		//5.
			rs=pstmt.executeQuery();
			OrderVO ovo=null;
			
			while(rs.next()) {
				ovo=new OrderVO(rs.getString("order_Num"), rs.getString("lunch_Code"),
						rs.getString("lunch_Name"), rs.getString("order_Name"), rs.getString("order_Date"),
						rs.getString("phone"), rs.getString("ip_Address"), rs.getString("status"),
						rs.getInt("quan"), rs.getInt("price"),rs.getString("request"));
				list.add(ovo);
			}//end while
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return list;
	}//selectOrderList
	
	/**
	 * ���ö� ���� �Ϸ� ������ ȣ��Ǿ� �ش� �ֹ� ���ö��� �ϼ����¸� �����ϴ� ��.
	 * @param orderNum
	 * @return
	 */
	public boolean updateStatus(String orderNum) throws SQLException{
		boolean flag=false;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String updateOrder="update ordering set status='Y' where order_num=?";
			pstmt=con.prepareStatement(updateOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
			int cnt=pstmt.executeUpdate();
			if(cnt==1){
				flag=true;
			}//end if
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//updateStatus
	
	/**
	 * �ֹ��� ���ö��� �����ϴ� ��
	 * @param orderNum
	 * @return
	 */
	public boolean deleteOrder(String orderNum) throws SQLException{
		boolean flag =false;

		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String deleteOrder="delete from ordering where order_num=?";
			pstmt=con.prepareStatement(deleteOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
			int cnt=pstmt.executeUpdate();
			if(cnt==1){
				flag=true;
			}//end if
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//deleteOrder
	
	/**
	 * ��û���� ��ȯ
	 * @return
	 * @throws SQLException
	 */
	public String selectRequest(String orderNum) throws SQLException{
		String request=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectRequest="SELECT REQUEST FROM ORDERING WHERE ORDER_NUM=?";
			pstmt=con.prepareStatement(selectRequest.toString());
		//4.
			pstmt.setString(1,orderNum);
		//5.
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				request=rs.getString("request");
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		if(request!=null) {
			return request;
		}else {
			request="";
			return request;
		}
	}//selectRequest
	
	public String selectRequestStatus(String orderNum) throws SQLException{
		String requests=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectRequests="SELECT REQUEST_STATUS FROM ORDERING WHERE ORDER_NUM=?";
			pstmt=con.prepareStatement(selectRequests.toString());
		//4.
			pstmt.setString(1,orderNum);
		//5.
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				requests=rs.getString("request_status");
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		if(requests!=null) {
			return requests;
		}else {
			requests="";
			return requests;
		}
	}//selectRequest
	
	public boolean updateRequestStatus(String orderNum) throws SQLException{
		boolean flag=false;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String updateOrder="update ordering set request_status='Y' where order_num=?";
			pstmt=con.prepareStatement(updateOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
			int cnt=pstmt.executeUpdate();
			if(cnt==1){
				flag=true;
			}//end if
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		return flag;
	}//updateStatus
	
	public static void main(String[] args) {
		try {
//			System.out.println(getInstance().login(new AdminLoginVO("rot", "1234")));
//			System.out.println(getInstance().selectDetailLunch("L_000001"));
			System.out.println(getInstance().selectOrderList());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
