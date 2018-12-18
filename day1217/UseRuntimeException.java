package day1217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JVM이 자동으로 예외를 처리해 주는 RuntimeException
 * @author owner
 */
public class UseRuntimeException {

	public static void main(String[] args) {

		//1.JTextArea 생성( 행수, 컬럼수)
		JTextArea jta = new JTextArea(10,40);
		jta.setEditable(false);
		jta.append("wow");
		//2.
		JScrollPane jsp=new JScrollPane(jta);
		//3.MessageDialog의 두번쨰 매개변수에 컴포넌트를 할당
		JOptionPane.showMessageDialog(null, jsp);
		
		try {
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int result =0;
		
		result = num1/num2;
		
		System.out.println(num1+"/"+num2+"="+result);
		
		}catch (ArrayIndexOutOfBoundsException aioobe) {
//			System.err.println("배열의 인덱스가 잘못되었습니다.");//err로 바꾸면 글씨가 빨간색으로 출력된다.
			System.err.println("ㅈㅅㅈㅅ... 잘못되었습니다.");//err로 바꾸면 글씨가 빨간색으로 출력된다.
			System.err.println("예외의 이유 : "+aioobe.getMessage());//1이 어쨌다는건지 알수 없다...
			System.err.println("예외처리 클래스명과 이유 : "+aioobe);
			aioobe.printStackTrace();//매우 자세한 예외 
			
		}catch (NumberFormatException nfe) {
			System.err.println("입력값이 숫자 형태가 아닙니다.");
			System.err.println("예외의 이유 : "+nfe.getMessage());
			System.err.println("예외처리 클래스명과 이유 : "+nfe);
			nfe.printStackTrace();
		}catch (ArithmeticException ae) {
			System.err.println("0으로 나눌 수 없습니다.");
			ae.printStackTrace();
		
		}catch (Exception e) {
			System.err.println("개발자가 인지하지 못한 예외."); //모든예외를 잡는다..!
			e.printStackTrace();
		}//<왜 예외를 각각처리하게 만들었냐면 : 예외가 발생했을때마다 식별해서 다르게 처리하려고..
		finally {
			System.out.println("반드시 실행되어야 할 코드");
		}
		
		//총 에러는3개가 있는데,
		// java.lang.ArrayIndexOutOfBoundsException: 0  =>런타임에러 try catch 안해도 됨.
		// java.lang.NumberFormatException: For input string: "사"   =>프린트스텍트레이스에 의해 자세히 나오는것.
		// java.lang.ArithmeticException: / by zero =>
		
	}//main

}//class