package Problem;

import Exceptions.IllegalMoveException;
import Puzzle.Board;
import Problem.TransitionModel.Action;
import TreeSearchAlgorithm.Node;

import static Puzzle.Cell.*;

/**
 *  This class defines the problem to solve.
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class BlocksWorldTileProblem implements Problem {

    private static int N = 4;

    public TransitionModel transitionModel;

    public Board goal;
    public State startState;

    private static String a = CellType.A.getText();
    private static String b = CellType.B.getText();
    private static String c = CellType.C.getText();
    private static String ag = CellType.AGENT.getText();
    private static String x = CellType.EMPTY.getText();

    public BlocksWorldTileProblem(){
        this.transitionModel = transitionModel();
        this.goal = intiGoalState();
        this.startState = initStartState();
    }

    public State initStartState(){
        String[][] grid = new String[][]
                       {{x, x, x , x},
                        {x, x, x, x},
                        {x, x, x, x},
                        {a, b, c, ag}};

        Board board = new Board(N, grid);
        return new State(board);
    }

    public Board intiGoalState() {
        String[][] grid = new String[][]
                       {{x, x, x, x},
                        {x, a, x, x},
                        {x, b, x, x},
                        {x, c,ag , x}};

        Board board = new Board(N, grid);
        return board;
    }


    @Override
    public TransitionModel transitionModel() {
        return new TransitionModel();
    }

    @Override
    public Action[] actions() {
        return Action.values();
    }


    @Override
    public State startState() {
        return startState;
    }

    @Override
    public Board goal() {
        return goal;
    }

    @Override
    public State generateState(State parent, Action action) throws IllegalMoveException {
        Board board = new Board(parent.getBoard().getN(),
                parent.getBoard().getGrid());

        State newState = new State(board);

        transitionModel.performTransition(action, newState);

        return newState;
    }

    @Override
    public int actionCost() {
        return 1;
    }


    /**
     * Checks by just comparing
     * the String configuration (of the Board)
     *
     * Replaces the string of the agent with
     * the string that represents an empty space
     * since the position of the agent does not matter
     * when checking the goal state
     * @param solution the node to check
     * @return
     */
    @Override
    public boolean checkGoal(Node solution) {
        State state = solution.getState();
        return goal().getConfiguration().replace(ag, x).equals(state.toString().replace(ag, x));
    }
}
