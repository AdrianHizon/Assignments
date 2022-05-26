/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #2
 * Phase 2
 * 
 * Purpose: Creates a Board object that represents a Reversi game board and can be played
 */
import java.io.*;

public class Board{
  public static final int EMPTY = 0; //An integer value that represents an empty space
  public static final int BLACK = 1; //An integer value that represents a black piece
  public static final int WHITE = 2; //An integer value that represents a white piece
  
  private int[][] board; //A 2 dimensional array that represents the game board
  
  /*
   * The constructor for the Board object
   * Receives a single int as a parameter that sets the size of the board
   * Only needs 1 parameter as the board is a square with an equal number of rows and collumns
   * Sets
   */
  public Board(int i){
    if(i >=2){
      board = new int[i][i];
      board[(i/2) - 1][(i/2) - 1] = WHITE;
      board[(i/2) - 1][(i/2)] = BLACK;
      board[(i/2)][(i/2) - 1] = BLACK;
      board[(i/2)][(i/2)] = WHITE;
    }
  }
  
  /*
   * Creates a String output when printing the Board object
   */
  public String toString(){
    String s = "";
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == BLACK){
          s += 'X';
        }
        else if(board[i][j] == WHITE){
          s += 'O';
        }
        else{
          s += '.';
        }
      }
      s += "\n";
    }
    return s;
  }
  
  /*
   * Receives an int parameter that represents a player
   * Returns an int value that represents the player's opponent
   */
  public static int opponentOf(int player){
    if(player == BLACK){
      return WHITE;
    }
    else if(player == WHITE){
      return BLACK;
    }
    else{
      return EMPTY;
    }
  }
  
  /*
   * Receives an int parameter that represents a player
   * Returns a String parameter that represents a player
   */
  public static String nameOf(int player){
    if(player == BLACK){
      return "Black";
    }
    else if(player == WHITE){
      return "White";
    }
    else{
      return "Empty";
    }
  }
  
  /*
   * Calculates the score of the game by finding the difference between the black pieces and the white pieces
   * Returns a positive value if black has more pieces and a negative value if white has more pieces
   */
  public int getScore(){
    int blackPieces = 0;
    int whitePieces = 0;
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j ++){
        if(board[i][j] == BLACK){
          blackPieces ++;
        }
        if(board[i][j] == WHITE){
          whitePieces ++;
        }
      }
    }
    return blackPieces - whitePieces;
  }
  
  /*
   * Receives an int parameter that represents a player
   * Searches the entire board array for spots that are possible moves
   * Creates a MoveList that contains all possible moves that can be played by the player
   */
  public MoveList allValidMoves(int player){
    MoveList validMoves = new MoveList(); //The MoveList that contains the possible moves
    DirectionList adjacentPieces; //Contains directions that point to adjacent pieces
    for(int i = 0; i < board.length; i ++){
      for(int j = 0; j < board.length; j++){
        adjacentPieces = this.validMove(i, j, player);
        if(this.emptyCell(i, j) && adjacentPieces.length() != 0){
          validMoves.addMove(new Move(i, j, adjacentPieces));
        }
      }
    }
    return validMoves;
  }
  
  /*
   * Receives 2 int parameters to represent a row and collumn on the board
   * Checks if the spot in the array with the received row and collumn contains an EMPTY int
   */
  public boolean emptyCell(int row, int collumn){
    return board[row][collumn] == EMPTY; 
  }
  
  /*
   * Receives 2 int parameters to represent a row and collumn on the board
   * Checks in all 8 directions around the given row and collumn to see if it's adjacent to a piece that's the opponent of the received player parameter
   * Also checks if pieces can be flipped in that direction
   * Returns a DirectionList that contains directions that fulfill these conditions
   */
  public DirectionList validMove(int row, int collumn, int player){
    DirectionList dList = new DirectionList();
    int rowToCheck = row; //The row of the board thats being checked
    int colToCheck = collumn; //The collumn of the board thats being checked
    DirectionList allDirections = DirectionList.allDirections();
    //Checks the cell in each direction around the given row and collumn coordinates
    for(int i = 0; i < allDirections.length(); i++){
      rowToCheck = row + allDirections.getDirection(i).getRowChange();
      colToCheck = collumn + allDirections.getDirection(i).getColChange();
      //This if statement checks if the spot on the board its checking is in the bounds of the array, contains an opponent's piece and if the player is allowed to flip pieces in that direction
      if(this.inBounds(rowToCheck, colToCheck) 
           && board[rowToCheck][colToCheck] == this.opponentOf(player)
           && flippable(row, collumn, player, allDirections.getDirection(i))){
        dList.addDirection(allDirections.getDirection(i));
      }
    }
    return dList;
  }
  
  /*
   * Receives 2 int parameters that represent a row and collumn on the board
   * Checks if this spot on the board is within the bounds of the board array
   */
  public boolean inBounds(int row, int collumn){
    return row >= 0 && row < board.length && collumn >= 0 && collumn < board.length;
  }
  
  /*
   * Receives 2 int parameters that represent a row and collumn on the board
   * Receives an int parameter that represents a player
   * Starts at the spot of the received row and collumn and continues in the direction indicated by the Direction object
   * If it finds a piece that matches the player than it returns true, else returns false
   */
  public boolean flippable(int row, int collumn, int player, Direction dir){
    int rowToCheck = row;
    int colToCheck = collumn;
    do{
      if(board[rowToCheck][colToCheck] == player){
        return true;
      }
      rowToCheck += dir.getRowChange();
      colToCheck += dir.getColChange();
    }
    while(this.inBounds(rowToCheck, colToCheck) && board[rowToCheck][colToCheck] != EMPTY);
    return false;
  }
  
  /*
   * Receives an int that represents a player and a Move parameter
   * Uses the Move object to find where to start and what direction to change pieces into the received player 
   */
  public void makeMove(int player, Move theMove){
    int rowToFlip;
    int colToFlip;
    DirectionList dirToFlip = theMove.getDirList();
    for(int i = 0; i < dirToFlip.length(); i ++){
      rowToFlip = theMove.getRow();
      colToFlip = theMove.getCollumn();
      do{
        board[rowToFlip][colToFlip] = player;
        rowToFlip += dirToFlip.getDirection(i).getRowChange();
        colToFlip += dirToFlip.getDirection(i).getColChange();
      }
      while(this.inBounds(rowToFlip, colToFlip) && board[rowToFlip][colToFlip] == opponentOf(player));
    }
  }
  
  /*
   * Saves a copy of the board to a text file
   * Creates a text file that's named with the received String parameter
   */
  public void saveFile(String fileName){
    try{
      PrintWriter pWriter = new PrintWriter(new FileWriter(fileName));
      pWriter.println(board.length);
      pWriter.println(this.toString());
      pWriter.close();
    }
    catch(IOException e){
      System.out.println("Couldn't save file");
    }
  }
}