package SearchAlgorithm;

import Problem.BlocksWorldTileProblem;
import Puzzle.TransitionModel;
import Problem.Problem;
import Puzzle.TransitionModel.Action;
import Utils.Utils;

import java.util.*;

public class DFS extends SearchAlgorithm {

    private Stack<Node> frontier;
    private Set<Node> explored;

    public DFS(){
        super();
        this.frontier = new Stack<Node>();
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

            Node nodeToExpand = frontier.pop();

            explored.add(nodeToExpand);

            for (Action action: problem.shuffleActions()) {

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

        Utils.print("Root node " + root.toString());


        while (!frontier.isEmpty()){

            Node nodeToExpand = frontier.pop();

            Utils.print("Expanding node \n " + nodeToExpand.toString());
            Utils.print(nodeToExpand.state.ascii());


            explored.add(nodeToExpand);


            depth++;
            int i = 1;
            for (Action action: problem.shuffleActions()) {

                Node child = new Node(nodeToExpand, action);
                nodes++;

                /* if action cannot be performed goes to the next action */
                if(!child.state.performAction(action)) continue;


                Utils.print("Successor "+ i++ + "\n"+ child.toString()+": "+ "[" + child.action + "]" );
                Utils.print(child.state.ascii());

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

        depth = path.size();
        Collections.reverse(path);
        return path;

    }
}
