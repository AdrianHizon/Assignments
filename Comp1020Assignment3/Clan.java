/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #3
 * Question #6
 * 
 * Purpose: Creates a Clan object that has a name and a list of Citizen objects which can all be different subclasses
 */

public class Clan{
  private String name; //The name of the clan
  private Citizen[] citizens; //The list of Citizen objects in the Clan
  
  /*
   * The constructor for the Clan object
   * Receives a String parameter for the name and an int parameter for the size of the clan
   * The first member of a clan is a barbarian to guarantee each clan has at least 1 fighter
   * Fills the rest of the clan with random types of citizens
   */
  public Clan(String clanName, int clanSize){
    name = clanName;
    citizens = new Citizen[clanSize];
    citizens[0] = new Barbarian();
    for(int i = 1; i < citizens.length; i++){
      citizens[i] = Citizen.randomCitizen();
    }
  }
  
  /*
   * An accessor for the name of the Clan
   */
  public String getName(){
    return name;
  }
  
  /*
   * Calculates the sum of the attack power of living fighters in the clan
   * Returns the sum
   */
  private int totalAttackPower(){
    int sum = 0;
    for(int i = 0; i < citizens.length; i++){
      if(citizens[i] instanceof Fighter && !((Fighter)citizens[i]).isDead()){
        sum += ((Fighter)citizens[i]).getPower();
      }
    }
    return sum;
  }
  
  /*
   * Calculates the number of fighters that are alive in a clan and returns that number
   */
  private int numFightersAlive(){
    int numAlive = 0;
    for(int i = 0; i < citizens.length; i++){
      if(citizens[i] instanceof Fighter && !((Fighter)citizens[i]).isDead()){
        numAlive ++;
      }
    }
    return numAlive;
  }
  
  /*
   * Receives a Clan object as an input
   * The Clan this is called on and the received input Clan attack each other
   * Calculates how much damage each clan can do to the other than reduces the health of fighters in each clan 
   */
  public void attack(Clan others){
    int thisMaxDamage = this.totalAttackPower() / others.numFightersAlive();
    int othersMaxDamage = others.totalAttackPower() / this.numFightersAlive();
    for(int i = 0; i < others.citizens.length; i ++){
      if(others.citizens[i] instanceof Fighter && !((Fighter)others.citizens[i]).isDead()){
        ((Fighter)others.citizens[i]).decreaseHp((int) (Math.random() * thisMaxDamage));
      }
    }
    for(int i = 0; i < this.citizens.length; i ++){
      if(this.citizens[i] instanceof Fighter && !((Fighter)this.citizens[i]).isDead()){
        ((Fighter)this.citizens[i]).decreaseHp((int) (Math.random() * othersMaxDamage));
      }
    }
  }
  
  /*
   * Checks if the clan this is called on is dead
   * If there are 0 living fighters than it returns true and false otherwise 
   */
  public boolean isDead(){
    return numFightersAlive() == 0;
  }
  
  /*
   * Causes each living fighter in a clan to gain power
   */
  public void gainPower(){
    for(int i = 0; i < citizens.length; i++){
      if(citizens[i] instanceof Fighter && !((Fighter)citizens[i]).isDead()){
        ((Fighter)citizens[i]).gainPower();
      }
    }
  }
  
  /*
   * Creates a String output when printing the Clan object
   */
  public String toString(){
    String s = name + "\nTotal attack power: " + totalAttackPower();
    for(int i = 0; i < citizens.length; i++){
      if((citizens[i] instanceof Fighter && !((Fighter)citizens[i]).isDead()) || citizens[i] instanceof Civilian){
        s += "\n" +  citizens[i].toString();
      }
    }
    return s;
  }
}