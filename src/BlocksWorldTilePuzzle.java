import Game.Actions;
import Game.Board;
import Game.State;

public class BlocksWorldTilePuzzle {

    private static int N = 4;
    public static State START_STATE = startState();
    public static State GOAL_STATE =  goalState();

    public Actions actions;

    BlocksWorldTilePuzzle(){
        this.actions = new Actions();
    }

    private static State startState(){

        String[][] grid = new String[][]
                {{"x", "x", "x", "x"},
                        {"a", "x", "C", "x"},
                        {"x", "B", "x", "x"},
                        {"x", "A", "x", "x"}};


        Board board = new Board(N, grid);

        board.getN();
        return new State(board, grid);
    }

    private static State goalState(){
        String[][] grid = new String[][]
                {{"x", "x", "x", "x"},
                        {"x", "x", "C", "x"},
                        {"x", "B", "x", "x"},
                        {"x", "A", "x", "a"}};


        Board board = new Board(N, grid);

        return new State(board, grid);
    }

    public Actions getActions() {
        return actions;
    }
}
