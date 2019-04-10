package homework;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HwMyBatisService {
	public HwMyBatisService() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//UseMyBatis
	
	//2�� ����
	public SqlSessionFactory getSessionFactory() throws IOException{
		//1.ȯ�漳�� xml�� stream����
		Reader reader=Resources.getResourceAsReader("homework/mybatis_config.xml"); //�����δ� �ʿ���� ��Ű����κ��� ������ȴ�.
			//mybatis-3.5.0.jar�� build path�� ������ ������ �Ǵµ� ����� ���� �ʴ´�.
		//2.MyBatis Framework ����
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//3.MyBatis Framework�� DB������ ��ü ���(��ü�� �ϳ��� ����)
		SqlSessionFactory ssf=ssfb.build(reader);
		//System.out.println(ssf);
		if(reader!=null) {
			reader.close();
		}//end if
		//3������ �ѹ��� �ؼ� ���丮��....
		
		return ssf;
	}//getSessionFactory
	
	
	public void selectAllDept() throws IOException {	
		//4.MyBatis Handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler�� ����Ͽ� DB�۾� ����
		//List<DeptDomain> list= ss.selectList("kr.co.sist.selectAllDept"); //selectAllDept�� �����ϴ�.-id�� ���� �ϴٸ�!
		//DeptDomain dd=null;
		//for(int i=0; i<list.size(); i++) {
		//	dd=list.get(i);
		//	System.out.println(dd.getDeptno()+"/"+dd.getDname()+"/"+dd.getLoc());
		//}//end for
		//6.����� ����� SqlSession�� �ݴ´�.
		//ss.close();
		
	}//selectAllDept

	public static void main(String[] args) {
		HwMyBatisService umb=new HwMyBatisService();
		try {
			umb.selectAllDept();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
