public class Customer {
  /* 
   * Customer
   * 
   * COMP 1020 Section A01
   * Instructor: Ali Neshati
   * Name: Adrian Hizon
   * Assignment #1
   * Phase 1
   * 
   * Purpose: Creates a Customer object that has a customer's name, email, and street address.
   */
  
  private final int MAX_RECENT_ORDERS = 3; //The maximum amount of recent orders that will be tracked
  
  private String name; //The name of the customer.
  private String email; //The email address of the customer.
  private String street; //The street address of the customer
  private Order[] recentOrders; //An array containing the most recent orders of this customer
  
  /*
   * The constructor for the Customer object.
   * Receives three String inputs for the customer's name, email, and street address.
   */
  public Customer(String name, String email, String street){
    this.name = name;
    this.email = email;
    this.street = street;
    recentOrders = new Order[MAX_RECENT_ORDERS];
  }
  
  /*
   * Checks if one customer is the same as another one by comparing their emails as they should be unique to each customer.
   * Receives a Customer object as a parameter
   * Returns true if the Customer object this method is called on and the inputted Customer object have the same email, 
   * otherwise, returns false.
   */
  public boolean equals(Customer c){
    return this.email.equals(c.email);
  }
  
  /*
   * An accessor to be able to use the name of a customer
   * Returns the name of this Customer object
   */
  public String getName(){
    return name;
  }
  
  /*
   * Receives an Order object
   * Adds the received Order to an Order array that holds the most recent orders related to a customer
   */
  public void updateRecentOrders(Order o){
    for(int i = recentOrders.length - 1; i > 0; i--){
      recentOrders[i] = recentOrders[i-1];
    }
    recentOrders[0] = o;
  }
  
  /*
   * Creates a String output of the recent orders of a customer
   */
  public String getStringRecentOrders(){
    String s = "Recent orders of customer " + name;
    for(int i = 0; i < recentOrders.length && recentOrders[i] != null; i++){
      s += "\n" + recentOrders[i];
    }
    return s;
  }
  
   /*
   * Creates a String output when printing a Customer object.
   */
  public String toString(){
    return "-Customer " + name + "\n" + "Email: " + email + "\n" + "Address: " + street;
  }
}