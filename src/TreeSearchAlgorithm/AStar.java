package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class AStar extends TreeSearch {

    //Uses a priority queue to store the fringe
    PriorityQueue<Node> fringe;

    public AStar(){
        super();            //Comparator that compares nodesGenerated using their estimated cost
        this.fringe = new PriorityQueue<>(Comparator.comparingInt(node -> node.estimatedCost));
    }

    @Override
    protected List<Node> treeSearch(Problem problem) {
        Node root = makeNode(problem, problem.startState(), true);

        fringe.add(root);

        while(!fringe.isEmpty()){
            Node nodeToExpand = fringe.remove();

            if(problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem, true);

            fringe.addAll(successors);
        }
        return null;
    }
}
