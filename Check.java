package TicTacToe;




public class Check{

/**
  returns the the move of computer player to one corner of the form if the cell
  is still empty at this time
  @param check is a boolean variable
  @return the move of user to corner
*/
  public static boolean checkCorner(boolean check){
   if(board[0][0]==' '){
     return Move(0,0,check); //if cell[0][0] is empty the computer take cell[0][0]
   } else if(board[0][2]==' '){
     return Move(0,2,check); //if cell[0][2] is empty the computer take cell[0][2]
   } else if(board[2][2]==' '){
     return Move(2,2,check); //if cell[2][2] is empty the computer take cell[2][2]
   } else if(board[2][0]==' '){
     return Move(2,0,check); //if cell[2][0] is empty the computer take cell[[2][0]
   } else{  //if all the four corner cell are not empty
     return false;
   }
 }

 /**
   Check.checkEmpty finds the empty cells in this 3*3 form and let computer
   player to take one
 */
   public static void checkEmpty(){
     for (int row = 0; row < 3; row++) { //from row 0 to row 2
        for (int col = 0; col < 3; col++) { //from column 0 to column 2
           if (board[row][col] == ' ') { //check if the cell is empty at this time
              board[row][col] = 'O'; //let computer player take this cell
              currentR=row; //set currentR to the place the computer player just take
              currentC=col; //set currentC to the place the computer player just take
              break;
           }
         }
       }
     }
}
