package Game;

import java.awt.*;

public class Board {

    private final int N;
    private Cell[][] cells;

    private Cell a;
    private Cell b;
    private Cell c;
    private Cell agent;

    /**
     * Creates a board NxN with cells
     * @param N the size of board
     * @param grid grid with {@code String} contents in it.
     */
    public Board(int N, String[][] grid) {
        this.N = N;
        this.cells = generateCells(grid, N);;

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
     * @param s the value of cell
     * @param x the "x" coordinate
     * @param y the "y" coordinate
     * @return the single cell generated.
     */
    private Cell generateSingleCell(String s, int x, int y){
        Cell cell = new Cell(x, y);

        if(s.equals(Cell.CellType.x.name())){
            cell.setCellType(Cell.CellType.x);
        }else if(s.equals(Cell.CellType.A.name())){
            cell.setCellType(Cell.CellType.A);
            setA(cell);
        }else if(s.equals(Cell.CellType.B.name())){
            cell.setCellType(Cell.CellType.B);
            setB(cell);
        }else if(s.equals(Cell.CellType.C.name())){
            cell.setCellType(Cell.CellType.C);
            setC(cell);
        }else if(s.equals(Cell.CellType.O.name())){
            cell.setCellType(Cell.CellType.O);
            setAgent(cell);
        }

        return cell;
    }


    public Cell getCellAtCoordinate(Point p){
        return cells[p.x][p.y];
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

    public Cell getB() {
        return b;
    }

    public void setB(Cell b) {
        this.b = b;
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
}
