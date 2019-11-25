
package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.Utils;

import java.util.Stack;
import java.util.List;

public class DFS extends TreeSearch {

    Stack<Node> fringe;

    public DFS(){
        super();
        this.fringe = new Stack<>();
    }

    @Override
    protected List<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

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