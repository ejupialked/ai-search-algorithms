package Problem;

import BlocksWorld.Board;
import BlocksWorld.Cell;
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
    Action actionTaken;


    public State(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            return board.equals(((State) obj).board);
        }
        return super.equals(obj);
    }


    public String ascii(){
        return board.getASCIIString();
    }

    public Action getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(Action actionTaken) {
        this.actionTaken = actionTaken;
    }

    @Override
    public String toString() {
        return board.toString();
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }

}
