package TicTacToe;

import javax.swing.*;

/**
This contains a library of useful operations of the board
@author TicTacToe
*/

public class Board{
  /**
  This shows how to use the Board.Initialize in the Board class to set the board up
  before the game start
  @param args an array of Strings
  */
  public static void initialize(){
      for(int row = 0; row < 3; row++){
      for (int column = 0; column < 3; column++){ //go through every rows and columns
        TTT100.board[row][column]=' '; //every space is empty
        TTT100.boardB[row][column].setEnabled(true); //all buttons can be pressed
      }
    }
    int userFirst = JOptionPane.showConfirmDialog(null, "Would you like to go first?", "Start",
				JOptionPane.YES_NO_OPTION); //asks if player wants to start the game or not
    if (userFirst != 0) {
      TTT100.computer(); //computer goes first if player does not
    }
  }

  /**
  This shows how to use Move in the Board class to go to the position where
  the user want to place next move
  @param a an int
  @param b an int
  @param check an boolean varibale
  @return the boolean expression which is always ture
  */

  public static boolean Move(int a, int b, boolean check){
    TTT100.board[a][b]='O'; //Computer's move
    TTT100.currentR=a;
    TTT100.currentC=b;
    return check;
  }


}
