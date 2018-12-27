package day1219;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File Ŭ����
 * -������ �������
 * -���丮 ����
 * -���� ����
 * @author owner
 */
public class UseFile {

	public UseFile() {
		String path="c:/dev/temp/java_read.txt";
		//1.����
		File file=new File(path);
		System.out.println(file);//overriding�Ǽ� ��ΰ� �� ���´�.
		if(file.exists()) {	//������ ���� �� ��
//			System.out.println(file.exists());
			System.out.println("���� ��� : "+file.getAbsolutePath());
			try {
				System.out.println("�Թ� ���  : "+file.getCanonicalPath());//�����ϰ� �ĺ������� path�� �빮��
			} catch (IOException ie) {
				ie.printStackTrace();
			}//end catch
			System.out.println("��� : "+file.getPath());
			System.out.println("������(�θ���) : "+file.getParent()); //c:/dev/temp
			System.out.println("���ϸ� : "+file.getName()); //java_read.txt
			
			System.out.println(file.isFile()?"True,�����Դϴ�.":"���丮");  //c:/dev/temp/�� ���丮�� ���´�.
			System.out.println(file.isDirectory()?"True,���丮�Դϴ�.":"����");
			
			System.out.println("������ ���� : "+file.length()+"byte");//NTFS ������ 1KB�� ������ ����� �ش�����ũ�⸸ŭ ����.
			System.out.println("����"+(file.canExecute()?"����":"�Ұ���"));
			System.out.println("�б�"+(file.canRead()?"����":"�Ұ���"));
			System.out.println("����"+(file.canWrite()?"����":"�Ұ���"));//(�б�����)����°��� �̾߱� ��.������� �Ѵ٤�.���Ͽ� ������� ���ϰ� ��������..
			System.out.println(file.isHidden()?"��������":"�Ϲ�����");//������ ������ ������
			Date d = new Date(file.lastModified());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			System.out.println("������ ������ : "+sdf.format(d)/*file.lastModified()*/);//=>long���� �����µ�,Date(long date) ��
			//Wed Dec 19 14:29:12 KST 2018(d)=>2018-12-19 ���� 14:29:12(sdf.format(d))
			
		}else {
			System.out.println("��θ� Ȯ���� �ּ���.");
		}//end else
		
	}//UseFile
	
	public static void main(String[] args) {
		new UseFile();
	}//main

}//class
