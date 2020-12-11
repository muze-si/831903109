import java.time.LocalDate;
public abstract class Drinks { //创建Drinks类
    protected String name; //名字
    protected double cost; //价格
    protected LocalDate manufacture;//生产日期
    protected int period;//保质期
    
    //构造
   public Drinks() {
	   name="";
	   cost=0.0;
	   manufacture=null;
	   period=0;
   }
    
    public Drinks(String name, double cost, LocalDate manufacture,int period) {
	this.name=name;
	this.cost=cost;
	this.manufacture=manufacture;
	this.period=period;
}

public void setName(String name){
	this.name=name;
}

public void setCost(double cost){
	this.cost=cost;
}

public void setManufacture(LocalDate manufacture){
	this.manufacture=manufacture;
}

public void setPeriod(int period){
	this.period=period;
}

public String getName(){  
	return this.name;
}

public double getCost() { 
   return this.cost;
}

public LocalDate getManufacture() { 
  return this.manufacture;
}

public int getPeriod() { 
	  return this.period;
	}


public boolean overdue( LocalDate manufacture, int period) { //判断是否过期
	LocalDate nowDate = LocalDate.now();
	manufacture = manufacture.plusDays(period);
	if(manufacture.isBefore(nowDate) || manufacture.isEqual(nowDate)) {
		return true;
	}
	else if(manufacture.isAfter(nowDate)) {
		return false;
	}
	return false;
	}

public abstract String toString(); //toString抽象方法
	 
}
