public class TestPhase3
{
	public static void main(String[] args)
	{	
		//initializing customers, restaurants and food apps
		Customer c1 = new Customer("Ellen Ripley", "ellrip@aol.com", "245 Alien road");
		Customer c2 = new Customer("John McClane", "johncowboy@hotmail.com", "560 Yippee-ki-yay boulevard");
		
		FoodItem fi1 = new FoodItem("Queen wooper", 5.45, 8.99, 500);
		FoodItem fi2 = new FoodItem("Super extra steakhouse triple queen wooper with cheese", 6.99, 11.99, 2);
		FoodItem fi3 = new FoodItem("Poutine", 1.75, 4.99, 500);
		FoodItem fi4 = new FoodItem("Fries", 0.66, 2.99, 2000);
		FoodItem[] menuBq = {fi1, fi2, fi3, fi4};
		Restaurant bq = new Restaurant("Burger Queen", menuBq);
		
		FoodItem fi5 = new FoodItem("City maki", 3, 4.99, 750);
		FoodItem fi6 = new FoodItem("City roll", 4, 6.99, 750);
		FoodItem fi7 = new FoodItem("City sashimi", 6.5, 11.99, 200);
		FoodItem fi8 = new FoodItem("City nigiri", 2, 3.99, 1000);
		FoodItem fi9 = new FoodItem("City teriyaki chicken", 5.5, 9.99, 0);
		FoodItem[] menuCs = {fi5, fi6, fi7, fi8, fi9};
		Restaurant cs = new Restaurant("City Sushi", menuCs);
		
		FoodApp atp = new FoodApp("AvoidThePlates", 0.25);
		FoodApp sc = new FoodApp("SuperConsume", 0.3);
		
		atp.addCustomer(c1);
		sc.addCustomer(c2);
		
		//Testing Order
		Order o1 = new Order(c1, bq, atp);
		
		System.out.println(o1);
		
		o1.addToOrder(fi2);
		System.out.println("\n" + o1);
		
		o1.addToOrder(fi4);
		System.out.println("\n" + o1);
		
		o1.addToOrder(fi2);
		System.out.println("\n" + o1);
		
		if (!o1.addToOrder(fi2))
			System.out.println("\nCould not add this item to the order: " + fi2);
		
		System.out.println("\n" + o1);
		
		o1.addToOrder(fi3);
		System.out.println("\n" + o1);
		
		
		//Testing another order
		Order o2 = new Order(c2, cs, sc);
		
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		o2.addToOrder(fi6);
		
		System.out.println("\n" + o2);
		
	}
}