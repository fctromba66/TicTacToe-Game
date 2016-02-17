/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author Francis Cuccio
 */
public class TicTacToeGame {
    static int[][] gameboard;
    static final int EMPTY = 0;
    static final int NOUGHT = -1;
    static final int CROSS = 1;
    
    static void set(int val, int row, int col) throws IllegalArgumentException {
        if (gameboard[row][col] == EMPTY)
            gameboard[row][col] = val;
        else 
            throw new IllegalArgumentException("Player already there!");
    }
    
    static void displayBoard() {
        for (int r = 0; r < gameboard.length; r++) {
            System.out.print("|");
            for (int c = 0; c < gameboard[r].length; c++) {
                switch(gameboard[r][c]) {
                    case NOUGHT:
                        System.out.print("O");
                        break;
                    case CROSS:
                        System.out.print("X");
                        break;
                    default: //Empty
                        System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println("\n———-\n");
        }
    }
    
    static void createBoard(int rows, int cols) {
        gameboard =  new int[3][3];
    }
    
    static int winOrTie() {
    //NOUGHT wins horizontal
      
        if (gameboard[0][0] == NOUGHT && gameboard[0][1] == NOUGHT && gameboard[0][2] == NOUGHT)
            return NOUGHT;
        else if (gameboard[1][0] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[1][2] == NOUGHT)
            return NOUGHT;
        else if (gameboard[2][0] == NOUGHT && gameboard[2][1] == NOUGHT && gameboard[2][2] == NOUGHT)
            return NOUGHT;

    //NOUGHT wins veritcal

        else if (gameboard[0][0] == NOUGHT && gameboard[1][0] == NOUGHT && gameboard[2][0] == NOUGHT)
            return NOUGHT;
        else if (gameboard[0][1] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[2][1] == NOUGHT)
            return NOUGHT;
        else if (gameboard[0][2] == NOUGHT && gameboard[1][2] == NOUGHT && gameboard[2][2] == NOUGHT)
            return NOUGHT;

    //NOUGHT wins diagonal

        else if (gameboard[0][0] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[2][2] == NOUGHT)
            return NOUGHT;
        else if (gameboard[0][2] == NOUGHT && gameboard[1][1] == NOUGHT && gameboard[2][0] == NOUGHT)
            return NOUGHT;

    //CROSS wins horizontal

        else if (gameboard[0][0] == CROSS && gameboard[0][1] == CROSS && gameboard[0][2] == CROSS)
            return CROSS;
        else if (gameboard[1][0] == CROSS && gameboard[1][1] == CROSS && gameboard[1][2] == CROSS)
            return CROSS;
        else if (gameboard[2][0] == CROSS && gameboard[2][1] == CROSS && gameboard[2][2] == CROSS)
            return CROSS;

    //CROSS wins veritcal

        else if (gameboard[0][0] == CROSS && gameboard[1][0] == CROSS && gameboard[2][0] == CROSS)
            return CROSS;
        else if (gameboard[0][1] == CROSS && gameboard[1][1] == CROSS && gameboard[2][1] == CROSS)
            return CROSS;
        else if (gameboard[0][2] == CROSS && gameboard[1][2] == CROSS && gameboard[2][2] == CROSS)
            return CROSS;

    //CROSS wins diagonal

        else if (gameboard [0][0] == CROSS && gameboard[1][1] == CROSS && gameboard[2][2] == CROSS)
            return CROSS;
        else if (gameboard [0][2] == CROSS && gameboard[1][1] == CROSS && gameboard[2][0] == CROSS)
            return CROSS;               
        else
            return -2;
    }
    
    public static void main(String[] args) {
        createBoard(3,3);
        int turn = 0;
        int playerVal;
        int outcome;
        java.util.Scanner scan = new
        java.util.Scanner(System.in);
        do {
            displayBoard();
            playerVal = (turn % 2 == 0)? NOUGHT : CROSS;
            if (playerVal == NOUGHT) 
                System.out.println("\n—O’s turn—");
            else 
                System.out.println(" \n—X’s turn—");
            System.out.print("Enter row and column:");
            try {
                set(playerVal, scan.nextInt(), scan.nextInt());
            } catch (Exception ex){System.err.println(ex);}
            turn ++;
            outcome = winOrTie();
        } while ( outcome == -2 );
        displayBoard();
        switch (outcome) {
        case NOUGHT:
            System.out.println("O wins!");
            break;
        case CROSS:
            System.out.println("X wins!");
            break;
        case 0:
            System.out.println("Tie.");
            break;
        }
    }
}