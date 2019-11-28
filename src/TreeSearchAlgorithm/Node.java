package TreeSearchAlgorithm;

import BlocksWorld.Cell;
import Exceptions.IllegalMoveException;
import Problem.Problem;
import Problem.TransitionModel.Action;
import BlocksWorld.Board;
import Problem.State;

public class Node implements Heuristic {

    State state;
    Node parent;
    Action action;
    int depth;


    int pathCost;
    int estimatedCost;
    boolean heuristic;

    /*the root */
    Node(Problem problem, State start, boolean heuristic){
        this.state = start;
        this.parent = null;
        this.heuristic = heuristic;
        this.depth = 0;

        if(heuristic){
            this.pathCost = 0;
            this.estimatedCost = calculateEstimatedCost(g(), h(problem.goal()));
        }
    }

    /* child (successor) */
    Node(Problem problem, Node parent, Action action, boolean heuristic) throws IllegalMoveException {
        this.state = problem.generateState(parent.state, action);
        this.action = action;
        this.parent = parent;
        this.heuristic = heuristic;
        this.depth = parent.depth + 1;


        if(heuristic){
            this.pathCost = parent.pathCost + problem.actionCost();
            this.estimatedCost = calculateEstimatedCost(g(), h(problem.goal()));
        }

    }



    @Override
    public int g() {
        return pathCost;
    }


    public boolean isHeuristic() {
        return heuristic;
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

        return sum + max*4;
    }



    @Override
    public int hImproved(Board boardGoal) {
        int sum = 0;
        Board boardCurr = state.getBoard();

        int a = boardCurr.getA().manhattanDistance(boardGoal.getA());
        int b = boardCurr.getB().manhattanDistance(boardGoal.getB());
        int c = boardCurr.getC().manhattanDistance(boardGoal.getC());

        sum = a + b + c;

        return sum;
    }

    @Override
    public int calculateEstimatedCost(int g, int h) {
        return g + h;
    }


    public Action getAction() {
        return action;
    }


    public int getEstimatedCost() {
        return estimatedCost;
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            return toString().equals(obj.toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.state.hashCode();
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
