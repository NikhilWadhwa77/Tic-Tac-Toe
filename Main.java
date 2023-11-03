package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }

        char currPlayer = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("[-1 to exit ]");
            System.out.println("Player " + currPlayer + " Enter: ");
            int row = sc.nextInt();

            if(row == -1){
                break;
            }

            int col = sc.nextInt();


            if(row > 2 || col > 2){
                System.out.println("Invalid Move, Try Again!");
            }

            if(board[row][col] == ' '){
                board[row][col] = currPlayer;
                gameOver = hasWon(board, currPlayer);
                if(gameOver){
                    System.out.println("Player " + currPlayer + " Wins, Fatality");
                }else{
                    currPlayer = (currPlayer == 'X') ? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid Move, Try Again!");
            }
        }
        printBoard(board);
    }

    static void printBoard(char[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 2){
                    System.out.print(arr[i][j] + " ");
                }else{
                    System.out.print(arr[i][j] + " | ");
                }


            }
            System.out.println();
        }
    }
    static boolean hasWon(char[][] board, char player){
//        rows
        for(int i = 0; i < 3; i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
//        columns
        for(int col = 0; col < 3; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
//        diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

//        else
        return false;
    }

}
