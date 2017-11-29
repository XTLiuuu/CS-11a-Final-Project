package board;

/**
This shows how to use the board.Initialize class to set the board up before the game start
@author TicTacToe
*/
public class Initialize{
  public static void main(String[] args){
    for(int row=0; row<3; row++){
      for (int column=0; column<3; column++){ //go through every rows and columns
        board[row][column]=' '; //every space is empty
      }
    }
  }
}
