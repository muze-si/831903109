import java.util.Scanner;

public class Tester {
     public static void main(String[] args) throws InterruptedException {
    	 Scanner scanner = new Scanner(System.in);
    	 int x = scanner.nextInt();
    	 
    	 for(int i = 0; i<10;i++) //��1~1000000000��Ϊʮ��
    		{
    		 Multithreading m = new Multithreading(i*100000000+1,i*100000000+100000000,x);
    		 m.start();
    		 m.join();
    		}
    	 Thread.sleep(50);
    	 System.out.println("1~1000000000�к���"+x+"�����ֵ��ܺͣ�"+Multithreading.sum);
	}

}
