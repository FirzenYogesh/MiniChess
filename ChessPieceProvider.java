/**
 * The ChessPieceProvider Class
 * This class provides data on how many each ChessPiece of different types must be placed on the board
 */
public class ChessPieceProvider {
    int numberOfPawns = 3;
    int numberOfCastle = 1;
    int numberOfBishop = 1;

    static ChessPieceProvider provideChessPieces(int numberOfPieces) {
        ChessPieceProvider provider = new ChessPieceProvider();
        for (int i = 6; i <= numberOfPieces; i++) {
            if (i % 3 == 0)
                provider.numberOfCastle++;
            else if (i % 3 == 1)
                provider.numberOfBishop++;
            else
                provider.numberOfPawns++;
        }
        return provider;
    }

    @Override
    public String toString() {
        return String.format("Pawns: %d\t Castle: %d\t Bishop: %d", numberOfPawns, numberOfCastle, numberOfBishop);
    }

    public int getNumberOfBishop() {
        return numberOfBishop;
    }

    public int getNumberOfCastle() {
        return numberOfCastle;
    }

    public int getNumberOfPawns() {
        return numberOfPawns;
    }
}
