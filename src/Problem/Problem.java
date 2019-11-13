package Problem;

import Puzzle.State;
import Puzzle.TransitionModel;
import Puzzle.TransitionModel.Action;

/**
 * Interface for defining the puzzle problem
 *
 * @author Alked Ejupi. Copyright (2019). All rights reserved.
 *
 */
public interface Problem {


    TransitionModel transitionModel();

    Action[] actions();
    Action[] shuffleActions();


    State startState();
    State goalState();

    /**
     * Check if the given state
     * is the actual goal.
     * @param state the state to check
     * @return {@code true} if it is the goal
     *         {@code false} otherwise.
     */
    boolean checkGoal(State state);
}
