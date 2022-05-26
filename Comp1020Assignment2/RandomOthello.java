import java.io.IOException;

/**
 * Play random games of Othello
 * to test the Board class for Assignment 2
 */
import java.io.IOException;
import java.util.Scanner;

public class RandomOthello {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Board theBoard;
        int boardSize = getBoardSize();
        theBoard = new Board(boardSize);

        //To make sure your code is working to get the initial setup from an input text file
        //comment lines 18 and 17 and uncomment the following line
        //theBoard = new Board("importBoardSetupTextFile.txt");

        int whoseTurn = Board.BLACK;
        int numPasses = 0; //When 2 players pass, the game ends

        while(numPasses<2){
            displayBoard(theBoard,whoseTurn);
            MoveList validMoves = theBoard.allValidMoves(whoseTurn);
            if(validMoves.isEmpty()){
                System.out.println(Board.nameOf(whoseTurn)+" has no valid moves.");
                numPasses++;
            }
            else { //Actually make a move
                System.out.println("Valid moves for "+Board.nameOf(whoseTurn)+" are:\n"+validMoves);
                //int i = keyboard.nextInt();
                Move chosenMove = validMoves.randomMove()
                  ;
                System.out.println("Move played is: "+chosenMove);
                theBoard.makeMove(whoseTurn,chosenMove);
                numPasses=0;
            }
            whoseTurn = Board.opponentOf(whoseTurn);
            System.out.print("Press Enter to continue:");
            String junk = keyboard.nextLine();
        }//while
        showScore(theBoard);
        theBoard.saveFile("saveTextFileName.txt");

    }//main

    private static int getBoardSize(){
        System.out.println("Enter the desired board size:");
        int size =  keyboard.nextInt();
        String junk = keyboard.nextLine(); //Flush the rest of the line
        return size;
    }

    private static void displayBoard(Board b, int player){
        System.out.println("The board:\n"+b);
        System.out.println(Board.nameOf(player)+"'s turn.");
    }

    private static void showScore(Board theBoard){
        int theScore = theBoard.getScore();
        System.out.println("Game over.\nScore is "+theScore);
        if(theScore>0)
            System.out.println(Board.nameOf(Board.BLACK)+" wins!");
        else if(theScore<0)
            System.out.println(Board.nameOf(Board.WHITE)+" wins!");
        else
            System.out.println("It's a tie!");
    }

}
