package day0403;

/**
 * 조회하는 컬럼의 값을 저장하는 VO를 Domain
 * @author owner
 */
public class DeptDomain {
	private int deptno;
	private String dname, loc;
	
/*	public DeptDomain() {
		System.out.println("DeptDomain기본생성자");
	}
	public DeptDomain(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		System.out.println("DeptDomain 인자있는 생성자");
	}//컴파일러가 생성자를 알아서 만들어줌으로 만들지 않고 사용한다.
	*/
	
	public void setDetpno(int deptno) {
		this.deptno = deptno;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}
	
}
