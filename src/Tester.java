import java.util.Scanner;

public class Tester {
     public static void main(String[] args) throws InterruptedException {
    	 Scanner scanner = new Scanner(System.in);
    	 int x = scanner.nextInt();
    	 
    	 for(int i = 0; i<10;i++) //将1~1000000000分为十组
    		{
    		 Multithreading m = new Multithreading(i*100000000+1,i*100000000+100000000,x);
    		 m.start();
    		 m.join();
    		}
    	 Thread.sleep(50);
    	 System.out.println("1~1000000000中含有"+x+"的数字的总和："+Multithreading.sum);
	}

}
