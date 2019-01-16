package kr.co.sist.lunch.amdin.vo;

public class AdminLoginVO {
	private String id,pass;

	public AdminLoginVO(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}//AdminLoginVO

	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}

}//class
