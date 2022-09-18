package Chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1 && line != toLine && column != toColumn)
            return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
        if (isUnderAttack(chessBoard, line, column)) return false;
        if (line != toLine && column == toColumn && Math.abs(line - toLine) == 1)
            return onColumnPiece(chessBoard, line, column, toLine, toColumn);
        if (line == toLine && column != toColumn && Math.abs(column - toColumn) == 1)
            return onLinePiece(chessBoard, line, column, toLine, toColumn);
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
