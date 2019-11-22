package Problem;

import Exceptions.IllegalMoveException;
import BlocksWorld.Board;
import Utils.Utils;
import Problem.TransitionModel.Action;

/**
 * Class that represent a single state of the puzzle,
 * in other words the arrangements of the pieces.
 * It also provides the possible action that can be performed.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public class State {

    Board board;
     TransitionModel transitionModel;
     Action actionTaken;


    /**
     * Instantiates a new State.
     *
     * @param board the board
     */
    public State(Board board) {
        this.board = board;
        this.transitionModel = new TransitionModel();
    }

    /**
     * Gets board.
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Perform an action on the {@link Board}
     *
     * @param a the action to perform
     * @return the boolean
     */
    public boolean performAction(Action a)  {
        try {
            transitionModel.performTransition(a, this);
            setActionTaken(a);
            return true;
        } catch (IllegalMoveException e){
            return false;
        }
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            return board.equals(((State) obj).board);
        }
        return super.equals(obj);
    }

    /**
     * Ascii string.
     *
     * @return the string
     */
    public String ascii(){
        return Utils.drawGrid(Utils.array2dToArray1d(board.getGrid()), board.getN());
    }

    /**
     * Gets action taken.
     *
     * @return the action taken
     */
    public Action getActionTaken() {
        return actionTaken;
    }

    /**
     * Sets action taken.
     *
     * @param actionTaken the action taken
     */
    public void setActionTaken(Action actionTaken) {
        this.actionTaken = actionTaken;
    }

    @Override
    public String toString() {
        return board.getConfiguration();
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }

}
