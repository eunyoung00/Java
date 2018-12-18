package day1218;

public class Data /*implements Cloneable*/{
	private String school;

	public Data() {
	}

	public Data(String school) {
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public Data getData() throws CloneNotSupportedException {
		Data data=(Data)this.clone();//clone()은 protected접근지정자를 가지고 있어 외부클래스에서 
									//다른클래스의 clone()을 호출할 수 없다.복제한것을 내어 주어야 한다~!
		return data;
	}
	//히스토리를 남겨야 하는상황에 객체를 복제하여 남겨둔다~!~!
	
}//class
