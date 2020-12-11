public class OverdraftBalanceException extends RuntimeException{ //自定义异常类
	private String message;
    //构造
	public OverdraftBalanceException(String message){
        super(message);
        this.message = message;
    }

    public static void main(String[] args) {
    	West2FriedChickenRestaurant check = new West2FriedChickenRestaurant(); 
    	try { 
		check.purchase(check.balance); 
        } catch (OverdraftBalanceException e) {
          e.printStackTrace(); 
        } 
      } 
     
    } 












