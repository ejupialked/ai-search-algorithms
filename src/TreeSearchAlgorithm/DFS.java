package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.Stack;
import java.util.List;

public class DFS extends TreeSearch {

    //LIFO queue
    Stack<Node> fringe;

    public DFS(){
        super();
        this.fringe = new Stack<>();
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem, problem.startState(), false);

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