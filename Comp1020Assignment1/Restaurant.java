public class Restaurant{
  /*
   * Restaurant
   * 
   * COMP 1020 Section A01
   * Instructor: Ali Neshati
   * Name: Adrian Hizon
   * Assignment #1
   * Phase 2
   * 
   * Purpose: Creates a Restaurant object that has a name and a menu in the form of a FoodItem array.
   */
  
  private String name; //The name of the restaurant
  private FoodItem[] menu; //The menu of the restaurant
  private double profit; //The profit of the restaurant
  
  /*
   * The constructor for the Restaurant object.
   * Receives a String for the name and a FoodItem array for the menu.
   */
  public Restaurant(String name, FoodItem[] menu){
    this.name = name;
    this.menu = menu;
    profit = 0; //When first created the restaurant has yet to make any profit.
  }
  
  /*
   * An accessor that allows the name of this Restaurant to be used
   */
  public String getName(){
    return name;
  }
  
  /*
   * Calculates the profit a restaurant makes from an order
   */
  public void fillOrder(double totalPrice, FoodItem[] foodOrdered, int amountOrdered, double feePercent){
    double markupSum = 0;
    for(int i = 0; i < amountOrdered; i++){
      markupSum += foodOrdered[i].getMarkup();
    }
    profit = markupSum - (totalPrice * feePercent);
  }
  
  /*
   * Creates a String output when printing the Restaurant object.
   */
  public String toString(){
    String s = "-- Restaurant " + name + "\n" + "Profit = " + profit + "\n" + "Menu:";
    
    //Adds every FoodItem in the menu to the String.
    for(int i = 0; i < menu.length; i++){
      s += "\n" + menu[i];
    }
    s += "\n"; //Spacing
    
    return s;
  }
}