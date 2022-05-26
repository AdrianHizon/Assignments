/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #3
 * Question #3
 * 
 * Purpose: Creates a Fighter object which is a subclass of Citizen that partakes in combat
 */

public abstract class Fighter extends Citizen{
  private int currentHealth; //The current health that this Fighter has
  private int currentAttack; //The current attack power that this Fighter has
  
  /*
   * Constructor for the Fighter object
   * Receives 2 int parameters that represent the health and attack power of the Fighter
   */
  public Fighter(int health, int attack){
    currentHealth = health;
    currentAttack = attack;
  }
  
  /*
   * Creates a String output when printing the Fighter object
   */
  public String toString(){
    return "Fighter: health=" + currentHealth + " attack=" + currentAttack;
  }
  
  /*
   * Decreases the health of the Fighter by the amount received as an parameter parameter
   * Sets the health to 0 if it becomes negative as health cannot be lower than 0
   */
  public void decreaseHp(int decrease){
    currentHealth -= decrease;
    if(currentHealth < 0){
      currentHealth = 0;
    }
  }
  
  /*
   * Checks to see if a fighter is dead or alive
   * Returns true if the fighter's health is 0 and false otherwise
   */
  public boolean isDead(){
    return currentHealth == 0;
  }
  
  /*
   * A dummy method to be used for polymorphism in subclasses
   */
  public void gainPower(){
  }
  
  /*
   * Increases the fighter's attack power by the amount received as an int parameter
   */
  public void gainPower(int power){
    currentAttack += power;
  }
  /*
   * An accessor method that returns the fighter's current attack power
   */
  public int getPower(){
    return currentAttack;
  }
}