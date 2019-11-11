package Utils;

import Puzzle.Cell;

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

    /**
     * Convert an array 2D to an array 1D
     * @param array2D the array 2D to convert
     * @return the 1D array
     */
    public static Cell[] array2dToArray1dCell(Cell[][] array2D){
        Cell[] array1D = new Cell[array2D.length*array2D[0].length];

        for(int i = 0; i < array2D.length; i++) {
            Cell[] row = array2D[i];
            System.arraycopy(array2D[i], 0, array1D, i * row.length, row.length);
        }

        return  array1D;
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
    /**
     * Print a string in the console
     * @param str the string to print
     */
    public static void print(String str, String str2){
        System.out.println(str2);
        System.out.println(str);
    }

}
