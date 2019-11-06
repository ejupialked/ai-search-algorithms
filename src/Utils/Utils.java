package Utils;

/**
 * Utility class
 *
 *
 * @author Alked Ejupi
 */

public final class Utils {

    public final static boolean DEBUG = true;

    public final static int DEPTH_FIRST = 1;
    public final static int BREADTH_FIRST  = 2;
    public final static int ITERATIVE_DEEPENING = 3;
    public final static int A_STAR_HEURISTIC = 4;


    /**
     * Draws the blocks of the puzzle in a nice way in the Console.
     *
     * @param puzzle the puzzle in 2D array form
     * @param n  the size of grid (nxn)
     * @return the String containing the puzzle with blocks
     */
    public static String drawGrid(String[][] puzzle, int n) {
        String[] array1D = array2dToArray1d(puzzle);

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
    private static String[] array2dToArray1d(String[][] array2D){
        String[] array1D = new String[array2D.length*array2D[0].length];

        for(int i = 0; i < array2D.length; i++) {
            String[] row = array2D[i];
            System.arraycopy(array2D[i], 0, array1D, i * row.length, row.length);
        }

        return  array1D;
    }


    /**
     * Print a string in the console
     * @param str the string to print
     */
    public static void print(String str){
        System.out.println(str);
    }

}
