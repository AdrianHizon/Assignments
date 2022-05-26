public class AssignmentTest{
  public static void main(String[] args){
    Customer ellen = new Customer("Ellen Ripley", "ellrip@aol.com", "245 Alien Road");
    System.out.println(ellen);
    Customer raf = new Customer("Rafael Daclison", "ellrip@aol.com", "40 Rue de la Ste. Famille");
    System.out.println(raf);
    
    FoodItem spaget = new FoodItem("Spaget", 10.45, 10.45, 1);
    System.out.println(spaget);
    spaget.setSellingPrice(9.45);
    spaget.decrementStock();
    System.out.println(spaget);
    spaget.increaseStock(2);
    spaget.decrementStock();
    spaget.decrementStock();
    System.out.println(spaget);
  }
}