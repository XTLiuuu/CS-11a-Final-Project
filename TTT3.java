import java.util.Scanner;

public class TTT3{
  public static char[][] board = new char[3][3];
  public static boolean first;
  public static Scanner input = new Scanner(System.in);
  public static int currentR,currentC;
  public static String currentS="P";
  public static char currentPlayer;
  public static int i=1;

  public static void main(String[] args) {
    initialize(); //initialize the game before every new game begins
    System.out.println("Would you like to go first?");
    first=TextIO.getlnBoolean();
    do{
      playTurn(); //ask the user who will play first
      //printboard();//print the current board
      if (currentS.equals("X")){
        System.out.println("You win!");}
      else if (currentS.equals("O")){
        System.out.println("I win!");
      }
      else if (currentS.equals("T")){
        System.out.println("This is a tie!");
      }
    }while(currentS.equals("P"));
  }

  public static void initialize(){
    for(int row=0; row<3; row++){
      for (int column=0; column<3; column++){ //go through every rows and columns
        board[row][column]=' '; //every space is empty
      }
    }
  }

  public static void playTurn(){
    if(first){
      player();
      i++;
      first=false;
    }
    else{
      computer();
      printboard();
      first=true;
      i++;
    }
  }

  public static void computer(){
    System.out.println("Now it's my turn");
    System.out.println(" ");
    if(i%2==0){
      if(board[1][1]==' '){ //computer go second
        board[1][1]='O';
        currentR=1;
        currentC=1;
      }

    }
    if (i%2!=0){ //computer go first
      if(i==1){
        board[0][0]='O';
        currentR=0;
        currentC=0;
      }
      else if(i==3){
        if(board[1][1]=='X'){
          board[2][2]='O';
          currentR=2;
          currentC=2;
        }
        else{
          if(currentR==0){
            board[2][0]='O';
            currentR=2;
            currentC=0;
          }
          else{
            board[0][2]='O';
            currentR=0;
            currentC=2;
          }
        }
      }
      else{
        if(twoOccupied()==false){
          if(Corner()==false){
            checkempty();
          }
        }
      }
    }
    checkwinner(currentR,currentC);
  }

  public static boolean Corner(){
    boolean check=true;
    return check=checkCorner(check);
  }

  public static boolean checkCorner(boolean check){
    if(board[0][0]==' '){
      return Move(0,0,check);
    }
    else if(board[2][2]==' '){
      return Move(2,2,check);
    }
    else if(board[0][2]==' '){
      return Move(0,2,check);
    }
    else if(board[2][0]==' '){
      return Move(2,0,check);
    }
    else{
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

  public static boolean twoOccupied(){
    boolean check=true;
    if(Row()==false) {
      if(Col()==false) {
        if(checkDiagonal()==false){//check diagonal from left to right
          if(checkOppositeDiagonal()==false){// check diagonal from right to left
            check=false;
          }
        }
      }
    }
    return check;
  }

  public static boolean Row(){
    boolean check=true;
    return check=checkRow(check);
  }

  public static boolean checkRow(boolean check){
    for(int row=0;row<3;row++){
      if((board[row][0]==board[row][1])&&(empty(row,2))) {
        return Move(row,2,check);
      } else if((board[row][0]==board[row][2])&&(empty(row,1))){
        return Move(row,1,check);
      } else if((board[row][1]==board[row][2])&&(empty(row,0))){
        return Move(row,0,check);
      } else {}
    }
    return false;
  }

  public static boolean Move(int a, int b, boolean check){
    board[a][b]='O';
    currentR=a;
    currentC=b;
    return check;
  }

  public static boolean Col(){
    boolean check=true;
    return check=checkCol(check);
  }

  public static boolean checkCol(boolean check){
    for(int col=0;col<3;col++){
      if((board[0][col]==board[1][col])&&(empty(0,col))){
        return Move(0,col,check);
      } else if((board[0][col]==board[2][col])&&(empty(1,col))){
        return Move(1,col,check);
      } else if((board[1][col]==board[2][col])&&(empty(2,col))){
        return Move(2,col,check);
      } else {}
    }
    return false;
  }


  public static boolean checkDiagonal(){
    boolean check=true;
    if((board[0][0]==board[1][1])&&(empty(2,2))){
      return Move(2,2,check);
    } else if((board[0][0]==board[2][2])&&(empty(1,1))){
      return Move(1,1,check);
    } else if((board[1][1]==board[2][2])&&(empty(0,0))){
      return Move(0,0,check);
    } else{
      return false;
    }
  }

  public static boolean checkOppositeDiagonal(){
    boolean check=true;
    if((board[0][2]==board[1][1])&&(empty(2,0))){
      return Move(2,0,check);
    } else if((board[0][2]==board[2][0])&&(empty(1,1))){
      return Move(1,1,check);
    } else if((board[1][1]==board[2][0])&&(empty(0,2))){
      return Move(0,2,check);
    } else{
      return false;
    }
  }

  public static void player(){
    System.out.println("Please enter your move");
    int row=input.nextInt()-1;
    int column=input.nextInt()-1;
    if ((row >= 0)&&(row < 3)&&(column>= 0)&&(column< 3)&&(board[row][column]==' ')){
      board[row][column]='X';
      currentR=row;
      currentC=column;
      printboard(); //print the board after this move
      checkwinner(currentR,currentC); //
      first=false;
    }
    else{
      System.out.println("This move is not valid. Please try again");
      player();
   }
 }


  public static void printboard(){
    System.out.println();
    System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
    System.out.println("---------");
    System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
    System.out.println("---------");
    System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
    System.out.println();
  }

  public static void checkwinner(int currentR,int currentC){
    currentPlayer=(char)(board[currentR][currentC]);
    if (win(currentPlayer,currentR, currentC)){
      if(currentPlayer=='X'){
        currentS="X";
      }
      else{
        currentS="O";
      }
    }
    else if(tie()){
      currentS="T";
    }
  }

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

  public static boolean win(char currentPlayer, int currentR, int currentC){
    return ((board[currentR][0] == currentPlayer)&&(board[currentR][1] == currentPlayer)&&(board[currentR][2] == currentPlayer))
        || ((board[0][currentC] == currentPlayer)&&(board[1][currentC] == currentPlayer)&&(board[2][currentC] == currentPlayer))
        || ((currentR== currentC)&&(board[0][0] == currentPlayer)&&(board[1][1] == currentPlayer)&&(board[2][2] == currentPlayer))
        || ((currentR + currentC == 2)&&(board[0][2] == currentPlayer)&&(board[1][1] == currentPlayer)&&(board[2][0] == currentPlayer));
  }


  public static boolean empty(int row,int col){
    if (board[row][col]==' '){
      return true;
    } else {
      return false;
    }
  }
}
