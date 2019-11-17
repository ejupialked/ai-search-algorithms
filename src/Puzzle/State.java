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

    private final Board board;
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
     * Perform a on the {@link Board}
     * @param a the action to perform
     * @return return {@code true} if action performs
     *         successfully, {@code false} otherwise.
     */
    public void performAction(Action a)  {
        try {
            transitionModel.moveAgent(a, board);
            setActionTaken(a);
        } catch (IllegalMoveException ignored){}
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            return board.equals(((State) obj).board);
        }
        return super.equals(obj);
    }


    @Override
    public int hashCode() {
        return board.hashCode();
    }

    public String ascii(){
        return Utils.drawGrid(Utils.array2dToArray1d(board.getGrid()), board.getN());
    }


    public TransitionModel.Action getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(TransitionModel.Action actionTaken) {
        this.actionTaken = actionTaken;
    }

    @Override
    public String toString() {
        return board.getConfiguration();
    }


}
