import java.util.Scanner;

public class TTT3{
  public static char[][] board = new int[3][3];
  public static boolean first;
  public static Scanner input = new Scanner(System.in);
  public static int currentR,currentC;
  public static String currentS="P";
  public static char currentPlayer;

  public static void main(String[] args) {
    initialize(); //initialize the game before every new game begins
    do{
      playturn(); //ask the user who will play first
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

  public static void playturn(){
    System.out.println();
    System.out.println("Would you like to go first?");
    first=TextIO.getlnBoolean();
    printboard();
    if(first){
      player();
    }
    //else{
    //  computer();
    //}
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
    System.out.println("-------------");
    System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
    System.out.println("-------------");
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
}



public static void computerMove(){
  if(!twoOccupied()){

  }
}


public static boolean twoOccupied(){
  boolean check=true;
  if(!checkRow()) {
    checkCol();
  } else if(!checkCol()){
    checkDiagnol();//check diagonal from left to right
  } else if(!checkDiagnol()){
    checkOppositeDiagonal();// check diagonal from right to left
  } else {
      check=false;
  }
  return check;
}


public static boolean checkRow(){
  boolean check=true;
  for(int row=0;row<3;row++){
    if(board[row][0]==board[row][1]) {
      board[row][2]='O';
    } else if(board[row][0]==board[row][2]){
      board[row][1]='O';
    } else if(board[row][1]==board[row][2]){
      board[row][0]='O';
    } else {
      check=false;
    }
  }
  return check;
}


public static boolean checkCol(){
  boolean check=true;
  for(int col=0;col<3;row++){
    if(board[0][col]==board[1][col]) {
      board[0][col]='O';
    } else if(board[0][col]==board[2][col]){
      board[1][col]='O';
    } else if(board[1][col]==board[2][col]){
      board[2][col]='O';
    } else {
      check=false;
    }
  }
  return check;
}


public static boolean checkDiagnol(){
  boolean check=true;
  if(board[0][0]==board[1][1]){
    board[2][2]='O';
  } else if(board[0][0]==board[2][2]){
    board[1][1]='O';
  } else if(board[1][1]==board[2][2]){
    board[0][0]='O';
  } else{
    check=false;
  }
  return check;
}

public static boolean checkOppositeDiagnol(){
  boolean check=true;
  if(board[0][2]==board[1][1]){
    board[2][0]='O';
  } else if(board[0][2]==board[2][0]){
    board[1][1]='O';
  } else if(board[1][1]==board[2][0]){
    board[0][2]='O';
  } else{
    check=false;
  }
  return check;
}
