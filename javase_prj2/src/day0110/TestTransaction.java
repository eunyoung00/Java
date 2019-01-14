package day0110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import kr.co.sist.connection.GetConnection;

/**
 * Transaction 처리 <br>
 * insert를 두번 실행할때, 두번다 잘 들어갔을때 commit되고, 안되면 rollback
 * @author owner
 */
public class TestTransaction {
	//Commit 과 Rollback을 DB작업 외부에서 처리할 수 있도록 인스턴스 변수를 class field에 빼 정의
	private Connection con;
//	private PreparedStatement pstmt=null;
//	PreparedStatement pstmt1=null;
	
	public boolean insert(TransactionVO tv) throws SQLException{
		//트랜젝션에 사용할 쿼리의 수 만큼 쿼리 실행 객체 선언
		PreparedStatement pstmt=null;//위로 올리면 끊어도 가능
		PreparedStatement pstmt1=null;//하나면 끊겨버린다...
		
		boolean flag=false;

		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			//auto commit 해제
			con.setAutoCommit(false);//맞음
		//3.
			String sql="insert into test_transaction1(subject,writer)values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, tv.getSubject());
			pstmt.setString(2, tv.getWriter());
		//4.
			int cnt=pstmt.executeUpdate();
			//3.
			String sql1="insert into test_transaction2(subject,writer)values(?,?)";
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, tv.getSubject());
			pstmt1.setString(2, tv.getWriter());
			//4.
			int cnt1=pstmt1.executeUpdate();
			//트랜젝션에 해당하는 모든 쿼리의 목표행수를 비교하여 커밋과 롤백여부를 설정한다.
			if(cnt==1&&cnt1==1) {
				flag=true;
//				con.commit();
//				System.out.println("Commit!!!");
//			}else {
//				con.rollback();
//				System.out.println("Rollback!!!");
			}//end else
		//5.
		}finally {
			//6.
//			if(pstmt !=null) {pstmt.close();}//end if
//			if(con !=null) {con.close();}//end if
			//끊으면 정상종료되어 commit됨.
		}//end finally
		return flag;//둘다1일때 true
	}//insert
	
	public void add() {
		String inputData=JOptionPane.showInputDialog("제목과 작성자를 입력해 주세요\n예)제목-작성자");
		
		String[] data=inputData.split("-");
		
		if(data.length!=2) {
			JOptionPane.showMessageDialog(null, "입력 형식을 확인해 주세요.");
			return;
		}//end if
		TransactionVO tv=new TransactionVO(data[0], data[1]);
		
		try {
			//DB업무를 사용하는 곳에서 수행결과를 받아 
			boolean flag=insert(tv);
			if(flag) {
				//커밋하거나
				con.commit();
				System.out.println("커밋!!!");//나를  써도되 통제,
			}else {
				//롤백한다.
				con.rollback();//하나 마나 성공 아니면 예외라 else를 들르지 않는다.update나 delete가 transaction일 때에만 들름.
				System.out.println("update나 delete의 롤백!!!");
			}//end else
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("insert의 롤백!!!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.close();//끊어지면 pstmt도 끊어진다...
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end catch
	}//add

	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.add();
	}//main
}//class
