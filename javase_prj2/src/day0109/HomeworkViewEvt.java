package day0109;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class HomeworkViewEvt extends WindowAdapter implements ActionListener{

	private HomeworkView hv;
	private JTextArea qv;
	private StringBuilder totalsql;
	private HomeworkDAO hdao;
	
	public HomeworkViewEvt(HomeworkView hv) {
		this.hv = hv;
		qv=hv.getJtaQueryView();
		totalsql=new StringBuilder();
		hdao=new HomeworkDAO(hv);
	}//HomeworkViewEvt

	@Override
	public void windowClosing(WindowEvent we) {
		hv.dispose();
	}//windowClosing
	
	boolean conflag=false;
	boolean tabflag=false;
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==hv.getJbtAddtab()) {
			addTable();
		}//end if
		
		if(ae.getSource()==hv.getJbtAddConst()) {
			addConstraint();
		}//end if
		if(ae.getSource()==hv.getJbtCreate()) {
			try {
				hdao.createTable();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//end if
		if(ae.getSource()==hv.getJbtReset()) {
			qv.setText("");
			totalsql.delete(0,totalsql.length());
			tabflag=false;
			conflag=false;
		}//end if
	}//actionPerformed
	
    public boolean chkNull(String str) {
        boolean sqlflag=false;
        if(str.equals("")) {
            JOptionPane.showMessageDialog(hv, "�� ĭ�� �Է��� �ּ���.");
            sqlflag= true;//�Ʒ������� �귯���� �ʰ�...?
        }//end if
        return !sqlflag;//""��� false �ΰ�
    }//chkNull
    
    public void addTable() {
    	if(chkNull(hv.getJtftabName().getText())) {//null�� �ƴ϶��
			StringBuilder sqlcreate=new StringBuilder();
			sqlcreate.append("Create table ").append(hv.getJtftabName().getText()).append("(\n");
			totalsql.append(sqlcreate.toString());
			qv.setText(totalsql.toString());
			tabflag=true;
		}//end if
    }//addTable
    
    public void addConstraint() {
    	StringBuilder sqlColumns=new StringBuilder();
		if(!tabflag) {
			JOptionPane.showMessageDialog(hv, "���̺��� �������ּ���");
			return;
		}
		//��ĭ ��� �̸� ũ�� ������� �� 
		//��������� primarykey�� unique�϶� �̸��� �ް� �ƴϸ� �Է¸������ �߰�
		
		//date�� �ȹް� 
		//number���ų� 22���� 	
		if(chkPrimary(totalsql.toString())) {
			if(chkNull(hv.getJtfcolName().getText())) {//null�� �ƴ϶��
				if(conflag) {//�ѹ� �������� ,\n�� �� �տ� �߰��ȴ�.
					sqlColumns.append(",\n");
					//System.out.println(totalsql);//sqlColumns�� ���������̶� ;�� ����!!
					totalsql.delete(totalsql.lastIndexOf(");")-1 ,totalsql.length());
				}//end if
	
//				sqlColumns.append("   ").append(hv.getJtfcolName().getText()).append(" ");
				try {
					switch (hv.getJcbDataType().getSelectedItem().toString()) {

					case "varchar2":
						if(chkNull(hv.getJtfcolsize().getText())) {
							if(0<Integer.parseInt(hv.getJtfcolsize().getText()) && Integer.parseInt(hv.getJtfcolsize().getText())<4000){
								sqlColumns.append("  ").append(hv.getJtfcolName().getText()).append(" ");
								sqlColumns
								.append(hv.getJcbDataType().getSelectedItem()).append(" (")
								.append(hv.getJtfcolsize().getText()).append(") ");
							}//end if
						}//end if
						break;
					case "number":
						if(chkNull(hv.getJtfcolsize().getText())) {
							if(0<Integer.parseInt(hv.getJtfcolsize().getText()) && Integer.parseInt(hv.getJtfcolsize().getText())<22){
								sqlColumns.append("  ").append(hv.getJtfcolName().getText()).append(" ");
								sqlColumns
								.append(hv.getJcbDataType().getSelectedItem()).append(" (")
								.append(hv.getJtfcolsize().getText()).append(") ");
							}//end if
						}//end if
						break;
					case "char":
						if(0<Integer.parseInt(hv.getJtfcolsize().getText()) && Integer.parseInt(hv.getJtfcolsize().getText())<2000){
							sqlColumns.append("  ").append(hv.getJtfcolName().getText()).append(" ");
							sqlColumns
							.append(hv.getJcbDataType().getSelectedItem()).append(" (")
							.append(hv.getJtfcolsize().getText()).append(") ");
						}//end if
						break;
					case "date":
						if(hv.getJtfcolsize().getText().equals("")){
							sqlColumns.append("  ").append(hv.getJtfcolName().getText()).append(" ");
							sqlColumns
							.append(hv.getJcbDataType().getSelectedItem()).append(" ");
						}else {
							JOptionPane.showMessageDialog(hv, "date�� ũ�Ⱑ �����ϴ�.");
						}
						break;
					default:
						JOptionPane.showMessageDialog(hv, "");
						break;
					}
				//���� ũ�Ⱑ ���ڰ� �ƴ϶��
				}catch (NumberFormatException nbfe) {
					JOptionPane.showMessageDialog(hv, "�÷��� ũ��� 0���� 4000�Դϴ�.");
				}//end catch
				
//				sqlColumns
//				.append(hv.getJcbDataType().getSelectedItem()).append(" (")
//				.append(hv.getJtfcolsize().getText()).append(") ");
				
				if(hv.getJcbConstraint().getSelectedItem()=="primary key"||hv.getJcbConstraint().getSelectedItem()=="unique") {
//					sqlColumns.append("constraint ").append(hv.getJtfConstraintName().getText()).append(" ")
//								.append(hv.getJcbConstraint().getSelectedItem()).append("\n);");
					sqlColumns.append(addPrimaryUnique());
				}else {
					sqlColumns.append(hv.getJcbConstraint().getSelectedItem()).append("\n);");
				}
			
			totalsql.append(sqlColumns.toString());
			qv.setText(totalsql.toString());
			conflag=true;
			}//end if
		}//end if
		
    }//addConstraint
    
    public boolean chkPrimary(String str) {
    	boolean prflag=false;
		if(hv.getJcbConstraint().getSelectedItem()=="primary key") {
			prflag=str.toString().contains("primary key");//���� �����Ѵٸ� true
		}//end if
		if(prflag) {
			JOptionPane.showMessageDialog(hv, "primary key�� �����մϴ�.");
		}//end if
		return !prflag;
    }
    
    public String addPrimaryUnique() {
    	String str="";
    	if(hv.getJcbConstraint().getSelectedItem()=="primary key"||hv.getJcbConstraint().getSelectedItem()=="unique") {
			str="constraint " +hv.getJtfConstraintName().getText()+" "+hv.getJcbConstraint().getSelectedItem()+"\n);";
    	}//end if
    	return str;
    }//addPrimaryUnique
    
    public String addNull() {
    	String str="";
    	str=hv.getJcbConstraint().getSelectedItem()+"\n);";
    	return str;
    }//addNull

}//class
