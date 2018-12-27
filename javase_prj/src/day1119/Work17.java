package day1119;

public class Work17 {

	public static void main(String[] args) {
/*		숙제 
		1. 출퇴근 시간을 입력받아 아래의 조건으로 출력하세요.
		  출력 :  출퇴근 시간은 최대 2시간의 제한이 있으며 60분을 넘는 다면 "장거리"
		 	 60분 이하라면 "단거리"를 출력하세요.
*/
		int time = Integer.parseInt(args[0]);
		if(time < 120) {
			if(time>60) {
				System.out.println("장거리");
			} else if(time<=60) {
				System.out.println("단거리");
			}
		} else
			System.out.println("2시간 초과");
/*	

		2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이 출력하세요.
		   교통수단은 "버스,지하철,택시,도보"로 제한한다.
		   버스요금 1200원, 지하철 요금 1250원, 택시요금 3800원 입니다.
		   요금은 10키로 까지는 기본요금, 
		   매 5키로 초과시 마다 100원씩 증가 합니다.

		 출력   :  xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로 입니다.
		            편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며, 한달 20일기준
		            교통비는 총: xxxx원 입니다.  
		            +플로우 차트
*/
		int len = Integer.parseInt(args[3]);
		int price = 0;
		if(args[2].equals("버스")) {
			if (len<=10)
				price = 1200;
			else {
				price = 1200+ (((int)((len-10)/5))*100);
			}
			System.out.println(args[1]+"님 출퇴근 교통수단은 "+args[2]+"이며 거리는 "+ args[3]+"키로 입니다.");
			System.out.println("편도 이용 요금 "+price+"원이고, 왕복이용 요금 "+(price*2)+"원이며,"
					+ " 한달 20일기준  교통비는 총: "+(price*2*20)+"원 입니다.");	
		}else if(args[2].equals("지하철")) {
			if (len<=10)
				price = 1250;
			else {
				price = 1250+ (((int)((len-10)/5))*100);
			}
			System.out.println(args[1]+"님 출퇴근 교통수단은 "+args[2]+"이며 거리는 "+ args[3]+"키로 입니다.");
			System.out.println("편도 이용 요금 "+price+"원이고, 왕복이용 요금 "+(price*2)+"원이며,"
					+ " 한달 20일기준  교통비는 총: "+(price*2*20)+"원 입니다.");
		}else if(args[2].equals("택시")) {
			if (len<=10)
				price = 3800;
			else {
				price = 3800+ (((int)((len-10)/5))*100);
			}
			System.out.println(args[1]+"님 출퇴근 교통수단은 "+args[2]+"이며 거리는 "+ args[3]+"키로 입니다.");
			System.out.println("편도 이용 요금 "+price+"원이고, 왕복이용 요금 "+(price*2)+"원이며,"
					+ " 한달 20일기준  교통비는 총: "+(price*2*20)+"원 입니다.");
		}else if (args[2].equals("도보")) {
			System.out.println(args[1]+"님 출퇴근 교통수단은 "+args[2]+"이며 거리는 "+ args[3]+"키로 입니다.");
			System.out.println("편도 이용 요금 "+price+"원이고, 왕복이용 요금 "+(price*2)+"원이며,"
					+ " 한달 20일기준  교통비는 총: "+(price*2*20)+"원 입니다.");
		}
		
		
		//한번더
		int flag = 0;
		double flag_add = 0;
		int fee = 0;
//		int transport = Integer.parseInt(args[2]);
		int distance = Integer.parseInt(args[3]);
		if(args[2].equals("도보")||args[2].equals("지하철")||args[2].equals("버스")||args[2].equals("택시")) {

			if(args[2].equals("도보")) {
				fee=0;
			}else if(args[2].equals("지하철")){
				fee=1250;
			}else if(args[2].equals("버스")) {
				fee=1200;
			}else {
				fee = 3800;
			}
			
			if(distance>10) {
				flag_add = (distance-10)/5; 
				flag = (distance-10)/5; 
				if(flag_add>flag) {
					flag_add=flag_add+1;
					fee = fee + ((int)flag_add*100);
				}
			}//end if
			System.out.println(args[1]+"님 출퇴근 교통수단은 "+args[2]+"이며 거리는 "+ args[3]+"키로 입니다.");
			System.out.println("편도 이용 요금 "+fee+"원이고, 왕복이용 요금 "+(fee*2)+"원이며,"
					+ " 한달 20일기준  교통비는 총: "+(fee*2*20)+"원 입니다.");
			
		} else {
			System.out.println("올바른 대중교통을 입력해 주세요");
		}

	}

}
