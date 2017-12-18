import pieces.ChessPiece;
import pieces.ChessPieceUtils;
import pieces.Position;

public class ChessBoard {

    private ChessPiece[][] chessBlocks;
    private ChessPiece[] player1Pieces;
    private ChessPiece[] player2Pieces;
    public boolean isPlayer1Move = true;
    private int rowSize;
    private int columnSize;

    public ChessBoard(ChessPiece[] player1Pieces, ChessPiece[] player2Pieces, int rowSize, int columnSize) {
        this.columnSize = columnSize;
        this.rowSize = rowSize;
        chessBlocks = new ChessPiece[rowSize][columnSize];
        this.player1Pieces = player1Pieces;
        this.player2Pieces = player2Pieces;
        for (int i = 0; i < columnSize; i++) {
            chessBlocks[rowSize - 1][i] = player1Pieces[i];
            chessBlocks[0][i] = player2Pieces[i];
        }
        for (int i = 1; i < rowSize - 1; i++) {
            for (int j = 0; j < columnSize; j++) {
                chessBlocks[i][j] = ChessPieceUtils.noPiece;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (chessBlocks[i][j] == ChessPieceUtils.noPiece || chessBlocks[i][j].isKilled()) {
                    System.out.print("-\t\t");
                } else {
                    System.out.printf("%s-%s\t", chessBlocks[i][j].getPlayer(), chessBlocks[i][j].getName());
                }
            }
            System.out.println("\n");
        }
    }

    public boolean moveAPiece(String command) {
        boolean moveSuccessful = false;
        if (isValidCommandFormat(command)) {
            String[] tempStrings = command.split(":");
            String name = tempStrings[0];
            String move = tempStrings[1];
            ChessPiece pieceMoved = ChessPieceUtils.noPiece;
            Position newPosition = Position.out;
            Position currentPosition = Position.out;
            if (isPlayer1Move) {
                for (ChessPiece player1Piece : player1Pieces) {
                    if (player1Piece.getName().toLowerCase().equals(name.toLowerCase())) {
                        player1Piece.prepareMove(move);
                        if (isMoveWithinTheBoard(player1Piece)) {
                            if (hasFriendly(player1Piece.getNewPosition(), player1Piece)) {
                                System.out.println("Invalid Move. Friendly Piece on the way");
                            } else {
                                if (hasEnemy(player1Piece.getNewPosition(), player1Piece)) {
                                    player1Piece.killPiece(getEnemy(player1Piece.getNewPosition()));
                                }
                                moveSuccessful = player1Piece.move(chessBlocks, move, ChessPieceUtils.player1);
                                newPosition = player1Piece.getNewPosition();
                                currentPosition = player1Piece.getCurrentPosition();
                            }
                            pieceMoved = player1Piece;
                        } else {
                            System.out.println("Invalid Move. Move goes out of the board");
                        }
                        break;
                    }
                }
            } else {
                for (ChessPiece player2Piece : player2Pieces) {
                    if (player2Piece.getName().toLowerCase().equals(name.toLowerCase())) {
                        player2Piece.prepareMove(move);
                        if (isMoveWithinTheBoard(player2Piece)) {
                            if (hasFriendly(player2Piece.getNewPosition(), player2Piece)) {
                                System.out.println("Invalid Move. Friendly Piece on the way");
                            } else {
                                if (hasEnemy(player2Piece.getNewPosition(), player2Piece)) {
                                    player2Piece.killPiece(getEnemy(player2Piece.getNewPosition()));
                                }
                                moveSuccessful = player2Piece.move(chessBlocks, move, ChessPieceUtils.player1);
                            }
                            pieceMoved = player2Piece;
                        } else {
                            System.out.println("Invalid Move. Move goes out of the board");
                        }
                        break;
                    }
                }
            }
            if (moveSuccessful) {
                isPlayer1Move = !isPlayer1Move;
                chessBlocks[pieceMoved.getOldPosition().getRow()][pieceMoved.getOldPosition().getColumn()] = ChessPieceUtils.noPiece;
                chessBlocks[pieceMoved.getCurrentPosition().getRow()][pieceMoved.getCurrentPosition().getColumn()] = pieceMoved;
            }
        } else {
            System.out.println("Invalid Move. Invalid Format");
        }
        return moveSuccessful;
    }

    //private boolean isMoveWithinTheBoard()//

    private boolean isValidCommandFormat(String command) {
        if (command.contains(":")) {
            String[] tempStrings = command.split(":");
            return tempStrings.length == 2;
        }
        return false;
    }

    private boolean isMoveWithinTheBoard(ChessPiece piece) {
        return piece.getNewPosition().getRow() >= 0
                && piece.getNewPosition().getRow() < rowSize
                && piece.getNewPosition().getColumn() >= 0
                && piece.getNewPosition().getColumn() < columnSize;
    }

    private boolean hasFriendly(Position position, ChessPiece piece) {
        ChessPiece blockToCheck = chessBlocks[position.getRow()][position.getColumn()];
        return blockToCheck.getPlayer().equals(piece.getPlayer());
    }

    private boolean hasEnemy(Position position, ChessPiece piece) {
        ChessPiece blockToCheck = chessBlocks[position.getRow()][position.getColumn()];
        return !blockToCheck.getPlayer().equals(piece.getPlayer());
    }

    private ChessPiece getEnemy(Position position) {
        return chessBlocks[position.getRow()][position.getColumn()];
    }


}
