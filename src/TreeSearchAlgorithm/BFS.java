package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.*;

public class BFS extends TreeSearch {

    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }


    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());

        fringe.add(root);

        while (!fringe.isEmpty()){

            Node nodeToExpand = fringe.remove();

            if(problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem);

            fringe.addAll(successors);
        }
        return null;
    }
}
