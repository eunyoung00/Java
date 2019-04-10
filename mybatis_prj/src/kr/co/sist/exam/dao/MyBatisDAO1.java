package kr.co.sist.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.Demp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.Dynamicif;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;

public class MyBatisDAO1 {
	public List<Emp> multiParam(EmpVO ev){
		List<Emp> list=null;
		//4.Handler¾ò±â
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("multiParam",ev);
		
		ss.close();
		
		return list;
	}//multiParam
	
	public List<Emp> lessThan(int sal){
		List<Emp> list=null;
		
		//4.
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("lessThan",sal);
		ss.close();
		
		return list;
	}//lessThan
	
	public List<Emp> greaterThan(int sal){
		List<Emp> list=null;
		
		//4.
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("greaterThan",sal);
		ss.close();
		
		return list;
	}//greaterThan
	
	public List<Zipcode> like(String dong){
		List<Zipcode> list=null;
		
		//4.
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("like",dong);
		ss.close();
		
		return list;
	}//like
	
	public int diaryTotalCount() {
		int cnt=0;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt=ss.selectOne("diaryCnt");
		
		return cnt;
	}//diaryTotalCount
	
	public List<DiaryList> subquery(DiaryListParamVO dlpvo){
		List<DiaryList> list=null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("subquery",dlpvo);
		
		return list;
	}//subquery
	
	public List<Union> union(){
		List<Union> list=null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("union");
		
		return list;
	}//union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list=null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("join",mgr);
		
		return list;
	}//join

	public List<Car> joinSubquery(){
		List<Car> list=null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("joinSubquery");
		
		return list;
	}//joinSubquery
	
	public List<Demp> dynamicTable(TnameVO tvo){
		List<Demp> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("dtable",tvo);
		return list;		
	}//dynamicTable
	
	public List<Dynamicif> dynamicIf(DeptnoVO dvo){
		List<Dynamicif> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("dynamicif", dvo);
		return list;
	}//dynamicIf
	
	public List<Dynamicif> dynamicChoose(DeptnoVO dvo){
		List<Dynamicif> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("kr.co.sist.exam2.dynamicChoose", dvo);
		return list;
	}//dynamicIf
	
	public List<Car> dynamicForeach(CarVO cv){
		List<Car> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("kr.co.sist.exam2.dynamicForeach", cv);
		return list;
	}//dynamicForeach
	
	public TestProcVO insertProc(TestProcVO tpvo) {
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		System.out.println("-----"+tpvo.getMsg());
		ss.selectOne("insertProcedure",tpvo);
		System.out.println("-----"+tpvo.getMsg());
		
		return tpvo;
	}//insertProc
	
	
	public static void main(String[] args) {
		MyBatisDAO1 md=new MyBatisDAO1();
		//md.multiParam(new EmpVO(30, "SALESMAN"));
		//md.lessThan(3000);
		//md.greaterThan(3000);
		//md.like("»óµµµ¿");
		//md.diaryTotalCount();
		//md.union();
		//md.join(7698);
		//md.joinSubquery();
		//md.dynamicTable(new TnameVO("cp_emp2"));
		//md.dynamicIf(13);//Error
		//md.dynamicIf(new DeptnoVO(20));
		//md.dynamicChoose(new DeptnoVO(100));
		
		//List<String> list=null;
		/*list=new ArrayList<String>();
		list.add("Çö´ë");
		list.add("±â¾Æ");
		list.add("BMW");
		list.add("»ï¼º");*/
		//md.dynamicForeach(new CarVO(list));
		
		TestProcVO tpvo=new TestProcVO(1111, 3000, 0, "±èÈñÃ¶", "´ë¸®", "");
		md.insertProc(tpvo);
		
		
	}//main
	
}//class
