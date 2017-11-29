package TicTacToe;

public class Check{

  /**
    generates a String in response to a user response
    passed in as an array of words, userResponse, Response and an integer i
    @param words the user's response after separating sentences into words
    @param userResponse the integrated response as a sentence
    @param Response an array contains all history responses
    @param i the number of history responses
    @return a string responding to the user's words, specific questions or history responses
  */

  public static boolean Edge(){
    boolean check=true;
    return check=checkEdge(check);
  }

  public static boolean checkEdge(boolean check){
    if(board[0][1]==' '){
      return Move(0,1,check);
    } else if(board[1][0]==' '){
      return Move(1,0,check);
    } else if(board[1][2]==' '){
      return Move(1,2,check);
    } else if(board[2][1]==' '){
      return Move(2,1,check);
    } else{
      return false;
    }
  }

  public static boolean Corner(){
    boolean check=true;
    return check=checkCorner(check);
  }

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

  public static void checkempty(){
    for (int row = 0; row < 3; row++) {
       for (int col = 0; col < 3; col++) {
          if (board[row][col] == ' ') {
             board[row][col] = 'O';
             currentR=row;
             currentC=col;
             break;
          }
       }
    }
  }

  public static boolean NoughtsOrCross(char symbol){
    boolean check=true;
    if(Row(symbol)==false) {
      if(Col(symbol)==false) {
        if(checkDiagonal(symbol)==false){//check diagonal from left to right
          if(checkOppositeDiagonal(symbol)==false){// check diagonal from right to left
            check=false;
          }
        }
      }
    }
    return check;
  }


  public static boolean Row(char symbol){
    boolean check=true;
    return check=checkRow(check,symbol);
  }

  public static boolean checkRow(boolean check,char symbol){
    for(int row=0;row<3;row++){
      if (twoOccupied(row,0,row,1,row,2,check,symbol)){
        return true;
      } else if (twoOccupied(row,0,row,2,row,1,check,symbol)){
        return true;
      } else if (twoOccupied(row,1,row,2,row,0,check,symbol)){
        return true;
      } else {}
    }
    return false;
  }

  /**
  checks whether the computer should make a move on a cell
  @param a row number of cell 1
  @param b column number of cell 1
  @param c row number of cell 2
  @param d column number of cell 2
  @param e row number of cell 3
  @param f column number of cell 3
  @param check initialized value is true
  @return the computer's move if true, return false if the condition is false
  */
  public static boolean twoOccupied(int a, int b, int c,int d,int e,int f,boolean check,char symbol){
    if(board[a][b]==symbol && board[c][d]==symbol && empty(e,f)) {
      //checks whether two cells on the same row or same column are occupied by the same player
      //and whether the third one is empty so that the computer will take this cell
      return Move(e,f,check);
    } else {
      return false;
    }
  }


  public static boolean Col(char symbol){
    boolean check=true;
    return check=checkCol(check,symbol);
  }

  /**
  checks whether there are two cells in the same column are occupied by the same player
  @param check initialized value is true
  @param b column number of cell 1
  */

  public static boolean checkCol(boolean check,char symbol){
    for(int col=0;col<3;col++){
      if (twoOccupied(0,col,1,col,2,col,check,symbol)){
        return true;
      } else if (twoOccupied(0,col,2,col,1,col,check,symbol)){
        return true;
      } else if (twoOccupied(1,col,2,col,0,col,check,symbol)){
        return true;
      } else {}
    }
    return false;
  }


  public static boolean checkDiagonal(char symbol){
    boolean check=true;
    if (!twoOccupied(0,0,1,1,2,2,check,symbol)){
      if (!twoOccupied(0,0,2,2,1,1,check,symbol)) {
        if (!twoOccupied(1,1,2,2,0,0,check,symbol)) {
          check=false;
        }
      }
    }
    return check;
  }


  public static boolean checkOppositeDiagonal(char symbol) {
    boolean check=true;
    if (!twoOccupied(0,2,1,1,2,0,check,symbol)){
      if (!twoOccupied(0,2,2,0,1,1,check,symbol)) {
        if (!twoOccupied(1,1,2,0,0,2,check,symbol)) {
          check=false;
        }
      }
    }
    return check;
  }


  /**
    checks whether a certain cell is empty
    passed in as an integer row and an integer col
    @param row the row number of this cell
    @param col the column number of this cell
    @return true if the cell is empty, false if the cell is occupied
  */

  public static boolean empty(int row,int col){
    if (board[row][col]==' '){
      return true;
    } else {
      return false;
    }
  }

}
