import pieces.ChessPiece;
import pieces.ChessPieceUtils;
import pieces.PiecePawn;
import pieces.Position;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        ChessPiece[] player1Pieces = new ChessPiece[5];
        ChessPiece[] player2Pieces = new ChessPiece[5];
        Scanner scanner = new Scanner(System.in);
        int rowSize, colSize;
        System.out.println("Enter the Row Size of the Chess Board");
        rowSize = scanner.nextInt();
        System.out.println("Enter the Column Size of the Chess Board");
        colSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        System.out.println("Enter Player 1 (P1) Pieces");
        for (int i = 0; i < colSize; i++) {
            System.out.println("Enter the name of the piece");
            String name = scanner.nextLine();
            player1Pieces[i] = new PiecePawn(name, ChessPieceUtils.player1, new Position(rowSize - 1, i));
        }
        System.out.println();
        System.out.println("Enter Player 2 (P2) Pieces");
        for (int i = colSize - 1; i >= 0; i--) {
            System.out.println("Enter the name of the piece");
            String name = scanner.nextLine();
            player2Pieces[i] = new PiecePawn(name, ChessPieceUtils.player2, new Position(0, i));
        }
        ChessBoard chessBoard = new ChessBoard(player1Pieces, player2Pieces, rowSize, colSize);
        while (ChessPieceUtils.player1PiecesLeft > 0 || ChessPieceUtils.player2PiecesLeft > 0) {
            System.out.println();
            System.out.println();
            System.out.println();
            chessBoard.displayBoard();
            System.out.println();
            System.out.println((chessBoard.isPlayer1Move ? ChessPieceUtils.player1 : ChessPieceUtils.player2) + " move: \n");
            String command = scanner.nextLine();
            chessBoard.moveAPiece(command);
        }
    }
}
