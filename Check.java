package TicTacToe;

public class Check{

  /**
  check if the center cell is empty; if yes, let the computer take that cell
  @return true if the center cell is empty and the computer takes that cell; false if the center cell is already occupied
  */
  public static boolean goCenter(){
    boolean check = true; // initialize check as true
    if(TTT100.board[1][1]==' '){ // check if the center cell is empty
      return check=Board.Move(1,1,check); // return true; and computer occupies the center cell
    } else {
      return false; // return false if the center cell is already occupied
    }
  }


  /**
  check if there are empty cells on the edges (i.e. cell [0][1],[1][0],[1][2],[2][1])
  @return true if there are empty cells on the edges
  */
  public static boolean edge(){
    boolean check=true; // intialize check as true
    // return true if computer occupies one of cell0][1], cell[1][0], cell[1][2], cell[2][1]; otherwise, false
    return check=checkEdge(check);
  }

  /**
  check if one of cell0][1], cell[1][0], cell[1][2], cell[2][1] is empty; if yes, the computer occupies that cell
  @param check the initail value is true
  @return true if one of cell0][1], cell[1][0], cell[1][2], cell[2][1] is empty; otherwise, false
  */
  public static boolean checkEdge(boolean check){
    if(TTT100.board[0][1]==' '){ // check if cell[0][1] is empty
      return Board.Move(0,1,check); // return true; and computer occupies cell [0][1]
    } else if(TTT100.board[1][0]==' '){ // check if cell[1][0] is empty
      return Board.Move(1,0,check); // return true; and computer occupies cell [1][0]
    } else if(TTT100.board[1][2]==' '){ // check if cell[1][2] is empty
      return Board.Move(1,2,check); // return true; and computer occupies cell [1][2]
    } else if(TTT100.board[2][1]==' '){ // check if cell[2][1] is empty
      return Board.Move(2,1,check); // return true; and computer occupies cell [2][1]
    } else{
      return false; // return false if none of cell0][1], cell[1][0], cell[1][2], cell[2][1] is empty
    }
  }

  /**
  check if there is empty cell on the corner
  @return true there is empty cell on the corners
  */
  public static boolean corner(){
    boolean check=true;
    return check=checkCorner(check);
  }

  /**
  returns the the move of computer player to one corner of the board if the cell
  is still empty at this time
  @param check initail value is true
  @return true if computer moves to an empty cell in the corner; otherwise, false
  */
  public static boolean checkCorner(boolean check){
    if(TTT100.board[0][0]==' '){ // check if cell[0][0] is empty
      return Board.Move(0,0,check); // return true; and computer occupies cell [0][0]
    } else if(TTT100.board[0][2]==' '){ // check if cell[0][2] is empty
      return Board.Move(0,2,check); // return true; and computer occupies cell [0][2]
    } else if(TTT100.board[2][2]==' '){ // check if cell[2][2] is empty
      return Board.Move(2,2,check); // return true; and computer occupies cell [2][2]
    } else if(TTT100.board[2][0]==' '){ // check if cell[2][0] is empty
      return Board.Move(2,0,check); // return true; and computer occupies cell [2][0]
    } else{
      return false; // return false if none of the corner cells is empty
    }
  }

  /**
  Finds the empty cells in this 3*3 board and let computer take the first
  empty cell it finds
  */
  public static void checkEmpty(){
    int x=0;
    for (int row = 0; row < 3; row++) {
       for (int col = 0; col < 3; col++) {
          if ((TTT100.board[row][col] == ' ')&&(x==0)) {
             TTT100.board[row][col] = 'O';
             TTT100.currentR=row;
             TTT100.currentC=col;
             x=1;
          }
       }
    }
  }

  /**
  Check if there are two noughts or crosses on a single row, column or diagonal
  @param symbol 'X' or 'O'
  @return true if there are two noughts or crosses in a single row, column or diagonal; otherwise, false
  */
  public static boolean noughtsOrCross(char symbol){
    boolean check=true; // initialize check as true
    if(!row(symbol)) { // check if there are two noughts or two crosses on a single row
      if(!col(symbol)) { // check if there are two noughts or two crosses on a single column
        if(!checkDiagonal(symbol)){ //check if there are two noughts or two crosses on the diagonal from left to right
          if(!checkOppositeDiagonal(symbol)){ // check if there are two noughts or two crosses on the diagonal from right to left
            check=false; // set check as false if there is no single row, column, or diagonal having two noughts or two crosses
          }
        }
      }
    }
    return check;
  }

  /**
  Check if there are two noughts or two crosses on a single row
  @param symbol 'X' or 'O'
  @return true if there are two noughts or two crosses on a single row; otherwise, false
  */
  public static boolean row(char symbol){
    boolean check=true; // initialize check as true
    return check=checkRow(check,symbol); // return false if neithor row 0,1,or 2 has two noughts or crosses
  }


