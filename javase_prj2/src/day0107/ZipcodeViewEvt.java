package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener{

	private ZipcodeView zv;
	
	public ZipcodeViewEvt(ZipcodeView zv) {
		this.zv=zv;
	}//ZipcodeViewEvt

	@Override
	public void windowClosing(WindowEvent we) {
		zv.dispose();
	}//windowClosing
	
	public String blockInjection(String sql) {
		return sql.replace("'", "").replaceAll("--", "");
	}//blockInjection
	//=>PreparedStatement를 쓰는것 만으로도 인젝션 공격을 막을 수 있다.(공격이 막힘)
	//=>PreparedStatement 사용하여 추가
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		//1.드라이버 <로딩>
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con =null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection 얻기
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		//3.쿼리문 <생성> 객체 얻기
			stmt=con.createStatement();
		//4.쿼리 <수행 후> 결과 얻기 
			StringBuilder selectZipcode=new StringBuilder();
			selectZipcode
			.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ")//null이면 whitespace주고 alias로 이름 다시 
			.append(" from zipcode ")
			.append(" where dong like '").append(blockInjection(dong)).append("%'");
			
			rs=stmt.executeQuery(selectZipcode.toString());
			
			ZipcodeVO zv=null;
			while(rs.next()) {//조회된 레코드가 존재한다면
				//VO에 값을 할당하고 
				zv=new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), 
									rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji"));
				//같은 이름의 객체를 여러개 관리하기 위해 List에 추가
				list.add(zv);
			}//end while
				
		}finally {
			//5.연결 끊기
			if(rs!=null) {rs.close(); }//end if
			if(stmt!=null) {stmt.close(); }//end if
			if(con!=null) {con.close(); }//end if
		}//end finally
		
		return list;
	}//selectZipcode
	
	public void searchZipcode(String dong) {
		try {
			//DB에서 조회한 결과를 받아서
			List<ZipcodeVO> listZip=selectZipcode(dong);
			//DefaultTableModel에 추가=> JTable에 반영된다.
			DefaultTableModel dtm=zv.getDtmZipcode();
			//D.T.M 초기화
			dtm.setRowCount(0);
			
			String[] rowData=null;
			//조회된 결과를 가지고
			for(ZipcodeVO zv : listZip) {//배열에 넣어
				rowData=new String[2];
				rowData[0]=zv.getZipcode();
				rowData[1]=zv.getSido()+" "+zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
				
				//D.T.M 에 레코드(행/row):우편번호,주소 추가
				dtm.addRow(rowData);
			}//end for
			
			if(listZip.isEmpty()) {//없어여~
				rowData=new String[2];
				rowData[0]="";
				rowData[1]="해당 동은 존재하지 않습니다.";
				
				dtm.addRow(rowData);
			}//end if
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(zv, "DB에서 문제 발생");
			se.printStackTrace();
		}//end catch
	}//searchZipcode
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String dong =zv.getJtfDong().getText().trim();
		if(!dong.equals("")) {
			searchZipcode(dong);
		}//end if
	}//actionPerformed

}//class
