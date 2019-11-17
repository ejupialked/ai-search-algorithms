package Problem;

import Puzzle.TransitionModel;
import Puzzle.TransitionModel.*;
import Puzzle.Board;
import Puzzle.State;
import java.util.Random;
import static Puzzle.Cell.*;

/**
 *  This class defines the problem to solve.
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class BlocksWorldTileProblem implements Problem {

    private static int N = 4;

    public TransitionModel transitionModel;
    public State goalState;
    public State startState;

    private static String a = CellType.A.getText();
    private static String b = CellType.B.getText();
    private static String c = CellType.C.getText();
    private static String ag = CellType.AGENT.getText();
    private static String x = CellType.EMPTY.getText();

    public BlocksWorldTileProblem(){
        this.transitionModel = new TransitionModel();
        this.goalState = intiGoalState();
        this.startState = initStartState();
    }

    public State initStartState(){
        String[][] grid = new String[][]
                       {{x, x, x , x},
                        {x, x, x, x},
                        {x, x, x, x},
                        {a, b, c,ag}};

        Board board = new Board(N, grid);
        return new State(board);
    }

    public State intiGoalState() {
        String[][] grid = new String[][]
                       {{a, x, x, c},
                        {x, x, x, x},
                        {x, x, ag, x},
                        {b, x,x , x}};

        Board board = new Board(N, grid);
        return new State(board);
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
    public Action[] randomiseActions() {
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
    public State startState() {
        return startState;
    }

    @Override
    public State goalState() {
        return goalState;
    }

    @Override
    public String goal() {
        return goalState.toString();
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
        return goal().replace(ag, x).equals(state.toString().replace(ag, x));
    }
}
