public class Direction{
  private int rowChange; //The direction of the change in row, 1 is a move downward and -1 is a move upward
  private int colChange; //The direction of the change in collumn, 1 is a move to the right and -1 is a move to the left
  
  /*
   * Constructor for the Direction object
   * Receives ints for the change in row and change in collumn
   */
  public Direction(int row, int col){
    this.rowChange = row;
    this.colChange = col;
  }
   /*
    * An accessor for the rowChange variable
    */
  public int getRowChange(){
    return rowChange;
  }
  
  /*
   * An accessor for the colChange variable
   */
  public int getColChange(){
    return colChange;
  }
  
  /*
   * Creates a String output when printing the Direction object
   */
  public String toString(){
    String s = "<";
    String vertDirection = "";
    String horiDirection = "";
    
    if(rowChange == 1){
      vertDirection = "down";
    }
    if(rowChange == -1){
      vertDirection = "up";
    }
    
    if(colChange == 1){
      horiDirection = "right";
    }
    if(colChange == -1){
      horiDirection = "left";
    }
    
    s += vertDirection;
    
    if(colChange != 0 && rowChange != 0){
      s += " ";
    }
    
    s += horiDirection + ">";
    
    return s;
  }
}