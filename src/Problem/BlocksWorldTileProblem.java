package Problem;

import Puzzle.TransitionModel;
import Puzzle.TransitionModel.*;
import Puzzle.Board;
import Puzzle.State;
import java.util.Random;

/**
 *  This class defines the problem to solve.
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class BlocksWorldTileProblem implements Problem {

    private static int N = 4;

    public TransitionModel transitionModel;

    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String AG = "@";
    private static String X = "x";

    public BlocksWorldTileProblem(){
        this.transitionModel = new TransitionModel();
    }

    @Override
    public TransitionModel transitionModel() {
        return transitionModel;
    }

    @Override
    public Action[] actions() {
        return Action.values();
    }
    @Override
    public Action[] shuffleActions() {
        Random rand = new Random();
        Action[] actions = actions();

        for (int i = 0; i < actions.length; i++) {
            int randomIndexToSwap = rand.nextInt(actions.length);
            Action temp = actions[randomIndexToSwap];
            actions[randomIndexToSwap] = actions[i];
            actions[i] = temp;
        }
        return actions;
    }

    @Override
    public State startState(){
        String[][] grid = new String[][]
                       {{X, X, X , X},
                        {X, X, X, X},
                        {X, X, X, X},
                        {A, B, C ,AG}};

        Board board = new Board(N, grid);

        return new State(board);
    }
    @Override
    public State goalState() {
        String[][] grid = new String[][]
                       {{X, X, X , X},
                        {X, A, X, X},
                        {X, B, AG, X},
                        {X, C,X , X}};


        Board board = new Board(N, grid);

        return new State(board);
    }


    /**
     * Checks by just comparing
     * the String configuration (of the Board)
     *
     * Replaces the string of the agent with
     * the string that represents an empty space
     * since the position of the agent does not matter
     * when checking the goal state
     * @param state the state to check
     * @return
     */
    @Override
    public boolean checkGoal(State state) {
        return goalState().toString().replace(AG, X).equals(state.toString().replace(AG, X));
    }


}
