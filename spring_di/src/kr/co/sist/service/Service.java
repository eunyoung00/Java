package kr.co.sist.service;

import java.util.List;

import kr.co.sist.vo.EmpVO;

public interface Service {
	public void addEmp(EmpVO ev);
	public List<EmpVO> searchEmp();
	
}
