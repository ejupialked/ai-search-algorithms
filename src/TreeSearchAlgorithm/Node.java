package TreeSearchAlgorithm;

import Exceptions.IllegalMoveException;
import Problem.Problem;
import Problem.TransitionModel.Action;
import BlocksWorld.Board;
import Problem.State;

public class Node implements Heuristic {

    State state;
    Node parent;
    Action action;

    int pathCost;
    int estimatedCost;

    /*the root */
    Node(State start){
        this.state = start;
        this.parent = null;
        this.pathCost = 0;
    }

    /* child (successor) */
    Node(Problem problem, Node parent, Action action) throws IllegalMoveException {
        this.state = problem.generateState(parent.state, action);
        this.action = action;
        this.parent = parent;
        this.pathCost = parent.pathCost + problem.actionCost();
        this.estimatedCost = calculateEstimatedCost(g(), h(problem.goal()));
    }

    @Override
    public int g() {
        return pathCost;
    }

    @Override
    public int h(Board boardGoal) {
        int sum = 0;
        Board boardCurr = state.getBoard();

        int a = boardCurr.getA().manhattanDistance(boardGoal.getA());
        int b = boardCurr.getB().manhattanDistance(boardGoal.getB());
        int c = boardCurr.getC().manhattanDistance(boardGoal.getC());

        int max = Math.max(a, Math.max(b, c))/3;


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

        return sum + max*4;
    }

    @Override
    public int calculateEstimatedCost(int g, int h) {
        return g + h;
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
        return this.state.hashCode();
    }

    @Override
    public String toString() {
        return state.getBoard().toString();
    }
}
