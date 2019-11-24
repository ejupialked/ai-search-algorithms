package TreeSearchAlgorithm;

import Problem.Problem;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStar extends TreeSearch {

    //Uses a priority queue to store the fringe
    PriorityQueue<Node> fringe;

    public AStar(){
        super();            //Comparator that compares nodes using their estimated cost
        this.fringe = new PriorityQueue<>(Comparator.comparingInt(n -> n.estimatedCost));
    }

    @Override
    protected List<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        fringe.add(root);

        while(!fringe.isEmpty()){
            Node nodeToExpand = fringe.poll();

            if(problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem);
            fringe.addAll(successors);
        }
        return null;
    }
}
