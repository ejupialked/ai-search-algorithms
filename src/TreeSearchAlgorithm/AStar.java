package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class AStar extends TreeSearch {

    PriorityQueue<Node> frontier;

    public AStar(){
        super();
        this.frontier = new PriorityQueue<>();
    }

    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        frontier.add(root);

        if(problem.checkGoal(root)){
            return solution(root);
        }

        while(!frontier.isEmpty()){

            Node nodeToExpand = frontier.poll();

            if (problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem);

            frontier.addAll(successors);

        }

        return null;
    }
}
