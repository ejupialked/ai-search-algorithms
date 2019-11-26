package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static Utils.DEBUG.*;

public class AStar extends TreeSearch {

    //Uses a priority queue to store the fringe
    PriorityQueue<Node> fringe;

    public AStar(){
        super();            //Comparator that compares nodes using their estimated cost
        this.fringe = new PriorityQueue<>(Comparator.comparingInt(n -> n.estimatedCost));
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem.startState());

        fringe.add(root);
        showAddingRoot(root.state.getBoard().getConfiguration());
        showFringe(fringe);

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
