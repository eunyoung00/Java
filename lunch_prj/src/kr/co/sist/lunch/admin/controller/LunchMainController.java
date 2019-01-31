package kr.co.sist.lunch.admin.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchMainController extends WindowAdapter implements ActionListener,MouseListener, Runnable{

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	
	public static final int DBL_CLICK=2;
	
	private String orderNum;
	private String lunchName;
	private int selectedRow;
	
	private Thread threadOrdering;//여러번 돌지 않도록 인스턴스변수로
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv=lmv;
		la_dao=LunchAdminDAO.getInstance();
		//도시락 목록을 초기화-설정 한다.
		setLunch();
		orderNum="";
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
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);//JVM의 모든 인스턴스 종료
	}//windowClosed
	
	/**
	 * 주문 사항 조회
	 */
	private void searchOrder() {//이메소드가 thread로 돌아야 한다. 원랜
		try {
			List<OrderVO> list=la_dao.selectOrderList();
			DefaultTableModel dtm=lmv.getDtmOrder();
			dtm.setRowCount(0);//초기화
			
			Vector<Object> vec=null;
			OrderVO ovo=null;
			for(int i=0;i<list.size(); i++) {
				ovo=list.get(i);
				vec=new Vector<Object>();
				vec.add(new Integer(i+1));
				vec.add(ovo.getOrderNum());
				vec.add(ovo.getLunchCode());
				vec.add(ovo.getLunchName());
				vec.add(ovo.getOrderName());
				vec.add(ovo.getQuan());
				vec.add(ovo.getPrice());
				vec.add(ovo.getorderDate());
				vec.add(ovo.getPhone());
				vec.add(ovo.getIpAddress());
				vec.add(ovo.getStatus());
				
				//추가
				dtm.addRow(vec);
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchOrder
	
	/**
	 * 요청사항의 값이 존재하고 읽지 않았다면 true
	 * 존재하지 않거나 읽었다면 false 반환한다.
	 * @return
	 */
	public boolean requestExist() {
		boolean flag=false;
//		JTable jt=lmv.getJtOrder();
		String request=null;
//		String requestStatus=null;
		try {
			request = la_dao.selectRequest(orderNum);
//			requestStatus = la_dao.selectRequest(orderNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		if(!request.equals(""));{//mt가 아니고
			flag=true;
		}//end if
		return flag;
	}//requestExist
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource()==lmv.getJtb()) {
			if(lmv.getJtb().getSelectedIndex()==1) {//두번째(주문)탭에서 이벤트 발생
//				System.out.println("이벤트발생발생~~~");
				
				///////////////////////////<주문현황을 계속~~~조회하여!!!=Thread 
				//실시간으로 DB를 조회하여 주문현황을 계속 갱신 ==>Thread
				if(threadOrdering==null) {//이거 없으면 계속 만들어진다.
					threadOrdering =new Thread(this);
					threadOrdering.start();
				}//end if
				
				//현제까지의 주문사항을 조회 (Thread로 돌려야 한다)
//				searchOrder();
			}//end if
		}//end if
		if(me.getSource()==lmv.getJtOrder()&&me.getClickCount()==DBL_CLICK) {//더블클릭시 쨔란
			JTable jt=lmv.getJtOrder();
			orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);
			try {
				if(!la_dao.selectRequest(orderNum).equals("")) {//값이 있으면
//					String request=la_dao.selectRequest(orderNum);
					if(la_dao.updateRequestStatus(orderNum)) {//상태변환성공
						msgCenter(lmv, "요청사항"+la_dao.selectRequest(orderNum));
					}else {//상태 변환 실패
						JOptionPane.showMessageDialog(lmv, "도시락 제작상태 변환이 실패!");
					}//end else
				
					int r = jt.rowAtPoint(me.getPoint());//위치뽑아 행가져와
			        if (r >= 0 && r < jt.getRowCount()) {
			        	
			        	jt.setRowSelectionInterval(r, r);//시작행과 끝행 사이의 행을 선택하는 일(시작과 끝이 같은게선택되어 그행이 선택되는)
			        } else {
			        	jt.clearSelection();
			        }//end else
			        //선택한 행을 넣는다.
			        selectedRow=r;
				JPopupMenu jp=lmv.getJpOrderMenu();
				jp.setLocation(me.getXOnScreen(),me.getYOnScreen());
				jp.setVisible(true);
				
				orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);//우클릭이 판정이 안돼서...
				lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
							(String)jt.getValueAt(jt.getSelectedRow(), 4);
				}//end if
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(lmv, "DB에서 문제 발생!\n잠시후 다시 시도해 보세요.");
				e.printStackTrace();
			}//end catch
			
			
		}else {
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);
			
		}//end else
		
		if(me.getSource()==lmv.getJtOrder() && me.getButton()==MouseEvent.BUTTON3) {//우클릭?
			JTable jt=lmv.getJtOrder();
			//마우스 포인터가 클릭되면 테이블에서 클릭한 행을 가져오는 일
			int r = jt.rowAtPoint(me.getPoint());//위치뽑아 행가져와
		        if (r >= 0 && r < jt.getRowCount()) {
		        	
		        	jt.setRowSelectionInterval(r, r);//시작행과 끝행 사이의 행을 선택하는 일(시작과 끝이 같은게선택되어 그행이 선택되는)
		        } else {
		        	jt.clearSelection();
		        }//end else
		        //선택한 행을 넣는다.
		        selectedRow=r;
//			System.out.println("아오 우클릭"+me.getX()+"/"+me.getY());
			JPopupMenu jp=lmv.getJpOrderMenu();
			jp.setLocation(me.getXOnScreen(),me.getYOnScreen());
//			jp.setBounds(me.getXOnScreen(),me.getYOnScreen(),100,100);
			jp.setVisible(true);
			
			orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);//우클릭이 판정이 안돼서...
