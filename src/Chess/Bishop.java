
package Chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(toLine - line) == 0) return false;
        if (line + toLine == column + toColumn) return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
        else return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }
}