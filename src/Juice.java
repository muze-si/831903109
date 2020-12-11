import java.time.LocalDate;
public class Juice extends Drinks{ //创建Juice类继承自Drinks类
    //构造
	public Juice() {
		super();
		this.period=2;
	}
	
	public Juice(String name, double cost, LocalDate manufacture, int period) {
		super(name, cost, manufacture, period);
		this.period=2;
	}
	
	public void setPeriod(int period) {
		this.period=period;
	}
	
	public int getPeriod() {
		return period;
	}

	@Override
	public String toString() {
		String n;
		String str="果汁名: "+this.getName()+" "+this.getCost()+" "+this.getManufacture()+" " +this.getPeriod();
		return str;
	}


	
	
	

}
