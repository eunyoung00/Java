package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.amdin.vo.LunchDetailVO;
import kr.co.sist.lunch.amdin.vo.LunchVO;

public class LunchMainController extends WindowAdapter implements ActionListener,MouseListener{

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	public static final int DBL_CLICK=2;
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv=lmv;
		la_dao=LunchAdminDAO.getInstance();
		//도시락 목록을 초기화-설정 한다.
		setLunch();
	}//LunchMainController
	
	/**
	 * JTable에 DB에서 조회한 도시락 정보를 보여준다.
	 */
	public void setLunch() {//사용범위를 고려햐여 밖에서 쓰이지 않으면 private
		DefaultTableModel dtmLunch=lmv.getDtmLunch();
		dtmLunch.setRowCount(0);//있던 row4개를 싹다 지워주고
		
		try {
			//DB에서 도시락 정보를 조회
			List<LunchVO> listLunch=la_dao.selectLunch();
			//JTable에 조회한 정보를 출력
			
			LunchVO lv=null;
			String imgPath="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			
			Object[] rowData=null;
			for(int i=0; i<listLunch.size(); i++) {
				lv=listLunch.get(i);
				
				//<dtm에 넣을떄에는 1차원 배열이나 vector로만 넣을수있다.
				//DTM에 데이터를 추가하기 위한 일차원배열(or Vector)를 생성하고 데이터를 추가
				rowData=new Object[5];
				rowData[0]=new Integer(i+1);//<기본형이 오브젝으로 들어감으로 int를 객체로 만들어 넣어준다.
				rowData[1]=lv.getLunchCode();
				rowData[2]=new ImageIcon(imgPath+lv.getLunchImg());
				rowData[3]=lv.getLunchName();
				rowData[4]=new Integer(lv.getPrice());//<aotoBoxing으로 잘 들어가지만 객체로 포장?해준다.
				
				//DTM에 추가
				dtmLunch.addRow(rowData);
				
			}//end for
			
			if(listLunch.isEmpty()) {//입력된 도시락이 없을 때 
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			}//end if
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중에 문제가 발생했습니다.");
			e.printStackTrace();
		}//end catch
		
	}//setLunch
	
	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}//windowClosing
	
	@Override
	public void mouseClicked(MouseEvent me) {
//		System.out.println(me.getClickCount());//클릭횟수
//		if(me.getClickCount()==DBL_CLICK/*2를 써도 되나 상수로 선언해 사용하면 가독성up*/) {
		switch(me.getClickCount()) {
		case DBL_CLICK:
//			System.out.println("더블 클릭!!");
			if(me.getSource()==lmv.getJtLunch()) {//도시락테이블에서 더블클릭
				//도시락 코드로 DB Table을 검색해 상세정보를 전달한다.
				JTable jt=lmv.getJtLunch();
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1));//코드 출력
				try {
					LunchDetailVO ldvo=la_dao.selectDetailLunch((String)jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv,ldvo,this);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생했습니다.");
					e.printStackTrace();
				}//end catch
			}//end if
			if(me.getSource()==lmv.getJtOrder()) {//주문테이블에서 더블클릭
				
			}//end if
		}//end switch
	}//mouseClicked
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lmv.getJbtAddLunch()) {//도시락 추가버튼
			new LunchAddView(lmv,this);
		}//end if

		if(ae.getSource()==lmv.getJcbMonth()) {
			setDay();
		}//end if
	}//actionPerformed

	/**
	 * 월이 선택되면 해당년의 해당월의 마지막날을 설정.
	 */
	private void setDay() {
		int selYear=((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth=(Integer)lmv.getJcbMonth().getSelectedItem();
		
		//마지막날 얻기
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth-1);
		
		int lastDay=cal.getActualMaximum(Calendar.DATE);
		int nowDay=cal.get(Calendar.DAY_OF_MONTH);

		lmv.getCbmDay().removeAllElements();//모델을 초기화 하고
		for(int day=1; day<lastDay+1; day++) {
			lmv.getCbmDay().addElement(day);//마지막날을 설정한다.
		}//end for
		lmv.getCbmDay().setSelectedItem(new Integer(nowDay));//그리고 오늘을 선택한다.
		//<기본형을 객체로 변환하여 넣어주는것auto Boxing되어서 들어가나 변환해준거당..
		
	}//setDay

	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}//class
