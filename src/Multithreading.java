 class Multithreading extends Thread{
	 static Object object = new Object();
	 static long sum; //������ӽ��
     private long begin; //��Сֵ
	 private long end; //���ֵ
	 private int x; //�����x
	 
  public  Multithreading(int begin, int end,int x) {
    	this.begin=begin;
    	this.end=end;
    	this.x=x;
    }

 public void run() {
	 long ans=0;
	 for (long i = begin; i <=end; i++) { //���ÿ�麬��x�����ֵĺ�
		 if (String.valueOf(i).contains(String.valueOf(x))==true) //�ж��Ƿ�������x
			 ans += i;
		 }
	 add(ans);
	 }
   synchronized static void add(long ans) {
		sum += ans; //����ܺ�
	}
 
 
 
 }
         
		


 
 
 
 
 
 
 
