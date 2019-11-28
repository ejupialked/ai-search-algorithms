package Utils;

import BlocksWorld.Board;
import BlocksWorld.Cell;
import Problem.BlocksWorldTileProblem;
import TreeSearchAlgorithm.Node;
import TreeSearchAlgorithm.TreeSearch;

import java.awt.*;

/**
 * Utility class
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public final class Utils {
    /**
     * Draws the blocks of the puzzle in a nice way in the Console.
     *
     * @param array1D the puzzle in 2d array form
     * @param n  the size of grid (nxn)
     * @return the String containing the puzzle with blocks
     */
    public static String drawGridCells(Cell[] array1D, int n) {

        String[] cellValues = new String[array1D.length];
        for (int i = 0; i < array1D.length; i++) {
            if(array1D[i].getCellType().getText().equals(Cell.CellType.EMPTY.getText()))
               cellValues[i] = " ";
            else
                cellValues[i] = array1D[i].getCellType().getText();

        }
        String pattern = buildPattern(n);
        String[] R ={"╔═╤╦╗","║ │║║o","╟─┼╫╢","╠═╪╬╣","╚═╧╩╝"};
        StringBuilder r = new StringBuilder();

        for (int X: pattern.getBytes()) {
            for (int x: pattern.replace("1",R[X-=48].length()>5?"151":"111").getBytes()){
                r.append(R[X].charAt(x - 48));
            }
            r.append("\n");
        }

        for(String i: cellValues) {
            r = new StringBuilder(r.toString().replaceFirst("o", i.equals("") ? "b" + i : i));
        }
        return r.toString();
    }


    public static Cell[][] convert1DTo2DCells(Cell[] array) {

        int n = (int) Math.sqrt(array.length);

        if (array.length != (n*n))
            throw new IllegalArgumentException("Invalid array length");

        Cell[][] cells = new Cell[n][n];

        for(int x=0; x<n; x++) {
            for (int y = 0; y < n; y++) {
                Cell c = array[(x * n) +y];
                c.setLocation(x, y);
                cells[x][y] = c;
            }
        }
        return cells;
    }
    /**
     * Build a pattern depending on the size of the grid
     * @param n the size
     * @return the pattern built
     */
    private static String buildPattern(int n){
        String pattern = "0";

        for (int i = 0; i < n-1; i++) {
            pattern += "12";
        }
        pattern += "14";
        return pattern;
    }

    public static String convert1DCellsToString(Cell[] array1D){
        StringBuilder s = new StringBuilder();
        for (Cell c: array1D) s.append(c.getCellType().getText());
        return s.toString();
    }


    public static Cell[] convertStringTo1DCells(String cells){
        Cell[] cells1 = new Cell[cells.length()];
        for (int i = 0; i < cells1.length; i++) {
            switch (String.valueOf(cells.charAt(i))){
                case "A": cells1[i] = new Cell(0, 1, Cell.CellType.A); break;
                case "B": cells1[i] = new Cell(0, 2, Cell.CellType.B); break;
                case "C": cells1[i] = new Cell(0, 3, Cell.CellType.C); break;
                case "@": cells1[i] = new Cell(0, 4, Cell.CellType.AGENT); break;
                case "-": cells1[i] = new Cell(0, 5, Cell.CellType.EMPTY); break;
            }
        }
        return cells1;
    }


    public static Cell[] convert2DCellsTo1DCells(Cell[][] array2D){
        Cell[] array1D = new Cell[array2D.length*array2D.length];

        for(int i = 0; i < array2D.length; i++) {
            Cell[] row = array2D[i];
            System.arraycopy(array2D[i], 0, array1D, i * row.length, row.length);
        }

        return  array1D;
    }


    public static boolean isDebuggerON() {
        return Debug.DEBUGGER;
    }

    public static Board generateBoard(Cell[][] cells, int n){
        Board newBoard =  new Board(n, cells);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n ; y++) {
                Cell cell = cells[x][y];
                switch (cell.getCellType()) {
                    case A: newBoard.setA(cell); break;
                    case B: newBoard.setB(cell); break;
                    case C: newBoard.setC(cell); break;
                    case AGENT: newBoard.setAgent(cell); break;
                }
            }

        }
        newBoard.updateConfiguration();
        return newBoard;
    }

    public static Cell cloneCell(Cell c){
        return new Cell(((int) c.getX()), ((int) c.getY()), c.getCellType());
    }

    public static Cell[][] generateGridCells(Cell a, Cell b, Cell c, Cell agent, int n){
        Cell[][] cells = new Cell[n][n];
        for (int x = 0; x < n ; x++) {
            for (int y = 0; y < n; y++) {
                if(x==a.x && y == a.y){
                    cells[x][y] = a;
                }else if(x==b.x && y == b.y){
                    cells[x][y] = b;
                }else if(x==c.x && y == c.y){
                    cells[x][y] = c;
                }else if(x==agent.x && y == agent.y){
                    cells[x][y] = agent;
                }else{
                    cells[x][y] = new Cell(new Point(x,y), Cell.CellType.EMPTY);
                }
            }
        }
        return cells;
    }



    public static void newLine(){
        System.out.println();
    }


    public static void println(String str){
        System.out.println(str);
    }
    public static void print(String str){
        System.out.print(str);
    }


    public static void printStartAndGoal(BlocksWorldTileProblem problem1) {
        println(" INITIAL STATE");
        println(problem1.startState().ascii());
        println(" GOAL STATE");
        if (problem1.getGoalConfiguration() == null) {
          println(drawGridCells(convert2DCellsTo1DCells(problem1.getGoalBoard().getCells()),
                    problem1.getGoalBoard().getN()));
        }else{
            int n = (int) Math.sqrt(problem1.goalConfiguration.length());
            println(drawGridCells(convertStringTo1DCells(problem1.getGoalConfiguration()), n));
        }

    }

    public static String solutionToString(TreeSearch search) {

        int i = 1;
        for (Node node: search.getSolution()) {
            search.getSolutionMoves().append(node.getAction()).append(" ");
            search.getSolutionASCII().append("Step ")
                    .append(i++)
                    .append(": ")
                    .append(node.getState().getActionTaken())
                    .append("\n")
                    .append("Configuration: ")
                    .append(node.getState().getBoard().getConfiguration())
                    .append("\n")
                    .append(node.getState().ascii())
                    .append("\n");
        }

        return search.getSolutionASCII() +
                        "\nTime elapsed: " + search.time() + "ms" +
                        "\nNumber nodes generated: " + search.getNodesGenerated() +
                        "\nDepth solution : " + search.getDepth() +
                        "\nMoves: " + search.getSolutionMoves();
    }
}
