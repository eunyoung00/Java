package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * port(1~65535 �� �ϳ��� ����)�� ����, ������ ������ �޴� ��.
 * @author owner
 */
public class SimpleServer {
	
	public SimpleServer() throws IOException {
		//1.PORT�� ���� �����ڰ� �����⸦ �Ͽ����� ��ٸ���.
//		ServerSocket server=new ServerSocket(3000);Ʈ���� ĳġ�� �������� ������?�ֳ���?
		ServerSocket server=null;
		//�����ڿ��� ������ �޼���
		String msg="�ȳ��ϼ���o(>_<)o";
		String revMsg="";//�����ڰ� ������ �޼����� ������ ����
		
		//�����ڿ��� �޼����� ������ ���� ��Ʈ��
		DataOutputStream dos=null;
		//�����ڰ� �������� �޼����� �б����� ��Ʈ��
		DataInputStream dis=null;
		
		try {
			server=new ServerSocket(3000);
			System.out.println("���� ���� �� "+server);
			//3.�����ڰ� ������ ������ ������ �޴´�.
			
			while(true) {//��������ڸ� ����
				Socket client = server.accept();
				System.out.println("������ ���� : "+client);
				//4.�����ڿ��� �޼����� ������ ���� ��Ʈ�� ����(Ŭ���̾�Ʈ��� ���Ͽ������� ���Դ�)
				dos=new DataOutputStream(client.getOutputStream());
				//5.�� ��Ʈ���� ������ ����.
				dos.writeUTF(msg);
				//6.��Ʈ���� �����͸� ������(����)���� ����
				dos.flush();
				////////////////////�ޱ� 12.26///////////////
				//12.Ŭ���̾�Ʈ�� �������� �޼����� �б����� ��Ʈ�� ����
				dis=new DataInputStream(client.getInputStream());
				//13.��Ʈ������ �޼��� �б�
				revMsg=dis.readUTF();
				JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�� �޼���\n"+revMsg);
				
				
			}//end while
		}finally {
			if(dis!=null) {dis.close();}//end if
			if(dos!=null) {dos.close();}//end if
			if(server!=null) {server.close();}//end if
		}//end finally
		
		
		
	}//SimpleServer

	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			System.out.println("��Ʈ�� �̹� ������Դϴ�.");
			e.printStackTrace();
		}
	}//main

}//class
