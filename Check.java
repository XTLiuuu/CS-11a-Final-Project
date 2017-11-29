package TicTacToe;




public class Check{

/**
  returns the the move of user to corner after checking the corners are empty
  @param check is a boolean expression
  @return the move of user to corner
*/
  public static boolean checkCorner(boolean check){
   if(board[0][0]==' '){
     return Move(0,0,check);
   } else if(board[0][2]==' '){
     return Move(0,2,check);
   } else if(board[2][2]==' '){
     return Move(2,2,check);
   } else if(board[2][0]==' '){
     return Move(2,0,check);
   } else{
     return false;
   }
 }
}
