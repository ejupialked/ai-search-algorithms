package Game;


import java.awt.*;

import static Utils.Utils.array2dToArray1d;
import static Utils.Utils.buildStringFromArray1D;

/**
 * Represents a board containing NxN cells.
 * It keeps track of tiles a, b, c and the agent.
 */
public class Board {

    private final int N;
    private Cell[][] cells;
    private String[][] grid;
    private String configuration;

    private Cell a;
    private Cell b;
    private Cell c;
    private Cell agent;

    /**
     * Creates a board NxN with cells
     * from the user input --> {@param grid}
     * @param N the size of board
     * @param grid grid with {@code String} contents in it.
     */
    public Board(int N, String[][] grid) {
        this.N = N;
        this.grid = grid;
        this.cells = generateCells(grid, N);
        this.configuration = buildStringFromArray1D(array2dToArray1d(grid));

    }

    /**
     * Generated 2d array of cells.
     *
     * @param grid the grid with {@code String} values.
     * @param N the size of the board NxN
     */
    private Cell[][] generateCells(String[][] grid, int N){
        Cell[][] cells = new Cell[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                cells[x][y] = generateSingleCell(grid[x][y], x, y);
            }
        }
        return cells;
    }


    /**
     * Generate a single cell.
     *
     * @param s the value of cell used to determine
     *          the cell type.
     * @param x the "x" coordinate
     * @param y the "y" coordinate
     * @return the single cell generated.
     */
    private Cell generateSingleCell(String s, int x, int y){
        Cell cell = new Cell(x, y);

        if(s.equals(Cell.CellType.EMPTY.getText())){
            cell.setCellType(Cell.CellType.EMPTY);
        }else if(s.equals(Cell.CellType.A.getText())){
            cell.setCellType(Cell.CellType.A);
            setA(cell);
        }else if(s.equals(Cell.CellType.B.getText())){
            cell.setCellType(Cell.CellType.B);
            setB(cell);
        }else if(s.equals(Cell.CellType.C.getText())){
            cell.setCellType(Cell.CellType.C);
            setC(cell);
        }else if(s.equals(Cell.CellType.AGENT.getText())){
            cell.setCellType(Cell.CellType.AGENT);
            setAgent(cell);
        }

        return cell;
    }


    public void updateBoard(){
        this.configuration = buildStringFromArray1D(array2dToArray1d(getGrid()));
    }

    public String getConfiguration() {
        return configuration;
    }


    @Override
    public String toString() {
        return configuration;
    }

    @Override
    public int hashCode() {
        return configuration.hashCode();
    }

    public void setBLocation(Point location) {
        this.b.setLocation(location);
    }

    public void setALocation(Point agent) {
        this.b.setLocation(agent);
    }

    public void setCLocation(Point agent) {
        this.b.setLocation(agent);
    }



    public Cell[][] getCells() {
        return cells;
    }


    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getA() {
        return a;
    }

    public void setA(Cell a) {
        this.a = a;
    }

    public void setB(Cell b) {
        this.b = b;
    }

    public Cell getB() {
        return b;
    }

    public String[][] getGrid() {
        return grid;
    }

    public Cell getC() {
        return c;
    }

    public void setC(Cell c) {
        this.c = c;
    }

    public Cell getAgent() {
        return agent;
    }

    public void setAgent(Cell agent) {
        this.agent = agent;
    }

    public int getN() {
        return N;
    }


    public void updateGrid() {
        String[][] grid = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                grid[i][j] = cells[i][j].getCellType().getText();
            }
        }

        this.grid = grid;
    }
}
