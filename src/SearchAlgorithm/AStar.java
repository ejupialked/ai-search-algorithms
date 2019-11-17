package SearchAlgorithm;

import Problem.Problem;
import Puzzle.TransitionModel.*;
import Utils.Utils;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStar extends SearchAlgorithm {

    private PriorityQueue<Node> priorityQueue;

    public AStar(){
        super();
        this.priorityQueue = new PriorityQueue<Node>();
    }

    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        priorityQueue.add(root);

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        while(!priorityQueue.isEmpty()){

            Node nodeToExpand = priorityQueue.poll();

            for(Action action: problem.actions()){

                // child with heuristic goal state
                Node child = new Node(nodeToExpand,problem.goalState(), action);
                nodes++;

                if(!child.state.performAction(action)) continue;

                if (problem.checkGoal(child.state)) {
                    return solution(child);
                }

                priorityQueue.add(child);
            }
        }
        return null;
    }
}
