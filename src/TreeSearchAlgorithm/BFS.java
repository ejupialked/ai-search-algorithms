package TreeSearchAlgorithm;

import Problem.Problem;

import java.util.*;
import static Utils.Debug.*;

public class BFS extends TreeSearch {

    //Uses a queue to store the fringe
    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem, problem.startState(), false);

        fringe.add(root);
        showAddingRoot(root);

        while(!fringe.isEmpty()){
            Node nodeToExpand = fringe.remove();

            showRemoveNodeFromFringe(nodeToExpand);
            showCheckGoal(nodeToExpand);

            if(problem.checkGoal(nodeToExpand)) {
                showGoal(nodeToExpand);
                 return solution(nodeToExpand);
            }
            showIsNotGoal(nodeToExpand);

            List<Node> successors = generateSuccessors(nodeToExpand, problem, false);
            fringe.addAll(successors);
            showAddAllSuccessors(successors.size());
            showFringe(fringe);
        }
        return null;
    }

}
