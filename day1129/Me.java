package day1129;

public class Me extends Person2{
	public int dexterity;//손재주
	public int fatigability;//피로도
	
	public Me() {
		dexterity=8;
		fatigability=0;
	}//me
	
	public String dexterity(int cnt) {
		String result="";
		//피로도가 횟수보다 적으면 잘 만들어 지고 넘으면 완성도가 떨어진다.
		//피로도는 1~10까지로 한번 실행될때마다 증가한다.
		
		if(fatigability<cnt) {
			result="잘 만들었다. s('.^)V";
			fatigability++;
			if(fatigability>10) {
				fatigability=10;
			}//end if
		}else if(fatigability>cnt) {
			result = "완성도가 떨어졌다.";
			fatigability++;
			if(fatigability>10) {
				fatigability=10;
			}//end if
		}else {
			result="완성되었당";
		}//end else
		
	
		return result;
	}
}
