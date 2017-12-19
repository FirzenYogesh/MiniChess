import pieces.*;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowSize, colSize;
        System.out.println("Enter the Row Size of the Chess Board");
        rowSize = scanner.nextInt();
        System.out.println("Enter the Column Size of the Chess Board");
        colSize = scanner.nextInt();
        ChessPiece[] player1Pieces = new ChessPiece[colSize];
        ChessPiece[] player2Pieces = new ChessPiece[colSize];
        ChessPieceUtils.player1PiecesLeft = colSize;
        ChessPieceUtils.player2PiecesLeft = colSize;
        scanner.nextLine();
        System.out.println();
        System.out.println("Enter Player 1 (P1) Pieces");
        for (int i = 0; i < colSize; i++) {
            System.out.println("Enter the name of the piece");
            String name = scanner.nextLine();
            name = name.trim();
            while (name.equals("") || name.equals("\n")) {
                System.out.println("Please enter a valid Character name");
                name = scanner.nextLine();
                name = name.trim();
            }
            player1Pieces[i] = new PieceCastle(name, ChessPieceUtils.player1, new Position(rowSize - 1, i));
        }
        System.out.println();
        System.out.println("Enter Player 2 (P2) Pieces");
        for (int i = colSize - 1; i >= 0; i--) {
            System.out.println("Enter the name of the piece");
            String name = scanner.nextLine();
            name = name.trim();
            while (name.equals("") || name.equals("\n")) {
                System.out.println("Please enter a valid Character name");
                name = scanner.nextLine();
                name = name.trim();
            }
            player2Pieces[i] = new PieceCastle(name, ChessPieceUtils.player2, new Position(0, i));
        }
        ChessBoard chessBoard = new ChessBoard(player1Pieces, player2Pieces, rowSize, colSize);
        while (ChessPieceUtils.player1PiecesLeft > 0 && ChessPieceUtils.player2PiecesLeft > 0) {
            System.out.println();
            System.out.println();
            System.out.println();
            chessBoard.displayBoard();
            System.out.println();
            System.out.println((chessBoard.isPlayer1Move ? ChessPieceUtils.player1 : ChessPieceUtils.player2) + " move: \n");
            String command = scanner.nextLine();
            chessBoard.moveAPiece(command);
            System.out.println("Status : ");
            System.out.println("Player 1 Pieces left: " + ChessPieceUtils.player1PiecesLeft);
            System.out.println("Player 2 Pieces left: " + ChessPieceUtils.player2PiecesLeft);
        }
        System.out.println();
        System.out.println();
        if (ChessPieceUtils.player1PiecesLeft == 0) {
            System.out.println("Player 2 Wins");
        } else {
            System.out.println("Player 1 Wins");
        }
    }
}
