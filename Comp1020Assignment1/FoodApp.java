public class FoodApp{
  /*
   * COMP 1020 Section A01
   * Instructor: Ali Neshati
   * Name: Adrian Hizon
   * Assignment #1
   * Phase 2
   * 
   * Purpose: Creates a FoodApp object that has a name, fee percentage, 
   * and customers that are tracked through a Customer array and an integer.
   */
  private static final int MAX_CUSTOMERS = 100; //The maximum number of customers a food app can have
  
  private String name; //The name of the food app
  private double feePercent; //The fees percentage the food app charges to a restaurant
  private Customer[] customers; //A Customer array
  private int currentCustomers; //The current amount of customers in the array
  
  /*
   * The constructor for the FoodApp object.
   * Receives a String for the name and a double for the fees percentage.
   */
  public FoodApp(String name, double feePercent){
    this.name = name;
    this.feePercent = feePercent;
    customers = new Customer[MAX_CUSTOMERS]; //The customers array is created with the size of the maximum number of customers
    currentCustomers = 0; //When the food app is first created there are no customers
  }
  
  /*
   * Finds the index of the customers array that the received Customer parameter is found at.
   * Returns the index of the customers array at which the Customer is found, returns -1 if it is not found.
   */
  public int getCustomerIndex(Customer c){
    int index = -1; //Initially -1 as it means no customer has been found.
    
    //Searches the Customer array until it finds the location of the received customer input or an empty space.
    for(int i = 0; i < customers.length; i++){
      if(customers[i] == null){
        break;
      }
      else if(customers[i].equals(c)){
        index = i; 
      }
    }
    return index;
  }
  /*
   * Receives a Customer parameter.
   * Searches the customers array for the received Customer parameter, if it's not found, it gets added to the array
   * Returns true if a customer has been added, otherwise, returns false.
   */
  public boolean addCustomer(Customer c){
    boolean customerAdded = false;
    
    if(getCustomerIndex(c) == -1){
      customers[currentCustomers] = c; 
      customerAdded = true;
      currentCustomers ++;
    }
    
    return customerAdded;
  }
  
  /*
   * Receives a Customer parameter.
   * Searches the customers array for the received Customer parameter, if it is found, it gets removed from the array.
   * Returns true if a customer has been removed, otherwise, returns false.
   */
  public boolean removeCustomer(Customer c){
    boolean customerRemoved = false; //Tracks if a customer has been removed
    int customerIndex = getCustomerIndex(c);
    
    //Starting at the index of the costumer being removed, moves each Customer in the customers array down 1 spot.
    if(customerIndex != -1){
      for(int i = customerIndex; i < (customers.length - 1); i ++){ //Used customers.length - 1 as the last 
        customers[i] = customers[i + 1];
      }
      currentCustomers --;
      customerRemoved = true;
    }
    
    return customerRemoved;
  }
  
  /*
   * An accessor that allows the name of this food app to be used
   * Returns a String that is the name of this food app
   */
  public String getName(){
    return name;
  }
  
  /*
   * An accessor that allows the fees percentage of this food app to be used
   * Returns a double that is the fees percentage
   */
  public double getFeePercent(){
    return feePercent;
  }
  
  /*
   * Creates a String output when printing the FoodApp object.
   */
  public String toString(){
    String s = "-- FoodApp " + name + "\n" + currentCustomers + " customer(s) registered";
    
    for(int i = 0; i < currentCustomers; i ++){
      s += "\n" + customers[i];
    }
    s += "\n"; //Spacing
    
    return s;
  }
}