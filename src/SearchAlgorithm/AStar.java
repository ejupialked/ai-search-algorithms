package SearchAlgorithm;

import Problem.Problem;
import Puzzle.TransitionModel.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import Utils.Utils.*;

import static Utils.Utils.print;

public class AStar extends SearchAlgorithm {

    private PriorityQueue<Node> frontier;

    public AStar(){
        super();
        this.frontier = new PriorityQueue<Node>();
    }

    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;


        //Utils.print("START STATE: \n" + problem.startState().ascii());
       // Utils.print("GOAL STATE: \n" + problem.goalState().ascii());

        frontier.add(root);

        if(problem.checkGoal(root.state)){
            return solution(root);
        }



        while(!frontier.isEmpty()){

            Node nodeToExpand = frontier.poll();

            print("EXPANDING STATE: " + nodeToExpand.state.toString() +"\n" + nodeToExpand.state.ascii());



            print("-----------PERFORMING ACTIONS on " + nodeToExpand.state.hashCode() +"---------------------");

            for(Action action: problem.actions()){

                Node child = new Node(nodeToExpand,problem.goalState(), action);
                nodes++;

                if(!child.state.performAction(action)) continue;

               print("["+action+"]" + child.state.hashCode() + "Cost: " + child.f + "\n" + child.state.ascii());


                if (problem.checkGoal(child.state)) {
                    return solution(child);
                }

                frontier.add(child);
            }

           print("-----------END ACTIONS on " + nodeToExpand.state.hashCode() +"---------------------");

        }
        return null;
    }
}
