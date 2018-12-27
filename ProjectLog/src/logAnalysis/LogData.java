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
		fdSelectB=sb.getFdSelect();/*new FileDialog(in, "파일 열기", FileDialog.LOAD);*/
		fdSelectB.setVisible(true);
		
		String filePath=fdSelectB.getDirectory();//경로
		String fileName=fdSelectB.getFile();//파일명
		
		File file=new File(filePath+fileName);
		
		try {
			br=new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));//파일과연결,8+16,속도개선
		
		StringTokenizer stk;
		Logmap=new HashMap<Integer,String>();
		logResult=new HashMap<Integer,String>();
		logKey=new HashMap<Integer,String>();
		logBrowser=new HashMap<Integer,String>();
		logTime=new HashMap<Integer,String>();
		//맵에 인덱스와 값 한줄을 저장해서 
		listLine=new ArrayList<String>();
		
		
//		 배열명 = new 데이터형[행의수][열의수];
		temp="";
		idx=0;
		while((temp=br.readLine())!=null) {
			//줄단위(\n전까지)로 읽어들여서 읽어들인 내용이 있다면
			Logmap.put(idx, temp);
			stk=new StringTokenizer(Logmap.get(idx), "][",false);
			listLine.add(stk.nextToken());
//			logResult.put(idx, stk.nextToken());
			listLine.add(stk.nextToken());
			listLine.add(stk.nextToken());
			listLine.add(stk.nextToken());//괄호로 잘라 넣어~!~!
			System.out.println(listLine);
			
			for(int i=0;i<listLine.size(); i++) {//리스트에서 배열로 담기
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
			listLine.clear();//한줄 넣고 클리어하면 한줄만!!
		}//end while
		
//		LogLine=new String[idx][4];//이차원 배열을 만들어 뿌리려 했으나 fail
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
			}	//반드시 연결을 종료.(warning이 뜬다)
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
//		return logKey.get(idx);//값String
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
