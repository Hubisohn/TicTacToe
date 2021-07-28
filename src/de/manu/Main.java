package de.manu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String gewinner;
        int zug = -1;
        String[] board = new String[9];

        String spname = null;
        String spsymb;
        String CheckSymb = null;

        int playercount = 0;

        System.out.println("Spieler 1:");
        spname = playerNameEnter(playercount, spname);
        spsymb = playerSymbEnter(CheckSymb);

        Player eins = new Player(spname);
        eins.playerSymbol = spsymb;

        CheckSymb = spsymb;

        playercount++;

        System.out.println("Spieler 2:");
        spname = playerNameEnter(playercount, spname);
        spsymb = playerSymbEnter(CheckSymb);

        Player zwei = new Player(spname);
        zwei.playerSymbol = spsymb;


        Arrays.fill(board, "#");

        printBrett(board);

        System.out.println("Das Spiel beginnt!");

        Player[] players = new Player[2];
        players[0] = eins;
        players[1] = zwei;

        while(true) {
            zug = (zug + 1) % 2;

            System.out.println(players[zug].playerName + " dein Zug:");
            board[eins.turn(board)] = players[zug].playerSymbol;
            printBrett(board);


            gewinner = winBrett(board);
            if(gewinner.equals(players[zug].playerSymbol)) {
                System.out.println(players[zug].playerName + " hat das Spiel gewonnen!");
                break;
            }
        }

    }

    public static String playerNameEnter(int playercount, String spname) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie ihren Namen ein:");
        if(playercount == 0) {
            return scanner.nextLine();
        }else{
            String CheckName = scanner.nextLine();
            while(CheckName.equals(spname)) {
                System.out.println("Dieser Username ist bereits in verwändung, bitte wählen Sie einen anderen!");
                CheckName = scanner.nextLine();
            }
            return CheckName;
        }
    }

    public static String playerSymbEnter(String CheckSymb) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie ein, welches Symbol Sie verwenden wollen:");
        String spsymb = scanner.nextLine();
        while (spsymb.equals("#") || spsymb.equals(CheckSymb)) {
            System.out.println("Du kannst kein # oder bereits verwendetes Zeichen verwenden!");
            System.out.println("Neue Eingabe:");
            spsymb = scanner.nextLine();
        }
        return spsymb;
    }

    public static void printBrett(String[] board){
        System.out.println("Spielbrett:");
        System.out.println("\n");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("_________");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("_________");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public static String winBrett(String[] board){
            if (board[0].equals(board[1]) && board[1].equals(board[2]) && !board[0].equals("#")) {
                return board[0];
            } else if (board[3].equals(board[4]) && board[4].equals(board[5]) && !board[3].equals("#")) {
                return board[3];
            } else if (board[6].equals(board[7]) && board[7].equals(board[8]) && !board[6].equals("#")) {
                return board[6];
            } else if (board[0].equals(board[4]) && board[4].equals(board[8]) && !board[0].equals("#")) {
                return board[0];
            } else if (board[6].equals(board[4]) && board[4].equals(board[2]) && !board[6].equals("#")) {
                return board[6];
            } else if (board[0].equals(board[3]) && board[3].equals(board[6]) && !board[0].equals("#")) {
                return board[0];
            } else if (board[1].equals(board[4]) && board[4].equals(board[7]) && !board[1].equals("#")) {
                return board[1];
            } else if (board[2].equals(board[5]) && board[5].equals(board[8]) && !board[2].equals("#")) {
                return board[2];
            } else {
                return "#";
            }
        }
}
