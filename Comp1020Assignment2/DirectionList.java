public class DirectionList{
  public static final int MAX_DIRECTIONS = 8; //The maximum amount of Direction objects a directionList can hold
  
  private Direction[] directionList; //An array that holds Direction objects
  private int size; //The size of the directionList partially filled array
  
  /*
   * A constructor for the DirectionList object
   * Receives no parameters and sets variables to default values
   */
  public DirectionList(){
    directionList = new Direction[MAX_DIRECTIONS];
    size = 0;
  }
  
  /*
   * Receives a Direction object and places it at the end of this objects directionList
   */
  public void addDirection(Direction d){
    directionList[size++] = d;
  }
  
  /*
   * An accessor for the size variable
   */
  public int length(){
    return size;
  }
  
  /*
   * An accessor for Direction objects in a directionList array
   * Receives an int parameter that is the index location of the Direction object to be accessed
   */
  public Direction getDirection(int i){
    return directionList[i];
  }
  
  /*
   * Creates a String output when printing the DirectionList object
   */
  public String toString(){
    String s = "{";
    for(int i = 0; i < size; i ++){
      s += directionList[i];
      if(i < (size - 1)){
        s += ", ";
      }
    }
    s += "}";
    return s;
  }
  
  /*
   * A static method that creates a DirectionList object that contains all possible Direction objects
   */
  public static DirectionList allDirections(){
    DirectionList allDirections = new DirectionList();
    for(int i = -1; i < 2; i++){
      for(int j = -1; j < 2; j++){
        if(i != 0 || j != 0){
          allDirections.addDirection(new Direction(i, j));
        }
      }
    }
    return allDirections;
  }
}