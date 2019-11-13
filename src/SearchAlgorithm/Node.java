package SearchAlgorithm;

import Puzzle.TransitionModel.Action;
import Puzzle.Board;
import Puzzle.State;

public class Node implements Comparable<Node>{

    State state;
    Node parent;
    Action action;


    /* Constructor for the root */
    Node(State start){
        this.state = start;
        this.parent =null;
    }

    /* Constructor for child (successor) */
    Node(Node parent, Action action){
        Board board = new Board(parent.state.getBoard().getN(),
                                parent.state.getBoard().getGrid());
        this.state = new State(board);
        this.action = action;
        this.parent = parent;

        state.performAction(action);
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
            return getState().equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.state.getBoard().getConfiguration().hashCode();
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
