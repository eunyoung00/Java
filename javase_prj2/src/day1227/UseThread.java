package day1227;

/**
 * Thread class �� ��ӹ޾Ƽ� Thread ���.
 * @author owner
 */

//1.Thread ���
public class UseThread extends Thread{

	//2.run method Override
	@Override
	public void run() {
		//3.Thread�� ���۵Ǿ�� �� �ڵ�(���ÿ� ����Ǿ�� �� �ڵ�)
		for(int i=0; i<1000; i++) {
			System.out.println("run i------>"+i);
		}//end for
	}//run
	
	public void test() {
		for(int i=0; i<1000; i++) {
			System.out.println("test ==========i="+i);
		}//end for
	}//test
	
	public static void main(String[] args) {
		//4.��ü ����
		UseThread ut=new UseThread();
		//5.�θ� Ŭ������ Thread�� ������ �ִ� start()method ȣ��.
		ut.start();//start�� ȣ���ϸ� start()�ȿ��� run()ȣ��.
		ut.test();//ȣ���� ���������� �ٸ����� �� �Ҽ� �ִ�.
		//Thread�� ������ ������ ���� �ʴ´�?�ϳ��ϱ�!!
		
//		ut.run();//�Ʒ��� for�� ������ �����ҷ����� �����Ŀ��� �Ѿ��.
//		//�����ϴ� ��ȭ�޴°�????
	}//main
}//class