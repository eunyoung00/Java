package day1203;

/**
 * ����� ���� Ư¡�� �θ�(Person)�� ���� ����ϰ� �ڽŸ��� Ư¡��(�ο��� ����)����.
 * @author owner
 */
public class HongGilDong extends Person{
	private int level;//Ȧ�浿�� �ο� ����
	
	/**
	 * ȫ�浿�� �ο��� ��κ��� ���ϹǷ� 7�� ����
	 */
	public HongGilDong() {
		super();
		level=7;
		
	}//HongGilDong
	
	/**
	 * �ο��ϴ� �� : �Էµ� �������� ���ٸ� �й�, �Էµ� �������� ���ٸ� �¸�, �Էµ� ������ ���ٸ� ���<br>
	 * �¸��ϸ� ������ 1����, �й��ϸ� ������ 1����, ���� ������ȭ ����.
	 * ������ �ִ� 10, �ּ� 0�� ������.
	 * @param inputLevel �ο� ������� ����
	 * @return �ο��� ���
	 */
	public String fight(int inputLevel) {
		String result="";
		
		if(level>inputLevel) {//�¸�
			result="�̰��. s('.^)V";
			level++;
			if(level>10) {
				level=10;
			}//end if
		}else if(level<inputLevel) {//�й�
			result = "����.Orz  ~(_-_)~";
			level--;
			if(level <1) {
				level=1;
			}//end if
		}else {//���
			result="��� --+;;";
		}//end else
		
		
		return result;
	}//fight
	
	@Override	//�����Ϸ����� ���. annotation.
	public String toString() {
		//�߸��ϸ� ���鶧�� �𸣰� �����ؾ� �˰� �ȴ�.
		//�̶��� method���� annotation�ִ°�
		//�߸������� Error�� ��� ��.
		return "ȫ�浿 ��ü�� �� �� : "+getEye()+", ��: "+getNose()+", ��: "+getMouth();
	}//toString
	
	/* (non-Javadoc)
	 * @see day1129.Person2#eat(java.lang.String, int)
	 */
	/**
	 * �θ�Ŭ������ �����ϴ� method�� ����� �ڽĿ��� �����ʾ�<br>
	 * ����� �Ĵ� -&gt; �ָ� ���� ����.<br>
	 * ȭ�������  ��-&gt; �� ���� ����.
	 *  (non-Javadoc)
	 * @see day1129.Person2#eat(java.lang.String, int)
	 */
	@Override
	public String eat(String menu, int price) {	//�ϳ��� Ʋ���� ����ش�.
		return getName()+"�� �ָ����� "+menu+"�� ������ "+price+"�� ���� ��Դ´�.";
	}//eat

	@Override
	public String eat() {
		return getName()+"�� ������ ���� �Դ´�.";
	}//eat

//	@Override
//	public String[] language(String lang) {
		
////		return "�ѱ���, �߱���, ��ȭ".split(",");
//
//		String[] tempLang=getLanguage();
//		
//		int idx=0;
//
//		for(int i=0; i<tempLang.length; i++) {
//			if(lang.equals(tempLang[i])) {
//				idx++;
//			}//end if
//		}//end if
//		
//		tempLang[idx] = lang;
//		return tempLang;
//		String[] lang = {"����","�ܰ��"};
		
		
//		String[] tempLang=getLanguage();
//		
//		int idx=0;
//		for(int i=0; i<tempLang.length; i++) {
//			if(tempLang[i] != null) {
//				//������ �� �����Ѵٸ� �����ε����� ��´�.
//				if(lang.equals(tempLang[i])) {
//					//�Էµ� �� �̹� ������ ����� �ݺ����� �������� �ش�濡 ����� �ִ� �ε����� ������.
//					break;
//				}//end if
//				idx++;
//			}//end if
//		}//end if
//		//������ �߰��ǰ� �ִٸ� �����. : upsert
//		tempLang[idx] = lang;
//		return tempLang;
//	}//language
	
	
	
	
}//class
