package pieces;

public class PieceBishop extends ChessPiece {



    public PieceBishop(String name, String player) {
        super(name, player);
        stepsToMove = 2;
        movementType = MovementType.DIAGONAL;
    }

    @Override
    public void prepareMove(String move) {

    }

    @Override
    public boolean move(ChessPiece[][] blocks, String move, String player) {
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
