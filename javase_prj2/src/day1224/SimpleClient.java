package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * 서버의 주소와 포트를 가지고 서버에 연결을 시도.
 * @author owner
 */
public class SimpleClient {
	
	public SimpleClient() throws UnknownHostException, IOException {
		//2.소켓을 생성. : 내컴퓨터에 들어갈 때에는 localhost, 127.0.0.1//내 렌카드를 치고 되돌아옴?
		//다른컴퓨터에 들어갈 때에는 ip address 사용
		Socket client =null;//누수를 막기 위함
		//서버에서 보내오는 메세지 읽기 위한 Stream
		DataInputStream dis=null;
		//서버로 데이터를 보내기 위한 스트림
		DataOutputStream dos=null;
		try {
			
			String ip=JOptionPane.showInputDialog("서버의 ip\n130,132,133,134,135"
					+ ",156,157,131,141,142,143,144,155,146,148,149,151,152,153");
			client=new Socket("211.63.89."+ip/*"localhost"*/, 65535);
			System.out.println("서버에 접속 하였습니다."+client);
			//7.소켓에서 스트림 얻기
			dis=new DataInputStream(client.getInputStream());
			//8.서버에서 보내온 메세지 읽기
			String revMsg=dis.readUTF();//조각조각 읽어 합침=>반환형 String
			JOptionPane.showMessageDialog(null,"서버의 메세지 "+revMsg);
			
			//9.서버로 데이터를 보내기 위한 스트림을 소켓에서 부터 얻는다.
			String sendMag="오늘은 수요일 입니다.";
			dos=new DataOutputStream(client.getOutputStream());
			//10.준비된 메세지를 스트림에 기록
			dos.writeUTF(sendMag);
			//11.스트림에 기록된 데이터를 목적지(소켓=>Server)로 분출
			dos.flush();
			
			
		}finally {
			if(dos!=null) {dos.close();}//end if
			if(dis!=null) {dis.close();}//end if
			if(client!=null) {client.close();}//end if
		}//end finally
		
	}//SimpleClient

	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
