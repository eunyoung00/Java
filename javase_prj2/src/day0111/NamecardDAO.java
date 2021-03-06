package day0111;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;

/**
 * DB Table에 명함 정보를 추가, 모든 명함 정보를 조회
 * @author owner
 */
public class NamecardDAO {
	private static NamecardDAO n_dao;//싱글턴-JVM에서 객체를 하나만 만들어 사용하기 위함
	
	private NamecardDAO() {
	}//NamecardDAO
	
	public static NamecardDAO getInstance() {
		if(n_dao==null) {//생성이 되어있는지
			n_dao=new NamecardDAO();
		}//end if
		return n_dao;
	}//getInstance
	
	public void insertNamecard(NamecardVO nvo) throws SQLException{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@211.63.89.150:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			String insertNamecard="insert into namecard(name,addr,img)values(?,?,?)";
			pstmt=con.prepareStatement(insertNamecard);
		//4.
			pstmt.setString(1, nvo.getName());
			pstmt.setString(2, nvo.getAddr());
			pstmt.setString(3, nvo.getImg());
		//5.
			pstmt.executeUpdate();
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
	}//insertNamecard
	
	public List<NamecardVO> selectAllNamecard() throws SQLException{
		List<NamecardVO> list=new ArrayList<NamecardVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@211.63.89.150:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			String selectNamecard="select name,addr,img from namecard order by input_date";//<대문자면 잘 보이지 않아..넣고 변환추천
			pstmt=con.prepareStatement(selectNamecard);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			NamecardVO nvo=null;
			while(rs.next()) {
				nvo=new NamecardVO(rs.getString("name"), rs.getString("addr"), rs.getString("img"));
				list.add(nvo);
			}//end while
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return list;
	}//selectAllNamecard
	
//	//단위테스트=>실행시 지워준당
//	public static void main(String[] args) {
//		NamecardDAO n=new NamecardDAO();
//		try {
//			n.insertNamecard(new NamecardVO("김건하","서울시 성동구 옥수수","no_image.png"));
////			System.out.println(n.selectAllNamecard().size());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch
//	}//main
	
}//class
