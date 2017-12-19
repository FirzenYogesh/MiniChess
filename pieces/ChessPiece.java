package pieces;

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

    public abstract void prepareMove(String move);

    public abstract boolean move(ChessPiece[][] block, String move);

    public abstract boolean isMoveValid(String move);

    abstract void getNewPosition(String move);

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

    boolean isPlayer1() {
        return player.equals(ChessPieceUtils.player1);
    }
}
