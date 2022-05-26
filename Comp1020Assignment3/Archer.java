/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #3
 * Question #4
 * 
 * Purpose: Creates an Archer object which is a subclass of the Fighter that has set stats
 */

public class Archer extends Fighter{
  private static final int DEFAULT_HEALTH = 100; //The default health that an archer starts with
  private static final int DEFAULT_ATTACK_POWER = 15; //The default attack power that an archer starts with
  private static final int POWER_GAIN = 10; //The amount of power that an archer gains
  
  /*
   * A constructor for the Archer class
   * Calls the Fighter constructor with the default health and attack power values
   */
  public Archer(){
    super(DEFAULT_HEALTH, DEFAULT_ATTACK_POWER);
  }
  
  /*
   * Creates a String output when printing an Archer object
   */
  public String toString(){
    return super.toString() + " (Archer)";
  }
  
  /*
   * Increases the power of the Archer by a set amount 
   * Calls the Fighter gainPower method to increase its power
   */
  public void gainPower(){
    super.gainPower(POWER_GAIN);
  }
}