package day1115;
/*
	Java ���α׷� �ܺο��� Java ���α׷� ���η� ���� ������ �� main method�� Arguments ���.
	���� : java Ŭ�������ϸ�(����Ʈ�ڵ��) �� �� ��...(�ִ� 21�ﰳ_�ε����� 21�ﰳ���� ����)
*/

class MainArguments {
	public static void main(String[] args) {

		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[0]+args[1]);	//���ڿ��� + ��������~!�̰͸� �ǰ�, *�� ���� �ʴ´�

		//int i = args[0];  int i = (int)args[0]; ������
		//�⺻�� ������ ���� �޶� ���� �ʴ´�.ĳ����(int)�� �����ʴ´�.
		//���ڿ��� ������ ��ȯ
		//Integer.parseInt(���ڿ�); IntegerŬ������ parseInt�޼ҵ��, ���ڿ��� �����Ͽ� int������ ��ȯ���� �װ��� ��ȯ�ϴ� ���� �Ѵ�. 
		//�ǰԸ��̾���.�ڡڡ�
		int i = Integer.parseInt(args[0]);	//���ĳ��� �ʿ��Ѱ͸� �߶󳻿�, ���������� ���ڿ��� ���������� �ƴ϶��(���ڰ�����) Error
		int j = Integer.parseInt(args[1]);	
		Integer.parseInt("ddd");

		System.out.println(i*j);
        //�̷��� Arguments �޾ƺ�~!

		System.out.println(args[2] +"�� �ȳ��ϼ���");//���ھ����� �ε����� ���� ���°Ÿ� Error /3��°�� ������ �ε��� 2�̴�/�������ǻ��x
        

        
	}//main
}//class
