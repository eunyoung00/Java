package day1219;

import java.io.File;

/**
 * ���� ����, ���� ����
 * @author owner
 */
public class UseFile2 {
	
	public void createDirectory() {
		File file = new File("c:/eunyoung/park");
		if(file.mkdirs()) {//s�����Ͱ� �Ⱥ����� ���̰� ���µ�, �����ϱ� ���޾� �ȸ�������µ�?
			System.out.println("���� ���� ����");
		}else {
			System.out.println("���� �̸��� ���� ����");
		}//end else
	}//createDirectory
	
	public void removeFile() {
		File file=new File("c:/dev/temp/a.txt");
		boolean flag=file.delete();//������ �ʰ� �����..���
		if(flag) {
			System.out.println("���� ���� ����");
		}else {
			System.out.println("���� ���� ����");
		}//end else
	}//removeFile
	
	public static void main(String[] args) {
		UseFile2 uf2= new UseFile2();
		uf2.createDirectory();
		System.out.println("-----------------------------");
		uf2.removeFile();
	}//main
}//class
