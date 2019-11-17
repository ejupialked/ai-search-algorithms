package Puzzle;

import Exceptions.IllegalMoveException;
import Puzzle.TransitionModel.*;
import Utils.Utils;

/**
 * Class that represent a single state of the puzzle,
 * in other words the arrangements of the pieces.
 * It also provides the possible action that can be performed.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 *
 */
public class State {

    private Board board;
    private TransitionModel transitionModel;
    private Action actionTaken;


    public State(Board board) {
        this.board = board;
        this.transitionModel = new TransitionModel();
    }

    public Board getBoard() {
        return board;
    }

    /**
     * Perform an action on the {@link Board}
     * @param a the action to perform
     */
    public boolean performAction(Action a)  {
        try {
            transitionModel.moveAgent(a, board);
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

    public String ascii(){
        return Utils.drawGrid(Utils.array2dToArray1d(board.getGrid()), board.getN());
    }

    public Action getActionTaken() {
        return actionTaken;
    }

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
