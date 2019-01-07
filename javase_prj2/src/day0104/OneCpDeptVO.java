package day0104;

public class OneCpDeptVO {
	private String dname,loc;

	public OneCpDeptVO() {
	}

	public OneCpDeptVO(String dnama, String loc) {
		this.dname = dnama;
		this.loc = loc;
	}

	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}

//저장되는 값이 다르면 무조건 VO를 새로 만든다.
//개발자의 실수로 값을 넣어버리는경우가 발생할수있어서!
}//class
