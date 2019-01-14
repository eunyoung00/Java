package day0110;

public class TestProcUpdateVO {
	private int empono,sal;
	private String job;
	
	public TestProcUpdateVO() {
	}
	public TestProcUpdateVO(int empono, int sal, String job) {
		this.empono = empono;
		this.sal = sal;
		this.job = job;
	}
	
	public int getEmpono() {
		return empono;
	}
	public int getSal() {
		return sal;
	}
	public String getJob() {
		return job;
	}

}//class
