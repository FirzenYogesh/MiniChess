package pieces;

public class PieceCastle extends ChessPiece {



    public PieceCastle(String name, String player) {
        super(name, player);
        stepsToMove = 2;
        movementType = MovementType.NORMAL;
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
