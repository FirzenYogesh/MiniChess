package pieces;

public class Position {
    int row, column;

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
        return "Row: " + row + "\nColumn: " + column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public static Position out = new Position(-1, -1);
}
