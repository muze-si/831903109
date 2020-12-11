import java.util.ArrayList;

public interface FriedChickenRestaurant { //抽象方法
	void purchase(double balance); //进货
	void sold(ArrayList<SetMeal> meal); //出售套餐
   }
