package Utils;

import BlocksWorld.Board;
import BlocksWorld.Cell;
import TreeSearchAlgorithm.Node;
import TreeSearchAlgorithm.TreeSearch;

import java.awt.*;
import java.util.List;
import java.util.Queue;

/**
 * Utility class
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public final class Utils {


    private static boolean DEBUG = true;

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

    public static Cell[] convert2DCellsTo1DCells(Cell[][] array2D){
        Cell[] array1D = new Cell[array2D.length*array2D.length];

        for(int i = 0; i < array2D.length; i++) {
            Cell[] row = array2D[i];
            System.arraycopy(array2D[i], 0, array1D, i * row.length, row.length);
        }

        return  array1D;
    }


    public static boolean isDEBUG() {
        return DEBUG;
    }

    public static Board generateBoard(Cell a, Cell b, Cell c, Cell agent, int n){
        Cell[][] gridCells = generateGridCells(a, b, c, agent, n);
        Board newBoard =  new Board(n, gridCells);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n ; y++) {
                Cell cell = gridCells[x][y];
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

    private static Cell[][] generateGridCells(Cell a, Cell b, Cell c, Cell agent, int n){
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


    public static void print(String str){
        System.out.println(str);
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
                        "\nNumber nodes generated: " + search.getNodes() +
                        "\nDepth solution : " + search.getDepth() +
                        "\nMoves: " + search.getSolutionMoves();
    }
}
