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
	
	//2�� ����
	public SqlSessionFactory getSessionFactory() throws IOException{
		//1.ȯ�漳�� xml�� stream����
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml"); //�����δ� �ʿ���� ��Ű����κ��� ������ȴ�.
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
	
	//2��
	public void insertCpDept(DeptVO dv) throws IOException,SQLException{
		//4.MyBatis Handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler�� ����Ͽ� DB�۾� ����
		int cnt=ss.insert("insertCpDept",dv);
		ss.commit(); //���־�� ���δ� ���н� rollback
		System.out.println("�߰� �۾�"+cnt);
		//�߰��۾��� 3�ٷ� ������ �ȴ�=>���꼺 ���
	}//insertCpDept
	
	//2��
	public void updateCpDept(DeptVO dv) throws IOException, SQLException{
		//4.MyBatis Handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5.������ ����
		int cnt=ss.update("updateCpDept",dv);
		ss.commit();
		System.out.println("���� ����"+cnt);
		
	}//updateCpDept
	
	//2��
	public void deleteCpDept(int deptno) throws SQLException,IOException{
		//4.MyBatis Handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler ����Ͽ� ���� ����
		int cnt=ss.delete("deleteCpDept",deptno);
		ss.commit();
		if(cnt==1){
			System.out.println(deptno+"�� �μ� ������ ���� �Ͽ����ϴ�.");
		}else {
			System.out.println(deptno+"�� �ش� �μ��� �������� �ʽ��ϴ�.");
		}//end else
		
	}//deleteCpDept
	
	public void selectAllDept() throws IOException {
/*		//1.ȯ�漳�� xml�� stream����
		Reader reader=Resources.getResourceAsReader("day0403/mybatis_config.xml"); //�����δ� �ʿ���� ��Ű����κ��� ������ȴ�.
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
*/		
		//4.MyBatis Handler ���
		SqlSession ss=getSessionFactory().openSession();
		//5.Handler�� ����Ͽ� DB�۾� ����
		List<DeptDomain> list= ss.selectList("kr.co.sist.selectAllDept"); //selectAllDept�� �����ϴ�.-id�� ���� �ϴٸ�!
		DeptDomain dd=null;
		for(int i=0; i<list.size(); i++) {
			dd=list.get(i);
			System.out.println(dd.getDeptno()+"/"+dd.getDname()+"/"+dd.getLoc());
		}//end for
		//6.����� ����� SqlSession�� �ݴ´�.
		ss.close();
		
	}//selectAllDept

	public static void main(String[] args) {
		UseMyBatis umb=new UseMyBatis();
		try {
			//2�� �߰�
			//DeptVO dv=new DeptVO(11, "SM����", "����");
			//umb.insertCpDept(dv);
			//commit�� ���ϸ� ���� ���� ������ �ʴ´�.
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
