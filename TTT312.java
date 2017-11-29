package TicTacToe;

import java.util.Scanner;

public class TTT3{

  public static char[][] board = new char[3][3]; //declare an array of a 3x3 board
  public static boolean first; //whether the player want to move first
  public static Scanner input = new Scanner(System.in); //input
  public static int currentR,currentC; //currentR is the row of the cell in the current move, currentC is the column of the cell in current move
  public static String currentS="P"; //currentS is the game status, "P" represents playing
  public static char currentPlayer; //currentPlayer is the current player for the next move
  public static int i=1; //i is the number of moves that have been made


  /**
  This program is a TicTacToe game between the computer and one player
  @param args an array of Strings which we ignore
  */

  public static void main(String[] args) {
    initialize(); //initialize the game before every new game begins
    System.out.println("Would you like to go first?");
    first=TextIO.getlnBoolean(); //whether the user chooses to play first
    do{
      playTurn(); //the main game class of computer and user
      if (currentS.equals("X")){ //"X" will be assigned to currentS when the user wins
        System.out.println("You win!");} // print out the game result
      else if (currentS.equals("O")){ //"O" will be assigned to currentS when the computer wins
        System.out.println("I win!"); // print out the game result
      }
      else if (currentS.equals("T")){ //"T" will be assigned to currentS when it is a tie
        System.out.println("This is a tie!"); //print out the game result
      }
    }while(currentS.equals("P")); //currentS remains the initialize value when the game is in process
  }

  /**
  initialize the game before every new game begins
  set every cells in rows and columns to be empty
  */

  public static void initialize(){
    for(int row=0; row<3; row++){
      for (int column=0; column<3; column++){ //go through every rows and columns
        board[row][column]=' '; //every cell is empty
      }
    }
  }

  /**
  The main game class, call the user's move and the computer's move
  and print out the board after each moves
  */

  public static void playTurn(){
    if(first){ //the user chooses to play first or the player's turn to move
      player(); //the user's move
      i++; //the number of moves in the game increases by 1
      first=false; //the next player will be the computer
    }
    else{
      computer(); //the computer's move
      printBoard(); //print out the current board
      first=true; //the next player will be the user
      i++; //the number of moves in the game increases by 1
    }
  }

  /**
  checks whether the center cell of this board is empty
  */
  public static boolean goCenter(){
    boolean check = true;
    if(board[1][1]==' '){
      return check=Board.move(1,1,check); //the computer will occupy the center cell
    } else {
      return false; //return false when it is not empty
    }
  }

  /**
  generates the computer's move
  */

  public static void computer(){
    System.out.println("Now it's my turn");
    System.out.println(" ");
    if(i%2==0){ //when user goes first, the move number of the computer is even
      if(!goCenter()){ //if the center cell is not empty
        if(!Check.noughtsOrCross('O')){ //check if there are two 'O' on the same row, column or diagonal
          if(!Check.noughtsOrCross('X')){ //check if there are two 'X' on the same row, column or diagonal
            if(!Check.edge()){ //check if there are empty cells on the edge
              Check.checkEmpty(); //the computer will make a move
            }
          }
        }
      }
    }
    //decide the computer's next move based on the user's move
    if (i%2!=0){ //when computer goes first, the move number of the computer is odd
      if(i==1){ //the first move of the game (made by computer)
        board[0][0]='O'; //computer will take the corner
        currentR=0; //set the current row number to the currentR, which is 0
        currentC=0; //set the current column number to the currentC, which is 0
      }
      else if(i==3){ //the third move of the game (made by computer)
        if(board[1][1]=='X'){ //check whether the center cell is occupied by the user (the user's first move)
          board[2][2]='O'; //the computer's move
          currentR=2; //set current row number to currnetR
          currentC=2; //set current column number to currnetC
        }
        else{
          //if the center cell is still empty
          //the computer avoids occupying a cell on the same row of the computer's first move
          if(currentR==0){ //if the user occupies a cell on the same row of the computer's first move
            board[2][0]='O'; //the computer takes the [2][0]
            currentR=2;
            currentC=0;
          }
          else{ //if the user does not occupy a cell on the same row of the computer's first move
            board[0][2]='O'; //the computer takes the [0][2]
            currentR=0;
            currentC=2;
          }
        }
      }
      else if((i==5)&&(board[1][1]==' ')){ //corporate with i=3???????????
        board[1][1]='O';
        currentR=0;
        currentC=0;
      }
      else{
        if(!Check.noughtsOrCross('O')){
          if(!Check.noughtsOrCross('X')){
            if(Check.corner()==false){
              Check.checkEmpty();
            }
          }
        }
      }
    }
    Board.checkWinner(currentR,currentC);  //check if there is a winner or a tie or still in process
  }


