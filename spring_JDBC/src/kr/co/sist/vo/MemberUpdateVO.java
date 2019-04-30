package kr.co.sist.vo;

public class MemberUpdateVO {
	private int num;
	private String name, highschool, loc; //파라메터로 들어오기 때문에 getter,setter만. 내가만드는거 아님
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHighschool() {
		return highschool;
	}
	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
