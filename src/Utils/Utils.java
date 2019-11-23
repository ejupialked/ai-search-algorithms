package Utils;

import BlocksWorld.Board;
import BlocksWorld.Cell;
import Problem.TransitionModel.Action;

import java.awt.*;
import java.util.Random;

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
    public static String drawGrid(String[] array1D, int n) {
        for (int i = 0; i < array1D.length; i++) {
            if(array1D[i].equals("x"))
                array1D[i] = " ";

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

        for(String i: array1D) {
            r = new StringBuilder(r.toString().replaceFirst("o", i.equals("") ? "b" + i : i));
        }

        return r.toString();
    }


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
            if(array1D[i].getCellType().getText().equals("x"))
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
        return "0" + "12".repeat(Math.max(0, n-1)) + "14";
    }


    /**
     * Convert an array 2D to an array 1D
     * @param array2D the array 2D to convert
     * @return the 1D array
     */
    public static String[] array2dToArray1d(String[][] array2D){
        String[] array1D = new String[array2D.length*array2D[0].length];

        for(int i = 0; i < array2D.length; i++) {
            String[] row = array2D[i];
            System.arraycopy(array2D[i], 0, array1D, i * row.length, row.length);
        }

        return  array1D;
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
        return newBoard;
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



    public static Action[] shuffle(Action[] actions) {
        Random rand = new Random();

        for (int i = 0; i < actions.length; i++) {
            int randomIndexToSwap = rand.nextInt(actions.length);
            Action temp = actions[randomIndexToSwap];
            actions[randomIndexToSwap] = actions[i];
            actions[i] = temp;
        }
        return actions;
    }




    /**
     * Build a string from array1D
     * @param array1D
     * @return the string
     */
    public static String buildStringFromArray1D(String[] array1D) {
        StringBuilder s = new StringBuilder();
        for (String s1: array1D) s.append(s1);
        return s.toString();
    }

    /**
     * Print a string in the console
     * @param str the string to print
     */
    public static void print(String str){

        System.out.println(str);
    }
}
