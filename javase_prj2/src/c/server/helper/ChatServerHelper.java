package c.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * �������� �����ϸ� �����ڼ��Ͽ� ��Ʈ���� ���ͼ� �����ϴ� Ŭ����<br>
 * �����ڰ� �����ϸ� ������ ���Ͽ��� �� ��Ʈ������ �޼����� ���ѷ����� �о���̰� ��������ڿ��� �޼��� ���
 * @author owner
 */
public class ChatServerHelper extends Thread{
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<ChatServerHelper> connectList;//����Ʈ�� �����ϴ� �ϳ��� Ŭ���̾�Ʈ �ϳ��ϳ� �ΰ�.
	
	private JFrame jf;
	private JScrollPane jsp;
	private String nick, client;
	
	
	/**
	 * ������ ������ �޾Ƽ� ��Ʈ���� ��� �޼����� �аų� ���� �� �ִ� ���·� �����.
	 * @param socket ������ ����
	 * @param dlm ������ ����â�� ����ϱ� ���� Model��ü
	 * @param cnt ���� ����
	 */
	public ChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt,JFrame jf,List<ChatServerHelper> list, JScrollPane jsp) {
		someClient=socket;
		this.dlm=dlm;
		this.cnt=cnt;
		this.jf=jf;
		connectList=list;
		this.jsp=jsp;
		
		//��Ʈ�� ���//<������ ���� �� �ִ� ���°� �Ȱ�
		try {
			readStream=new DataInputStream(someClient.getInputStream());
			writeStream=new DataOutputStream(someClient.getOutputStream());
			
			//�����ڰ� �������� nick�� �޴´�.
			nick=readStream.readUTF();
			//����â�� ���Ӹ޼����� ���
			dlm.addElement("["+someClient.getInetAddress()+"/"+nick+"] ���� �����ϼ̽��ϴ�.");//<���� �ð������� ��������.
			
			//������ ������ ��� �����ڿ��� �޼����� ���(<�������Ծ�~!)
			broadcast("["+cnt+"] ��° �����ڰ� ["+nick+"]���� ä�ù濡 �����Ͽ����ϴ�.");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			//setclient();
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ���� �߻�...");
			ie.printStackTrace();
		}//end catch
		
	}//MultiChatServerHelper
	
	public void run() {
		if(readStream!=null) {
			try {//<�갡 ������ try�� while������.
				
				String revMsg="";
				while(true) {
					//�������� �������� ��� �޼����� �о, ��� �����ڿ��� �Ѹ���.
					revMsg=readStream.readUTF();
					broadcast(revMsg);
				}//end while
			} catch (IOException ie) {
				//�����ڰ� ����ϸ� �ش� �����ڸ� ����Ʈ���� ���� �Ѵ�. �Ŀ� ����â�� �����ֵ� �����Ⱦ� ���� ��������ڿ��� �����ش�.
				connectList.remove(this);//<cnt�� �ȵǴ� ������ list�� �������� �����µ�, �տ������ ������ �ε����� ��������� �ȵ�.(���� ������ �ϸ� ��)
				setclient();
				
				//�޼����� �о������ ���ϴ� ���¶�� �����ڰ� ������ ������ ����.�� ������ â�� �ѷ��ش�.
				dlm.addElement(cnt+"��°/"+nick+" ������ ���");
				broadcast("["+nick+"]���� ����Ͽ����ϴ�.");
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum()+1 );
				ie.printStackTrace();
//			} catch (EOFException ee) {//������ �����µ�?�� �о���̷� �Ҷ�?
//				ee.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}//end catch
		}//end if
	}//run
	
	/**
	 * ��� �����ڿ��� �޼����� �ѷ��ִ� ��.
	 * synchronized : MultiThread���� ���� ȣ���� ���´�.(����ȭó��)
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		ChatServerHelper csh=null;
		
		try {
			for(int i=0; i<connectList.size(); i++) {//<��������ڰ� ���ð�.
				
				csh = connectList.get(i);//list���� Helper��ü�� ���
				csh.writeStream.writeUTF(msg);//��� ��Ʈ���� ���
				csh.writeStream.flush();//�������� ����
			}//end for
		} catch (IOException ie) {//<���������»��¿��� ��°� ������ �����
			JOptionPane.showMessageDialog(jf, "["+cnt+"] ��° �����ڿ��� �޼����� ���� �� �����ϴ�.");
			ie.printStackTrace();
		}//end catch
	}//broadcast
	
	public synchronized void setclient() {
		ChatServerHelper csh=null;
		client="    ,";
		for(int i=0; i<connectList.size();i++){
			csh=connectList.get(i);
			client=client+csh.nick+",";
		}//end for
		broadcast(client);
	}//setclient
	
	
}//class
