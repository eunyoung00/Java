package day0403;

public class DeptVO {
	//�ƹ��� �������¶� ���� �ٸ��� �Ǹ����� �Ѵ�.(���� ���ó�� �ٸ���!)
	private int deptno;
	private String dname,loc;
	
	public DeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}//�����ִ� �����ڸ� ���� ����-���� ���� �ϴ� ��찡 �ֱ� ����!!insert/update!!
	
	//���޸��ϸ�Ǽ� getter��
	public int getDeptno() {
		return deptno;
	}
	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}
}
