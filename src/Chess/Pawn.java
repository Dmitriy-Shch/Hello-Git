package Chess;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            if (color.equals("White") && toLine - line == 2 && line == 1 && toColumn == column)
                return isOnBoard(chessBoard, line, column, toLine, toColumn);
            if (color.equals("Black") && line - toLine == 2 && line == 6 && toColumn == column)
                return isOnBoard(chessBoard, line, column, toLine, toColumn);
            if (Math.abs(toLine - line) > 1 || Math.abs(toColumn - column) > 0) return false;
            if (toLine <= line && getColor().equals("White")) return false;
            if (toLine >= line && getColor().equals("Black")) return false;
            if (Math.abs(toLine - line) == 0) return false;
            else return true;
        } else {
            if (color.equals("White") && line != toLine && column != toColumn && Math.abs(line - toLine) == 1)
                return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
            if (color.equals("Black") && line != toLine && column != toColumn && Math.abs(line - toLine) == 1)
                return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
            else return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
