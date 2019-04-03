package day0403;

public class DeptVO {
	//아무리 같은형태라도 일이 다르면 또만들어야 한다.(값의 사용처가 다르면!)
	private int deptno;
	private String dname,loc;
	
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}//인자있는 생성자만 쓰는 이유-값이 들어가야 하는 경우가 있기 때문!!insert/update!!
	
	//전달만하면되서 getter만
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
