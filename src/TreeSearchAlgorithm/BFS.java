package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.Utils;

import java.util.*;

public class BFS extends TreeSearch {

    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }


    @Override
    protected List<Node> search(Problem problem) {
        Node root = new Node(problem.startState());

        fringe.add(root);

        while (!fringe.isEmpty()){

            Node nodeToExpand = fringe.remove();

            Utils.print("Removing node " + nodeToExpand.hashCode() + " from the fringe.");
            if(problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            Utils.print("Start to expand " + nodeToExpand.hashCode() + ".");
            List<Node> successors = generateSuccessors(nodeToExpand, problem);

            fringe.addAll(successors);
        }
        return null;
    }
}
