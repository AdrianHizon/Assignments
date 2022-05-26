/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #3
 * Question #5
 * 
 * Purpose: Creates a Barbarian object which is a subclass of the Fighter that has set stats
 */


public class Barbarian extends Fighter{
  private static final int DEFAULT_HEALTH = 200; //The default health that a barbarian starts with
  private static final int DEFAULT_ATTACK_POWER = 20;//The default attack power that a barbarian starts with
  private static final int POWER_GAIN = 15; //The amount of power that a barbarian gains
  
  /*
   * A constructor for the Barbarian class
   * Calls the Fighter constructor with the default health and attack power values
   */
  public Barbarian(){
    super(DEFAULT_HEALTH, DEFAULT_ATTACK_POWER);
  }
  
  /*
   * Creates a String output when printing a Barbarian object
   */
  public String toString(){
    return super.toString() + " (Barbarian)";
  }
  
  /*
   * Increases the power of the Barbarian by a set amount 
   * Calls the Fighter gainPower method to increase its power
   */
  public void gainPower(){
    super.gainPower(POWER_GAIN);
  }
}