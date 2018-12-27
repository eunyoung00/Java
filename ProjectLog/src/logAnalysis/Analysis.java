package logAnalysis;


import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Analysis extends Dialog implements ActionListener{

	private LogData ld;
//	private FileDialog fileSelect;
	private Button btnOk;
	private int maxkey;
	private String keyname;
	
	public Analysis(LogData ld) {
//		super("로그 분석");
		
		this.ld=ld;

		Label lblLogLine = new Label("분석한 로그의 줄" );
		Label lblStart = new Label("시작");
		Label lblLast = new Label("끝");
		Label lblTilde = new Label("~");
		TextField tfStart =new TextField(/*getLineStart*/"0");
		TextField tfLast =new TextField(/*getLineLast*/);
		btnOk=new Button("확인");
		
		
		Label lblKeyMax = new Label(/*q1().toString()*/"키ㅣㅣㅣㅣ");
		Label lblBrowser = new Label("브라우저별 접속횟수,비율 ");
		Label lblResult = new Label("서비스를 성공한 횟수,실패한 횟수");
		Label lblTime = new Label("요청이 가장 많은 시간 ");
		Label lblAbnormal = new Label("비정삭정인 요청 횟수,비율");
		
		Panel panelLine =new Panel();
		panelLine.add(lblLogLine);
		panelLine.add(lblStart);
		panelLine.add(tfStart);
		panelLine.add(lblTilde);
		panelLine.add(lblLast);
		panelLine.add(tfLast);
		panelLine.add(btnOk);
		
		Panel panelKey =new Panel();
		Panel panelBrowser =new Panel();
		Panel panelResult =new Panel();
		Panel panelTime =new Panel();
		Panel panelAbnormal =new Panel();
		panelKey.add(lblKeyMax);
		panelBrowser.add(lblBrowser);
		panelResult.add(lblResult);
		panelTime.add(lblTime);
		panelAbnormal.add(lblAbnormal);
		
		
		Panel panelTotal =new Panel();
		panelTotal.setLayout(new GridLayout(5, 1));
		panelTotal.add(panelKey);
		panelTotal.add(panelBrowser);
		panelTotal.add(panelResult);
		panelTotal.add(panelTime);
		panelTotal.add(panelAbnormal);
		
		
		btnOk.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}//windowClosing
		});//addWindowListener
		
		add("North",panelLine);
		add("Center",panelTotal);
		
		setBounds(300, 300, 500, 500);
		setVisible(true);
	}//Analysis

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed
	
	public void quest1() {
//		LogData ld=null;
//		ld=new LogData();
//		maxkey = 0;//
		
		int[] cnt=null;//순자적으로 저장된 키의 번호의 해당하는 갯수
		int index=new LogData().getIdx();//인덱스를 얻어서 
//		Map<Integer, String> getKey= new LogData().getLogKey();
//		//가져온 키 맵을 넣는다. 인덱스는 라인수, 값은 해당라인의 키를 얻는다.
		
		//{res=198, java=220, d8=190, jsp=197, hadoop=169, 
		//front=163, mongodb=195, javascript=211, jg9k=180, ora=214}
		String[] arrkey= {"res", "java", "d8", "jsp", "hadoop", "front",
									"mongodb", "javascript", "jg9k", "ora"};
		Map<Integer,String> mapKey=new HashMap<Integer,String>();
		//키의값들을 순차적으로 저장해줄 map
		
		cnt=new int[arrkey.length];//cnt의 방도 키갯수만큼 준다.
		for(int i=0; i<arrkey.length; i++) {//키의 수만큼
			mapKey.put(i, arrkey[i]);//맵에 순차적으로 배열을 넣어준다.
		}//end for
		for(int i=0; i<index; i++) {//파일의 줄수만큼 반복될때 
			//해당 인덱스의 값을 얻어온다.
			String value=new LogData().getLogKey().get(index);
			
			for(int j=0; j<arrkey.length; j++) {//10가지의 키와 비교하기 위함.
				if(value.contains(mapKey.get(j)/*listKey.get(j)*/)) {//배열의 값이포함되면
					cnt[i]=0;//해당 번째 cnt를 초기화 하고 값을 더해준다.
					int cnttest=0;//초기화
					cnttest++;
					cnt[i]=cnttest;//카운트해 넣어준다.
				}//end if
			}//end for
		}//end for
		
		//최고갯수 구하기(((비교)))
		maxkey=cnt[0];
		int keynamenum=0;
		for(int j=0; j<arrkey.length; j++) {//10개의 키의 갯수들을 비교
			if (maxkey<=cnt[j]) {
				maxkey=cnt[j];//최댓값
				keynamenum=j;//그번호의 키의 번호
			}//end if
		}//end for
		keyname=mapKey.get(keynamenum);
	}//quest1
	
	public String q1() {
		quest1();
		return "최다 사용한 키의 이름은 "+keyname+"이고, "+maxkey+" 번 실행되었습니다.";
	}//return
	
	//quest4 -Time
	public void quest4() {//요청이 가장 많은 시간
		//2018-04-05 11:12:37   //11부분만!
		Set<String> setTime=new HashSet<String>();//set에 시간을 저장해 줄거다
		int index=new LogData().getIdx();//인덱스를 얻어서 
		List<String> listTime =new ArrayList<String>();//비교할 대상
		int[] cnt=null;
		
		for(int i=0; i<index; i++) {//파일의 줄수만큼 반복될때 
			//11~12번째 sub값을 얻어온다.
			setTime.add(new LogData().getLogTime().get(i).substring(11, 12));
			listTime.add(new LogData().getLogTime().get(i).substring(11, 12));
			
		}//end for
		cnt=new int[setTime.size()];
		int cnttest=0;
		//셋에 저장된 시간범위가 값이 다 담긴 리스트와 같으면
		for(int j=0; j<setTime.size(); j++) {
			for(int i=0; i<index; i++) {
//				Iterator<E>
//				if(listTime.contains(setTime.) {
					cnt[j]=0;
					cnttest++;
					cnt[j]=cnttest;
//				}//end if
			
			}//end for
		}//end for
		
	}//quest4
	
	public String q4() {
		quest4();
		return "최다 사용한 키의 이름은 "+null+"이고, "+null+" 번 실행되었습니다.";
	}//return
	
}//class
