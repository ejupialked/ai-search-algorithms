
package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.DEBUG;
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
        Node root = makeNode(problem.startState());

        fringe.add(root);
        DEBUG.showAddingRoot(root);
        DEBUG.showFringe(fringe);

        while (!fringe.isEmpty()){
            Node nodeToExpand = fringe.pop();
            DEBUG.showRemoveNodeFromFringe(nodeToExpand);

            DEBUG.showCheckGoal(nodeToExpand);
            if(problem.checkGoal(nodeToExpand)) {
                DEBUG.showGoal(nodeToExpand);
                return solution(nodeToExpand);
            }
            DEBUG.showIsNotGoal(nodeToExpand);
            List<Node> successors = generateRandomSuccessors(nodeToExpand, problem);
            DEBUG.showAddAllSuccessors(successors.size());
            fringe.addAll(successors);
            DEBUG.showFringe(fringe);

        }
        return null;
    }
}