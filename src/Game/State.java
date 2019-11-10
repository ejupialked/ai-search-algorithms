package Game;

import Exceptions.IllegalMoveException;
import Utils.Utils;

public class State {

    private final Board board;
    private Actions actions;


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
        return Utils.drawGrid(board.getArray1D(), board.getN());
    }




    @Override
    public String toString() {
        return board.getConfiguration();
    }


}
