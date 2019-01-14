package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

public class HomeworkDAO {
	
	private HomeworkView hv;
	
	public HomeworkDAO(HomeworkView hv) {
		this.hv = hv;
	}//HomeworkDAO

	public void createTable() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			
//			String tableName=JOptionPane.showInputDialog("생성할 테이블 명 입력");
			String tableName=hv.getJtftabName().toString();
//			String constraintName=hv.getJtfConstraintName().toString();
			
			//3.//테이블이 존재하는지 ?
			StringBuilder selectTname=new StringBuilder();
			selectTname.append("select tname from tab where tname=?");
			//4.
			pstmt=con.prepareStatement(selectTname.toString());
			
			pstmt.setString(1, tableName.toUpperCase());
			//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, tableName+"테이블이 존재합니다");
			}//end if
			pstmt.close();//그때그때 쓰임이 끝나면 닫아 준다.
			
		//3.
			StringBuilder createTable=new StringBuilder();
			try {
				//자르는 부분이 문젠데 쿼리가 완성되지 않으면 ;를 찾을수 없어서
			String sql=hv.getJtaQueryView().getText().substring(0,hv.getJtaQueryView().getText().lastIndexOf(";"));
			System.out.println(sql);
			//아무것도 없을때 비었을때 생성버튼을 누르면 막아야 한다....
			createTable.append(sql);
			//<권한만있으면 view나 시노님을 만드는것도 가능하지만 함수나 트리거같은 기능은 thin의 특성상 안됨.
			pstmt=con.prepareStatement(createTable.toString());
		//4.
		//5.
			pstmt.execute();//넣는데 컬럼이름 중복 여기서 걸림...
			JOptionPane.showMessageDialog(null, "테이블이 생성되었습니다.");
			}catch (java.lang.StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(hv, "쿼리를 완성해주세요");
			}//end catch
		}finally {
			//6.
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
	}//createTa
}//class
