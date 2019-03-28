package xml0327;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AttParsing {

	public List<AttVO> personData(String lastName) throws MalformedURLException, JDOMException, IOException{
		List<AttVO> list=new ArrayList<AttVO>();
		
		//1.Builder ���� =>(Parser)
		SAXBuilder builder=new SAXBuilder();
		//2.xml�б�
		Document doc=builder.build(new URL("http://localhost:8080/jsp_prj/xml0327/att.xml"));
		//3.�ֻ��� �θ��� ���->persons node
		Element rootNode=doc.getRootElement();
		//4.ó�� �ڽ� ���� ���->person
		Iterator<Element> personNodes=rootNode.getChildren().iterator();
		//5.�� ��� person node�� �ݺ�
		Element personNode=null;
		Attribute lastAtt=null; //lastName�Ӽ��� ����
		Attribute cityAtt=null; //city�Ӽ��� ����
		Attribute zipcodeAtt=null; //zipcode�Ӽ��� ����
		String lastNameAtt="";
		
		Iterator<Element> personSubNodes=null;
		Element someNode=null; //person�� �ڽĳ��� �ޱ�(name,address)
		
		AttVO avo=null;
		
		while(personNodes.hasNext()) { //personNodes��� �ݺ���Ų��.
			personNode=personNodes.next(); //�ݺ����� personNodes�ϳ� ���
			//person�� �ڽ� ������ ���->name,address
			personSubNodes=personNode.getChildren().iterator();
			while(personSubNodes.hasNext()) {
				someNode=personSubNodes.next();//name,address
				
				//�Էµ� ������ ���� �����ؾ� �ϹǷ� ������ �ִ� nameNode�� ��.
				if("name".equals(someNode.getName())) {
					lastAtt=someNode.getAttribute("lastName"); //���� �Ӽ� ���
					lastNameAtt=lastAtt.getValue(); //�Ӽ� �� ���
					//System.out.println(lastNameAtt);//�������
					if(lastName.equals(lastNameAtt)) { //�达�϶��� (name��� ������ ��=��)
						avo=new AttVO(); //���� ������ VO�� ���� �ϰ�
						avo.setFirstName(someNode.getValue()); //getValue()=getText() //�̸���
						avo.setLastName(lastNameAtt); //���� �߰�
					}//end if
				}//end if
				
				if(lastName.equals(lastNameAtt)) { //�Ű������� �Էµ� ������ ���� ��
					if("address".equals(someNode.getName())) { //address ��� ���
						cityAtt=someNode.getAttribute("city"); //city�Ӽ� ���
						zipcodeAtt=someNode.getAttribute("zipcode"); //zipcode�Ӽ� ���
						
						avo.setCity(cityAtt.getValue());//������ VO�� city��
						avo.setZipcode(zipcodeAtt.getValue());//address ��
						avo.setAddress(someNode.getText());//��� ������ �� �߰�.
						list.add(avo); //������ ��ġ������ parsing�� ���� ���� ��ü�� list�� �߰�
					}//end if
				}//end if
				
			}//end while
		}//end while
		
		return list;
	}//personData
	
	/*xml���� ��Ī�� �߿�!
	public static void main(String[] args) {
		AttParsing a=new AttParsing();
		try {
			//a.personData("��");
			System.out.println(a.personData("��"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
*/
}//class