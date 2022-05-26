public class FoodItem{
  /*
   * FoodItem
   * 
   * COMP 1020 Section A01
   * Instructor: Ali Neshati
   * Name: Adrian Hizon
   * Assignment #1
   * Phase 1
   * 
   * Purpose: Creates a FoodItem object that has a food item's name, cost, selling price, and stock.
   */
  
  private String name; //The name of the food item
  private double cost; //The cost of the food item
  private double sellPrice; //The selling price of the food item
  private int stock; //The amount of stock of the food item
  
  /*
   * The constructor for the FoodItem object.
   * Receives a String input for the name, 
   * two double inputs for the cost and selling price, and an integer for the stock. 
   */
  public FoodItem(String name, double cost, double sellPrice, int stock){
    this.name = name;
    this.cost = cost;
    this.sellPrice = sellPrice;
    this.stock = stock; 
  }
  
  /*
   * Checks if there is stock of the FoodItem this method is called on.
   * Returns true if the stock is >0, otherwise returns false.
   */
  public boolean isAvailable(){
    return this.stock > 0;
  }
  
  /*
   * Creates a String output when printing the FoodItem object.
   */
  public String toString(){
    String s = "- " + name + "\n" + "$" + sellPrice;
    
    if(this.isAvailable() == false){
      s += " (SOLD OUT)"; 
    }
    return s; 
  }
  
  /*
   * Changes the selling price of the FoodItem this method is called on.
   * Receives a double and sets the selling price to the received input.
   */
  public void setSellingPrice(double price){
    this.sellPrice = price;
  }
  
  /*
   * Decreases the stock of the FoodItem this method is called on.
   * Each time this method is called the stock of the FoodItem decrements by 1.
   */
  public void decrementStock(){
    stock --;
  }
  
  /*
   * Increases the stock of the food item this method is called on.
   * Receives an integer as an input.
   * Increases the stock of the FoodItem by the amount of the integer parameter.
   */
  public void increaseStock(int amount){
    this.stock += amount;
  }
  
  /*
   * An accessor to be able to use this food item's selling price
   * Returns a double that is the selling price
   */
  public double getSellPrice(){
    return sellPrice;
  }
  
  /*
   * Calculates the markup of a food item by subtracting the cost from the selling price
   */
  public double getMarkup(){
    return sellPrice - cost;
  }
}