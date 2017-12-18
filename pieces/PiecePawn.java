package pieces;

public class PiecePawn extends ChessPiece {

    public PiecePawn(String name, String player, Position position) {
        super(name, player);
        stepsToMove = 1;
        movementType = MovementType.NORMAL;
        currentPosition = position;
        oldPosition = position;
    }

    @Override
    public boolean move(ChessPiece[][] blocks, String move, String player) {
        if (isMoveValid(move)) {
            oldPosition = new Position(currentPosition);
            currentPosition = new Position(newPosition);
        } else {
            System.out.println("Invalid move. Pawn should be commanded only one of the following: ");
            System.out.println("f or b or l or r");
        }
        return false;
    }

    @Override
    public void prepareMove(String move) {
        getNewPosition(move);
    }

    @Override
    public boolean isMoveValid(String move) {
        switch (move.toLowerCase()) {
            case "f":
            case "b":
            case "l":
            case "r":
                return true;
            default:
                return false;
        }
    }

    @Override
    void getNewPosition(String move) {
        newPosition = new Position(currentPosition);
        System.out.println(newPosition);
        switch (move.toLowerCase()) {
            case "f":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.row += -1;
                } else {
                    newPosition.row += 1;
                }
                break;
            case "b":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.row += 1;
                } else {
                    newPosition.row += -1;
                }
                break;
            case "l":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.column += -1;
                } else {
                    newPosition.column += 1;
                }
                break;
            case "r":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.column += 1;
                } else {
                    newPosition.column += -1;
                }
                break;
        }
        System.out.println(newPosition);
    }
}
