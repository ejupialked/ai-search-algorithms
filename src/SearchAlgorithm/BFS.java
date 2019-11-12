package SearchAlgorithm;

import Problem.BlocksWorldTileProblem;
import Puzzle.TransitionModel;
import Problem.Problem;
import Puzzle.TransitionModel.Action;
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


    @Override
    protected LinkedList<Node> treeSearch(Problem problem) {
        Node root = new Node(problem.startState(), null);
        nodes++;

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        frontier.add(root);

        while (!frontier.isEmpty()){

            Node nodeToExpand = frontier.remove();

            explored.add(nodeToExpand);

            int i = 1; //improve values
            for (Action action: problem.actions()) {

                Node child = new Node(nodeToExpand, action);
                nodes++;

                /* if action cannot be performed goes to the next action */
                if(!child.state.performAction(action)) continue;

                if (problem.checkGoal(child.state)) {
                    return solution(child);
                }

                frontier.add(child);

            }
        }
        return null;
    }


    /**
     * Solves {@link BlocksWorldTileProblem} with BFS
     *
     * @param problem the problem to solve
     * @return a {@code LinkedList<Node>} containing the solution
     *          if successful, returns {@code null} if case of failure.
     */
    @Override
    protected LinkedList<Node> graphSearch(Problem problem) {

        Node root = new Node(problem.startState(), null);
        nodes++;

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        frontier.add(root);

        while (!frontier.isEmpty()){

            Node nodeToExpand = frontier.remove();

            explored.add(nodeToExpand);

            int i = 1;
            for (Action action: Action.values()) {

                Node child = new Node(nodeToExpand, action);
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

        path.add(solution);
        while (solution.parent != null) {
            path.add(solution.parent);
            solution = solution.parent;
        }

        Collections.reverse(path);

        depth = path.size();
        return path;

    }
}
