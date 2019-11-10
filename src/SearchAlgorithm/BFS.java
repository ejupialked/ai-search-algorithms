package SearchAlgorithm;

import Game.Actions;
import PuzzleProbem.Puzzle;
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
    public LinkedList<Node> search(Puzzle problem) {

        Node root = new Node(problem.startState());
        nodes++;

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        frontier.add(root);

        while (!frontier.isEmpty()){

            Node node = frontier.remove();

            explored.add(node);

            for (Actions.AgentMove action: Actions.AgentMove.values()) {
                Node child = new Node(node.getState(), node);
                nodes++;

                if(!child.getState().action(action)) continue;

                Utils.print("Action: " + action);
                Utils.print(child.state.Ascii());


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
        return path;

    }
}
