public class TestPhase2
{
	public static void main(String[] args)
	{
		//Testing the Restaurant class
		FoodItem fi1 = new FoodItem("Queen wooper", 5.45, 8.99, 500);
		FoodItem fi2 = new FoodItem("Super extra steakhouse triple queen wooper with cheese", 6.99, 11.99, 200);
		FoodItem fi3 = new FoodItem("Poutine", 1.75, 4.99, 500);
		FoodItem fi4 = new FoodItem("Fries", 0.66, 2.99, 2000);
		FoodItem[] menuBq = {fi1, fi2, fi3, fi4};
		Restaurant bq = new Restaurant("Burger Queen", menuBq);
		
		System.out.println(bq);
		
		
		FoodItem fi5 = new FoodItem("City maki", 3, 4.99, 750);
		FoodItem fi6 = new FoodItem("City roll", 4, 6.99, 750);
		FoodItem fi7 = new FoodItem("City sashimi", 6.5, 11.99, 200);
		FoodItem fi8 = new FoodItem("City nigiri", 2, 3.99, 1000);
		FoodItem fi9 = new FoodItem("City teriyaki chicken", 5.5, 9.99, 0);
		FoodItem[] menuCs = {fi5, fi6, fi7, fi8, fi9};
		Restaurant cs = new Restaurant("City Sushi", menuCs);
		
		System.out.println(cs);
		
		
		//Testing the FoodApp class
		FoodApp atp = new FoodApp("AvoidThePlates", 0.25);
		
		Customer c1 = new Customer("Ellen Ripley", "ellrip@aol.com", "245 Alien road");
		Customer c2 = new Customer("John McClane", "johncowboy@hotmail.com", "560 Yippee-ki-yay boulevard");
		Customer c2copy = new Customer("John Copy", "johncowboy@hotmail.com", "560 Yippee-ki-yay boulevard");
		
		atp.addCustomer(c1);
		atp.addCustomer(c2);
		
		System.out.println(atp);
		
		if (!atp.addCustomer(c2copy))
			System.out.println("This email address already exists!");
		System.out.println(); //spacing
		
		if (atp.removeCustomer(c2copy))
			System.out.println("Customer removed.");
		
		System.out.println(atp);
		
		if(atp.addCustomer(c2copy))
			System.out.println("Customer added");
		System.out.println(atp);
	}
}