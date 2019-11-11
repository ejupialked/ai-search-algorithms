package Game;

import Exceptions.IllegalMoveException;
import Utils.Utils;

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


    public boolean action(Actions.AgentMove action)  {
        try {
            actions.moveAgent(action, board);
            setActionTaken(action);
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

    public String Ascii(){
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
