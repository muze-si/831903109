import java.time.LocalDate;
public abstract class Drinks { //����Drinks��
    protected String name; //����
    protected double cost; //�۸�
    protected LocalDate manufacture;//��������
    protected int period;//������
    
    //����
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


public boolean overdue( LocalDate manufacture, int period) { //�ж��Ƿ����
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

public abstract String toString(); //toString���󷽷�
	 
}
