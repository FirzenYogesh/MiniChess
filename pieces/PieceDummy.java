package pieces;

public class PieceDummy extends ChessPiece {
    public PieceDummy() {
        super("-", "");
        stepsToMove = 0;
        movementType = MovementType.NONE;
        isKilled = true;
    }

    public PieceDummy(String player) {
        super("-", player);
        stepsToMove = 0;
        movementType = MovementType.NONE;
        isKilled = true;
    }

    @Override
    public void prepareMove(String move) {

    }

    @Override
    public boolean move(ChessPiece[][] block, String move) {
        return false;
    }

    @Override
    public boolean isMoveValid(String move) {
        return false;
    }

    @Override
    void getNewPosition(String move) {

    }
}
