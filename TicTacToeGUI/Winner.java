package TicTacToeGUI;

public class Winner {

  /**
  This contains methods checking if the game has a winner or if it is a tie
  @author TicTacToe
  */

  /**
  Check if the game is a tie.
  @return return true if the board has no empty cell and there is no winner; otherwise, return false
  */
  public static boolean tie(){
    for (int row = 0; row < 3; row++) {
       for (int col = 0; col < 3; col++) {
          if (TTT100.board[row][col] == ' ') {
             return false;  // not every cell is filled in
          }
       }
    }
    return true;  // no empty cells
  }

  /**
  Check if the game has a winner.
  If yes, returns true; if no, returns false.
  @param currentPlayer current player
  @param currentR the number of row the current player puts X or O on
  @param currentC the number of column the current player puts X or O on
  @return return true if a player wins; return falls if nobody has won
  */
  public static boolean win(char currentPlayer, int currentR, int currentC){
    return ((TTT100.board[currentR][0] == currentPlayer)&&(TTT100.board[currentR][1] == currentPlayer)&&(TTT100.board[currentR][2] == currentPlayer)) //if the current player gets three in a row
        || ((TTT100.board[0][currentC] == currentPlayer)&&(TTT100.board[1][currentC] == currentPlayer)&&(TTT100.board[2][currentC] == currentPlayer)) //if the current player gets three in a column
        || ((currentR == currentC)&&(TTT100.board[0][0] == currentPlayer)&&(TTT100.board[1][1] == currentPlayer)&&(TTT100.board[2][2] == currentPlayer)) //if the current player has three in a diagonal
        || ((currentR + currentC == 2)&&(TTT100.board[0][2] == currentPlayer)&&(TTT100.board[1][1] == currentPlayer)&&(TTT100.board[2][0] == currentPlayer)); //if the current player has three in the opposite diagonal
  }


  /**
  Check which player is the winner or noone is the winner.
  @param currentR the number of row the current player puts X or O on
  @param currentC the number of column the current player puts X or O on
  */
  public static void checkWinner(int currentR, int currentC){
     char currentPlayer = TTT100.board[currentR][currentC];
     if (win(currentPlayer,TTT100.currentR,TTT100.currentC)){ //if we have a winner at this time
       if(currentPlayer == 'X'){ //the winner is the user
         TTT100.dialog.setText("You won the game!");
       }else if (currentPlayer == 'O'){ //the winner is the computer
         TTT100.dialog.setText("You lost the game!");
       }
       disableBoard();
     }else if(tie()){ //if there is no winner at this time
       TTT100.dialog.setText("The game was tied!");
       disableBoard();
     }
   }

 /**
  Disables board when game ends.
 */
 public static void disableBoard(){
   for (int row = 0; row < 3; row++) {
     for (int column = 0; column < 3; column++) {
       TTT100.boardB[row][column].setEnabled(false); //all buttons cannot be pressed again
     }
   }
 }


}
