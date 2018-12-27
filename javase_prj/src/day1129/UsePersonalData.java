package day1129;

public class UsePersonalData {


//	 서울시 거주자 x명
//	 나이 합 x살
//	 최고령자 "정택순(여자)"
//	 
//	1. 위의값을 배열에 입력하는 method를 작성할것.     v
//	2. 배열에 입력된 값을 출력하는 method 를 작성할것.   
//	   2번 method 에서 서울시에 살고 있는 인원수를 출력 할것.
//	   2번 method 에서 나이의 합을 출력 할것.
//	   2번 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것.
	public PersonalData[] inputData() {
		PersonalData[] dataArr = null;
		dataArr = new PersonalData[7];
		
		dataArr[0]=new PersonalData(1, "이재찬", "서울시 강남구 역삼동", 28,"남자");
		dataArr[1]=new PersonalData(2, "이재현", "서울시 동대문구 답십리동", 27,"남자");
		dataArr[2]=new PersonalData(3, "김정운", "수원시 영통구 영통동", 26,"남자");
		dataArr[3]=new PersonalData(4, "정택성", "서울시 구로구 구로동",27,"남자");
		dataArr[4]=new PersonalData(5, "정택순", "서울시 동작구 상도동",29,"여자");
		dataArr[5]=new PersonalData(6, "김건하", "경기도 부천시 부천동",26,"남자");
		dataArr[6]=new PersonalData(7, "이재순", "서울시 광진구 광나루동",27,"여자");
		
		for(PersonalData tempData : dataArr ) {
		System.out.println(tempData.getNum()+" / "+tempData.getName()
		+" / "+tempData.getAddr()
		+" / "+tempData.getAge()+" / "+
				tempData.getGender());
		}
		return dataArr;
	}
	
	public void print1(PersonalData[] dataArr) {
		int cnt=0;
//		   2번-1 method 에서 서울시에 살고 있는 인원수를 출력 할것.
		PersonalData tempData=null;
		for(int i=0; i<dataArr.length; i++) {
			tempData=dataArr[i];
			if(tempData.getAddr().startsWith("서울시")) {
				cnt++;
			}
		}
		System.out.println("서울시 거주자"+cnt+"명");
	}
	
	public void print2(PersonalData[] dataArr) {
//		   2번-2 method 에서 나이의 합을 출력 할것.
		int agesum=0;
		PersonalData tempData=null;
		for(int i=0; i<dataArr.length; i++) {
			tempData=dataArr[i];
			agesum = tempData.getAge()+agesum;
		}
		System.out.println("나이 합 "+agesum+"살");
	}
	
	public void print3(PersonalData[] dataArr) {
//		   2번-3 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것.	

		int maxAge=0;
		String name = null;
		String gen = null;
		PersonalData tempData=null;
		for(int i=0; i<dataArr.length; i++) {
			tempData=dataArr[i];
			if(maxAge<tempData.getAge()) {
				//현재 순환중인  방의 값으로 최고점수를 변경해 준다.
				maxAge=tempData.getAge();
				name = tempData.getName();
				gen = tempData.getGender();
				
			}//자바의 최고 점수
		}
		System.out.println("최고령자\""+name+"("+gen+")"+"\"");
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsePersonalData upd = new UsePersonalData();
		PersonalData[] dataArr = upd.inputData();
//		upd.inputData();
		upd.print1(dataArr);
		upd.print2(dataArr);
		upd.print3(dataArr);

	}

}
