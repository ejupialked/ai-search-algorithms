package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static Utils.Debug.*;

public class AStar extends TreeSearch {

    //Uses a priority queue to store the fringe
    PriorityQueue<Node> fringe;

    public AStar(){
        super();            //Comparator that compares nodesGenerated using their estimated cost
        this.fringe = new PriorityQueue<>(Comparator.comparingInt(n -> n.estimatedCost));
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem.startState());

        fringe.add(root);
        showAddingRoot(root);
        showFringe(fringe);

        while(!fringe.isEmpty()){

            Node nodeToExpand = fringe.remove();
            showRemoveNodeFromFringe(nodeToExpand);
            showFringe(fringe);


            showCheckGoal(nodeToExpand);
            if(problem.checkGoal(nodeToExpand)) {
                showGoal(nodeToExpand);
                return solution(nodeToExpand);
            }
            showIsNotGoal(nodeToExpand);

            List<Node> successors = generateSuccessors(nodeToExpand, problem, true);

            fringe.addAll(successors);
            showAddAllSuccessors(successors.size());
            showFringe(fringe);

        }
        return null;
    }

}
