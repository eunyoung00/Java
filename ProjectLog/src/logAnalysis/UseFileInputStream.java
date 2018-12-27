package logAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
/*import java.io.FileNotFoundException;*/
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * HDD에 존재하는 File과 연결하여 그 내용을 읽어들일때 사용하는 FileInputStream
 * @author owner
 */
public class UseFileInputStream {
	
	public UseFileInputStream() throws IOException/*,FileNotFoundException는 왜 안해도 될까?*/{
		File file=new File("C:/dev/01.group_prj1/sist_input_1.log");
		if(file.exists()) {
			BufferedReader br=null;
			try {
				//8bit인 FileInputStream이라서 
				//한글이 깨진다..=>16bit와 연결하여 잘뜨게 만들예정(12-20)
//				//스트림을 생성하여 JVM에서 HDD의 파일과 연결.
//				FileInputStream fis=new FileInputStream(file);
//				int temp=0;
//				
//				while((temp=fis.read())!=-1) {//읽어들인 내용이 존재한다면 
//					System.out.print((char)temp);//1byte씩읽어들여 한글이 깨진다.
//				}//end while
//				//스트림 사용을 완료 했으면 스트림을 끊어서 메모리 누수를 막는다.
//				fis.close();
				
				///////////////12-20-2018 코드 추가/////////////////////
				//8bit stream과 16bit stream연결 : 한글이 깨지는 문제 해결.
//				FileInputStream fis=new FileInputStream(file);//파일과 연결
//				InputStreamReader isr=new InputStreamReader(fis);//8bit+16bit연결
//				br=new BufferedReader(isr);//속도개선, 줄단위 읽기
				//buffer가 들어가면은 속도개선,next()는 포인터
				
				//위의 3줄을 한줄로~!
				br=new BufferedReader(new InputStreamReader(
										new FileInputStream(file)));
				StringTokenizer stk;
				String temp="";
				int idx=0;
				while((temp=br.readLine())!=null) {
					//줄단위(\n전까지)로 읽어들여서 읽어들인 내용이 있다면
					System.out.println("["+idx+"]["+temp);//console에 출력
					stk=new StringTokenizer(temp, "][",false);
					System.out.println(stk.nextToken());//200
					System.out.println(stk.nextToken());//http
					System.out.println(stk.nextToken());//ie
					System.out.println(stk.nextToken());//2018~
					idx++;
				}//end while
//				br.close();	//반드시 연결을 종료.(warning이 뜬다)
				
				//가지는 문제????????
				//지금은 없는데 잠재적인 문제는~! 연결종료가 안될수도 있다는게 문제
				//readLine에서 예외가 발생했을때 연결된 상태인데 close가 안된다는게 문제다!
				//close가 안되기 때문!!따라서 성공하든 실패하던 꼭수행하는 쪽으로 ㄱㄱ
				
//			}catch (FileNotFoundException e) {//FileInputStream
//				e.printStackTrace();//예외가 터져서 들어온거지 처리가 된상태는 아님.
//			}catch (IOException e) {//readLine,close()
//				e.printStackTrace();
			}finally {
//				try {
					if(br!=null) {br.close();}
					//br이 생성되지 않았을때 nullpointerException발생할수 있어if로 조건.
//				} catch (IOException e) {
//					e.printStackTrace();
//				}//end catch
			}//end catch
		}else {
			System.out.println("경로나 파일명을 확인하세요.");
		}//end else
	}//UseFileInputStream
	
	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
