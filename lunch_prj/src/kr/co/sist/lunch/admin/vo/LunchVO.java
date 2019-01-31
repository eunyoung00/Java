package kr.co.sist.lunch.admin.vo;


public class LunchVO {
	private String lunchCode, lunchName,lunchImg;
	private int price;
	public LunchVO(String lunchCode, String lunchName, String lunchImg, int price) {
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.lunchImg = lunchImg;
		this.price = price;
	}
	
	public String getLunchCode() {
		return lunchCode;
	}
	public String getLunchName() {
		return lunchName;
	}
	public String getLunchImg() {
		return lunchImg;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "LunchVO [lunchCode=" + lunchCode + ", lunchName=" + lunchName + ", lunchImg=" + lunchImg + ", price="
				+ price + "]";
	}
}//class
