import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import TreeSearchAlgorithm.BFS;
import TreeSearchAlgorithm.DFS;
import TreeSearchAlgorithm.IDS;
import TreeSearchAlgorithm.AStar;
import TreeSearchAlgorithm.TreeSearchAlgorithm;
import Utils.Utils;


import static Utils.Utils.print;

/**
 *
 * Run the algorithms here.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class Main {


    public static void main(String[] args){
        Problem problem = new BlocksWorldTileProblem();

        Utils.print("--------START STATE--------");
        Utils.print(problem.startState().ascii());

        Utils.print("--------GOAL STATE--------");
        Utils.print(Utils.drawGrid(Utils.array2dToArray1d(problem.goal().getGrid()), problem.goal().getN()));
        if(args.length != 0){
            String algorithm = args[0];
            solveProblem(problem, algorithm);
        }






    }


    public static void solveProblem(Problem problem,String algorithm){

        String output = null;
            switch (algorithm) {
                case "BFS":
                    TreeSearchAlgorithm bfs = new BFS();
                    output = bfs.solveProblem(problem);
                    break;
                case "DFS":
                    TreeSearchAlgorithm dfs = new DFS();
                    output = dfs.solveProblem(problem);
                    break;
                case "IDS":
                    TreeSearchAlgorithm ids = new IDS();
                    output = ids.solveProblem(problem);
                    break;
                case "AStar":
                    TreeSearchAlgorithm ashs = new AStar();
                    output = ashs.solveProblem(problem);

            }

            print(output);
    }
}
