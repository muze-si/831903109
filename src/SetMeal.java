public class SetMeal { //创建SetMeal类
	public String mealName;//套餐名
	public double price;//价格
	public String chickenName;//炸鸡名
	protected Drinks beverage;//饮料

	//构造
 public SetMeal() {
	this.mealName="";
	this.price=0.0;
	this.chickenName="";
	this.beverage=null;
} 

	
public SetMeal(String mealName, String chickenName, Drinks beverage, double price) {
	this.mealName=mealName;
	this.price=price;
	this.chickenName=chickenName;
	this.beverage=beverage;
}

public void setMealName(String mealName) {
	this.mealName=mealName;
}

public void setPrice(double price) {
	this.price=price;
}

public void setChickenName(String chickenName) {
	this.chickenName=chickenName;
}

public void setBeverage(Drinks beverage) {
	this.beverage=beverage;
}

public String getMealName() {
	return this.mealName;
	
}

public double getPrice() {
	return this.price;
	
}

public String getChickenName() {
	return this.chickenName;
}

public Drinks getBeverage() {
	return this.beverage;
}

public String toString() { //覆写toString（）方法
	String str="套餐名: "+this.getMealName()+" "+this.getChickenName()+" "+this.getBeverage().name+"  "+this.getPrice()+"\n******************************************";
	System.out.print(str);
	return "";
}

public void FriedChickenRestaurant() {
}


}
