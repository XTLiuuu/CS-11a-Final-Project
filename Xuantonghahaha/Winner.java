package TicTacToe;

public class Winner {

  /**
  This contains methods checking the game process and printing out the game results
  @author TicTacToe
  */

  /**
  checkWinner(currentR,currentC) checks which player is the winner or noone is the winner.
  @param currentR the number of row the current player puts X or O on
  @param currentC the number of column the current player puts X or O on
  */

  public static void checkWinner(int currentR, int currentC){
     TTT100.currentPlayer=(char)(TTT100.board[currentR][currentC]);
     if (win(TTT100.currentPlayer,TTT100.currentR,TTT100.currentC)){ //if we have a winner at this time
       if(TTT100.currentPlayer=='X'){ //the winner is the user
         TTT100.currentS="X";
       }
       else{ //the winner is the computer
         TTT100.currentS="O";
       }
     }
     else if(tie()){ //if there is no winner at this time
       TTT100.currentS="T";
     }
   }

   /**
   win(currentPlayer,currentR,currentC) checks if the game has a winner.
   If yes, returns true; if no, returns false.
   @param currentPlayer current player
   @param currentR the number of row the current player puts X or O on
   @param currentC the number of column the current player puts X or O on
   @return return true if a player wins; return falls if nobody has won
   */
   public static boolean win(char currentPlayer, int currentR, int currentC){
     return ((TTT100.board[currentR][0] == currentPlayer)&&(TTT100.board[currentR][1] == currentPlayer)&&(TTT100.board[currentR][2] == currentPlayer)) //if the current player gets three in a row
         || ((TTT100.board[0][currentC] == currentPlayer)&&(TTT100.board[1][currentC] == currentPlayer)&&(TTT100.board[2][currentC] == currentPlayer)) //if the current player gets three in a column
         || ((currentR== currentC)&&(TTT100.board[0][0] == currentPlayer)&&(TTT100.board[1][1] == currentPlayer)&&(TTT100.board[2][2] == currentPlayer)) //if the current player has three in a diagonal
         || ((currentR + currentC == 2)&&(TTT100.board[0][2] == currentPlayer)&&(TTT100.board[1][1] == currentPlayer)&&(TTT100.board[2][0] == currentPlayer)); //if the current player has three in the opposite diagonal
   }

  /**
  tie() checks if the game is a tie.
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
 printGameResult() prints out the result of the game
 */
 public static void printGameResult(){
   if (TTT100.currentS.equals("X")){ //"X" will be assigned to currentS when the user wins
     System.out.println("You win!");} // print out the game result
   else if (TTT100.currentS.equals("O")){ //"O" will be assigned to currentS when the computer wins
     System.out.println("I win!"); // print out the game result
   }
   else if (TTT100.currentS.equals("T")){ //"T" will be assigned to currentS when it is a tie
     System.out.println("This is a tie!"); //print out the game result
   }
 }
}
