package Chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) == Math.abs(column - toColumn) && (line != toLine && column != toColumn))
            return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
        else if (line != toLine && column == toColumn) return onColumnPiece(chessBoard, line, column, toLine, toColumn);
        else if (line == toLine && column != toColumn) return onLinePiece(chessBoard, line, column, toLine, toColumn);
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
