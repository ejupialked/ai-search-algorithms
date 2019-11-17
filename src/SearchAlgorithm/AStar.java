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

        Utils.print("Root node: " + root.toString());
        Utils.print(root.state.ascii());

        if(problem.checkGoal(root.state)){
            return solution(root);
        }

        while(!priorityQueue.isEmpty()){

            Node nodeToExpand = priorityQueue.poll();
            Utils.print("Taking node: " + nodeToExpand.toString());
            Utils.print("highest priority");
            Utils.print(nodeToExpand.state.ascii());

            Utils.print("-----------------EXPANDING "+ nodeToExpand.toString() + "---------------------------");
            for(Action action: problem.actions()){

                // child with heuristic goal state
                Node child = new Node(nodeToExpand,problem.goalState(), action);
                nodes++;

                if(!child.state.performAction(action)) continue;

                Utils.print("Child " + child.toString() + "has f: " + child.f);
                Utils.print(child.state.ascii());

                if (problem.checkGoal(child.state)) {
                    return solution(child);
                }

                priorityQueue.add(child);
            }

        }




        return null;
    }
}
