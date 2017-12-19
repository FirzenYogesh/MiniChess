package pieces;

public class PieceBishop extends ChessPiece {


    public PieceBishop(String name, String player, Position position) {
        super(name, player);
        stepsToMove = 2;
        movementType = MovementType.DIAGONAL;
        currentPosition = position;
        oldPosition = position;
    }

    @Override
    public void prepareMove(String move) {
        getNewPosition(move);
    }

    @Override
    public boolean move(ChessPiece[][] block, String move) {
        oldPosition = new Position(currentPosition);
        currentPosition = new Position(newPosition);
        //System.out.println(currentPosition);
        switch (move) {
            case "fl":
                if (isPlayer1())
                    killPiece(block[currentPosition.row + 1][currentPosition.column + 1]);
                else
                    killPiece(block[currentPosition.row - 1][currentPosition.column - 1]);
                break;
            case "fr":
                if (isPlayer1())
                    killPiece(block[currentPosition.row + 1][currentPosition.column - 1]);
                else
                    killPiece(block[currentPosition.row - 1][currentPosition.column + 1]);
                break;
            case "bl":
                if (isPlayer1())
                    killPiece(block[currentPosition.row - 1][currentPosition.column + 1]);
                else
                    killPiece(block[currentPosition.row + 1][currentPosition.column - 1]);
                break;
            case "br":
                if (isPlayer1())
                    killPiece(block[currentPosition.row - 1][currentPosition.column - 1]);
                else
                    killPiece(block[currentPosition.row + 1][currentPosition.column + 1]);
                break;
        }
        return true;
    }

    @Override
    public boolean isMoveValid(String move) {
        switch (move.toLowerCase()) {
            case "fl":
            case "fr":
            case "bl":
            case "br":
                return true;
            default:
                System.out.println();
                System.out.println("Invalid move. Bishop should be commanded only one of the following: ");
                System.out.println("fl or fr or bl or br");
                System.out.println();
                return false;
        }
    }

    @Override
    void getNewPosition(String move) {
        newPosition = new Position(currentPosition);
        //System.out.println(newPosition);
        switch (move.toLowerCase()) {
            case "fl":
                if (isPlayer1()) {
                    newPosition.row += -2;
                    newPosition.column += -2;
                } else {
                    newPosition.row += 2;
                    newPosition.column += 2;
                }
                break;
            case "fr":
                if (isPlayer1()) {
                    newPosition.row += -2;
                    newPosition.column += 2;
                } else {
                    newPosition.row += 2;
                    newPosition.column += -2;
                }
                break;
            case "bl":
                if (isPlayer1()) {
                    newPosition.row += 2;
                    newPosition.column += -2;
                } else {
                    newPosition.row += -2;
                    newPosition.column += 2;
                }
                break;
            case "br":
                if (isPlayer1()) {
                    newPosition.row += 2;
                    newPosition.column += 2;
                } else {
                    newPosition.row += -2;
                    newPosition.column += -2;
                }
                break;
        }
    }


}
