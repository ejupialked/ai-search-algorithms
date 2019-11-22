package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class AStar extends TreeSearch {

    PriorityQueue<Node> fringe;

    public AStar(){
        super();
        this.fringe = new PriorityQueue<>();
    }

    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        fringe.add(root);

        if(problem.checkGoal(root)){
            return solution(root);
        }

        while(!fringe.isEmpty()){

            Node nodeToExpand = fringe.poll();

            if (problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem);

            fringe.addAll(successors);

        }

        return null;
    }
}
