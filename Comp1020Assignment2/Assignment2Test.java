import java.io.*;

public class Assignment2Test {
  public static void main(String[] args) {
    /*
    Direction test = new Direction(1, -1);
    Direction test2 = new Direction(0, 1);
    Direction test3 = new Direction(-1, 0);
    
    System.out.println(test);
    System.out.println(test2);
    System.out.println(test3);
    
    DirectionList test4 = new DirectionList();
    //System.out.println(test4.length());
    for(int i = -1; i < 1; i++){
      System.out.println(i);
    }
    int i = 0;
    while(i != 10){
      i = (int) ((Math.random() * 10) + 1);
      System.out.println(i);
    }
    */
    //Board b = new Board(4);
    //Board b = new Board("test2.txt");
    //DirectionList d = new DirectionList();
    //d.addDirection(new Direction(1, 0));
    //Move m = new Move(1, 3, d);
    
    
    //System.out.println(b);
    
    //b.flippable(0, 0, 1, new Direction(1, 1));
    
    //MoveList mList = b.allValidMoves(1);
    //System.out.println(mList);
    //b.makeMove(1, mList.randomMove());
    //System.out.println(b);
    
    
    //System.out.println(Board.nameOf(1));
    //System.out.println(b.searchThisDirection(5, 4, 1, new Direction(-1, -1)));
    
    /*
    System.out.println(b);
    MoveList mList1;
    MoveList mList2;
    do{
      //System.out.println("It's " + nameOf(1) + "'s turn."
      System.out.println("It's " + Board.nameOf(1) + "'s turn.");
      mList1 = b.allValidMoves(1);
      //System.out.println("Valid moves: " + mList1);
      if(mList1.isEmpty() != true){
        b.makeMove(1, mList1.randomMove());
      }
      else{
        //System.out.println(Board.nameOf(1) + " couldn't play a turn");
      }
      System.out.println(b);
      
      System.out.println("It's " + Board.nameOf(2) + "'s turn.");
      mList2 = b.allValidMoves(2);
      //System.out.println("Valid moves: " + mList2);
      if(mList2.isEmpty() != true){
        b.makeMove(2, mList2.randomMove());
      }
      else{
        //System.out.println(Board.nameOf(2) + " couldn't play a turn");
      }
      System.out.println(b);
    }
    while(!(mList1.isEmpty() == true && mList2.isEmpty() == true));
    */
    
    //b.saveFile("test.txt");
    
    String line;
    String previousLine = "";
    int linesRead = 0; 
    int cols = 0;
    try{
      BufferedReader br = new BufferedReader(new FileReader("test2.txt"));
      
      char charToRead;
      int c;
      do{
        c = br.read();
        if(c != -1){
          
        }
      }
      while(c != -1);
      
      
      /*
      do{
        line = br.readLine();
        if(line != null && line.length() != 0){
          linesRead ++;
          System.out.println(line.length());
          System.out.println(previousLine.length());
          cols = line.length();
        }
        previousLine = line;
      }
      while(line != null);
      if(linesRead != cols){
        throw new IOException("The rows and collumns are not equal.");
      }
      br.close();
    }
    */
    }
    catch(IOException ioe){
      System.out.println(ioe.getMessage());
    }
  }
}
