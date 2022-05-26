public class Order{
  /*
   * Order
   * 
   * COMP 1020 Section A01
   * Instructor: Ali Neshati
   * Name: Adrian Hizon
   * Assignment #1
   * Phase 4
   * 
   * Purpose: Create an Order object that interacts with the Customer, Restaurant, FooItem, and FoodApp objects to create orders
   */
  
  private static final int MAX_ORDERS = 10; //The maximum amount of items that can be ordered
  
  private static int totalOrders = 0; //Tracks the total amount of orders that have been placed, starts with 0 orders
  
  int orderNumber; //The order number
  Customer customer; //The customer who placed the order
  Restaurant restaurant; //The restaurant that receives the order
  FoodApp foodApp; //The food app that the order was placed through
  FoodItem[] foodOrdered; //An array of all the food items ordered
  int amountOrdered; //The amount of food items ordered
  double totalPrice; //The total price of the order
  
  /*
   * Constructor for the Order object
   * Receives a Customer object for the customer, a Restaurant object for the restaurant, and a FoodApp object for the food app
   * Increments the total orders by 1 as a class variable
   */
  public Order(Customer customer, Restaurant restaurant, FoodApp foodApp){
    this.restaurant = restaurant;
    this.customer = customer;
    this.foodApp = foodApp;
    foodOrdered = new FoodItem[MAX_ORDERS];
    amountOrdered = 0; //A new order has no items
    totalPrice = 0; //An empty order has no price
    orderNumber = 900001 + totalOrders; //The first order starts at 900001 and is incremented by 1 for each Order object created
    totalOrders ++;
  }
  
  /*
   * Receives a FoodItem as a parameter
   * If maximum amount of food items has not been reached and the received food item has stock, adds the received FoodItem to the foodOrdered array 
   * Returns true if an order was added, otherwise, returns false
   */
  public boolean addToOrder(FoodItem food){
    boolean foodAdded = false;
    if(amountOrdered < MAX_ORDERS && food.isAvailable()){
      foodOrdered[amountOrdered] = food;
      food.decrementStock();
      totalPrice += food.getSellPrice();
      amountOrdered ++;
      foodAdded = true;
    }
    return foodAdded;
  }
  
  /*
   * Calls the Restaurant fillOrder method and Customer updateRecentOrders with the proper paremeters set
   */
  public void submitOrder(){
    restaurant.fillOrder(totalPrice, foodOrdered, amountOrdered, foodApp.getFeePercent());
    customer.updateRecentOrders(this);
  }
  
  /*
   * Creates a String output when printing an Order object
   */
  public String toString(){
    String s = "-- " + foodApp.getName() + " order #" + orderNumber + 
    "\n" + "For customer " + customer.getName() + " with restaurant " + restaurant.getName();
    
    for(int i = 0; i < amountOrdered; i++){
      s += "\n" + foodOrdered[i];
    }
    
    s += "\n Total Price: $" + totalPrice;
    return s;
  }
}