package SearchAlgorithm;

import Problem.BlocksWorldTileProblem;
import Puzzle.Actions;
import Problem.Problem;
import Utils.Utils;

import java.util.*;

public class BFS extends SearchAlgorithm {

    private Queue<Node> frontier;
    private Set<Node> explored;

    public BFS(){
        super();
        this.frontier = new LinkedList<>();
        this.explored = new HashSet<>();
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

        Node root = new Node(problem.startState(), null);
        nodes++;

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        frontier.add(root);

        while (!frontier.isEmpty()){

            Node nodeToExpand = frontier.remove();

            explored.add(nodeToExpand);

            for (Actions.AgentMove action: Actions.AgentMove.values()) {

                Node child = new Node(nodeToExpand.state, nodeToExpand);
                nodes++;

                /* if action cannot be performed goes to the next action */
                if(!child.state.performAction(action)) continue;

                if (!explored.contains(child) || !frontier.contains(child)) {
                    if (problem.checkGoal(child.state)) {
                        return solution(child);
                    }

                    frontier.add(child);
                }
            }
        }

        return null;
    }


    @Override
    public LinkedList<Node> solution(Node solution) {

        LinkedList<Node> path = new LinkedList<>();

        while (solution.parent != null) {
            path.add(solution.parent);
            solution = solution.parent;
        }

        Collections.reverse(path);
        return path;

    }
}
