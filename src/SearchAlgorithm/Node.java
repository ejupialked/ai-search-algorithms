package SearchAlgorithm;

import Puzzle.TransitionModel.Action;
import Puzzle.Board;
import Puzzle.State;

public class Node implements Comparable<Node>, Heuristic{

    State state;
    Node parent;
    Action action;
    int f;

  ;
    /*the root */
    Node(State start){
        this.state = start;
        this.parent =null;
    }

    /* child (successor) */
    Node(Node parent, Action action){
        Board board = new Board(parent.state.getBoard().getN(),
                parent.state.getBoard().getGrid());
        this.state = new State(board);
        this.action = action;
        this.parent = parent;
    }


    /* child (successor) heuristic */
    Node(Node parent, State goal, Action action){
        Board board = new Board(parent.state.getBoard().getN(),
                parent.state.getBoard().getGrid());
        this.state = new State(board);
        this.action = action;
        this.parent = parent;

        this.f = f(g(),h(goal));
    }


    /* Node for g() */
    Node(Node parent){
        this.parent = parent;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.f, o.f);
    }

    @Override
    public int g() {
        if(this.parent == null){
            return 0;
        }
        Node curr = new Node(this.parent);

        int cost = 0;
        while (curr != null){
            curr = curr.parent;
            cost++;
        }
        return cost;
    }

    @Override
    public int h(State goal) {
        int sum = 0;

        Board boardGoal = goal.getBoard();
        Board boardCurr = state.getBoard();

        sum += boardCurr.getA().manhattanDistance(boardGoal.getA());
        sum += boardCurr.getB().manhattanDistance(boardGoal.getB());
        sum += boardCurr.getC().manhattanDistance(boardGoal.getC());

        int ag = (int) Math.floor(sum / 3);

        sum += ag;

        return sum;
    }

    @Override
    public int f(int g, int h) {
        return g + h;
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

}
