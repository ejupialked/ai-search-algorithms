package PuzzleProbem;

import Game.Actions;
import Game.State;

/**
 * Interface for defining a puzzle problem
 */
public interface Puzzle {


    State startState();

    State goalState();

    Actions actions();


    /* size of the grid */
    int sizeProblem();


    /**
     * Check if the given state
     * is the actual goal.
     * @param state the state to check
     * @return {@code true} if it is the goal
     *         {@code false} otherwise.
     */
    boolean checkGoal(State state);
}
