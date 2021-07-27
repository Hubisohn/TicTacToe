package de.manu;

import java.util.Scanner;

public class Player {

    public String playerName;
    public String playerSymbol;

    Scanner feldpos = new Scanner(System.in);

    public Player(String playerName){
        this.playerName = playerName;
    }

    public int turn(String[] board){
        int input = feldpos.nextInt();
        input = input - 1;
        if(input < 9 && input >= 0){
            boolean pass = validTurn(board, input);
            if(pass == true){
                return input;
            }else{
                System.out.println("Ungültiger Wert!");
                return turn(board);
            }
        }else
            System.out.println("Ungültiger Wert!");
            return turn(board);
    }

    public boolean validTurn(String[] board, int input){
        if(board[input].equals("#")){
            return true;
        }
        return false;
    }

}