  /**
  The user's move
  */

  public static void player(){
    System.out.println("Please enter your move");
    int row=input.nextInt()-1; //turn the format of row into the right version that the computer can read ?
    int column=input.nextInt()-1; //turn the format of column into the right version that the computer can read ?
    if ((row >= 0)&&(row < 3)&&(column>= 0)&&(column< 3)&&(board[row][column]==' ')){ //check if the user's move is valid (whether the cell is empty)
      board[row][column]='X'; //input the user's move
      currentR=row;
      currentC=column;
      Board.printBoard(); //print the board after this move
      checkW=Board.winner(currentR,currentC); //check the game status
      first=false; //change the next player to computer
    }
    else{ //if the user's move is not valid
      System.out.println("This move is not valid. Please try again");
      player(); //ask the user to input again
   }
 }

 /**
 print the current board
 print the move and the other features of the board
??空格对嘛
 */


  public static void printboard(){
    System.out.println();
    System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
    System.out.println("---------");
    System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
    System.out.println("---------");
    System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
    System.out.println();
  }

  /**
  checks the game status
  carry in as an integer currentR and an integer currentC
  */

  public static void checkWinner(int currentR,int currentC){
    currentPlayer=(char)(board[currentR][currentC]); //currentPlayer is the symbol of the current cell
    //check if the game is still in process
    if (win(currentPlayer,currentR, currentC)){ //if someone wins the game
      if(currentPlayer=='X'){ //if the current player is 'X'
        currentS="X"; //assign 'X' to currentS (change the currentS from 'P' to 'S')
      }
      else{ //the current player is 'O'
        currentS="O"; //assign 'O' to currentS (change the currentS from 'P' to 'O')
      }
    }
    else if(tie()){ //if the game result is a tie
      currentS="T"; //assign 'T' to currentS (change the currentS from 'P' to 'T')
    }
  }


  /**
  check whether a tie has appeared
  if every cells are occupied and nobody wins, then the game is a tie
  */
  public static boolean tie(){
    for (int row = 0; row < 3; row++) { //go through every row and every column
       for (int col = 0; col < 3; col++) {
          if (board[row][col] == ' ') { //check whether there are empty spaces left
             return false;  // not every cell is filled in
          }
       }
    }
    return true;  // no empty cells
  }

  /**
  check whether someone has won the game
  carry in as a char currentPlayer, an integer currenR and an integer currentC
  @param currentPlayer the current player at this move
  @param currentR the current row of the cell at this move
  @param currentC the current column of the cell at this move
  @return whether there are three same symbols on the same row, column or diagonal
  */

  public static boolean win(char currentPlayer, int currentR, int currentC){
    return ((board[currentR][0] == currentPlayer)&&(board[currentR][1] == currentPlayer)&&(board[currentR][2] == currentPlayer))
        || ((board[0][currentC] == currentPlayer)&&(board[1][currentC] == currentPlayer)&&(board[2][currentC] == currentPlayer))
        || ((currentR== currentC)&&(board[0][0] == currentPlayer)&&(board[1][1] == currentPlayer)&&(board[2][2] == currentPlayer))
        || ((currentR + currentC == 2)&&(board[0][2] == currentPlayer)&&(board[1][1] == currentPlayer)&&(board[2][0] == currentPlayer));
  }
}
