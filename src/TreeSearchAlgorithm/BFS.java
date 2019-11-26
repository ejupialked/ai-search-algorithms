package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.*;
import static Utils.DEBUG.*;

public class BFS extends TreeSearch {

    //Uses a queue to store the fringe
    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem.startState());

        fringe.add(root);
        showAddingRoot(root.state.getBoard().getConfiguration());

        while(!fringe.isEmpty()){

            Node nodeToExpand = fringe.remove();
            showRemoveNodeFromFringe(fringe, nodeToExpand.toString());

            showCheckGoal(nodeToExpand.toString());
            if(problem.checkGoal(nodeToExpand)) {
                showGoal(nodeToExpand.state.toString());
                 return solution(nodeToExpand);
            }
            showIsNotGoal(nodeToExpand.toString());

            List<Node> successors = generateSuccessors(nodeToExpand, problem);

            fringe.addAll(successors);
            showAddAllSuccessors(successors.size());
            showFringe(fringe);

        }
        return null;
    }



}
