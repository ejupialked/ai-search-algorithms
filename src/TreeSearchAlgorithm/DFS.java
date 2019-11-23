
package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.*;

public class DFS extends TreeSearch {

    Stack<Node> fringe;

    public DFS(){
        super();
        this.fringe = new Stack<>();
    }


    @Override
    protected List<Node> search(Problem problem) {
        Node root = new Node(problem.startState());

        fringe.add(root);

        while (!fringe.isEmpty()){

            Node nodeToExpand = fringe.pop();

            if(problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateRandomSuccessors(nodeToExpand, problem);

            fringe.addAll(successors);
        }
        return null;
    }
}