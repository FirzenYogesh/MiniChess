package pieces;

public class PieceDummy extends ChessPiece {
    public PieceDummy() {
        super("-", "");
        stepsToMove = 0;
        movementType = MovementType.NONE;
    }

    public PieceDummy(String player) {
        super("-", player);
        stepsToMove = 0;
        movementType = MovementType.NONE;
    }

    @Override
    public void prepareMove(String move) {

    }

    @Override
    public boolean move(ChessPiece[][] blocks, String move, String player) {
        return false;
    }

    @Override
    boolean isMoveValid(String move) {
        return false;
    }

    @Override
    void getNewPosition(String move) {

    }
}