  /**
  Check if there are two noughts or two crosses on row 0,1,or 2
  @param check initial value is true
  @param symbol 'X' or 'O'
  @return true if there are two noughts or two crosses on row 0,1,or 2; otherwise, false
  */
  public static boolean checkRow(boolean check,char symbol){
    for(int row=0;row<3;row++){
      // check if cell[row][0] and cell[row][1] are occupied by the same symbol; check if cell[row][2] is empty
      if (twoOccupied(row,0,row,1,row,2,check,symbol)){
        return true;
      // check if cell[row][0] and cell[row][2] are occupied by the same symbol; check if cell[row][1] is empty
      } else if (twoOccupied(row,0,row,2,row,1,check,symbol)){
        return true;
      // check if cell[row][1] and cell[row][2] are occupied by the same symbol; check if cell[row][0] is empty
      } else if (twoOccupied(row,1,row,2,row,0,check,symbol)){
        return true;
      } else {}
    }
    return false; // return false if neithor row 0,1,or 2 has two noughts or two crosses
  }

  /**
  checks if a row, column, or diagonal has two cells occupied by the same symbol('X' or 'O')
  the computer will occupy the remaining cell on that row, column, or diagonal if it's empty
  @param a row number of cell 1
  @param b column number of cell 1
  @param c row number of cell 2
  @param d column number of cell 2
  @param e row number of cell 3
  @param f column number of cell 3
  @param check initial value is true
  @param symbol 'X' or 'O'
  @return true if a row, column, or diagonal has two cells with the same symbol and the remaining cell is empty; otherwise, false
  */
  public static boolean twoOccupied(int a, int b, int c,int d,int e,int f,boolean check,char symbol){
    if(TTT100.board[a][b]==symbol && TTT100.board[c][d]==symbol && empty(e,f)) {
      return Board.Move(e,f,check);
    } else {
      return false;
    }
  }

  /**
  Check if there are two noughts or two crosses on a single column
  @param symbol 'X' or 'O'
  @return true if there are two noughts or two crosses on a single column; otherwise, false
  */
  public static boolean col(char symbol){
    boolean check=true; // initialize check as true
    return check=checkCol(check,symbol);
  }

  /**
  Check if there are two noughts or two crosses on column 0,1,or 2
  @param check initial value is true
  @param symbol 'X' or 'O'
  @return true if there are two noughts or two crosses on column 0,1,or 2; otherwise, false
  */
  public static boolean checkCol(boolean check,char symbol){
    for(int col=0;col<3;col++){
      // check if cell[0][col] and cell[1][col] are occupied by the same symbol; check if cell[2][col] is empty
      if (twoOccupied(0,col,1,col,2,col,check,symbol)){
        return true;
      // check if cell[0][col] and cell[2][col] are occupied by the same symbol; check if cell[1][col] is empty
      } else if (twoOccupied(0,col,2,col,1,col,check,symbol)){
        return true;
      // check if cell[1][col] and cell[2][col] are occupied by the same symbol; check if cell[0][col] is empty
      } else if (twoOccupied(1,col,2,col,0,col,check,symbol)){
        return true;
      } else {}
    }
    return false; // return false if neithor column 0,1,or 2 has two noughts or two crosses
  }

  /**
  Check if there are two noughts or two crosses on the diagonal from left to right
  @param symbol 'X' or 'O'
  @return true if there are two noughts or two crosses on the diagonal from left to right; otherwise, false
  */
  public static boolean checkDiagonal(char symbol){
    boolean check=true; // initailize check as true
    // check if cell[0][0] and cell[1][1] are occupied by the same symbol; check if cell[2][2] is empty
    if (!twoOccupied(0,0,1,1,2,2,check,symbol)){
      // check if cell[0][0] and cell[2][2] are occupied by the same symbol; check if cell[1][1] is empty
      if (!twoOccupied(0,0,2,2,1,1,check,symbol)) {
        // check if cell[1][1] and cell[2][2] are occupied by the same symbol; check if cell[0][0] is empty
        if (!twoOccupied(1,1,2,2,0,0,check,symbol)) {
          check=false; // return false if there are no two noughts or two crosses on the diagonal from left to right
        }
      }
    }
    return check;
  }

  /**
  Check if there are two noughts or two crosses on the diagonal from right to left
  @param symbol 'X' or 'O'
  @return true if there are two noughts or two crosses on the diagonal from right to left; otherwise, false
  */
  public static boolean checkOppositeDiagonal(char symbol) {
    boolean check=true; // initailize check as true
    // check if cell[0][2] and cell[1][1] are occupied by the same symbol; check if cell[2][0] is empty
    if (!twoOccupied(0,2,1,1,2,0,check,symbol)){
      // check if cell[0][2] and cell[2][0] are occupied by the same symbol; check if cell[1][1] is empty
      if (!twoOccupied(0,2,2,0,1,1,check,symbol)) {
        // check if cell[1][1] and cell[2][0] are occupied by the same symbol; check if cell[0][2] is empty
        if (!twoOccupied(1,1,2,0,0,2,check,symbol)) {
          check=false; // return false if there are no two noughts or two crosses on the diagonal from right to left
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
    @return true if the cell is empty, false if the cell is occupied; otherwise, false
  */
  public static boolean empty(int row,int col){
    if (TTT100.board[row][col]==' '){ // check if a specific cell is empty
      return true;
    } else {
      return false;
    }
  }

}
