package TicTacToe;
import java.util.Scanner;

/**
This contains a library of useful operations of the board
@author TicTacToe
*/


public class Board{

  /**
  intialize() sets up an empty 3x3 board by assigning ' ' to every row and column
  before a new game starts
  */
  public static void initialize(){
    for(int row=0; row<3; row++){
      for (int column=0; column<3; column++){ //go through every rows and columns
        TTT100.board[row][column]=' '; //every space is empty
      }
    }
  }



  /**
  move(a,b,check) places the user's or computer's move on the board
  @param a an integer of the row number
  @param b an integer of the column number
  @param check an boolean varibale whose initial value is true
  @return a boolean expression that is always "true"
  */

  public static boolean move(int a, int b, boolean check){
    TTT100.board[a][b]='O';
    TTT100.currentR=a;
    TTT100.currentC=b;
    return check;
  }


  /**
  printBoard() prints out the current board after each moves
  */

  public static void printBoard(){
    System.out.println("   1  2   3");
    System.out.println("1  " + TTT100.board[0][0] + "| " + TTT100.board[0][1] + " | " + TTT100.board[0][2]);
    System.out.println("  -----------");
    System.out.println("2  " + TTT100.board[1][0] + "| " + TTT100.board[1][1] + " | " + TTT100.board[1][2]);
    System.out.println("  -----------");
    System.out.println("3  " + TTT100.board[2][0] + "| " + TTT100.board[2][1] + " | " + TTT100.board[2][2]);
  }
}
