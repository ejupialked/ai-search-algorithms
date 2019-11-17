import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import SearchAlgorithm.BFS;
import SearchAlgorithm.DFS;
import SearchAlgorithm.IDS;
import SearchAlgorithm.ASHS;

import SearchAlgorithm.SearchAlgorithm;


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

        String algorithm = args[0];

        String output = null;

        switch (algorithm){
            case "BFS":
                SearchAlgorithm bfs = new BFS();
                output = bfs.searchDebug(problem);
                break;
            case "DFS":
                SearchAlgorithm dfs = new DFS();
                output = dfs.searchDebug(problem);
                break;
            case "IDS":
                SearchAlgorithm ids = new IDS();
                output = ids.searchDebug(problem);
            case "ASHS":
                SearchAlgorithm ashs = new ASHS();
                output = ashs.searchDebug(problem);

        }


       print(output);

    }
}
