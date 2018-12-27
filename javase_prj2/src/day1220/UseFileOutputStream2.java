package day1220;

import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 8bit Stream�� 16bit Stream�� ����Ͽ� ���ڿ� �����͸� File�� ���.
 * @author owner
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data="������ 20�� ����� �Դϴ�.������ �ݿ��Ͽ���";
	//1.File ��ü ���� :������ �����Ѵٸ� ����������� �Ǵ�
		File file = new File("c:/dev/temp/java_write2.txt");
		
		boolean flag=false;//������ ���� �� 
		if(file.exists()) {//������ ������ ��.
			boolean[] temp= {false,true,true};//��,�ƴϿ�,���
			flag=temp[JOptionPane.showConfirmDialog(null, "����ðڽ��ϱ�???")];
		}//end if
		//<�̺κ� �� ���ϸ� if ���谡 �ȴ�...
	//2.Stream ����
		if(!flag) { //true
			BufferedWriter bw=null;
			try {
				//8bit Stream�� 16bit Stream�� ���� ���.))))
//				//2.���ϰ� �����Ͽ� ������ �����ϴ� ��Ʈ��. : FileNotFoundException�߻�->������ ������.(������ �������)
//				FileOutputStream fos = new FileOutputStream(file);
//				//3.���ڿ��� �������� ��Ʈ���� ���� (�������� �ӵ��� ������ ����)
//				OutputStreamWriter osw =new OutputStreamWriter(fos);
//				//4.���� �ӵ��� �����ϱ� ���� ��Ʈ�� ����.
//				BufferedWriter bw=new BufferedWriter(osw);
//				
//				bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

				////////////////////16bit �� ���////////////////////////////////
				bw=new BufferedWriter(new FileWriter(file));
				//���ڿ��� ���� 16bit�� �� ����..!
				/////////////////16bit////////////////////////////////
				
				bw.write(data);//��Ʈ���� �����͸� ���
				bw.flush();//������ ���Ϸ� ����   //���ص� close�Ǹ� �߽�����.
				System.out.println("���Ͽ� ��� �Ϸ�!!!");
			} finally {
				//��Ʈ�� ��ü�� �����Ǿ� �ִٸ� ���� ����
				if(bw!=null) {bw.close();}//end if   //close�ȵǵ� flush�Ǹ� ���´�.
			}//end finally
		}//end if
	}//UseFileOutputStream2
	
	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
