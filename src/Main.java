
import static Utils.Utils.drawGrid;
import static Utils.Utils.print;

public class Main {

    public static void main(String[] args) {

        int n = 4;

        String[][] grid = {{" ", " ", " ", " "},
                {" ", " ", "C", " "},
                {" ", "B", " ", " "},
                {" ", "A", " ", "a"}
        };


        print(drawGrid(grid, n));

    }
}
