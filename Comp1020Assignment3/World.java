/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #3
 * Question #7
 * 
 * Purpose: Creates a World object that contains Clan objects that can attack each other
 */
public class World{
  private Clan[] clans; //An array that holds the clans in the world
  private int numClans; //The number of clans currently in the world
  private static int MAX_CLANS = 10; //The maximum amount of clans in a world
  
  /*
   * The contructor for the World object
   * Creates a world with default values
   */
  public World(){
    clans = new Clan[MAX_CLANS];
    numClans = 0;
  }
  
  /*
   * Adds a received clan parameter to the list of clans
   */
  public void addClan(Clan c){
    clans[numClans++] = c;
  }
   
  /*
   * Returns the current number of clans in the world
   */
  public int getNumClans(){
    return numClans;
  }
  
  /*
   * Receives 2 int parameters that are 2 indices for the clan list
   * These 2 clans then attack each other
   * The living fighters than gain power
   * Deletes a clan if it no longer has any living fighters
   */
  public void attack(int clan1, int clan2){
    System.out.println("Clan " + clans[clan1].getName() + " is attacking clan " + clans[clan2].getName() + ".\n");
    clans[clan1].attack(clans[clan2]);
    clans[clan1].gainPower();
    clans[clan2].gainPower();
    if(clans[clan1].isDead()){
      deleteClan(clan1);
      if(clan1 < clan2){ //If clan1 was deleted and was less than clan2 then the index for clan2 would've been moved down 1 spot
        clan2 --;
      }
    }
    if(clans[clan2].isDead()){
      deleteClan(clan2);
    }
  } 
   /*
    * Deletes a clan indicated by the receive int parameter from the list of clans 
    * Then, shifts every clan after the deleted clan down 1 spot in the index
    */
  private void deleteClan(int index){
    System.out.println("Clan " + clans[index].getName() + " has been wiped out.\n");
    for(int i = index; i < clans.length - 1; i ++){
      clans[i] = clans[i + 1];
    }
    numClans--;
  }
  
  /*
   * Creates a String output when printing the World object
   */
  public String toString(){
    String s = "There are " + numClans + " clans in the world.";
    if(numClans == 1){
      s = "There is " + numClans + " clan in the world.";
    }
    for(int i = 0; i < numClans; i++){
      s += "\n---------- \n" + clans[i];
    }
    s += "\n";
    return s;
  } 
}