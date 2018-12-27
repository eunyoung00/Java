package day1221;

import java.io.File;

public class Test {
	
	public static void main(String[] args) {
		String s= "c:/dev/temp/java_read.txt";
		File file=new File(s);
		//Lastindexof....
		
		System.out.println(s+"/"+file);
		String[] name=s.split(".");
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]);
		}
//		System.out.println(name[0]+"_bak."+name[1]);
		
		StringBuilder sb=new StringBuilder(s);
		System.out.println(sb.insert(sb.lastIndexOf("."),"_bak"));
		
	}//main
}//class
