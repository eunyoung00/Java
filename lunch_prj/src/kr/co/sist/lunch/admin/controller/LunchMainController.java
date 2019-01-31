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
	
	private Thread threadOrdering;//������ ���� �ʵ��� �ν��Ͻ�������
	
	public LunchMainController(LunchMainView lmv) {
		this.lmv=lmv;
		la_dao=LunchAdminDAO.getInstance();
		//���ö� ����� �ʱ�ȭ-���� �Ѵ�.
		setLunch();
		orderNum="";
	}//LunchMainController
	
	/**
	 * JTable�� DB���� ��ȸ�� ���ö� ������ �����ش�.
	 */
	public void setLunch() {//�������� ����Ῡ �ۿ��� ������ ������ private
		DefaultTableModel dtmLunch=lmv.getDtmLunch();
		dtmLunch.setRowCount(0);//�ִ� row4���� �ϴ� �����ְ�
		
		try {
			//DB���� ���ö� ������ ��ȸ
			List<LunchVO> listLunch=la_dao.selectLunch();
			//JTable�� ��ȸ�� ������ ���
			
			LunchVO lv=null;
			String imgPath="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";
			
			Object[] rowData=null;
			for(int i=0; i<listLunch.size(); i++) {
				lv=listLunch.get(i);
				
				//<dtm�� ���������� 1���� �迭�̳� vector�θ� �������ִ�.
				//DTM�� �����͸� �߰��ϱ� ���� �������迭(or Vector)�� �����ϰ� �����͸� �߰�
				rowData=new Object[5];
				rowData[0]=new Integer(i+1);//<�⺻���� ���������� ������ int�� ��ü�� ����� �־��ش�.
				rowData[1]=lv.getLunchCode();
				rowData[2]=new ImageIcon(imgPath+lv.getLunchImg());
				rowData[3]=lv.getLunchName();
				rowData[4]=new Integer(lv.getPrice());//<aotoBoxing���� �� ������ ��ü�� ����?���ش�.
				
				//DTM�� �߰�
				dtmLunch.addRow(rowData);
				
			}//end for
			
			if(listLunch.isEmpty()) {//�Էµ� ���ö��� ���� �� 
				JOptionPane.showMessageDialog(lmv, "�Էµ� ��ǰ�� �����ϴ�.");
			}//end if
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �߿� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		}//end catch
		
	}//setLunch
	
	@Override
	public void windowClosing(WindowEvent we) {
		lmv.dispose();
	}//windowClosing
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);//JVM�� ��� �ν��Ͻ� ����
	}//windowClosed
	
	/**
	 * �ֹ� ���� ��ȸ
	 */
	private void searchOrder() {//�̸޼ҵ尡 thread�� ���ƾ� �Ѵ�. ����
		try {
			List<OrderVO> list=la_dao.selectOrderList();
			DefaultTableModel dtm=lmv.getDtmOrder();
			dtm.setRowCount(0);//�ʱ�ȭ
			
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
				
				//�߰�
				dtm.addRow(vec);
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchOrder
	
	/**
	 * ��û������ ���� �����ϰ� ���� �ʾҴٸ� true
	 * �������� �ʰų� �о��ٸ� false ��ȯ�Ѵ�.
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
		if(!request.equals(""));{//mt�� �ƴϰ�
			flag=true;
		}//end if
		return flag;
	}//requestExist
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource()==lmv.getJtb()) {
			if(lmv.getJtb().getSelectedIndex()==1) {//�ι�°(�ֹ�)�ǿ��� �̺�Ʈ �߻�
//				System.out.println("�̺�Ʈ�߻��߻�~~~");
				
				///////////////////////////<�ֹ���Ȳ�� ���~~~��ȸ�Ͽ�!!!=Thread 
				//�ǽð����� DB�� ��ȸ�Ͽ� �ֹ���Ȳ�� ��� ���� ==>Thread
				if(threadOrdering==null) {//�̰� ������ ��� ���������.
					threadOrdering =new Thread(this);
					threadOrdering.start();
				}//end if
				
				//���������� �ֹ������� ��ȸ (Thread�� ������ �Ѵ�)
//				searchOrder();
			}//end if
		}//end if
		if(me.getSource()==lmv.getJtOrder()&&me.getClickCount()==DBL_CLICK) {//����Ŭ���� ¹��
			JTable jt=lmv.getJtOrder();
			orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);
			try {
				if(!la_dao.selectRequest(orderNum).equals("")) {//���� ������
//					String request=la_dao.selectRequest(orderNum);
					if(la_dao.updateRequestStatus(orderNum)) {//���º�ȯ����
						msgCenter(lmv, "��û����"+la_dao.selectRequest(orderNum));
					}else {//���� ��ȯ ����
						JOptionPane.showMessageDialog(lmv, "���ö� ���ۻ��� ��ȯ�� ����!");
					}//end else
				
					int r = jt.rowAtPoint(me.getPoint());//��ġ�̾� �డ����
			        if (r >= 0 && r < jt.getRowCount()) {
			        	
			        	jt.setRowSelectionInterval(r, r);//������� ���� ������ ���� �����ϴ� ��(���۰� ���� �����Լ��õǾ� ������ ���õǴ�)
			        } else {
			        	jt.clearSelection();
			        }//end else
			        //������ ���� �ִ´�.
			        selectedRow=r;
				JPopupMenu jp=lmv.getJpOrderMenu();
				jp.setLocation(me.getXOnScreen(),me.getYOnScreen());
				jp.setVisible(true);
				
				orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);//��Ŭ���� ������ �ȵż�...
				lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
							(String)jt.getValueAt(jt.getSelectedRow(), 4);
				}//end if
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(lmv, "DB���� ���� �߻�!\n����� �ٽ� �õ��� ������.");
				e.printStackTrace();
			}//end catch
			
			
		}else {
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);
			
		}//end else
		
		if(me.getSource()==lmv.getJtOrder() && me.getButton()==MouseEvent.BUTTON3) {//��Ŭ��?
			JTable jt=lmv.getJtOrder();
			//���콺 �����Ͱ� Ŭ���Ǹ� ���̺��� Ŭ���� ���� �������� ��
			int r = jt.rowAtPoint(me.getPoint());//��ġ�̾� �డ����
		        if (r >= 0 && r < jt.getRowCount()) {
		        	
		        	jt.setRowSelectionInterval(r, r);//������� ���� ������ ���� �����ϴ� ��(���۰� ���� �����Լ��õǾ� ������ ���õǴ�)
		        } else {
		        	jt.clearSelection();
		        }//end else
		        //������ ���� �ִ´�.
		        selectedRow=r;
//			System.out.println("�ƿ� ��Ŭ��"+me.getX()+"/"+me.getY());
			JPopupMenu jp=lmv.getJpOrderMenu();
			jp.setLocation(me.getXOnScreen(),me.getYOnScreen());
//			jp.setBounds(me.getXOnScreen(),me.getYOnScreen(),100,100);
			jp.setVisible(true);
			
			orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);//��Ŭ���� ������ �ȵż�...
//			System.out.println(jt.getValueAt(jt.getSelectedRow(), 1));
//			System.out.println(jt.getSelectedRow());
			lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
						(String)jt.getValueAt(jt.getSelectedRow(), 4);
			
			
		}else {
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);
			
		}//end else
//		System.out.println(me.getClickCount());//Ŭ��Ƚ��
//		if(me.getClickCount()==DBL_CLICK/*2�� �ᵵ �ǳ� ����� ������ ����ϸ� ������up*/) {
		switch(me.getClickCount()) {
		case DBL_CLICK:
//			System.out.println("���� Ŭ��!!");
			if(me.getSource()==lmv.getJtLunch()) {//���ö����̺��� ����Ŭ��
				//���ö� �ڵ�� DB Table�� �˻��� �������� �����Ѵ�.
				JTable jt=lmv.getJtLunch();
//				System.out.println(jt.getValueAt(jt.getSelectedRow(), 1));//�ڵ� ���
				try {
					LunchDetailVO ldvo=la_dao.selectDetailLunch((String)jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv,ldvo,this);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��߽��ϴ�.");
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
		if(ae.getSource()==lmv.getJbtAddLunch()) {//���ö� �߰���ư
			new LunchAddView(lmv,this);
		}//end if

		if(ae.getSource()==lmv.getJcbMonth()) {//���� ������ ���� ����
			setDay();
		}//end if
		
		if(ae.getSource()==lmv.getJbtCalcOrder()) {//���� ��ư Ŭ��
			searchCalc();
		}//end if
		
//		if(ae.getSource()==lmv.getJmOrderRemove()) {
////			JOptionPane.showConfirmDialog(lmv, "���� ������ �κ�");
//		}//end if
//		if(ae.getSource()==lmv.getJmOrderStatus()) {
//			//���ۻ��°� 'N'�� ���¿����� ����!
//			JTable jt=lmv.getJtOrder();
//			if(((String)jt.getValueAt(selectedRow, 10)).equals("N")) {
//				switch(JOptionPane.showConfirmDialog(lmv, orderNum+" "+lunchName+"�ֹ������� �����Ͻðڽ��ϱ�?")) {
//				case JOptionPane.OK_OPTION:
//					try {
//					if(la_dao.deleteOrder(orderNum)) {//DB Table���� �ش� ���ڵ� ����
//						msgCenter(lmv, orderNum+"�ֹ��� �����Ǿ����ϴ�.");
//						//�ֹ� ���̺� ���� (������ db���� ������ �;��ϴµ�
//						searchOrder();
//					}else {
//						msgCenter(lmv, orderNum+"�ֹ��� �������� �ʽ��ϴ�.");
//					}//end else
//					}catch (SQLException e) {
//						msgCenter(lmv, "DB���� ���� �߻�");
//						e.printStackTrace();
//					}//end catch
//					}//end switch
//				}//end if
//			}else {
//				msgCenter(lmv, "���۵� ���ö��� ������ �� �����ϴ�.");
//			}//end else
//			JPopupMenu jp= lmv.getJpOrderMenu();
//			jp.setVisible(false);//popup�޴� ����
		  
			if(ae.getSource() == lmv.getJmOrderRemove()) {
			//���ۻ��°� 'N'�� ���¿����� ����
			JTable jt = lmv.getJtOrder();
			if(((String)jt.getValueAt(selectedRow, 10)).equals("N")) { //���ۻ��°� 'N'�� ���¿����� ����
				switch(JOptionPane.showConfirmDialog(lmv, "[ "+orderNum+lunchName+" ] �ֹ������� �����Ͻðڽ��ϱ�?")) {
	            case JOptionPane.OK_OPTION :
	               try {
	                  if(la_dao.deleteOrder(orderNum)) { //DB Table�� �ش� ���ڵ� ����
	                     lmv.getJpOrderMenu().setVisible(false);
	                     msgCenter(lmv, "�ֹ��� �����Ǿ����ϴ�.");
	                     //���̺� ����
	                     searchOrder();
	                  } else {
	                     JOptionPane.showMessageDialog(lmv, "���ö� �ֹ� ������ �����Ͽ����ϴ�.");
	                  }//end else
	               } catch (SQLException se) {
	                  lmv.getJpOrderMenu().setVisible(false);
	                  JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��Ͽ����ϴ�.");
	                  se.printStackTrace();
	               }//end catch
	            }//end switch
			} else {
				lmv.getJpOrderMenu().setVisible(false);
	            JOptionPane.showMessageDialog(lmv, "���۵� ���ö��� ������ �� �����ϴ�.");
     		}//end else
			}//end if

//			try {//�ֹ� �ϷḦ �Ϸ��� ��û������ ������ �о�� �ϰ� ������ �׳� �ֹ� �ϷḦ ����ָ� �ȴ�.
//			if(ae.getSource()==lmv.getJmOrderStatus()&&requestExist()) {
//					//la_dao.selectRequest(orderNum).equals("N")) {
//				//�ֹ��Ϸ�+���� ���� ���¶��
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
			
			
			if(ae.getSource()==lmv.getJmOrderStatus()) {//�ֹ��Ϸ�
				//���ۻ��°� 'N'�� ���¿����� ����!
/////////////////////////////////////////////////
			try {
				if (la_dao.selectRequestStatus(orderNum).equals("N")) {// �����ʾ�����
//String request=la_dao.selectRequest(orderNum);
					if (la_dao.updateRequestStatus(orderNum)) {// ���º�ȯ����
						msgCenter(lmv, "��û����" + la_dao.selectRequest(orderNum));
					} else {// ���� ��ȯ ����
						JOptionPane.showMessageDialog(lmv, "���ö� ���ۻ��� ��ȯ�� ����!");
					} // end else
				} // end if
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // end if
			/*
			 * int r = jt.rowAtPoint(me.getPoint());//��ġ�̾� �డ���� if (r >= 0 && r <
			 * jt.getRowCount()) {
			 * 
			 * jt.setRowSelectionInterval(r, r);//������� ���� ������ ���� �����ϴ� ��(���۰� ���� �����Լ��õǾ� ������
			 * ���õǴ�) } else { jt.clearSelection(); }//end else //������ ���� �ִ´�. selectedRow=r;
			 * JPopupMenu jp=lmv.getJpOrderMenu();
			 * jp.setLocation(me.getXOnScreen(),me.getYOnScreen()); jp.setVisible(true);
			 * 
			 * orderNum=(String)jt.getValueAt(jt.getSelectedRow(), 1);//��Ŭ���� ������ �ȵż�...
			 * lunchName=(String)jt.getValueAt(jt.getSelectedRow(), 3)+" "+
			 * (String)jt.getValueAt(jt.getSelectedRow(), 4);
			 * 
			 */
////////////////////////////////////////////////////////////////////////////////////////		
				JTable jt=lmv.getJtOrder();
				if(((String)jt.getValueAt(selectedRow, 10)).equals("N")) {
			
			switch(JOptionPane.showConfirmDialog(lmv, "["+orderNum+lunchName+"] �ֹ��� �Ϸ�����ϱ�?")) {
			case JOptionPane.OK_OPTION : 
				//DB Table�� �ش� ���ڵ� ����
				try {
					if(la_dao.updateStatus(orderNum)) {//���º�ȯ����
						jt.setValueAt("Y", selectedRow, 10);//���̺��� ���� ����//<ȭ�鸸 �ٲ�!DB�� �ƴ�!
					}else {//���� ��ȯ ����
						JOptionPane.showMessageDialog(lmv, "���ö� ���ۻ��� ��ȯ�� ����!");
					}//end else
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(lmv, "DB���� ���� �߻�!\n����� �ٽ� �õ��� ������.");
					e.printStackTrace();
				}//end catch		
			}//end switch
			}else {
				JOptionPane.showMessageDialog(lmv, "������ �Ϸ�� ���ö��Դϴ�.");//static import�� �޾� ª�� ����Ѵ�.�ƴϸ� �޼ҵ带 �޼ҵ带 �ϳ������...
			}//end else
			
			JPopupMenu jp= lmv.getJpOrderMenu();
			jp.setVisible(false);//popup�޴� ����
		}//end if
	}//actionPerformed

	/**
	 * ��,��,�� ������ �����ͼ� ���� 
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
			//������������ ��ȸ����� �޾Ƽ� JTable�� ���
			List<CalcVO> list =la_dao.selectCalc(searchDate.toString());
//			System.out.println(list);
			//JTable�� �����͸� �߰��ϴ� �ڵ� �ۼ�

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
				//DTM�� ���������� 1���� �迭Ȥ�� ���ͷ� �־����. �߰��ϱ����� �迭�� ������ �߰�.
			}//end for
			
			//�����Ͱ� ���� ������ "�Ǹŵ� ���ö��� �����ϴ�" �� ���
			if(list.isEmpty()) {
				dtm.setRowCount(0);
				JOptionPane.showMessageDialog(lmv, searchDate.toString()+"�� �Ǹŵ� ���ö��� �����ϴ�.");
			}//end if
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchCalc

	/**
	 * ���� ���õǸ� �ش���� �ش���� ���������� ����.
	 */
	private void setDay() {
		int selYear=((Integer)lmv.getJcbYear().getSelectedItem()).intValue();
		int selMonth=(Integer)lmv.getJcbMonth().getSelectedItem();
		
		//�������� ���
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, selYear);
		cal.set(Calendar.MONTH, selMonth-1);
		
		int lastDay=cal.getActualMaximum(Calendar.DATE);
//		int nowDay=cal.get(Calendar.DAY_OF_MONTH);

		lmv.getCbmDay().removeAllElements();//���� �ʱ�ȭ �ϰ�
		for(int day=1; day<lastDay+1; day++) {
			lmv.getCbmDay().addElement(day);//���������� �����Ѵ�.
		}//end for
		
//		lmv.getCbmDay().setSelectedItem(new Integer(nowDay));//�׸��� ������ �����Ѵ�.
		//<�⺻���� ��ü�� ��ȯ�Ͽ� �־��ִ°�auto Boxing�Ǿ ���� ��ȯ���ذŴ�..
		
	}//setDay

	@Override
	public void run() {
		//30�ʸ��� �ѹ��� ��ȸ ����
		try {
			while(true) {  //<���� ��~~�ӵ��� DB�� �����ߴ� ���� ~�ݺ��Ǿ� ���õ� ���� �ʴ´�.CUP�� ���� ��Ƹ���
				searchOrder();//<while�� ������ ��ȸ�� �ѹ����Ǿ� �ƴ�.���ѷ����� �����ش�.
				Thread.sleep(1000*30);
			}//end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "�ֹ� ��ȸ �� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
			//������ ����ϴ� ������� ���! Ű����ũ-����-�ֹ��� �� ������ ���� �ֹ��� ���ö����� �����°͵� ���� ���ϰ� ���ɸ���.
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
