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
import kr.co.sist.exam.vo.CursorVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;
import kr.co.sist.exam.vo.TransactionVO;

public class MyBatisDAO1 {
	public List<Emp> multiParam(EmpVO ev){
		List<Emp> list=null;
		//4.Handler���
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
		ss.close();
		return cnt;
	}//diaryTotalCount
	
	public List<DiaryList> subquery(DiaryListParamVO dlpvo){
		List<DiaryList> list=null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("subquery",dlpvo);
		ss.close();
		return list;
	}//subquery
	
	public List<Union> union(){
		List<Union> list=null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("union");
		ss.close();
		return list;
	}//union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list=null;
		
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("join",mgr);
		ss.close();
		return list;
	}//join

	public List<Car> joinSubquery(){
		List<Car> list=null;
		
		SqlSession ss= MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("joinSubquery");
		ss.close();
		return list;
	}//joinSubquery
	
	public List<Demp> dynamicTable(TnameVO tvo){
		List<Demp> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("dtable",tvo);
		ss.close();
		return list;		
	}//dynamicTable
	
	public List<Dynamicif> dynamicIf(DeptnoVO dvo){
		List<Dynamicif> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("dynamicif", dvo);
		ss.close();
		return list;
	}//dynamicIf
	
	public List<Dynamicif> dynamicChoose(DeptnoVO dvo){
		List<Dynamicif> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("kr.co.sist.exam2.dynamicChoose", dvo);
		ss.close();
		return list;
	}//dynamicIf
	
	public List<Car> dynamicForeach(CarVO cv){
		List<Car> list=null;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		list=ss.selectList("kr.co.sist.exam2.dynamicForeach", cv);
		ss.close();
		return list;
	}//dynamicForeach
	
	public TestProcVO insertProc(TestProcVO tpvo) {
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		System.out.println("-----"+tpvo.getMsg());
		ss.selectOne("insertProcedure",tpvo);
		System.out.println("-----"+tpvo.getMsg());
		ss.close();
		return tpvo;
	}//insertProc
	
	public void selectProc(CursorVO c_vo) {
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("selectProcedure", c_vo);
		ss.close();
	}//selectProc
	
	public int insertTransaction(TransactionVO t_vo) {
		int cnt=0,cnt1=0;
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt=ss.insert("tr1",t_vo);
		cnt1=ss.insert("tr2", t_vo);

		if((cnt+cnt1)==2) {
			ss.commit();
		}
		ss.close();
		return cnt+cnt1;
	}//insertTransaction
	
	
	public static void main(String[] args) {
		MyBatisDAO1 md=new MyBatisDAO1();
		//md.multiParam(new EmpVO(30, "SALESMAN"));
		//md.lessThan(3000);
		//md.greaterThan(3000);
		//md.like("�󵵵�");
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
		list.add("����");
		list.add("���");
		list.add("BMW");
		list.add("�Ｚ");*/
		//md.dynamicForeach(new CarVO(list));
		
		/*TestProcVO tpvo=new TestProcVO(1111, 3000, 0, "����ö", "�븮", "");
		md.insertProc(tpvo);
		*/
		
		/*CursorVO c_vo=new CursorVO();
		c_vo.setDeptno(10);
		md.selectProc(c_vo);
		System.out.println(c_vo.getEmpList());*/
		
		TransactionVO tv=new TransactionVO("������ ��¾�� ����� ���� �����", "������");
		
		System.out.println(md.insertTransaction(tv));
	}//main
	
}//class
