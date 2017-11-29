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

  public static boolean goCenter(){
    boolean check = true;
    if(board[1][1]==' '){
      return check=Move(1,1,check);
    } else {
      return false;
    }
  }


  public static void computer(){
    System.out.println("Now it's my turn");
    System.out.println(" ");
    if(i%2==0){// user go first
      if(!goCenter()){
        if(!NoughtsOrCross('O')){
          if(!NoughtsOrCross('X')){
            if(!Edge()){
              checkempty();
            }
          }
        }
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
      else if((i==5)&&(board[1][1]==' ')){
        board[1][1]='O';
        currentR=0;
        currentC=0;
      }
      else{
        if(!NoughtsOrCross('O')){
          if(!NoughtsOrCross('X')){
            if(Corner()==false){
              checkempty();
            }
          }
        }
      }
    }
    checkwinner(currentR,currentC);
  }

  public static boolean Edge(){
    boolean check=true;
    return check=checkEdge(check);
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


  /**
  @param a row number of grid 1
  @param b column number of grid 1
  @param c row number of grid 2
  @param d column number of grid 2
  @param e row number of grid 3
  @param f column number of grid 3
  @param check initialized value is true
  */
  public static boolean twoOccupied(int a, int b, int c,int d,int e,int f,boolean check,char symbol){
    if(board[a][b]==symbol && board[c][d]==symbol && empty(e,f)) {
      return Move(e,f,check);
    } else {
      return false;
    }
  }

  public static boolean Move(int a, int b, boolean check){
    board[a][b]='O';
    currentR=a;
    currentC=b;
    return check;
  }

  public static boolean Col(char symbol){
    boolean check=true;
    return check=checkCol(check,symbol);
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
