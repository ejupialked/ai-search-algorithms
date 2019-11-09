package Game;

import Utils.Utils;

public class State {

    private final Board board;

    public State(Board board, String[][] grid2D) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return Utils.drawGrid(board.getArray1D(), board.getN());
    }
}
