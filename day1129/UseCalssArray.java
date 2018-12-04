package day1129;


/**
 * 사용자 정의 데이터형(내가만든 클래스)을 사용하여 배열을 생성.<br>
 * 생성된 배열 방하나는 여러개의 다양한 값을 저장하고 사용할 수 있다.
 * @author owner
 */
public class UseCalssArray {
	
	public UseCalssArray(){
		//1.선언) 데이터형[] 배열명=null;
//		Data[] dataArr=new Data[4];//배열을 만든거지 방이 만들어진게 아님.null이 들어가있음.
		Data[] dataArr=null;
		//2.생성) 배열명 = new 데이터형[방의수];
		dataArr = new Data[4];
		//3.값 할당 : 배열명[방의번호]=new 생성자();
		//아니면, 클래스명 객체명 = new 생성자();
			  //배열명[방의 번호] = 객체명;    //같다. 방에 넣은거나 객체로 넣은거나 .. 값을넣을땐 코드가 더 길어지니까 위에것을 추천한다.
//		System.out.println(Arrays.toString(dataArr));
		dataArr[0]= new Data("공선의",27,"gong@daum.net",'G');
		dataArr[1]= new Data("김건하",29,"kim@daum.net",'K');
		dataArr[2]= new Data("최지우",25,"choi@daum.net",'C');
//		System.out.println(Arrays.toString(dataArr));

		//객체생성 후 값을 추가
		Data d = new Data();
		dataArr[3]=d;
		//주소는 하나 이므로 배열명을 사용하여 method를 호출하든
//		dataArr[3]= new Data();
		dataArr[3].setName("정택성");
		dataArr[3].setAge(26);
		//객체명을 사용하여 method를 호출하든 동일하게 값이 변경된다.
		d.setEmail("jung@jung.net");
		d.setInitial('D');
//		System.out.println(Arrays.toString(dataArr));
		//기본생성자로는 값이 들어가지 않는다.
		
		//4.값 사용) 
		//배열명으로 바로 사용하거나
		System.out.println(dataArr[0].getName()+" / "+dataArr[0].getAge());
		//객체에 저장하여 사용.
		Data temp = dataArr[0];
		System.out.println(temp.getName()+" / "+temp.getAge());
		//식별 할수 있기 때문에 객체에 저장하는게 가독성 향상된다.
		
		//일괄처리)
//		Data tempData=null;
//		for(int i=0; i<dataArr.length; i++) {
//			tempData=dataArr[i];
//			System.out.println(tempData.getName()+" / "+tempData.getAge()
//						+" / "+tempData.getEmail()+" / "+
//								tempData.getInitial());
//		}//클래스로 배열을 만들면 메소드로 값을 넣는다.(?)

		for(Data tempData : dataArr) {
			System.out.println(tempData.getName()+" / "+tempData.getAge()
			+" / "+tempData.getEmail()+" / "+
					tempData.getInitial());
		}//end for  //i번째를 꺼내지 않아도 되어서 편리
		
		
		
	}//UseCalssArray

	public static void main(String[] args) {
		//main method가 있으면java application 단독으로 실행될수 있는 프로그램
		new UseCalssArray();
		
		
	}//main
}//class
