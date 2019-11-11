package Puzzle;

import Exceptions.IllegalMoveException;
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
    private Actions actions;
    private Actions.AgentMove actionTaken;


    public State(Board board) {
        this.board = board;
        this.actions = new Actions();
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
    public boolean performAction(Actions.AgentMove a)  {
        try {
            actions.moveAgent(a, board);
            setActionTaken(a);
            return true;
        } catch (IllegalMoveException e) {
            return false;
        }
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            return getBoard().getConfiguration().equals(
                    ((State) obj).getBoard().getConfiguration());
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


    public Actions.AgentMove getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(Actions.AgentMove actionTaken) {
        this.actionTaken = actionTaken;
    }

    @Override
    public String toString() {
        return board.getConfiguration();
    }


}
