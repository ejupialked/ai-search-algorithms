package SearchAlgorithm;

import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import Puzzle.TransitionModel.Action;

import java.util.*;

public class BFS extends SearchAlgorithm {

    private Queue<Node> frontier;

    public BFS(){
        super();
        this.frontier = new LinkedList<>();
    }

    /**
     * Solves {@link BlocksWorldTileProblem} with BFS
     *
     * @param problem the problem to solve
     * @return a {@code LinkedList<Node>} containing the solution
     *          if successful, returns {@code null} if case of failure.
     */
    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;
        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        frontier.add(root);
        while (!frontier.isEmpty()){
            Node nodeToExpand = frontier.remove();

            for (Action action: problem.actions()) {
                Node child = new Node(nodeToExpand, action);
                nodes++;

                if(!child.state.performAction(action)) continue;

                if (problem.checkGoal(child.state)) {
                    return solution(child);
                }

                frontier.add(child);
            }
        }
        return null;
    }
}
