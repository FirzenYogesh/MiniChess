package pieces;

public class PieceCastle extends ChessPiece {


    public PieceCastle(String name, String player, Position position) {
        super(name, player);
        stepsToMove = 2;
        movementType = MovementType.NORMAL;
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
        switch (move.toLowerCase()) {
            case "f":
                if (isPlayer1())
                    killPiece(block[currentPosition.row + 1][currentPosition.column]);
                else
                    killPiece(block[currentPosition.row - 1][currentPosition.column]);
                break;
            case "b":
                if (isPlayer1())
                    killPiece(block[currentPosition.row - 1][currentPosition.column]);
                else
                    killPiece(block[currentPosition.row + 1][currentPosition.column]);
                break;
            case "l":
                if (isPlayer1())
                    killPiece(block[currentPosition.row][currentPosition.column + 1]);
                else
                    killPiece(block[currentPosition.row][currentPosition.column - 1]);
                break;
            case "r":
                if (isPlayer1())
                    killPiece(block[currentPosition.row][currentPosition.column - 1]);
                else
                    killPiece(block[currentPosition.row][currentPosition.column + 1]);
                break;
        }
        return true;
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
                System.out.println("Invalid move. Castle should be commanded only one of the following: ");
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
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.row += -2;
                } else {
                    newPosition.row += 2;
                }
                break;
            case "b":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.row += 2;
                } else {
                    newPosition.row += -2;
                }
                break;
            case "l":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.column += -2;
                } else {
                    newPosition.column += 2;
                }
                break;
            case "r":
                if (player.equals(ChessPieceUtils.player1)) {
                    newPosition.column += 2;
                } else {
                    newPosition.column += -2;
                }
                break;
        }
        //System.out.println(newPosition);
    }


}
