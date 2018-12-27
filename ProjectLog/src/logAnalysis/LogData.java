package logAnalysis;


import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class LogData {
	
	private Login in;
	private BufferedReader br;
	private String[][] LogLine;
	private String[] logs;
	private String temp;
	private int idx;
	private List<String> listLine;
	private Map<Integer, String> Logmap,logKey,logBrowser,logResult,logTime;

	public LogData(){
		SelectBtn sb=null;
//		sb= new SelectBtn(in);
		br=null;
		FileDialog fdSelectB=null;
		fdSelectB=sb.getFdSelect();/*new FileDialog(in, "���� ����", FileDialog.LOAD);*/
		fdSelectB.setVisible(true);
		
		String filePath=fdSelectB.getDirectory();//���
		String fileName=fdSelectB.getFile();//���ϸ�
		
		File file=new File(filePath+fileName);
		
		try {
			br=new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));//���ϰ�����,8+16,�ӵ�����
		
		StringTokenizer stk;
		Logmap=new HashMap<Integer,String>();
		logResult=new HashMap<Integer,String>();
		logKey=new HashMap<Integer,String>();
		logBrowser=new HashMap<Integer,String>();
		logTime=new HashMap<Integer,String>();
		//�ʿ� �ε����� �� ������ �����ؼ� 
		listLine=new ArrayList<String>();
		
		
//		 �迭�� = new ��������[���Ǽ�][���Ǽ�];
		temp="";
		idx=0;
		while((temp=br.readLine())!=null) {
			//�ٴ���(\n������)�� �о�鿩�� �о���� ������ �ִٸ�
			Logmap.put(idx, temp);
			stk=new StringTokenizer(Logmap.get(idx), "][",false);
			listLine.add(stk.nextToken());
//			logResult.put(idx, stk.nextToken());
			listLine.add(stk.nextToken());
			listLine.add(stk.nextToken());
			listLine.add(stk.nextToken());//��ȣ�� �߶� �־�~!~!
			System.out.println(listLine);
			
			for(int i=0;i<listLine.size(); i++) {//����Ʈ���� �迭�� ���
//				System.out.println(listLine.get(i));
				logs = new String[listLine.size()];
				listLine.toArray(logs);
				logResult.put(idx, logs[0]);
				logKey.put(idx, logs[1]);
				logBrowser.put(idx, logs[2]);
				logTime.put(idx, logs[3]);
//				System.out.println(LogLine[idx][i]);
			}//end for
			System.out.println(logResult.get(idx));
			System.out.println(logKey.get(idx));
			System.out.println(logBrowser.get(idx));
			System.out.println(logTime.get(idx));

			idx++;
			listLine.clear();//���� �ְ� Ŭ�����ϸ� ���ٸ�!!
		}//end while
		
//		LogLine=new String[idx][4];//������ �迭�� ����� �Ѹ��� ������ fail
//		for(int i=0; i<idx; i++){ 
//			for(int j =0;j<logs.length; j++) {
//				System.out.println(logs[j]);
//				LogLine[i][j]=logs[j];
//			}//end for
//		}//end for
			new Analysis(this);
		
		} catch (FileNotFoundException fnfe) {
		} catch (IOException ie) {
		}finally {
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	//�ݵ�� ������ ����.(warning�� ���)
		}
		//end catch
		
	}//LogData

	
//	public String getLogData(int i, int j) {
//		System.out.println(Log[i][j]);
//		return Log[i][j];
//	}
	
	public int getIdx() {
		return idx;
	}
//	public String getLogKey(int idx) {
////		System.out.println(logKey.get(idx));
//		return logKey.get(idx);//��String
//	}
	public Map<Integer, String> getLogKey() {
		return logKey;
	}
	public Map<Integer, String> getLogBrowser() {
		return logBrowser;
	}
	public Map<Integer, String> getLogResult() {
		return logResult;
	}
	public Map<Integer, String> getLogTime() {
		return logTime;
	}

//	public static void main(String[] args) {
	
//		new LogData().getLogKey(1980);
//	}
	
}//class
