package SearchAlgorithm;

import Game.Actions;
import Problem.Puzzle;
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
     * Solves {@link Problem.BlocksWorldTilePuzzle} with BFS
     *
     * @param problem the problem to solve
     * @return a {@code LinkedList<Node>} containing the solution
     *          if successful, returns {@code null} if case of failure.
     */
    @Override
    protected LinkedList<Node> search(Puzzle problem) {

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

                Node successor = new Node(nodeToExpand.getState(), nodeToExpand);
                nodes++;

                if(!successor.getState().action(action)) continue;

                Utils.print("Action: " + action);
                Utils.print(successor.state.Ascii());


                if (!explored.contains(successor) || !frontier.contains(successor)) {
                    if (problem.checkGoal(successor.state)) {
                        return solution(successor);
                    }

                    frontier.add(successor);
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
        return path;

    }
}