//			System.out.println(jt.getValueAt(jt.getSelectedRow(), 1));
//			System.out.println(jt.getSelectedRow());
			lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
						(String)jt.getValueAt(jt.getSelectedRow(), 4);
			
			
		}else {
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);
			
		}//end else
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
		}//end switch
	}//mouseClicked
	
	private void msgCenter(Component parentComponent,String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}//msgCenter
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lmv.getJbtAddLunch()) {//도시락 추가버튼
			new LunchAddView(lmv,this);
		}//end if

		if(ae.getSource()==lmv.getJcbMonth()) {//월별 마지막 일자 변경
			setDay();
		}//end if
		
		if(ae.getSource()==lmv.getJbtCalcOrder()) {//정산 버튼 클릭
			searchCalc();
		}//end if
		
//		if(ae.getSource()==lmv.getJmOrderRemove()) {
////			JOptionPane.showConfirmDialog(lmv, "정말 삭제인 부분");
//		}//end if
//		if(ae.getSource()==lmv.getJmOrderStatus()) {
//			//제작상태가 'N'인 상태에서만 동작!
//			JTable jt=lmv.getJtOrder();
//			if(((String)jt.getValueAt(selectedRow, 10)).equals("N")) {
//				switch(JOptionPane.showConfirmDialog(lmv, orderNum+" "+lunchName+"주문정보를 삭제하시겠습니까?")) {
//				case JOptionPane.OK_OPTION:
//					try {
//					if(la_dao.deleteOrder(orderNum)) {//DB Table에서 해당 레코드 삭제
//						msgCenter(lmv, orderNum+"주문이 삭제되었습니다.");
//						//주문 테이블 갱신 (원래는 db에서 가지고 와야하는데
//						searchOrder();
//					}else {
//						msgCenter(lmv, orderNum+"주문이 삭제되지 않습니다.");
//					}//end else
//					}catch (SQLException e) {
//						msgCenter(lmv, "DB에서 문제 발생");
//						e.printStackTrace();
//					}//end catch
//					}//end switch
//				}//end if
//			}else {
//				msgCenter(lmv, "제작된 도시락은 삭제할 수 없습니다.");
//			}//end else
//			JPopupMenu jp= lmv.getJpOrderMenu();
//			jp.setVisible(false);//popup메뉴 숨김
		  
			if(ae.getSource() == lmv.getJmOrderRemove()) {
			//제작상태가 'N'인 상태에서만 동작
			JTable jt = lmv.getJtOrder();
			if(((String)jt.getValueAt(selectedRow, 10)).equals("N")) { //제작상태가 'N'인 상태에서만 동작
				switch(JOptionPane.showConfirmDialog(lmv, "[ "+orderNum+lunchName+" ] 주문정보를 삭제하시겠습니까?")) {
	            case JOptionPane.OK_OPTION :
	               try {
	                  if(la_dao.deleteOrder(orderNum)) { //DB Table의 해당 레코드 삭제
	                     lmv.getJpOrderMenu().setVisible(false);
	                     msgCenter(lmv, "주문이 삭제되었습니다.");
	                     //테이블 갱신
	                     searchOrder();
	                  } else {
	                     JOptionPane.showMessageDialog(lmv, "도시락 주문 삭제에 실패하였습니다.");
	                  }//end else
	               } catch (SQLException se) {
	                  lmv.getJpOrderMenu().setVisible(false);
	                  JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생하였습니다.");
	                  se.printStackTrace();
	               }//end catch
	            }//end switch
			} else {
				lmv.getJpOrderMenu().setVisible(false);
	            JOptionPane.showMessageDialog(lmv, "제작된 도시락은 삭제할 수 없습니다.");
     		}//end else
			}//end if

