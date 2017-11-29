package TicTacToe;
import java.util.Scanner;

/**
This contains a library of useful operations of the board
@author TicTacToe

*/


public class Board{

  /**
  This shows how to use the board.Initialize class to set the board up
  before the game start
  @param args an array of Strings
  */

  public static void Initialize(String[] args){
    for(int row=0; row<3; row++){
      for (int column=0; column<3; column++){ //go through every rows and columns
        board[row][column]=' '; //every space is empty
      }
    }
  }



  /**
  This shows how to use the board.Move class to go to the position where
  the user want to place next move
  @param a an int
  @param b an int
  @param check an boolean varibale
  @return the boolean expression which is always ture
  */

  public static boolean Move(int a, int b, boolean check){
    board[a][b]='O';
    currentR=a;
    currentC=b;
    return check;
  }


  /**
  This shows how to use the board.printboard class to print out the board
  at each step
  @param args an array of Strings
  */

  public static void printboard(String[] args){
    System.out.println();
    System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
    System.out.println("---------");
    System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
    System.out.println("---------");
    System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
    System.out.println();
  }
}
