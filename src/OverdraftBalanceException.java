public class OverdraftBalanceException extends RuntimeException{ //�Զ����쳣��
	private String message;
    //����
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












