package TicTacToe;

import java.util.Scanner;

public class TTT100{

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
    Board.initialize(args); //initialize the game before every new game begins
    System.out.println("Would you like to go first?");
    first=TextIO.getlnBoolean(); //whether the user chooses to play first
    do{
      playTurn(); //the main game class of computer and user
      Winner.printGameResult();// prints out the result of the game
    }while(currentS.equals("P")); //currentS remains the initialize value when the game is in process
  }

  /**
   an ordered sequence of moves that the computer would take if user go first
   First, computer should check if the center cell is empty; if so, it should take the center cell
   Second, computer should check if there are two '0's on the same row, column or diagonal; if so,
   it should occupy the cell that would make three 'O's
   Third, computer should check if there are two 'X's on the same row, column or diagonal; if so,
   it should thake the remaining empty cell on that row, column or diagonal so that the user would not win
   Fourth, computer should check if there are empty cells on the edge, i.e. cell [0][1],[1][0],[1][2],[2][1];
   if so, it should take the first empty edge cell it finds
   Finally, it should check if there still are empty cells on the board; if so, it should take the first
   empty cell it finds.
  */
  public static void userGoFirst() {
    if(!Check.goCenter()){ //if the center cell is not empty
      if(!Check.noughtsOrCross('O')){ //check if there are two 'O' on the same row, column or diagonal
        if(!Check.noughtsOrCross('X')){ //check if there are two 'X' on the same row, column or diagonal
          if(!Check.edge()){ //check if there are empty cells on the edge
            Check.checkEmpty(); //the computer will make a move
          }
        }
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
      Board.printBoard(); //print out the current board
      first=true; //the next player will be the user
      i++; //the number of moves in the game increases by 1
    }
  }


  /**
  */
  public static void computerGoFirst() {
    if (i==1){ //the first move of the game (computer's first move)
      moveV2(0,0,'O');//computer takes the upper left corner
    } else if(i==3){ //the third move of the game (computer's second move)
      computerGoFirstSecondMove();
    } else if((i==5)&&(board[1][1]==' ')){
      moveV2(1,1,'O');
    } else{
      computerGoFirstGeneralMove();
    }
  }


  /**
  computer's second move when it goes first
  */
  public static void computerGoFirstSecondMove() {
    if(board[1][1]=='X'){ //check whether the center cell is occupied by the user (the user's first move)
      moveV2(2,2,'O');// computer takes the center
    } else{
      //if the center cell is still empty
      //the computer avoids occupying a cell on the same row of the computer's first move
      if(currentR==0){ //if the user occupies a cell on the same row of the computer's first move
        moveV2(2,0,'O'); //the computer takes the [2][0]
      } else{ //if the user does not occupy a cell on the same row of the computer's first move
        moveV2(0,2,'O'); //the computer takes the [0][2]
      }
    }
  }

  /**
  computer occupies a specific cell
  */
  public static void moveV2 (int a, int b, char symbol){
    board[a][b]=symbol; //computer occupies this cell
    currentR=a; //set the current row number as currentR; updates currentR to a
    currentC=b; //set the current column number as currentC; updates currentC to b
  }

  /**
  */
  public static void computerGoFirstGeneralMove() {
    if(!Check.noughtsOrCross('O')){
      if(!Check.noughtsOrCross('X')){
        if(Check.corner()==false){
          Check.checkEmpty();
        }
      }
    }
  }

  /**
  generates the computer's move
  */

  public static void computer(){
    System.out.println("Now it's my turn\n");
    if(i%2==0){ //when user goes first, the move number of the computer is even
      userGoFirst();
    }
    //decide the computer's next move based on the user's move
    if (i%2!=0){ //when computer goes first, the move number of the computer is odd
      computerGoFirst();
    }
    Winner.checkWinner(currentR,currentC);  //check if there is a winner or a tie or still in process
  }


  /**
  The user's move
  */

  public static void player(){
    System.out.println("Please enter your move");
    int row=input.nextInt()-1; //turn the format of row into the right version that the computer can read ?
    int column=input.nextInt()-1; //turn the format of column into the right version that the computer can read ?
    if ((row >= 0)&&(row < 3)&&(column>= 0)&&(column< 3)&&(board[row][column]==' ')){ //check if the user's move is valid (whether the cell is empty)
      moveV2(row,column,'X'); //input the user's move
      Board.printBoard(); //print the board after this move
      first=false; //change the next player to computer
    } else{ //if the user's move is not valid
      System.out.println("This move is not valid. Please try again");
      player(); //ask the user to input again
   }
 }
}
