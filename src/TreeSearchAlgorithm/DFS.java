
package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.Debug;
import java.util.Stack;
import java.util.List;

public class DFS extends TreeSearch {

    Stack<Node> fringe;

    public DFS(){
        super();
        this.fringe = new Stack<>();
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem, problem.startState(), false);

        fringe.add(root);
        Debug.showAddingRoot(root);
        Debug.showFringe(fringe);

        while (!fringe.isEmpty()){
            Node nodeToExpand = fringe.pop();

            Debug.showRemoveNodeFromFringe(nodeToExpand);

            Debug.showCheckGoal(nodeToExpand);
            if(problem.checkGoal(nodeToExpand)) {
                Debug.showGoal(nodeToExpand);
                return solution(nodeToExpand);
            }
            Debug.showIsNotGoal(nodeToExpand);
            List<Node> successors = generateRandomSuccessors(nodeToExpand, problem);
            Debug.showAddAllSuccessors(successors.size());
            fringe.addAll(successors);
            Debug.showFringe(fringe);

        }
        return null;
    }
}