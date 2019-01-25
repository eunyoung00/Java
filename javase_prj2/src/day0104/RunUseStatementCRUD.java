package day0104;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class RunUseStatementCRUD {
	
	private UseStatementCRUD us_crud;
	
	public RunUseStatementCRUD() {
		us_crud=new UseStatementCRUD();
	}//RunUseStatementCRUD

	public void addCpDept() {
		String tempData=JOptionPane.showInputDialog("�μ� ���� �߰� \n�Է� ��)�μ���ȣ,�μ���,��ġ");
		if(tempData!=null && !tempData.equals("")) {//�����Ͱ� �ִٸ�  null.equals�̴ϱ� ������ ������� �ʾƼ� Error�߻����� �ʴ´�.
			String[] data=tempData.split(",");
			if(data.length!=3) {//�߸��� ������
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			}//end if
			
			int deptno=0;
			String dname="";
			String loc="";
			
			try {
				deptno=Integer.parseInt(data[0]);
				dname=data[1];
				loc=data[2];
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�.");
				return;
			}//end catch
			
			//ó���� �Էµ����͸� VO�� �����ϰ�
			CpDeptVO cdvo=new CpDeptVO(deptno,dname,loc);
			//VO�� ���� DB�� insert�Ѵ�.
			
			try {
				us_crud.insertCpDept(cdvo);//�߰�����
				JOptionPane.showMessageDialog(null, deptno+"�� �μ����� �߰�");
			} catch (SQLException se) {//����
				
				String errMsg="";
				switch (se.getErrorCode()) {
				case 1:	errMsg=deptno+"�� �μ��� �̹� �����մϴ�."; break;
				case 1438:	errMsg="�μ� ��ȣ�� ���ڸ� �Դϴ�."; break;//������Ʈ�Ҷ����� ���´�.
				case 12899:	errMsg="�μ����̳� ��ġ�� �ʹ� ��ϴ�."; break;

				default: errMsg="���E�մϴ�.�ý��ۿ� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ��� �ּ���.";	
				}//end switch
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}//end catch
		}//end if
	}//addCpDept
	
	public void modifyCpDept() {
		String tempData=JOptionPane.showInputDialog("�μ� ���� ���� \n�μ���ȣ�� ��ġ�ϴ� �μ����� ��ġ�� �����մϴ�.\n�Է� ��)�μ���ȣ,�μ���,��ġ");
		if(tempData!=null && !tempData.equals("")) {//�����Ͱ� �ִٸ�  null.equals�̴ϱ� ������ ������� �ʾƼ� Error�߻����� �ʴ´�.
			String[] data=tempData.split(",");
			if(data.length!=3) {//�߸��� ������
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;
			}//end if
			
			int deptno=0;
			String dname="";
			String loc="";
			
			try {
				deptno=Integer.parseInt(data[0]);
				dname=data[1];
				loc=data[2];
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�.");
				return;
			}//end catch
			
			//ó���� �Էµ����͸� VO�� �����ϰ�
			CpDeptVO cdvo=new CpDeptVO(deptno,dname,loc);
			//VO�� ���� DB�� update�Ѵ�.
			
			try {
				//������ ����/����/���� 3��
				String msg="";
				if(us_crud.updateCpDept(cdvo)) {//����� ���ڵ尡 ����
					msg=deptno+"�� �μ��� ������ �����Ͽ����ϴ�.";
				}else{//����� ���ڵ尡 �������� x
					msg=deptno+"�� �μ��� �������� �ʽ��ϴ�.";
				}//end else
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {//����
				
				String errMsg="";
				switch (se.getErrorCode()) {
				case 12899:	errMsg="�μ����̳� ��ġ�� �ʹ� ��ϴ�."; break;
				default: errMsg="���E�մϴ�.�ý��ۿ� ������ �߻��߽��ϴ�. ��� �� �ٽ� �õ��� �ּ���.";	
				}//end switch
				JOptionPane.showMessageDialog(null, errMsg);
				se.printStackTrace();
			}//end catch
		}//end if
	}//modifyCpDept
	
	public void removeCpDept() {
		String inputData=JOptionPane.showInputDialog("�μ� ����\n������ �μ���ȣ �Է�");
		if(inputData !=null && !inputData.equals("")) {
			int deptno=0;
			
			try {
				deptno=Integer.parseInt(inputData);
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����̾�� �մϴ�.");
				return;
			}//end catch
			
			try {
				String msg=deptno+"�� �μ��� �������� �ʽ��ϴ�.";
				
				if(us_crud.deleteCpDept(deptno)) {
					msg=deptno+"�� �μ���ȣ�� �����Ͽ����ϴ�.";
				}//end if
				
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}//end catch
		}//end if
	}//searchAllCpDept
	
	public void searchAllCpDept() {
		
		StringBuilder viewCpDept=new StringBuilder();
		viewCpDept
		.append("------------------------------------------------------")
		.append("------------------------------------------------------\n")
		.append("��ȣ\t�μ���ȣ\t�μ���\t��ġ\n")
		.append("------------------------------------------------------")
		.append("------------------------------------------------------\n");
		
		int rowCount=0;
		try {
			List<CpDeptVO> list= us_crud.selectAllCpDept();
			CpDeptVO cdv=null;
			
			rowCount=list.size();
			for(int i=0; i<list.size(); i++) {
				cdv=list.get(i);
				viewCpDept
				.append(i+1).append("\t")
				.append(cdv.getDeptno()).append("\t")
				.append(cdv.getDname()).append("\t")
				.append(cdv.getLoc()).append("\n");
			}//end for
			
			if(list.isEmpty()) { //list.size()==0
				viewCpDept.append("�Էµ� �μ������� �������� �ʽ��ϴ�.\n");
			}//end if
			
		}catch (SQLException e) {
			viewCpDept.append("DBMS���� ������ �߻��Ͽ����ϴ�. ��������\n");
			e.printStackTrace();
		}//end catch
		
		viewCpDept.append("------------------------------------------------------")
		.append("------------------------------------------------------\n")
		.append("\t\t\t��").append(rowCount).append("���� �μ������� ��ȸ�Ǿ����ϴ�.");
		
		JTextArea jta=new JTextArea(20,50);
		jta.setEditable(false);//�Է¹���
		jta.setText(viewCpDept.toString());//������� ��µ����͸� T.A�� �����Ѵ�.
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü �μ� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
		
	}//searchAllCpDept
	
	public void searchOneCpDept() {
		
		String inputData=JOptionPane.showInputDialog("�μ� ��ȸ \n��ȸ�� �μ���ȣ�� �Է��� �ּ���.");
		if(inputData!=null && !inputData.equals("")) {
			try {
				int deptno=Integer.parseInt(inputData);
				//�μ���ȣ�� �Է��Ͽ� �μ���ȣ�� �ش��ϴ� �μ������� ��ȸ   <�ϰ� �Ѹ���.
				//��ȸ�� �μ��� �ִٸ� ������ ��ü�� ��ȯ�ǰ� ��ȸ�� �μ��� ���ٸ� null�� ��ȯ�ȴ�.
				OneCpDeptVO ocd_vo= us_crud.selectCpDept(deptno);
				
				
				StringBuilder viewData=new StringBuilder();
				viewData.append("�μ��� : ").append(ocd_vo.getDname())//���⼭ nullpointerException�� �߻��ϴ°�.
				.append(", ��ġ : ").append(ocd_vo.getLoc());
				
				JLabel lbl=new JLabel(viewData.toString());
				lbl.setFont(new Font("SansSerif", Font.BOLD, 15));
				
				JOptionPane.showMessageDialog(null, lbl);
				
//				us_crud.selectAllCpDeptNo()//[1,20,30]//������ �ѹ��� try catch�ϴ� �پ˾Ҵµ� ..�ƴ�.
//				StringBuilder allDeptno=new StringBuilder();
//				List<Integer> allDeptnolist=new ArrayList<Integer>();
//				for(Integer i/*������!!*/ : allDeptnolist) {
//					allDeptno.append(i.intValue()).append(" ");//����ε�?
//				}//end for
				
			}catch (NullPointerException npe) {
				StringBuilder allDeptno=new StringBuilder();
//				JOptionPane.showMessageDialog(null, inputData+"��ȣ�� �μ��� �������� �ʽ��ϴ�.");
				//�����ϴ� �μ���ȣ�� �����ϰ� �ʹ�.
				try {
					List<Integer> allDeptnolist=us_crud.selectAllCpDeptNo();
					for(Integer i/*������!!*/ : allDeptnolist) {//����Ʈ�� ���� ������ ���ڿ��� �ѹ��� ����� �������.
						allDeptno.append(i.intValue()).append(" ");
//						System.out.println(i.intValue());
					}//end for
					JOptionPane.showMessageDialog(null, inputData+"��ȣ�� �μ��� �������� �ʽ��ϴ�.\n"+"���� �����ϴ� �μ��� "+us_crud.selectAllCpDeptNo()+"�� �Դϴ�.");
					JOptionPane.showMessageDialog(null, allDeptno+"�� �μ��� �����մϴ�.");
				} catch (HeadlessException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}//end catch
				
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �������·� �Է��ϼž� �մϴ�.");
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "DB�������� ������ �߻��߽��ϴ�.");
				e.printStackTrace();
			}//end catch
		}//end if
	}//searchOneCpDept
	
	//DAO����� �ϴµ� Data access object DB�� ���õ� ���� ó�� Ŭ����
	
	public static void main(String[] args) {
		RunUseStatementCRUD rus_crud=new RunUseStatementCRUD();
		
		boolean exitFlag=false;
		String inputMenu="";
		do {
			inputMenu=JOptionPane.showInputDialog("�޴�����\n1.�μ��߰� 2.�μ����� 3.�μ����� 4.��ü�μ���ȸ 5.Ư���μ���ȸ 6.����");
			if (inputMenu!=null/* && !inputMenu.equals("")*/) {
				switch (inputMenu) {//JDK 1.7�̻���� ���ڿ� �� ���� 
				case "1":
					rus_crud.addCpDept();
					break;
				case "2":
					rus_crud.modifyCpDept();
					break;
				case "3":
					rus_crud.removeCpDept();
					break;
				case "4":
					rus_crud.searchAllCpDept();
					break;
				case "5":
					rus_crud.searchOneCpDept();
					break;
				case "6":
					exitFlag=true;
					break;
	
				default:
					JOptionPane.showMessageDialog(null, inputMenu+"�� �����Ǵ� ���񽺰� �ƴմϴ�.");
					break;
				}//end switch
			}else{
				exitFlag=true;
			}//end if
			
		}while(!exitFlag);
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�.");
		
	}//main

}//class