public class MoveList{
  public static final int MAX_MOVES = 32; //The maximum amount of Move objects that can 
  
  private Move[] moveList; //An array of Move objects
  private int size; //The size of the moveList partially filled array
  
  /*
   * The constructor for the MoveList object
   * Receives no parameters and set variables to default values
   */
  public MoveList(){
    moveList = new Move[MAX_MOVES];
    size = 0;
  }
  
  /*
   * Receives a Move object and adds it to the end of the moveList array 
   */
  public void addMove(Move m){
    moveList[size++] = m;
  }
  
  /*
   * Creates a String output when printing out the MoveList object
   */
  public String toString(){
    String s = "";
    for(int i = 0; i < size; i++){
      s += moveList[i] + "\n";
    }
    return s;
  }
  
  /*
   * Checks if the MoveList this method is called on is empty or not
   */
  public boolean isEmpty(){
    return size == 0;
  }
  
  /*
   * Returns a random Move object from the MoveList this method is called on
   * Returns null if the MoveList is empty
   */
  public Move randomMove(){
    Move m = null;
    if(size != 0){
      int i = (int) 
        (Math.random() * size);
      m = moveList[i];
    }
    return m;
  }
  
  /*
   * An accessor for Direction objects in a directionList array
   * Receives an int parameter that is the index location of the Move object to be accessed
   */
  public Move getMove(int i){
    return moveList[i];
  }
}