import java.time.LocalDate;
public class Juice extends Drinks{ //����Juice��̳���Drinks��
    //����
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
		String str="��֭��: "+this.getName()+" "+this.getCost()+" "+this.getManufacture()+" " +this.getPeriod();
		return str;
	}


	
	
	

}
