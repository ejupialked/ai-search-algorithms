package SearchAlgorithm;

import Problem.Problem;
import Puzzle.TransitionModel.Action;

import java.util.*;

public class DFS extends SearchAlgorithm {

    private Stack<Node> frontier;

    public DFS(){
        super();
        this.frontier = new Stack<Node>();
    }


    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        frontier.add(root);

        while (!frontier.isEmpty()){

            Node nodeToExpand = frontier.pop();

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
}
