package Game;

import Utils.Utils;

public class State {

    private final Board board;
    private String state;
    private String[] array1D;


    public State(Board board, String[][] grid2D) {
        this.board = board;
        this.array1D = Utils.array2dToArray1d(grid2D);

        StringBuilder s = new StringBuilder();
        for (String s1: array1D) s.append(s1);

        this.state = s.toString();


    }


    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {


        Cell[] cells = Utils.array2dToArray1dCell(board.getCells());

        String[] array1d = new String[board.getN() * board.getN()];

            for (int i = 0; i < cells.length; i++) {
                array1d[i] = cells[i].getCellType().name();
            }

            StringBuilder s = new StringBuilder();
            for (String s1 : array1D) s.append(s1);

            this.state = s.toString();

            return Utils.drawGrid(array1d, board.getN());

    }
}
