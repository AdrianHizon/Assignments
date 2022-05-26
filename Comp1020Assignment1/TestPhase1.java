public class TestPhase1
{
	public static void main(String[] args)
	{
		//Testing Customer
		Customer c1 = new Customer("Ellen Ripley", "ellrip@aol.com", "245 Alien road");
		System.out.println(c1);
		
		System.out.println(); //spacing
		
		Customer c2 = new Customer("John McClane", "johncowboy@hotmail.com", "560 Yippee-ki-yay boulevard");
		System.out.println(c2);
		
		System.out.println(); //spacing
		
		if (c1.equals(c2))
			System.out.println("Both customers have the same email address");
		else
			System.out.println("Both customers have different email addresses");
		
		System.out.println(); //spacing
		
		//Testing FoodItem
		FoodItem spaget = new FoodItem("Spaget", 4.5, 10.75, 50);
		System.out.println(spaget);
		
		FoodItem egg = new FoodItem("Pristine deathclaw egg", 9.75, 14.99, 0);
		System.out.println(egg);
		
		System.out.println(); //spacing
		
		egg.increaseStock(2);
		egg.setSellingPrice(15.59);
		System.out.println(egg);
	}
}