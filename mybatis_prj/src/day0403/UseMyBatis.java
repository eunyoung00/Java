package day0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {
	public UseMyBatis() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//UseMyBatis
	
	//2차 수업
	public SqlSessionFactory getSessionFactory() throws IOException{
		//1.환경설정 xml에 stream연결
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml"); //절대경로는 필요없고 패키지경로부터 적으면된다.
			//mybatis-3.5.0.jar를 build path로 잡으면 개발은 되는데 운용이 되지 않는다.
		//2.MyBatis Framework 생성
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3.MyBatis Framework과 DB연동한 객체 얻기(객체를 하나로 관리)
		SqlSessionFactory ssf=ssfb.build(reader);
		//System.out.println(ssf);
		if(reader!=null) {
			reader.close();
		}//end if
		//3번까지 한번만 해서 팩토리로....
		
		return ssf;
	}//getSessionFactory
	
	//2차
	public void insertCpDept(DeptVO dv) throws IOException,SQLException{
		//4.MyBatis Handler 얻기
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler를 사용하여 DB작업 수행
		int cnt=ss.insert("insertCpDept",dv);
		ss.commit(); //해주어야 보인다 실패시 rollback
		System.out.println("추가 작업"+cnt);
		//추가작업이 3줄로 끝나게 된다=>생산성 향상
	}//insertCpDept
	
	//2차
	public void updateCpDept(DeptVO dv) throws IOException, SQLException{
		//4.MyBatis Handler 얻기
		SqlSession ss=getSessionFactory().openSession();
		//5.쿼리문 수행
		int cnt=ss.update("updateCpDept",dv);
		ss.commit();
		System.out.println("변경 성공"+cnt);
		
	}//updateCpDept
	
	//2차
	public void deleteCpDept(int deptno) throws SQLException,IOException{
		//4.MyBatis Handler 얻기
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler 사용하여 쿼리 수행
		int cnt=ss.delete("deleteCpDept",deptno);
		ss.commit();
		if(cnt==1){
			System.out.println(deptno+"번 부서 정보를 삭제 하였습니다.");
		}else {
			System.out.println(deptno+"번 해당 부서는 존재하지 않습니다.");
		}//end else
		
	}//deleteCpDept
	
	public void selectAllDept() throws IOException {
/*		//1.환경설정 xml에 stream연결
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml"); //절대경로는 필요없고 패키지경로부터 적으면된다.
			//mybatis-3.5.0.jar를 build path로 잡으면 개발은 되는데 운용이 되지 않는다.
		//2.MyBatis Framework 생성
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3.MyBatis Framework과 DB연동한 객체 얻기(객체를 하나로 관리)
		SqlSessionFactory ssf=ssfb.build(reader);
		//System.out.println(ssf);
		if(reader!=null) {
			reader.close();
		}//end if
		//3번까지 한번만 해서 팩토리로....
*/		
		//4.MyBatis Handler 얻기
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler를 사용하여 DB작업 수행
		List<DeptDomain> list= ss.selectList("kr.co.sist.selectAllDept"); //selectAllDept도 가능하다.-id가 유일 하다면!
		DeptDomain dd=null;
		for(int i=0; i<list.size(); i++) {
			dd=list.get(i);
			System.out.println(dd.getDeptno()+"/"+dd.getDname()+"/"+dd.getLoc());
		}//end for
		//6.사용이 종료된 SqlSession을 닫는다.
		ss.close();
		
	}//selectAllDept

	public static void main(String[] args) {
		UseMyBatis umb=new UseMyBatis();
		try {
			//2차 추가
			//DeptVO dv=new DeptVO(11, "SM개발", "원주");
			//umb.insertCpDept(dv);
			//commit을 안하면 값이 들어간게 보이지 않는다.
			//umb.updateCpDept(dv);
			umb.deleteCpDept(1);
			
			umb.selectAllDept();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
