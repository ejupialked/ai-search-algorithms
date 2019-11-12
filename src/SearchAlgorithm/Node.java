package SearchAlgorithm;


import Puzzle.TransitionModel.Action;
import Puzzle.Board;
import Puzzle.State;

public class Node {
    State state;
    Node parent;
    Action action;
    int pathCost;

    Node(State start, Node parent){
        this.state = start;
        this.parent =null;
    }

    Node(Node parent, Action action){
        Board board = new Board(parent.state.getBoard().getN(),parent.state.getBoard().getGrid());
        this.state = new State(board);
        this.action = action;
        this.parent = parent;
    }



    /**
     * Returns the state of the board
     * as a String.
     * @return the state of board
     */
    @Override
    public String toString() {
        return Integer.toString(hashCode());
    }

    public State getState() {
        return state;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            return getState().getBoard().getConfiguration().equals(
                    ((Node) obj).getState().getBoard().getConfiguration());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.state.getBoard().getConfiguration().hashCode();
    }
}
