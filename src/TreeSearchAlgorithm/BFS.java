package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

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

        while(!fringe.isEmpty()){
            Node nodeToExpand = fringe.remove();

            if(problem.checkGoal(nodeToExpand)) {
                 return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem, false);
            fringe.addAll(successors);
        }
        return null;
    }

}
