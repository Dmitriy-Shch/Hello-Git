package Chess;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
            if (line != toLine && column == toColumn)
                return onColumnPiece(chessBoard, line, column, toLine, toColumn);
            if (line == toLine && column != toColumn)
                return onLinePiece(chessBoard, line, column, toLine, toColumn);
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }


}
