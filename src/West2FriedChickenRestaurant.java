import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{
     public double balance; //���
     protected ArrayList<Beer> beer ; //ơ���б�
     protected ArrayList<Juice> juice ;//��֭�б�
     static ArrayList<SetMeal> meal;//�ײ��б�
     /*ArrayList�������ݺͶ�ȡ���ݵ��ٶȸ���*/
     public West2FriedChickenRestaurant() {
    	 balance=300; //�������
     }
     
      public West2FriedChickenRestaurant(ArrayList<Juice> juice ,ArrayList<Beer> beer,ArrayList<SetMeal> meal) {  
    	  beer=this.beer;
    	  juice = this.juice;
     }
     
     static{ //���ײ��б��ʼ��
    	 meal=new ArrayList<SetMeal>();
    	 meal.add(new SetMeal ("�ײ�һ","��Ȼը��",new Beer("ѩ��", 3.0 ,LocalDate.now(), 30, 3.8f),40.0));
    	 meal.add(new SetMeal("�ײͶ�","����ը��",new Beer("�ൺ", 2.5 ,LocalDate.now(), 30, 2.8f),40.0));
    	 meal.add(new SetMeal("�ײ���","��Ȼը��",new Juice("��֭", 5.0 ,LocalDate.now(), 2),42.0));
    	 meal.add(new SetMeal("�ײ���","����ը��",new Juice("Ҭ֭", 6.0 ,LocalDate.now(), 2),43.0));
    	 System.out.println("ը����˵���");
    	 for(int i=0;i<meal.size();i++) {
    	     
    		 System.out.println(meal.get(i));	
    	 }
     }
     
     Scanner sc = new Scanner(System.in);
     int temp=0;
     int temp1=0;
     
     public void FriedChickenRestaurant() { //ʵ��ը����ӿڣ���������ͽ����Ĺ���
    	 System.out.println("1.�����ײ�     2.��������  3.�˳�:");
    	 System.out.println("������ȷ�ϲ���:");
          int i = sc.nextInt();
          switch (i) {
              case 1:   
                  sold(meal);
                  break;
              case 2:
            	  purchase(balance);
                  break;
              case 3:
                  System.out.println("�˳�");
                  break;

          }
     }

	
	@Override
	public void sold(ArrayList<SetMeal> meal) { //�����ײ�
		System.out.println("�������������ײ���:");
		String str=sc.next();
		for(int i= 0;i<meal.size();i++) {
                if(meal.get(i).mealName.equals(str)) {
                	meal.remove(i);
                	temp=i;
                	System.out.println("���۳ɹ���");
                	break;
                	}
        	       }
    	}
	
	public void use(Beer beer1) throws IngredientSortOutException{ //˽�з������ı�ơ�ƿ��
	   ArrayList<Beer> beer= new ArrayList<Beer>();
	   beer.add(new Beer("ѩ��", 3.0 ,LocalDate.now(), 30, 3.8f));
       beer.add(new Beer("�ൺ", 2.5 ,LocalDate.now(), 30, 2.8f));
       String set=meal.get(temp).getBeverage().name;
       try {
    	   for(int i=0;i<beer.size();i++) {
    		   temp1=i;
    		   System.out.println(i);
    		   if(beer.get(i).name.equals(set)==true) {
    			   beer.remove(i-1);
    			   System.out.println("�����Ͽ���Ѹ���");
    			  break;
    		   }
    		  
    	   }
       }
       catch(IngredientSortOutException e){
    	   System.out.println(e.getMessage());
    	   System.out.println("���������ۿ�");
    	   
       }
		}
	
	public void use(Juice juice1) throws IngredientSortOutException{ //˽�з������ı��֭���
		   ArrayList<Juice> juice= new ArrayList<Juice>();
		   juice.add(new Juice("��֭", 5.0 ,LocalDate.now(), 2));
	       juice.add(new Juice("Ҭ֭", 6.0 ,LocalDate.now(), 2));
			try {
	    	   for(int i=0;i<juice.size();i++) {
	    		   Juice b=juice.get(i);
	    		   if((meal.get(temp).getBeverage().name).equals(b.name)==true) {
	    			   juice.remove(i-1);
	    			   System.out.println("�����Ͽ���Ѹ���");
	    			   break;
	    		   }
	    	   }
	       }
	       catch(IngredientSortOutException e){
	    	   System.out.println(e.getMessage());
	    	   System.out.println("���������ۿ�");
	       }
			}
	
	

	@Override
	public void purchase(double balance) throws OverdraftBalanceException{ //��������
		West2FriedChickenRestaurant wt=new West2FriedChickenRestaurant();
		balance=wt.balance;
		System.out.println("��Ʒ���ƣ�");
		String name=sc.next();
		System.out.println("�۸�");
		double cost=sc.nextDouble();
		System.out.println("�������ڣ�");
		String data=sc.next();
		LocalDate bDate;
		try {
			bDate = LocalDate.parse(data);
		}catch(Exception e) {
			System.out.println("��ʽ����");
			return;
		}
		System.out.println("�Ƿ��оƾ�����/��");
		String b=sc.next();
		Beer b1=new Beer();
		Juice j=new Juice();
		Drinks drink = null;
		float alcohol = 0;
	
		if(b.contentEquals("��")) { //�ж���������
			System.out.println("������");
			alcohol=sc.nextFloat();
			drink=new Beer(name, cost, bDate, b1.getPeriod(),alcohol);
			System.out.println("���빺��������");
			int n=sc.nextInt();
			balance=balance-(cost*n);
		}
		if(b.contentEquals("��")) {
			System.out.println("���빺��������");
			drink=new Juice(name, cost, bDate, j.getPeriod());
			int n=sc.nextInt();
			balance=balance-(cost*n);
			
		}
	     
		if (balance <0) { //�жϽ����Ƿ�ɹ�����������ֵ
		    throw new OverdraftBalanceException("���㣬����ʧ��    "+"��ֵΪ��"+balance*(-1)); 
		    } else { 
		    	if(drink instanceof Beer && drink.overdue(bDate, b1.getPeriod())==false) {
					beer.add(new Beer(name, cost, bDate, b1.getPeriod(),alcohol)); 
				    System.out.println("�����ɹ�");
					System.out.println("���Ϊ��"+balance);
				    
				}
				 if(drink instanceof Juice && drink.overdue(bDate, j.getPeriod())==false) {
					juice.add(new Juice(name, cost, bDate, j.getPeriod()));
					 System.out.println("�����ɹ�");
					 System.out.println("���Ϊ��"+balance);
				}
				 
				 else {
					System.out.println("��Ʒ���ڣ�����ʧ��");
				}
		    }
	}
		    
	
	public static void main(String[] args) {
		System.out.println("ը�������ϵͳ");
		ArrayList<Juice> juice=new ArrayList<Juice>();
		ArrayList<Beer> beer=new ArrayList<Beer>();
		West2FriedChickenRestaurant west=new West2FriedChickenRestaurant(juice, beer, meal);
		west.FriedChickenRestaurant();
		Beer beer1 = null;
		Juice juice1 = null;
		west.use(juice1);
	}
  
}
