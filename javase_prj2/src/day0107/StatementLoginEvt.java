package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StatementLoginEvt extends WindowAdapter implements ActionListener{

	private StatementLogin sl;
	
	public StatementLoginEvt(StatementLogin sl) {
		this.sl=sl;//has a ����
	}//StatementLoginEvt

	@Override
	public void windowClosing(WindowEvent we) {
		sl.dispose();
	}//windowClosing
	
	public boolean chkNull(String id, String pass) {
		boolean flag=false;
		
		try {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(sl, "���̵�� �ʼ� �Է�");
				sl.getJtfId().requestFocus();
				flag= true;//�Ʒ������� �귯���� �ʰ�...?
				//���ܸ� ������ �߻����� ���̵�� ��й�ȣ�� ������ �ΰ��� â�̶ߴ°��� ���Ҵ�.
				//���ܸ� ������ �߻�!: throw new ����ó�� Ŭ������();
					throw new LoginException();
			}//end if
			if(pass.equals("")) {
				JOptionPane.showMessageDialog(sl, "��й�ȣ�� �ʼ� �Է�");
				sl.getJpfPass().requestFocus();
				flag= true;//�Ʒ������� �귯���� �ʰ�...?
			}//end if
		} catch (LoginException le) {
//			le.printStackTrace();
		}//end catch
		
		return !flag;//���ٸ� false�� ������.return�� �ѹ��� ó���ϴ°� ���� �ڵ�.
	}//chkNull
	
	public String login(String id, String pass) throws SQLException{
		String name="";
		
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection ���
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String dbo_id="scott";
			String dbo_pass="tiger";//�� �ܿ��ش�~!~!!!!
			con=DriverManager.getConnection(url, dbo_id, dbo_pass);
		//3.������ ���� ��ü���
			stmt=con.createStatement();
		//4.���� ������ ��� ���
			StringBuilder selectName=new StringBuilder();
			selectName
			.append(" select name ")
			.append(" from test_login ")
			.append(" where id='").append(blockSqlInjection(id)).append("' and ")
			.append(" pass='").append(blockSqlInjection(pass)).append("'");
			
			rs=stmt.executeQuery(selectName.toString());
			if(rs.next()) {//�Էµ� id�� pass�� �´� �̸��� ���� => �α��� ����
				name=rs.getString("name");
			}//end if
		}finally {
			//5.���� ����
			if(rs!=null) {rs.close();}//end if
			if(stmt!=null) {stmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}//end finally
		
		return name;
	}//login
	
	public String blockSqlInjection(String data) {
		return data.replace(" ", "").replace("'", "").replaceAll("--", "");
	}//blockSqlInjection
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sl.getJtfId() || ae.getSource()==sl.getJpfPass() || ae.getSource()==sl.getJbtLogin()) {
			
			String id=sl.getJtfId().getText().trim();
			String pass=new String(sl.getJpfPass().getPassword()).trim();
			
			if(chkNull(id,pass)) {
				
				try {
					String name=login(id, pass);
					
					if(name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "���̵� ��й�ȣ�� Ȯ���� �ּ���.");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return;
					}//end if
					
//					JOptionPane.showMessageDialog(sl, name+"�� �α��� �ϼ̽��ϴ�.");
					JDialog jd=new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name+"�� �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX()+100, sl.getY()+100, 300, 200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//exit_on~�ƴ�  �ͱ�
					
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(sl, "DB�۾� �� ������ �߻��Ͽ����ϴ�.");
					se.printStackTrace();
				}//end catch
			}//end if
		}//end if
		
		if(ae.getSource()==sl.getJbtCancel()) {
			sl.getJtfId().setText("");
			sl.getJpfPass().setText("");
			sl.getJtfId().requestFocus();
		}//end if
	}//actionPerformed
	
}//class