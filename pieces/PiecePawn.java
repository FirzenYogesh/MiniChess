package pieces;

/**
 * The Pawn Piece derived from ChessPiece
 * Pawn Moves 1 step at a time either in Front or Back or Right or Left
 */
public class PiecePawn extends ChessPiece {

    public PiecePawn(String name, String player, Position position) {
        super(name, player);
        stepsToMove = 1;
        movementType = MovementType.NORMAL;
        currentPosition = position;
        oldPosition = position;
    }

    @Override
    public boolean move(ChessPiece[][] block, String move) {
        /*if (isMoveValid(move)) {

        }
        return false;*/
        oldPosition = new Position(currentPosition);
        currentPosition = new Position(newPosition);
        //System.out.println(currentPosition);
        return true;
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
                System.out.println();
                System.out.println("Invalid move. Pawn should be commanded only one of the following: ");
                System.out.println("f or b or l or r");
                System.out.println();
                return false;
        }
    }

    @Override
    void getNewPosition(String move) {
        newPosition = new Position(currentPosition);
        //System.out.println(newPosition);
        switch (move.toLowerCase()) {
            case "f":
                if (isPlayer1()) {
                    newPosition.row += -1;
                } else {
                    newPosition.row += 1;
                }
                break;
            case "b":
                if (isPlayer1()) {
                    newPosition.row += 1;
                } else {
                    newPosition.row += -1;
                }
                break;
            case "l":
                if (isPlayer1()) {
                    newPosition.column += -1;
                } else {
                    newPosition.column += 1;
                }
                break;
            case "r":
                if (isPlayer1()) {
                    newPosition.column += 1;
                } else {
                    newPosition.column += -1;
                }
                break;
        }
        //System.out.println(newPosition);
    }
}
