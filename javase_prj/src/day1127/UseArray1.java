package day1127;

/**
 * 1���� �迭 : ���ϳ��� ���θ� ������ �迭<br>
 * �迭 - �޸𸮿� ���� ������������ ������ ��������.<br>
 * ������ ��������, ����������<br>
 * �ϰ�ó���� ���(��ġó���� ������)<br>
 * ���� ���� ���(�迭��.length)
 * 
 * @author owner
 */
public class UseArray1 {
	
	/**
	 * 1���� �迭�� ������ �������� ���.
	 */
	public UseArray1() {
//		System.out.println("������");
		//1.�迭 ����) ��������[] �迭�� =null;
		int[] arr=null;
//		System.out.println("arr");
		//2.�迭 ����) �迭��=new ��������[���ǰ���];
		//�迭�� �����ϸ� ��� ���� ���� �ʱ�ȭ �ȴ�.
		arr=new int[6];
		//1+2 ����� ����) ��������[] �迭��=new ��������[���ǰ���];
		int[] arr1 = new int[8];
		System.out.println(arr+"/"+arr1);
		
		System.out.println("arr �迭 ���� ���� "+arr.length+", arr1�迭���� ���� : "
							+arr1.length);
		//3.���Ҵ�) �迭��[���� �ε���]=��;
		arr[0]= 11;
		arr[1]= 27;
		arr[2]= 14;
		arr[3]= 46;
		//4.�� ���)
		System.out.printf("arr[0]=%d, arr[1]=%d,arr[2]=%d\n"
							,arr[0],arr[1],arr[2]);
		//�迭�� ���� �ε����� ����ϸ� Error
//		arr[6]=10;//Error
		System.out.println("arr[5]="+arr[5]);
	
		System.out.println("-----------------------------------------");
		//�ϰ� ó��
		for(int i=0; i<arr.length; i++) {//length�� keyword�� ()���� ����.
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}

	

	}//UseArray1
	
	/**
	 * 1���� �迭�� �⺻�� ������ ���. new ���x
	 */
	public void arrayPrimitive() {
		System.out.println("====================�⺻�� ������ ���========================");
		//1.���� : ��������[] �迭�� = {��,,,};
		int[] arr= {2019,11,27,15,20};
		System.out.println("���� �� : "+arr.length);
//		int[] arr1 = new int[6] {1,2,3,4,5,6,7};//���� ������ �����ϸ� Error
		int[] arr1 = new int[] {1,2,3,4,5,6,7};
		System.out.println("arr1�� ���� �� : "+arr1.length);
		
		arr[0]=  2019;
		System.out.println(arr[0]+"/"+arr[1]);
		//�ʱ�ȭ�� �濡 ���� ����ִ°� ���� ����� ����.
		
		//������ ��
		for(int i = 0;i<arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}//end for
		/*
		������ �Ǵ� ���� for :�迭�̳� Collection(List,Set)�� ó�� ����� �������
		������ ���� ���������� �ս��� ��� �� ��, ���.
		for(�迭���� ���� ������ ���� : �迭 (list,set)){
			������
		}*/
		for(int value :arr1) {
			System.out.println(value);
		}//end for//�������� �غ��� ������ for�� ó�� ��������.
		//�����ɶ����� int�� ������� ������� �ϱ⶧���� ����. ��������.
		
		//arr1�迭�� ������ ����� ó�� ����� ���
		int idx = arr1.length-1;
		for(int i=0;i<arr1.length; i++) {
				System.out.print("arr1["+idx+"]="+arr1[idx]+" ");
				idx=idx-1;
		}//end for 
		System.out.println();
		for(int i=arr1.length-1; i>=0; i--) {
			System.out.print("arr1["+i+"]="+arr1[i]+" ");
		}
		
		
	}//arrayPrimitive
	
	
	

//	public void method() {
//		System.out.println("method");		
//	}//method
	
	
	public static void main(String[] args) {
//		UseArray1 ua1 = new UseArray1();
//		//�����ڰ� ����� ���� ������ �ʿ䰡 ����
		new UseArray1();
		new UseArray1().arrayPrimitive();
		//<�ν��Ͻ��� �������� �ʰ� ���¹��.
//		new UseArray1().method();//��üȭ
		
		
	}//main
}//class
