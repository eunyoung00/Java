package day1218;

public class ScoreVO {
	private String name;
	private int javaScore,oracleScore;
	
	public ScoreVO(String name, int javaScore, int oracleScore) {
		super();
		this.name = name;
		this.javaScore = javaScore;
		this.oracleScore = oracleScore;
	}//ScoreVO
	
	public String getName() {
		return name;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public int getOracleScore() {
		return oracleScore;
	}
	
}//class

