package PuzzleProbem;

import Game.Actions;
import Game.Board;
import Game.State;

public class BlocksWorldTilePuzzle implements Puzzle {

    private static int N = 4;
    public State START_STATE = startState();
    public State GOAL_STATE =  goalState();

    public Actions actions;

    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String AG = "a";
    private static String X = "x";

    public BlocksWorldTilePuzzle(){
        this.actions = new Actions();
    }

    @Override
    public State startState(){
        String[][] grid = new String[][]
                       {{X, X, X , X},
                        {X, X, X, X},
                        {X, X, X, X},
                        {A, B, C, AG}};

        Board board = new Board(N, grid);

        return new State(board);
    }
    @Override
    public State goalState() {
        String[][] grid = new String[][]
                        {{X, X, X, X},
                        {X, A, X, X},
                        {X, B, X, X},
                        {X, C, X, AG}};
        Board board = new Board(N, grid);

        return new State(board);
    }


    @Override
    public Actions actions() {
        return actions;
    }

    @Override
    public int sizeProblem() {
        return N;
    }

    @Override
    public boolean checkGoal(State state) {
        return goalState().toString()
                .replace("a", "x")
                .equals(state.toString().replace("a", "x"));
    }


}
