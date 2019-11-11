package Problem;

import Puzzle.Actions;
import Puzzle.Board;
import Puzzle.State;


/**
 *  This class defines the problem to solve.
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class BlocksWorldTileProblem implements Problem {

    private static int N = 4;

    public Actions actions;

    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String AG = "@";
    private static String X = "x";

    public BlocksWorldTileProblem(){
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
                        {B, A, X, X},
                        {X, X, X, X},
                        {X, C, X, AG}};



        Board board = new Board(N, grid);

        return new State(board);
    }


    /**
     * Checks by just comparing
     * the String configuration (of the Board)
     * @param state the state to check
     * @return
     */
    @Override
    public boolean checkGoal(State state) {
        return goalState().toString().replace(AG, X).equals(state.toString().replace(AG, X));
    }


}
