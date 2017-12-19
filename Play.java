import pieces.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = 0;
        while (numberOfPieces < 5) {
            System.out.println("Enter the number of pieces (min 5): ");
            numberOfPieces = scanner.nextInt();
        }
        ChessPiece[] player1Pieces;
        ChessPiece[] player2Pieces;
        ChessPieceUtils.player1PiecesLeft = numberOfPieces;
        ChessPieceUtils.player2PiecesLeft = numberOfPieces;
        scanner.nextLine();
        System.out.println("Pieces Allowed in the game: " + ChessPieceProvider.provideChessPieces(numberOfPieces));
        System.out.println();
        System.out.println("Enter Player 1 (P1) Pieces");
        player1Pieces = getPlayerPieces(numberOfPieces, ChessPieceUtils.player1);
        System.out.println();
        System.out.println("Enter Player 2 (P2) Pieces");
        player2Pieces = getPlayerPieces(numberOfPieces, ChessPieceUtils.player2);

        ChessBoard chessBoard = new ChessBoard(player1Pieces, player2Pieces, numberOfPieces, numberOfPieces);
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

    private static ChessPiece[] getPlayerPieces(int numberOfPieces, String player) {
        Scanner scanner = new Scanner(System.in);
        ChessPiece[] pieces = new ChessPiece[numberOfPieces];
        ArrayList<String> tempList = new ArrayList<>();
        ChessPieceProvider provider = ChessPieceProvider.provideChessPieces(numberOfPieces);
        int i = 0;
        while (i < numberOfPieces) {
            System.out.println();
            System.out.println("Enter the Piece Type:\np for Pawn\nc for Castle\nb for Bishop\n");
            String pieceType = scanner.nextLine().trim();
            while (!pieceType.toLowerCase().equals("p") && !pieceType.toLowerCase().equals("c") && !pieceType.toLowerCase().equals("b")) {
                System.out.println("Enter a valid Piece Type");
                pieceType = scanner.nextLine().trim();
            }
            switch (pieceType.toLowerCase()) {
                case "p":
                    if (provider.numberOfPawns > 0)
                        break;
                    else {
                        System.out.println();
                        System.out.println("You have reached the limit of Pawns you can use");
                        continue;
                    }
                case "c":
                    if (provider.numberOfCastle > 0)

                        break;
                    else {
                        System.out.println("You have reached the limit of Castle you can use");
                        continue;
                    }
                case "b":
                    if (provider.numberOfBishop > 0)
                        break;
                    else {
                        System.out.println("You have reached the limit of Bishop you can use");
                        continue;
                    }
            }
            System.out.println("Enter the name of the piece");
            String name = scanner.nextLine().trim();
            while (name.equals("") || name.equals("\n")) {
                System.out.println("Please enter a valid Character name");
                name = scanner.nextLine().trim();
            }
            while (tempList.contains(name)) {
                System.out.println("Please enter a Unique Character name");
                name = scanner.nextLine().trim();
            }
            tempList.add(name);
            Position position;
            if (player.equals(ChessPieceUtils.player1))
                position = new Position(numberOfPieces - 1, i);
            else
                position = new Position(0, (numberOfPieces - 1) - i);
            ChessPiece piece;
            switch (pieceType.toLowerCase()) {
                case "p":
                    provider.numberOfPawns--;
                    piece = new PiecePawn(name, player, position);
                    break;
                case "c":
                    provider.numberOfCastle--;
                    piece = new PieceCastle(name, player, position);
                    break;
                case "b":
                    provider.numberOfBishop--;
                    piece = new PieceBishop(name, player, position);
                    break;
                default:
                    piece = ChessPieceUtils.noPiece;
            }
            if (player.equals(ChessPieceUtils.player1)) {
                pieces[i] = piece;
            } else {
                pieces[(numberOfPieces - 1) - i] = piece;
            }
            i++;
        }
        /*for (int i = 0; i < numberOfPieces; i++) {

            //pieces[i] = new PieceCastle(name, ChessPieceUtils.player1, new Position(numberOfPieces - 1, i));
        }*/
        return pieces;
    }
}
