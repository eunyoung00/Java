package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
/*import java.io.FileNotFoundException;*/
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HDD�� �����ϴ� File�� �����Ͽ� �� ������ �о���϶� ����ϴ� FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	
	public UseFileInputStream() throws IOException/*,FileNotFoundException�� �� ���ص� �ɱ�?*/{
		File file=new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			BufferedReader br=null;
			try {
				//8bit�� FileInputStream�̶� 
				//�ѱ��� ������..=>16bit�� �����Ͽ� �߶߰� ���鿹��(12-20)
//				//��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����.
//				FileInputStream fis=new FileInputStream(file);
//				int temp=0;
//				
//				while((temp=fis.read())!=-1) {//�о���� ������ �����Ѵٸ� 
//					System.out.print((char)temp);//1byte���о�鿩 �ѱ��� ������.
//				}//end while
//				//��Ʈ�� ����� �Ϸ� ������ ��Ʈ���� ��� �޸� ������ ���´�.
//				fis.close();
				
				///////////////12-20-2018 �ڵ� �߰�/////////////////////
				//8bit stream�� 16bit stream���� : �ѱ��� ������ ���� �ذ�.
//				FileInputStream fis=new FileInputStream(file);//���ϰ� ����
//				InputStreamReader isr=new InputStreamReader(fis);//8bit+16bit����
//				br=new BufferedReader(isr);//�ӵ�����, �ٴ��� �б�
				//buffer�� ������ �ӵ�����,next()�� ������
				
				//���� 3���� ���ٷ�~!
				br=new BufferedReader(new InputStreamReader(
										new FileInputStream(file)));
				
				String temp="";
				while((temp=br.readLine())!=null) {
					//�ٴ���(\n������)�� �о�鿩�� �о���� ������ �ִٸ�
					System.out.println(temp);//console�� ���
				}//end while
//				br.close();	//�ݵ�� ������ ����.(warning�� ���)
				
				//������ ����????????
				//������ ���µ� �������� ������~! �������ᰡ �ȵɼ��� �ִٴ°� ����
				//readLine���� ���ܰ� �߻������� ����� �����ε� close�� �ȵȴٴ°� ������!
				//close�� �ȵǱ� ����!!���� �����ϵ� �����ϴ� �������ϴ� ������ ����
				
//			}catch (FileNotFoundException e) {//FileInputStream
//				e.printStackTrace();//���ܰ� ������ ���°��� ó���� �Ȼ��´� �ƴ�.
//			}catch (IOException e) {//readLine,close()
//				e.printStackTrace();
			}finally {
//				try {
					if(br!=null) {br.close();}
					//br�� �������� �ʾ����� nullpointerException�߻��Ҽ� �־�if�� ����.
//				} catch (IOException e) {
//					e.printStackTrace();
//				}//end catch
			}//end catch
		}else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}//end else
	}//UseFileInputStream
	
	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class