//			try {//주문 완료를 하려면 요청사항이 있으면 읽어야 하고 없으면 그냥 주문 완료를 띄워주면 된다.
//			if(ae.getSource()==lmv.getJmOrderStatus()&&requestExist()) {
//					//la_dao.selectRequest(orderNum).equals("N")) {
//				//주문완료+읽지 않은 상태라면
//				JTable jt=lmv.getJtOrder();
//				orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//					String request=la_dao.selectRequest(orderNum);
//					if(!request.equals("")) {
//						msgCenter(lmv, la_dao.selectRequest(orderNum));
//					}//end if
//			}//end if
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}//end catch
			
			
			if(ae.getSource()==lmv.getJmOrderStatus()) {//주문완료
				//제작상태가 'N'인 상태에서만 동작!
/////////////////////////////////////////////////
			try {
				if (la_dao.selectRequestStatus(orderNum).equals("N")) {// 읽지않았을때
//String request=la_dao.selectRequest(orderNum);
					if (la_dao.updateRequestStatus(orderNum)) {// 상태변환성공
						msgCenter(lmv, "요청사항" + la_dao.selectRequest(orderNum));
					} else {// 상태 변환 실패
						JOptionPane.showMessageDialog(lmv, "도시락 제작상태 변환이 실패!");
					} // end else
				} // end if
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // end if
			/*
			 * int r = jt.rowAtPoint(me.getPoint());//위치뽑아 행가져와 if (r >= 0 && r <
			 * jt.getRowCount()) {
			 * 
			 * jt.setRowSelectionInterval(r, r);//시작행과 끝행 사이의 행을 선택하는 일(시작과 끝이 같은게선택되어 그행이
			 * 선택되는) } else { jt.clearSelection(); }//end else //선택한 행을 넣는다. selectedRow=r;
			 * JPopupMenu jp=lmv.getJpOrderMenu();
			 * jp.setLocation(me.getXOnScreen(),me.getYOnScreen()); jp.setVisible(true);
			 * 
			 * orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);//우클릭이 판정이 안돼서...
			 * lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
			 * (String)jt.getValueAt(jt.getSelectedRow(), 4);
			 * 
			 */
////////////////////////////////////////////////////////////////////////////////////////		
				JTable jt=lmv.getJtOrder();
				if(((String)jt.getValueAt(selectedRow, 10)).equals("N")) {
			
			switch(JOptionPane.showConfirmDialog(lmv, "["+orderNum+lunchName+"] 주문이 완료었습니까?")) {
			case JOptionPane.OK_OPTION : 
				//DB Table의 해당 레코드 변경
				try {
					if(la_dao.updateStatus(orderNum)) {//상태변환성공
						jt.setValueAt("Y", selectedRow, 10);//테이블의 값만 변경//<화면만 바꿈!DB는 아님!
					}else {//상태 변환 실패
						JOptionPane.showMessageDialog(lmv, "도시락 제작상태 변환이 실패!");
					}//end else
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제 발생!\n잠시후 다시 시도해 보세요.");
					e.printStackTrace();
				}//end catch		
			}//end switch
			}else {
				JOptionPane.showMessageDialog(lmv, "제작이 완료된 도시락입니다.");//static import로 받아 짧게 사용한다.아니면 메소드를 메소드를 하나만들어...
			}//end else
			
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);//popup메뉴 숨김
		}//end if
	}//actionPerformed

	/**
	 * 년,월,일 정보를 가져와서 정산 
	 */
	private void searchCalc() {
		int selYear=((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth=(Integer)lmv.getJcbMonth().getSelectedItem();
		int selDay=(Integer)lmv.getJcbDay().getSelectedItem();
		
		StringBuilder searchDate=new StringBuilder();
		searchDate.append(selYear).append("-")
		.append(selMonth).append("-").append(selDay);
		
//		System.out.println(searchDate);
		try {
			//선택한일자의 조회결과를 받아서 JTable에 출력
			List<CalcVO> list =la_dao.selectCalc(searchDate.toString());
//			System.out.println(list);
			//JTable에 데이터를 추가하는 코드 작성

//	        String[] row = new String[list.size()];
//	        list.toArray(row);
//			for(int i=0; i<list.size(); i++) {
//				String[] comma=row[i].split(",");
////				CalcVO cvo=new CalcVO(lunchCode, lunchName, price, total)
//				lmv.getDtmCalc().addRow(comma[i]);
//			}//end for
			DefaultTableModel dtm=lmv.getDtmCalc();
			if(!list.isEmpty()) {
				dtm.setRowCount(0);
			}//end if
			Object[] rowData=null;
			CalcVO cv=null;
			
			for(int i=0; i<list.size(); i++) {
				cv=list.get(i);
				rowData=new Object[4];
				rowData[0]=new Integer(i+1);
				rowData[1]=cv.getLunchName()+"("+cv.getLunchCode()+")";
				rowData[2]=new Integer(cv.getTotal());
				rowData[3]=new Integer(cv.getPrice());
				dtm.addRow(rowData);
				//DTM에 넣을때에는 1차원 배열혹은 벡터로 넣어야함. 추가하기위한 배열을 생성해 추가.
			}//end for
			
			//데이터가 없는 날에는 "판매된 도시락이 없습니다" 를 출력
			if(list.isEmpty()) {
				dtm.setRowCount(0);
				JOptionPane.showMessageDialog(lmv, searchDate.toString()+"에 판매된 도시락이 없습니다.");
			}//end if
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchCalc

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
//		int nowDay=cal.get(Calendar.DAY_OF_MONTH);

		lmv.getCbmDay().removeAllElements();//모델을 초기화 하고
		for(int day=1; day<lastDay+1; day++) {
			lmv.getCbmDay().addElement(day);//마지막날을 설정한다.
		}//end for
		
//		lmv.getCbmDay().setSelectedItem(new Integer(nowDay));//그리고 오늘을 선택한다.
		//<기본형을 객체로 변환하여 넣어주는것auto Boxing되어서 들어가나 변환해준거당..
		
	}//setDay

	@Override
	public void run() {
		//30초마다 한번씩 조회 수행
		try {
			while(true) {  //<문젠 계~~속돌아 DB를 연결했다 끊고 ~반복되어 선택도 되지 않는다.CUP도 많이 잡아먹음
				searchOrder();//<while이 없으면 조회가 한번만되어 아님.무한루프로 돌려준다.
				Thread.sleep(1000*30);
			}//end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "주문 조회 중 문제가 발생했습니다.");
			e.printStackTrace();
			//소켓을 사용하는 방법또한 방법! 키오스크-서버-주문이 뜸 서버를 돌고 주문이 들어올때마다 들어오는것도 있음 부하가 덜걸린다.
		}//end catch
	}//run
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}//class
