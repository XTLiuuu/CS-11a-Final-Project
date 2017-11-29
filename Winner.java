package TicTacToe;

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
          if (board[row][col] == ' ') {
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
    return ((board[currentR][0] == currentPlayer)&&(board[currentR][1] == currentPlayer)&&(board[currentR][2] == currentPlayer))
        || ((board[0][currentC] == currentPlayer)&&(board[1][currentC] == currentPlayer)&&(board[2][currentC] == currentPlayer))
        || ((currentR== currentC)&&(board[0][0] == currentPlayer)&&(board[1][1] == currentPlayer)&&(board[2][2] == currentPlayer))
        || ((currentR + currentC == 2)&&(board[0][2] == currentPlayer)&&(board[1][1] == currentPlayer)&&(board[2][0] == currentPlayer));
  }
}
