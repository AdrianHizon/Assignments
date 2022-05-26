public class Move{
  private int row; //The row on the board where the move is being palyed
  private int collumn; //The collumn on the board where the move is being played
  private DirectionList dirList; //Contains the directions of the pieces to be flipped by this move
  
  /*
   * The constructor for the Move object
   * Receives ints for the row and collumn and a DirectionList for dirList
   */
  public Move(int row, int collumn, DirectionList dirList){
    this.row = row;
    this.collumn = collumn;
    this.dirList = dirList; 
  }
  
  /*
   * An accessor for the row variable
   */
  public int getRow(){
    return row;
  }
  
  /*
   * An accessor for the collumn variable
   */
  public int getCollumn(){
    return collumn;
  }
  
  /*
   * An accessor for the dirList variable
   */
  public DirectionList getDirList(){
    return dirList;
  }
  
  /*
   * Creates a String output when printing the Move object
   */
  public String toString(){
    return "(" + row + "," + collumn + ") flips directions " + dirList; 
  }
}