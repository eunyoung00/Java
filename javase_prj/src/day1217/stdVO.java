package day1217;

public class stdVO {
	private int num;//번호
	private String name;//이름
	private int javaScore;//자바점수
	private int oracleScore;//오라클점수
	private int sum;//총합
	private double avr;//평균
	
	//다 가져온걸 인스턴스변수에 넣고(setter), 그 인스턴스 변수를 getter에 담아 다시 보내준다?  
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvr() {
		return avr;
	}
	public void setAvr(double avr) {
		this.avr = avr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public int getOracleScore() {
		return oracleScore;
	}
	public void setOracleScore(int oracleScore) {
		this.oracleScore = oracleScore;
	}
	
}
