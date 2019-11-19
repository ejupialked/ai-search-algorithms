package TreeSearchAlgorithm;

import Problem.BlocksWorldTileProblem;
import Problem.Problem;

import java.util.*;

public class BFS extends TreeSearchAlgorithm {

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

        frontier.add(root);

        while (!frontier.isEmpty()){
            Node nodeToExpand = frontier.remove();

            if (problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem);

            frontier.addAll(successors);

        }
        return null;
    }
}
