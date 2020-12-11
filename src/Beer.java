import java.time.LocalDate;
public class Beer extends Drinks { //创建Beer类继承自Drinks类
	protected float alcohol; //酒精度
	
	//构造
	public Beer() { 
		super();
		this.alcohol=0; 
		this.period=30;
	}
	
	
	public Beer(String name, double cost, LocalDate manufacture, int period,float alcohol) {
		super(name, cost, manufacture, period);
		this.alcohol=0;
		this.period=30;
	}
	
	public void setAlcohol(float alcohol) {
		this.alcohol=alcohol;
	}
	
	public void setPeriod(int period) {
		this.period=period;
	}
	
	public float getAlcohol() {
		return alcohol;
	}
	
	public int getPeriod() {
		return period;
	}
	
	@Override
	public String toString() {
		String str="啤酒名: "+this.getName()+" "+this.getCost()+" "+this.getManufacture()+" " +this.getPeriod()+" "+this.getAlcohol();
		return str;
	}

}
