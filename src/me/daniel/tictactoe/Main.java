package me.daniel.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initial message, only displayed once.
        System.out.println("Tic Tac Toe");
        System.out.println("Enter row and column (0-2)");

        //Sets turns, new Board (b), and Scanner.
        Board b = new Board();
        Scanner sc = new Scanner(System.in);
        int turns = 0;

        System.out.println("Type 1 if you want to play single player or 2 for local multiplayer.");
        int game = sc.nextInt();

        if (game == 2) {

            while (b.checkWin() == ' ') {
                b.print();

                //Asks user input for row first time.
                System.out.print("Enter row in which you want to place your shape in : ");
                int row = sc.nextInt();

                //Asks user input for column first time.
                System.out.print("Enter column in which you want to place your shape in : ");
                int col = sc.nextInt();

                //Loop (isEmpty) to get user input on where to place shape.

                while (!b.isEmpty(row, col)) {
                    System.out.println("Place is already taken, please type a different row and/or col.");
                    //Asks user input for row every turn.
                    System.out.print("Enter row in which you want to place your shape in : ");
                    row = sc.nextInt();

                    //Asks user input for column every turn.
                    System.out.print("Enter column in which you want to place your shape in : ");
                    col = sc.nextInt();
                }

                //Checks if turns are even or odd and accordingly places x or o on specified coordinates.
                if (turns % 2 == 0) {
                    b.move('x', row, col);

                } else {
                    b.move('o', row, col);

                }
                //Adds 1 to turns to move it forward.
                turns++;
            }
            //Prints last and states winner
            b.print();
            System.out.println();
            System.out.println("Congratulations " + (b.checkWin() + "").toUpperCase() + " you have won!");

        } else {
            //Basic Random AI
            while (b.checkWin() == ' ') {
                if(turns % 2 == 0) {
                    b.print();
                }

                if(turns % 2 == 0) {
                    //Asks user input for row first time.
                    System.out.print("Enter row in which you want to place your shape in : ");
                    int row = sc.nextInt();

                    //Asks user input for column first time.
                    System.out.print("Enter column in which you want to place your shape in : ");
                    int col = sc.nextInt();

                    //Infinite loop to get user input on where to place shape.

                    while (!b.isEmpty(row, col)) {
                        System.out.println("Place is already taken, please type a different row and/or col.");
                        //Asks user input for row every turn.
                        System.out.print("Enter row in which you want to place your shape in : ");
                        row = sc.nextInt();

                        //Asks user input for column every turn.
                        System.out.print("Enter column in which you want to place your shape in : ");
                        col = sc.nextInt();
                    }

                    b.move('x', row, col);
                } else {
                    //move ai
                    int aiRow = (int) (Math.random() * 3);
                    int aiCol = (int) (Math.random()*3);

                    while (!b.isEmpty(aiRow, aiCol)) {
                        aiRow = (int) (Math.random() * 3);
                        aiCol = (int) (Math.random()*3);
                    }

                    System.out.println("AI is making a move ;)");
                    b.move('o', aiRow, aiCol);
                }

                //Adds 1 to turns to move it forward.
                turns++;
            }
            //Prints last and states winner
            b.print();
            System.out.println();
            System.out.println("Congratulations " + (b.checkWin() + "").toUpperCase() + " you have won!");
        }

    }
}

