
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
        Node root = new Node(problem.startState());

        fringe.add(root);
        DEBUG.showAddingRoot(root.state.getBoard().getConfiguration());
        DEBUG.showFringe(fringe);

        while (!fringe.isEmpty()){
            Node nodeToExpand = fringe.pop();
            DEBUG.showRemoveNodeFromFringe(fringe, nodeToExpand.toString());

            DEBUG.showCheckGoal(nodeToExpand.toString());
            if(problem.checkGoal(nodeToExpand)) {
                DEBUG.showGoal(nodeToExpand.state.toString());
                return solution(nodeToExpand);
            }
            DEBUG.showIsNotGoal(nodeToExpand.toString());
            List<Node> successors = generateRandomSuccessors(nodeToExpand, problem);
            DEBUG.showAddAllSuccessors(successors.size());
            fringe.addAll(successors);
            DEBUG.showFringe(fringe);

        }
        return null;
    }
}