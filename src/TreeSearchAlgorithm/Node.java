package TreeSearchAlgorithm;

import Exceptions.IllegalMoveException;
import Problem.Problem;
import Problem.TransitionModel.Action;
import Puzzle.Board;
import Problem.State;

public class Node implements Comparable<Node>, Heuristic {

    State state;
    Node parent;
    Action action;
    int actionCost;

    int f;

    /*the root */
    Node(State start){
        this.state = start;
        this.parent = null;
        this.actionCost = 0;
    }


    /* child new  */
    Node(Problem problem, Node parent, Action action) throws IllegalMoveException {
        this.state = problem.generateState(parent.state, action);
        this.action = action;
        this.parent = parent;
        this.actionCost = parent.actionCost + problem.actionCost();
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
    Node(Node parent, Board goal, Action action){
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
    public int h(Board boardGoal) {
        int sum = 0;
        Board boardCurr = state.getBoard();

        int a = boardCurr.getA().manhattanDistance(boardGoal.getA());
        int b = boardCurr.getB().manhattanDistance(boardGoal.getB());
        int c = boardCurr.getC().manhattanDistance(boardGoal.getC());

        int max = Math.max(a, Math.max(b, c));


        if(!(boardCurr.getA().manhattanDistance(boardGoal.getA()) == 0)){
            sum += boardCurr.getA().manhattanDistance(boardGoal.getA());
            if(!((boardCurr.getAgent().manhattanDistance(boardCurr.getA())) > 5)){
                sum += (boardCurr.getAgent().manhattanDistance(boardCurr.getA()));
            }
        }

        if(!(boardCurr.getB().manhattanDistance(boardGoal.getB()) == 0)){
            sum += boardCurr.getB().manhattanDistance(boardGoal.getB());
            if(!((boardCurr.getAgent().manhattanDistance(boardCurr.getB())) > 5)){
                sum += (boardCurr.getAgent().manhattanDistance(boardCurr.getB()));
            }
        }

        if(!(boardCurr.getC().manhattanDistance(boardGoal.getC()) == 0)){
            sum += boardCurr.getC().manhattanDistance(boardGoal.getC());
            if(!((boardCurr.getAgent().manhattanDistance(boardCurr.getC())) > 5)){
                sum += (boardCurr.getAgent().manhattanDistance(boardCurr.getC()));
            }
        }

        return sum+ max*4;
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
