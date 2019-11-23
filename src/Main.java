import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import TreeSearchAlgorithm.BFS;
import TreeSearchAlgorithm.DFS;
import TreeSearchAlgorithm.IDS;
import TreeSearchAlgorithm.AStar;
import TreeSearchAlgorithm.TreeSearch;
import Utils.Utils;


import java.awt.*;

import static Utils.Utils.print;

/**
 * Run the algorithms here.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public class Main {


    public static void main(String[] args){
        Problem problem = new BlocksWorldTileProblem();


        BlocksWorldTileProblem problem1 = new BlocksWorldTileProblem();


        Point a = new Point(0,0);
        Point b = new Point(1,1);
        Point c = new Point(2,2);
        Point agent = new Point(3,3);

        Point aGoal = new Point(3,3);
        Point bGoal = new Point(2,2);
        Point cGoal = new Point(1,1);
        Point agentGoal = new Point(0,0);

        Utils.print(problem1.initCellsStart(a, b, c, agent).asciiCells());
        Utils.print(problem1.initCellsGoal(aGoal, bGoal, cGoal, agentGoal).asciiCells());



        Utils.print("--------START STATE--------");
        Utils.print(problem.startState().ascii());

        Utils.print("--------GOAL STATE--------");
        Utils.print(Utils.drawGrid(Utils.array2dToArray1d(problem.goal().getGrid()), problem.goal().getN()));
        if(args.length != 0){
            String algorithm = args[0];
            solveProblem(problem, algorithm);
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
