package SearchAlgorithm;

import Puzzle.TransitionModel.Action;
import Puzzle.Board;
import Puzzle.State;

public class Node implements Comparable<Node>, Heuristic {

    State state;
    Node parent;
    Action action;


    int cost;
    int h;
    int g;
    int f;


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


    @Override
    public int compareTo(Node o) {
        if (this.f == o.f) {
            return o.g - this.g;
        }
        else {
            return o.f - this.f;
        }
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
    public int g(Node node) {
        return 0;
    }

    @Override
    public int h(Node node) {
        return 0;
    }

    @Override
    public int f(Node node) {
        return 0;
    }


}
