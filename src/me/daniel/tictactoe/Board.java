package me.daniel.tictactoe;

public class Board {
    //Creates board 3 by 3.
    private char[][] board = new char[3][3];

        //contructor
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    //getter (accessor)
    public char get(int row, int col) {
        return board[row][col];
    }

    //setter (mutator)
    public void move(char piece, int row, int col) {
        board[row][col] = piece;
    }

    //getter
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public boolean isEmpty(int row, int col) {
        if (board[row][col] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public char checkWin() {

        //check winners in columns
        for (int i = 0; i < board.length; i++) {
            char winner = 's';
            for (int j = 0; j < board[i].length; j++) {
                if (winner == 's') {
                    winner = board[i][j];
                }

                if (board[i][j] == ' ') break;
                if (board[i][j] != winner) break;

                winner = board[i][j];

                if (j == board[i].length - 1) return winner;
            }
        }

        //rows
        for (int i = 0; i < board[0].length; i++) {
            char winner = 's';
            for (int j = 0; j < board.length; j++) {
                if (winner == 's') {
                    winner = board[j][i];
                }

                if (board[j][i] == ' ') break;
                if (board[j][i] != winner) break;

                winner = board[j][i];

                if (j == board.length - 1) return winner;
            }
        }

        //sideways
        char winner = 's';
        for (int i = 0; i < board.length; i++) {
            if (winner == 's') {
                winner = board[i][i];
            }

            if (board[i][i] == ' ') break;
            if (board[i][i] != winner) break;

            winner = board[i][i];

            if (i == board[i].length - 1) return winner;
        }

        return ' ';
    }
}
