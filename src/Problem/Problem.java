package Problem;

import Exceptions.IllegalMoveException;
import Problem.TransitionModel.Action;
import BlocksWorld.Board;
import TreeSearchAlgorithm.Node;

/**
 * Interface for defining the Blocks World Tile puzzle problem
 *
 * @author Alked Ejupi. Copyright (2019). All rights reserved.
 *
 */
public interface Problem {

    TransitionModel transitionModel();

    Action[] actions();

    State startState();

    Board goal();

    State generateState(State parentState, Action action) throws IllegalMoveException;

    int actionCost();

    /**
     * Checks by just comparing
     * the String configuration (of the Board)
     *
     * Replaces the string of the agent with
     * the string that represents an empty space
     * since the position of the agent does not matter
     * when checking the goal state
     * @param solution the node to check
     * @return true if it is the goal
     */
    boolean checkGoal(Node solution);
}
