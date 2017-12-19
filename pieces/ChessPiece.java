package pieces;

/**
 * Base Class for All Chess Pieces
 */
public abstract class ChessPiece {
    String name;
    String player;
    int stepsToMove;
    Position currentPosition;
    Position oldPosition;
    Position newPosition;
    boolean isKilled = false;
    MovementType movementType;


    public enum MovementType {NORMAL, DIAGONAL, BOTH, NONE}

    public ChessPiece(String name, String player) {
        this.name = name;
        this.player = player;
    }

    /**
     * A method to make sure the move is possible
     *
     * @param move The Move Command for the soldier
     */
    public abstract void prepareMove(String move);

    /**
     * The method where the piece's move takes place
     *
     * @param block All Chess Pieces in the ChessBoard
     * @param move  The Move Command for the soldier
     * @return true if the move was made else false
     */
    public abstract boolean move(ChessPiece[][] block, String move);

    /**
     * Method to check if the given move(command) is valid or not
     *
     * @param move The Move Command for the soldier
     * @return true if the move is valid for the given ChessPiece else false
     */
    public abstract boolean isMoveValid(String move);

    /**
     * The new Position where the ChessPiece will be after the given move
     *
     * @param move The Move Command for the soldier
     */
    abstract void getNewPosition(String move);

    /**
     * Kill the specified Piece
     *
     * @param piece Piece to Kill
     */
    public void killPiece(ChessPiece piece) {
        if (!player.equals(piece.player) && !piece.name.equals("-")) {
            piece.isKilled = true;
            piece.currentPosition = Position.out;
            piece.newPosition = Position.out;
            piece.oldPosition = Position.out;
            if (piece.player.equals(ChessPieceUtils.player1)) {
                ChessPieceUtils.player1PiecesLeft--;
                ChessPieceUtils.player2Score++;
            } else {
                ChessPieceUtils.player2PiecesLeft--;
                ChessPieceUtils.player1Score++;
            }
        }
    }

    /**
     * Check if the Piece is Killed or not
     *
     * @return true if Piece is Dead else false
     */
    public boolean isKilled() {
        return isKilled;
    }

    public void setCurrentPosition(Position position) {
        currentPosition = position;
        //System.out.println(currentPosition);
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Position getOldPosition() {
        return oldPosition;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public String getName() {
        return name;
    }

    public String getPlayer() {
        return player;
    }

    /**
     * To Check which player the piece belongs to
     *
     * @return true if the piece belongs to Player 1 else false
     */
    boolean isPlayer1() {
        return player.equals(ChessPieceUtils.player1);
    }
}
