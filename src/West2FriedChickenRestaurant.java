import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{
     public double balance; //余额
     protected ArrayList<Beer> beer ; //啤酒列表
     protected ArrayList<Juice> juice ;//果汁列表
     static ArrayList<SetMeal> meal;//套餐列表
     /*ArrayList搜索数据和读取数据的速度更快*/
     public West2FriedChickenRestaurant() {
    	 balance=300; //设置余额
     }
     
      public West2FriedChickenRestaurant(ArrayList<Juice> juice ,ArrayList<Beer> beer,ArrayList<SetMeal> meal) {  
    	  beer=this.beer;
    	  juice = this.juice;
     }
     
     static{ //对套餐列表初始化
    	 meal=new ArrayList<SetMeal>();
    	 meal.add(new SetMeal ("套餐一","孜然炸鸡",new Beer("雪花", 3.0 ,LocalDate.now(), 30, 3.8f),40.0));
    	 meal.add(new SetMeal("套餐二","香辣炸鸡",new Beer("青岛", 2.5 ,LocalDate.now(), 30, 2.8f),40.0));
    	 meal.add(new SetMeal("套餐三","孜然炸鸡",new Juice("橙汁", 5.0 ,LocalDate.now(), 2),42.0));
    	 meal.add(new SetMeal("套餐四","香辣炸鸡",new Juice("椰汁", 6.0 ,LocalDate.now(), 2),43.0));
    	 System.out.println("炸鸡店菜单：");
    	 for(int i=0;i<meal.size();i++) {
    	     
    		 System.out.println(meal.get(i));	
    	 }
     }
     
     Scanner sc = new Scanner(System.in);
     int temp=0;
     int temp1=0;
     
     public void FriedChickenRestaurant() { //实现炸鸡店接口，完成售卖和进货的管理
    	 System.out.println("1.出售套餐     2.批量进货  3.退出:");
    	 System.out.println("请输入确认操作:");
          int i = sc.nextInt();
          switch (i) {
              case 1:   
                  sold(meal);
                  break;
              case 2:
            	  purchase(balance);
                  break;
              case 3:
                  System.out.println("退出");
                  break;

          }
     }

	
	@Override
	public void sold(ArrayList<SetMeal> meal) { //出售套餐
		System.out.println("请输入卖出的套餐名:");
		String str=sc.next();
		for(int i= 0;i<meal.size();i++) {
                if(meal.get(i).mealName.equals(str)) {
                	meal.remove(i);
                	temp=i;
                	System.out.println("出售成功！");
                	break;
                	}
        	       }
    	}
	
	private void use(Beer beer1) throws IngredientSortOutException{ //私有方法，改变啤酒库存
	   ArrayList<Beer> beer= new ArrayList<Beer>();
	   beer.add(new Beer("雪花", 3.0 ,LocalDate.now(), 30, 3.8f));
       beer.add(new Beer("青岛", 2.5 ,LocalDate.now(), 30, 2.8f));
       String set=meal.get(temp).getBeverage().name;
       try {
    	   for(int i=0;i<beer.size();i++) {
    		   temp1=i;
    		   System.out.println(i);
    		   if(beer.get(i).name.equals(set)==true) {
    			   beer.remove(i-1);
    			   System.out.println("该饮料库存已更改");
    			  break;
    		   }
    		  
    	   }
       }
       catch(IngredientSortOutException e){
    	   System.out.println(e.getMessage());
    	   System.out.println("该饮料已售空");
    	   
       }
		}
	
	private void use(Juice juice1) throws IngredientSortOutException{ //私有方法，改变果汁库存
		   ArrayList<Juice> juice= new ArrayList<Juice>();
		   juice.add(new Juice("橙汁", 5.0 ,LocalDate.now(), 2));
	       juice.add(new Juice("椰汁", 6.0 ,LocalDate.now(), 2));
			try {
	    	   for(int i=0;i<juice.size();i++) {
	    		   Juice b=juice.get(i);
	    		   if((meal.get(temp).getBeverage().name).equals(b.name)==true) {
	    			   juice.remove(i-1);
	    			   System.out.println("该饮料库存已更改");
	    			   break;
	    		   }
	    	   }
	       }
	       catch(IngredientSortOutException e){
	    	   System.out.println(e.getMessage());
	    	   System.out.println("该饮料已售空");
	       }
			}
	
	

	@Override
	public void purchase(double balance) throws OverdraftBalanceException{ //批量进货
		ArrayList<Juice> juice= new ArrayList<Juice>();
		ArrayList<Beer> beer= new ArrayList<Beer>();
		West2FriedChickenRestaurant wt=new West2FriedChickenRestaurant();
		balance=wt.balance;
		System.out.println("商品名称：");
		String name=sc.next();
		System.out.println("价格：");
		double cost=sc.nextDouble();
		System.out.println("生产日期：");
		String data=sc.next();
		LocalDate day;
		try {
			day = LocalDate.parse(data);
		}catch(Exception e) {
			System.out.println("格式有误");
			return;
		}
		System.out.println("是否含有酒精（是/否）");
		String b=sc.next();
		Beer b1=new Beer();
		Juice j=new Juice();
		Drinks drink = null;
		float alcohol = 0;
	
		if(b.contentEquals("是")) { //判断饮料种类
			System.out.println("度数：");
			alcohol=sc.nextFloat();
			drink=new Beer(name, cost, day, b1.getPeriod(),alcohol);
			System.out.println("输入购买数量：");
			int n=sc.nextInt();
			balance=balance-(cost*n);
			if(balance>=0) {
				//beer.add(new Beer(name, cost, day, b1.getPeriod(),alcohol));
				//System.out.println(beer);
			}
		}
		if(b.contentEquals("否")) {
			System.out.println("输入购买数量：");
			drink=new Juice(name, cost, day, j.getPeriod());
			int n=sc.nextInt();
			balance=balance-(cost*n);
			if(balance>=0) {
				//juice.add(new Juice(name, cost, day, j.getPeriod()));
				//System.out.println(juice);
			}
			
		}
		
		if (balance <0) { //判断进货是否成功，输出余额或差值
		    throw new OverdraftBalanceException("余额不足，进货失败    "+"差值为："+balance*(-1)); 
		    } else { 
		    	if(drink instanceof Beer && drink.overdue(day, b1.getPeriod())==false) {
					beer.add(new Beer(name, cost, day, b1.getPeriod(),alcohol)); 
				    System.out.println("进货成功");
					System.out.println("余额为："+balance);
				    
				}
				 if(drink instanceof Juice && drink.overdue(day, j.getPeriod())==false) {
					
					 juice.add(new Juice(name, cost, day, j.getPeriod()));
					 System.out.println("进货成功");
					 System.out.println("余额为："+balance);
				}
				 
				 if(drink.overdue(day, j.getPeriod())==true) {
					System.out.println("商品过期，进货失败");
				}
		    }
	}
		    
}
