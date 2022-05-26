/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #3
 * Question #1
 * 
 * Purpose: An abstract Citizen superclass to allow polymorphism for its subclasses
 */

public abstract class Citizen{
  
  /*
   * Creates a String output when printing a Citizen object
   */
  public String toString(){
    return "Citizen";
  }
  
  /*
   * Generates a random number from 0 to 2
   * Returns different Citizen subclasses depending on the generated number
   */
  public static Citizen randomCitizen(){
    int randomNumber = (int) (Math.random() * 3);
    if(randomNumber == 0){
      return new Civilian();
    }
    else if(randomNumber == 1){
      return new Archer();
    }
    else{
      return new Barbarian();
    }
  }
}