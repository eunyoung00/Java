package day0107;

import java.sql.Date;

public class CpEmp2OneVO {
	private int sal;
	private String ename;
	private Date hiredate;
	
	public CpEmp2OneVO() {
		super();
	}//CpEmp2OneVO
	
	public CpEmp2OneVO(int sal, String ename, Date hiredate) {
		super();
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
	}//CpEmp2OneVO
	
	public int getSal() {
		return sal;
	}
	public String getEname() {
		return ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	
}//class
