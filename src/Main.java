import BlocksWorld.Board;
import Exceptions.IllegalMoveException;
import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import Problem.State;
import Problem.TransitionModel;
import TreeSearchAlgorithm.BFS;
import TreeSearchAlgorithm.DFS;
import TreeSearchAlgorithm.IDS;
import TreeSearchAlgorithm.AStar;
import TreeSearchAlgorithm.TreeSearch;
import Utils.Utils;


import java.awt.*;
import java.io.IOException;

import static Utils.Utils.drawGridCells;
import static Utils.Utils.print;

/**
 * Run the algorithms here.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public class Main {


    public static void main(String[] args){
        //Problem problem = new BlocksWorldTileProblem();




        Point a = new Point(3,0);
        Point b = new Point(3,1);
        Point c = new Point(3,2);
        Point agent = new Point(3,3);

        Point aGoal = new Point(1,1);
        Point bGoal = new Point(3,1);
        Point cGoal = new Point(3,2);
        Point agentGoal = new Point(2,0);


        BlocksWorldTileProblem problem1 = new BlocksWorldTileProblem(a, b, c, agent, aGoal, bGoal, cGoal, agentGoal);



         print("--------START STATE--------");
        print(problem1.startState().asciiCells());

       print("--------GOAL STATE--------");
      print(drawGridCells(Utils.convert2DCellsTo1DCells(problem1.goal().getGridCells()), problem1.goal().getN()));
        if(args.length != 0){
            String algorithm = args[0];
            solveProblem(problem1, algorithm);
        }
    }


    /**
     * Solve problem.
     *
     * @param problem   the problem
     * @param algorithm the algorithm
     */
    public static void solveProblem(Problem problem,String algorithm){

        String output = null;
            switch (algorithm) {
                case "BFS":
                    TreeSearch bfs = new BFS();
                    output = bfs.solveProblem(problem);
                    break;
                case "DFS":
                    TreeSearch dfs = new DFS();
                    output = dfs.solveProblem(problem);
                    break;
                case "IDS":
                    TreeSearch ids = new IDS();
                    output = ids.solveProblem(problem);
                    break;
                case "AStar":
                    TreeSearch ashs = new AStar();
                    output = ashs.solveProblem(problem);

            }

            print(output);
    }
}
