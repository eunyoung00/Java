package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import kr.co.sist.connection.GetConnection;

/**
 * Procedure 호출
 * @author owner
 */
public class UseCallableStatement {

	public UseCallableStatement() throws SQLException{
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		String tempData=JOptionPane.showInputDialog("숫자 2개 입력\n예)숫자,숫자");
		int num1=Integer.parseInt(tempData.split(",")[0]);
		int num2=Integer.parseInt(tempData.split(",")[1]);
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt=con.prepareCall("{ call proc_plus(?,?,?) }");
			//<만들어진(db에 저장된) procedure의 이름
			//<쿼리가 들어가지 않더라도 db의 작업을 할수있는게 callable~의 장점
			
		//4.바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, num1);
			cstmt.setInt(2, num2);
			
			//out parameter
			cstmt.registerOutParameter(3, Types.NUMERIC);
			
		//5.쿼리 실행 후 결과 얻기(프로시져 실행)
			//프로시져를 실행하면 in parameter와 out parameter에 값이 할당 
			cstmt.execute();
			
			int total=cstmt.getInt(3);
			
			JOptionPane.showMessageDialog(null, num1+"+"+num2+"="+total);
			//<이때의 결과값은 프로시져가 계산해서 가져오는것
			
		}finally {
			//6.
			if(cstmt!=null) {cstmt.close();	}//end if
			if(con!=null) {con.close();	}//end if
		}//end finally
	}//UseCallableStatement
	
	public static void main(String[] args) {
		try {
			new UseCallableStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
