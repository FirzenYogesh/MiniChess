package pieces;

/**
 * This class is used to represent coordinate of the chess piece
 */
public class Position {
    /**
     * The x-coordinate of piece
     */
    int row;
    /**
     * The y-coordinate of piece
     */
    int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position(Position position) {
        row = position.row;
        column = position.column;
    }

    @Override
    public String toString() {
        return String.format("Row: %d\tColumn: %d", row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public static Position out = new Position(-1, -1);
}
