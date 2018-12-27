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
//		super("�α� �м�");
		
		this.ld=ld;

		Label lblLogLine = new Label("�м��� �α��� ��" );
		Label lblStart = new Label("����");
		Label lblLast = new Label("��");
		Label lblTilde = new Label("~");
		TextField tfStart =new TextField(/*getLineStart*/"0");
		TextField tfLast =new TextField(/*getLineLast*/);
		btnOk=new Button("Ȯ��");
		
		
		Label lblKeyMax = new Label(/*q1().toString()*/"Ű�ӤӤӤ�");
		Label lblBrowser = new Label("�������� ����Ƚ��,���� ");
		Label lblResult = new Label("���񽺸� ������ Ƚ��,������ Ƚ��");
		Label lblTime = new Label("��û�� ���� ���� �ð� ");
		Label lblAbnormal = new Label("���������� ��û Ƚ��,����");
		
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
		
		int[] cnt=null;//���������� ����� Ű�� ��ȣ�� �ش��ϴ� ����
		int index=new LogData().getIdx();//�ε����� �� 
//		Map<Integer, String> getKey= new LogData().getLogKey();
//		//������ Ű ���� �ִ´�. �ε����� ���μ�, ���� �ش������ Ű�� ��´�.
		
		//{res=198, java=220, d8=190, jsp=197, hadoop=169, 
		//front=163, mongodb=195, javascript=211, jg9k=180, ora=214}
		String[] arrkey= {"res", "java", "d8", "jsp", "hadoop", "front",
									"mongodb", "javascript", "jg9k", "ora"};
		Map<Integer,String> mapKey=new HashMap<Integer,String>();
		//Ű�ǰ����� ���������� �������� map
		
		cnt=new int[arrkey.length];//cnt�� �浵 Ű������ŭ �ش�.
		for(int i=0; i<arrkey.length; i++) {//Ű�� ����ŭ
			mapKey.put(i, arrkey[i]);//�ʿ� ���������� �迭�� �־��ش�.
		}//end for
		for(int i=0; i<index; i++) {//������ �ټ���ŭ �ݺ��ɶ� 
			//�ش� �ε����� ���� ���´�.
			String value=new LogData().getLogKey().get(index);
			
			for(int j=0; j<arrkey.length; j++) {//10������ Ű�� ���ϱ� ����.
				if(value.contains(mapKey.get(j)/*listKey.get(j)*/)) {//�迭�� �������ԵǸ�
					cnt[i]=0;//�ش� ��° cnt�� �ʱ�ȭ �ϰ� ���� �����ش�.
					int cnttest=0;//�ʱ�ȭ
					cnttest++;
					cnt[i]=cnttest;//ī��Ʈ�� �־��ش�.
				}//end if
			}//end for
		}//end for
		
		//�ְ��� ���ϱ�(((��)))
		maxkey=cnt[0];
		int keynamenum=0;
		for(int j=0; j<arrkey.length; j++) {//10���� Ű�� �������� ��
			if (maxkey<=cnt[j]) {
				maxkey=cnt[j];//�ִ�
				keynamenum=j;//�׹�ȣ�� Ű�� ��ȣ
			}//end if
		}//end for
		keyname=mapKey.get(keynamenum);
	}//quest1
	
	public String q1() {
		quest1();
		return "�ִ� ����� Ű�� �̸��� "+keyname+"�̰�, "+maxkey+" �� ����Ǿ����ϴ�.";
	}//return
	
	//quest4 -Time
	public void quest4() {//��û�� ���� ���� �ð�
		//2018-04-05 11:12:37   //11�κи�!
		Set<String> setTime=new HashSet<String>();//set�� �ð��� ������ �ٰŴ�
		int index=new LogData().getIdx();//�ε����� �� 
		List<String> listTime =new ArrayList<String>();//���� ���
		int[] cnt=null;
		
		for(int i=0; i<index; i++) {//������ �ټ���ŭ �ݺ��ɶ� 
			//11~12��° sub���� ���´�.
			setTime.add(new LogData().getLogTime().get(i).substring(11, 12));
			listTime.add(new LogData().getLogTime().get(i).substring(11, 12));
			
		}//end for
		cnt=new int[setTime.size()];
		int cnttest=0;
		//�¿� ����� �ð������� ���� �� ��� ����Ʈ�� ������
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
		return "�ִ� ����� Ű�� �̸��� "+null+"�̰�, "+null+" �� ����Ǿ����ϴ�.";
	}//return
	
}//class
