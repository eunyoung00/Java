package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO;
import kr.co.sist.exam.domain.DeptInfo;
import kr.co.sist.exam.domain.Emp;

public class MyBatisService {
	
	/**
	 * �÷��ϳ� ���ڵ��ϳ�
	 * @return
	 */
	public String deptName() {
		MyBatisDAO mb_dao=MyBatisDAO.getInstance();
		String dname=mb_dao.singleColumn()+"�μ�";
		return dname;
	}//deptName -controller�� ������ ����ϰ� �ȴ�.
	
	/**
	 * �÷������� ���ڵ��ϳ�
	 * @return
	 */
	public DeptInfo deptInfo() {
		MyBatisDAO mb_dao=MyBatisDAO.getInstance();
		DeptInfo di=mb_dao.multiColumn();
		return di;
	}//deptInfo
	
	public List<Integer> multiRow(){
		List<Integer> list=null;
		MyBatisDAO mb_dao=MyBatisDAO.getInstance();
		list=mb_dao.multiRow();
		
		return list;
	}//multiRow
	
	public List<Emp> multiColumnRow(int deptno){
		List<Emp> list=null;
		
		MyBatisDAO mb_dao=MyBatisDAO.getInstance();
		
		list=mb_dao.multiColumnRow(deptno);
		
		return list;
	}//multiColumnRow
	
}//class
