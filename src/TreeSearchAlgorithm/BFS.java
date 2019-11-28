package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.Debug;
import java.util.*;

public class BFS extends TreeSearch {

    //Uses a FIFO queue to store the fringe
    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem, problem.startState(), false);

        fringe.add(root);
        Debug.showAddingRoot(root);

        while(!fringe.isEmpty()){
            Node nodeToExpand = fringe.remove();

            Debug.showRemoveNodeFromFringe(nodeToExpand);
            Debug.showCheckGoal(nodeToExpand);

            if(problem.checkGoal(nodeToExpand)) {
                 Debug.showGoal(nodeToExpand);
                 return solution(nodeToExpand);
            }
            Debug.showIsNotGoal(nodeToExpand);

            List<Node> successors = generateSuccessors(nodeToExpand, problem, false);
            fringe.addAll(successors);
            Debug.showAddAllSuccessors(successors.size());
            Debug.showFringe(fringe);
        }
        return null;
    }

}
