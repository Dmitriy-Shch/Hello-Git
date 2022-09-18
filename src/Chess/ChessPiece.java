package Chess;


public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean onPiece(ChessBoard chessBoard, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] != null)
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        else return true;
    }

    protected boolean isOnBoard(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) return true;
        return false;
    }

    protected boolean checkPos(int pos) {
        return pos <= 7 && pos >= 0;
    }

    protected boolean onLinePiece(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isOnBoard(chessBoard, line, column, toLine, toColumn)) {
            int onLine = 0, onColumn = 0;
            for (int i = 1; i <= Math.abs(column - toColumn); i++)
                if (column > toColumn && chessBoard.board[Math.abs(line)][column - i] != null) {
                    onColumn = i;
                    onLine++;
                } else if (column < toColumn && chessBoard.board[line][column + i] != null) {
                    onColumn = i;
                    onLine++;
                }
            if (onLine > 1) return false;
            if (onLine == 1) {
                if (onColumn != Math.abs(column - toColumn)) return false;
                return onPiece(chessBoard, toLine, toColumn);
            } else return true;
        } else return true;
    }

    protected boolean onColumnPiece(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isOnBoard(chessBoard, line, column, toLine, toColumn)) {
            int onLine = 0, onColumn = 0;
            for (int i = 1; i <= Math.abs(line - toLine); i++)
                if (line > toLine && chessBoard.board[Math.abs(line - i)][column] != null) {
                    onColumn++;
                    onLine = i;
                } else if (line < toLine && chessBoard.board[line + i][column] != null) {
                    onColumn++;
                    onLine = i;
                }
            if (onColumn > 1) return false;
            if (onColumn == 1) {
                if (onLine != Math.abs(line - toLine)) return false;
                return onPiece(chessBoard, toLine, toColumn);
            } else return true;
        } else return true;
    }

    protected boolean onDiagonalPiece(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isOnBoard(chessBoard, line, column, toLine, toColumn)) {
            int onLine = 0, onColumn = 0;
            for (int i = 1; i <= Math.abs(line - toLine); i++) {
                if (line > toLine && column > toColumn && chessBoard.board[line - i][column - i] != null) {
                    onLine++;
                    onColumn = i;
                } else if (line < toLine && column < toColumn && chessBoard.board[line + i][column + i] != null) {
                    onLine++;
                    onColumn = i;
                } else if (line < toLine && column > toColumn && chessBoard.board[line + i][column - i] != null) {
                    onLine++;
                    onColumn = i;
                } else if (line > toLine && column < toColumn && chessBoard.board[line - i][column + i] != null) {
                    onLine++;
                    onColumn = i;
                }
            }
            if (onLine > 1) return false;
            if (onLine == 1) {
                if (onColumn != Math.abs(line - toLine)) return false;
                return onPiece(chessBoard, toLine, toColumn);
            } else return true;
        }else return true;
    }
}