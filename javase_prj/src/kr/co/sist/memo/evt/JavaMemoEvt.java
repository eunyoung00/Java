package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	private String taNoteDate/* =null도 되지만 2가지 비교해야해서 */;// TextArea의 내용을 저장할 변수
	private String openPath;// 열었던 파일명을 저장.
	private TextArea tempTa;

	public JavaMemoEvt(JavaMemo jm) {// 객체가 생성될때 갖고 있어야할 초기화값을 넣어줌.
		this.jm = jm;
		taNoteDate = "";// 2가지를 비교하기위해 설정.
		openPath = "";
		tempTa= jm.getTaNote();
	}// JavaMemoEvt

	@Override
	public void windowClosing(WindowEvent we) {
		if(!taNoteDate.equals(tempTa.getText())) {
			saveMemo();
		}//end if
		jm.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		// miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp
		// 이벤트를 비교해야될 객체들

		// 새글 메뉴아이템에서 이벤트가 발생 했을 때
		if (ae.getSource() == jm.getMiNew()) {
			// 라벨을 가지고 비교 할거면 getter method가 필요가 없다 .
			// 주소를 얻어 오기 위해서 getter method가 필요한 것이고, 사용하는 방법이 라벨비교 보다 좋다.
			newMemo();
		} // end if

		// 열기 메뉴 아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {// JOptionPane귀찮으면 static import로 할수도
				JOptionPane.showMessageDialog(jm, "선택한 파일을 읽을 수 없습니다.", "파일열기 에러", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "선택한 파일을 읽어들이는중 문제가 발생하였습니다.", "파일열기 에러", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} // end if

		// 저장 메뉴 아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		} // end if

		// 다른이름으로 저장 메뉴 아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		} // end if

		// 종료 메뉴 아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiEnd()) {
			//저장되지 않은 내용이 있다면 저장하고 종료
//			System.out.println(taNoteDate+"/"+tempTa.getText());
			if(!taNoteDate.equals(tempTa.getText())) {
				saveMemo();
			}//end if
			jm.dispose();// <원래는 그냥종료하면 안된다.savememo로 해결..안됬당..+조건!
		} // end if

		// 서식 메뉴 아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		} // end if

		// 도움말 메뉴 아이템에서 이벤트가 발생했을 때
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		} // end if

	}// actionPerformed

	/**
	 * 새글 에 대한 처리 :TextArea를 초기화 한다.
	 */
	public void newMemo() {
		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		// 저장할 것인지 판단
//		taNoteDate.equals(tempTa.getText());//저장할 필요가 없다?
		if (!taNoteDate.equals(tempTa.getText())) {
//			JOptionPane.showConfirmDialog(jm, "\"제목없음.txt\"로 저장 하시겠습니까?");
			int flag = JOptionPane.showConfirmDialog(jm, "다른 이름으로 저장 하시겠습니까?");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
				break;
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			}// end switch
		} // end if

		if (!flagNew) {
			tempTa.getText();// 버그때문에 값을 한번 갖고 와야함.
			tempTa.setText("");
			// 새글이 된 이후에는 읽기한 내용을 초기화
			taNoteDate = tempTa.getText();// <""를 넣어준것도 같다. 바로 위에서 초기화했기 때문
			openPath = "";// <턴이 지나갔으니까 초기화
			// 읽어들인 파일의 경로를 초기화 그래야 다음번에 쓸때 문제가 발생하지 않는다.

			jm.setTitle("메모장-새글");
		} // end if
	}// newMemo

	/**
	 * txt파일을 열기
	 */
	public void openMemo() throws FileNotFoundException, IOException {
		//////////////// 12-20-2018 코드 추가 시작///////////////////
		// TextArea의 내용과 읽어들였던 내용이 다르다면 저장여부를 묻고, 작업을 진행한다.
		TextArea tempTa = jm.getTaNote();
		boolean flagOpen = false;
		if (!taNoteDate.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, openPath + "\n을 저장하시겠습니까?");
//			if (!openPath.equals("")) {// 파일한번이라도 열었어~! 가아니면
//				int flag=JOptionPane.showConfirmDialog(jm, openPath+"\n을 저장하시겠습니까?");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				if (!openPath.equals("")) {
					// 아니면 기존의 이름에 저장할 것인지
					saveMemo();
				} else {
					// 다름 이름으로 저장할 것인지
					newSaveMemo();
				} // end else

			case JOptionPane.NO_OPTION:
				flagOpen = false;
				break;
			default:
				flagOpen = true;
			}// end switch
		} // end if
			//////////////// 12-20-2018 코드 추가 끝///////////////////
		if (!flagOpen) {

			FileDialog fdOpen = new FileDialog(jm, "문서 열기", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();// 경로
			String fileName = fdOpen.getFile();// 파일명

			if (filePath != null) {// 선택한 파일이 존재
				//////////////// 12-20-2018 코드 추가 시작///////////////////
				/////// 내용 : 스트림으로 파일의 내용을 읽는 코드 추가, 작성자 : 나
				// 선택한 파일로 파일객체를 생성.
				File file = new File(filePath + fileName);
				// 16bit Stream으로만 구성(좀더간편) 사용
				BufferedReader br = null;

				try {
					br = new BufferedReader(new FileReader(file));
					String temp = "";
					// T.A를 초기화 한 후
					// <초기화 하지 않았더니 아래에 글이 쌓이고 쌓인다.
					tempTa.setText("");// getText안했는데도 되네..?
					while ((temp = br.readLine()) != null) {
						// 파일에서 읽어들인 내용을 설정한다.
						tempTa.append(temp + 
								/* 리눅스는\r넣어주나 없으나 같다. 윈도우는 아님!둘다 필요~!~!
								 * 아님여는건 상관없으나 줄이한줄로 저장된다 */"\r\n");
					} // end while

					// 현재상태를 저장할때는 인스턴스 변수를 사용하게 된다.
					// 변수에 읽어들인 내용을 저장
					taNoteDate = tempTa.getText();// ""상황과 null상황이 있을것.

					// 열었던 파일명을 저장
					openPath = file.getAbsolutePath();
				} finally {
					if (br != null) {
						br.close();
					} // end if
						// nullpointer exception떨어지는걸 미연에 방지할수 있다.
				} // end finally

				//////////////// 12-20-2018 코드 추가 끝/////////////////////
				// 파일의 경로와 이름을 Frame의 TitleBar에 설정
				jm.setTitle("메모장-열기 " + filePath + fileName);
			} // end if
		} // end if

	}// openMemo

	/**
	 * 작성한 메모 저장 - 기존의 파일명을 그대로 저장하는 파일명에 반영
	 */
	public void saveMemo() {
		//기존에 열었던 이름의 파일에 덮어쓰는 일
		try {
			if(!openPath.equals("")) {
				createFile(openPath);
			}else{
				newSaveMemo();
			}//end else
			
			///////////////열고 수정해서 저장하면 줄이한줄로 저장된다.///////////////
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
//		newSaveMemo();
	}// saveMemo

	private void createFile(String pathName) throws IOException{
		//saveMemo가불리면 파일명 패스, newSaveMemo가불리면 파일명 창
		BufferedWriter bw=null;
		
		try {
			//사용자가 디렉토리명을 마음대로 변경할 수 없기 때문에 File 클래스를 사용할 필요가 없다.
			bw=new BufferedWriter(new FileWriter(pathName));//<있는위치에 넣는것이기 때문에 File이 필요가없
			//<굳이 물어보지 않아도 된다.
			bw.write(jm.getTaNote().getText());//textArea의 내용을 스트림에 기록
			bw.flush();//스트림에 기록된 내용을 목적지로 분출
			
			openPath=pathName;
			taNoteDate=jm.getTaNote().getText();
		}finally {
			if(bw!=null) {bw.close();}//end if
		}//end finally
	}//createFile
	
	/**
	 * 파일명을 입력받아 새 이름으로 저장
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "문서 저장", FileDialog.SAVE);
		fdSave.setVisible(true);

		String filePath = fdSave.getDirectory();// 경로
		String fileName = fdSave.getFile();// 파일명

		if (filePath != null) {//저장버튼이 눌렸을때 동작.
			try {
				createFile(filePath+fileName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "저장중 문제 발생", "문제발생", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}//end catch
			// 파일의 경로와 이름을 Frame의 TitleBar에 설정
			jm.setTitle("메모장-저장 " + filePath + fileName);
		} // end if
	}// newSaveMemo

	/**
	 * 글꼴을 설정하는 다이얼로그를 실행하는 일
	 */
	public void formatDialog() {
		new MemoFormat(jm);// this는 이벤트니까 메인을 넣기 위해 jm
	}// formatDialog

	/**
	 * 메모장 정보를 제공하는 다이얼로그를 실행
	 */
	public void helpDialog() {
		new Help(jm);
	}// helpDialog

}// class
