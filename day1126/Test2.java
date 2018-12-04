package day1126;

public class Test2 {
	
	public void swap(int i, int j){
        int temp=0;
        temp = i;
        i=j;
        j=temp;
    System.out.println("i="+i+",j="+j);//300 100
    }

	public static void main(String[] args) {
        int i=100,j=300;
        System.out.println(i+" "+j);//100 300
        Test2 t = new Test2();
        t.swap(i,j);
        System.out.println(i+" "+j);
    }//main
//	100 300
//	i=300,j=100
//	100 300
//call by value



	
}//class
