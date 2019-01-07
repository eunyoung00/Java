package day0107;

public class CpEmp2AllVO {
	private int empno,sel;
	private String  name, hiredate;
	
	public CpEmp2AllVO() {
	}//CpEmp2AllVO
	
	public CpEmp2AllVO(int empno, int sel, String name, String hiredate) {
		this.empno = empno;
		this.sel = sel;
		this.name = name;
		this.hiredate = hiredate;
	}//CpEmp2AllVO
	
	public int getEmpno() {
		return empno;
	}
	public int getSel() {
		return sel;
	}
	public String getName() {
		return name;
	}
	public String getHiredate() {
		return hiredate;
	}
	
}//class
