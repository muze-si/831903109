 class Multithreading extends Thread{
	 static Object object = new Object();
	 static long sum; //保存相加结果
     private long begin; //最小值
	 private long end; //最大值
	 private int x; //输入的x
	 
  public  Multithreading(int begin, int end,int x) {
    	this.begin=begin;
    	this.end=end;
    	this.x=x;
    }

 public void run() {
	 long ans=0;
	 for (long i = begin; i <=end; i++) { //求出每组含有x的数字的和
		 if (String.valueOf(i).contains(String.valueOf(x))==true) //判断是否含有数字x
			 ans += i;
		 }
	 add(ans);
	 }
   synchronized static void add(long ans) {
		sum += ans; //求出总和
	}
 
 
 
 }
         
		


 
 
 
 
 
 
 
