import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import SearchAlgorithm.BFS;
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


        SearchAlgorithm bfs = new BFS();
        //SearchAlgorithm dfs = new DFS();
        //SearchAlgorithm bfs = new BFS();
        //SearchAlgorithm bfs = new BFS();


        String BFSDetails = bfs.searchDebug(problem);
        //String BFSDetails = bfs.searchDebug(problem);
        //String BFSDetails = bfs.searchDebug(problem);
        //String BFSDetails = bfs.searchDebug(problem);

       print(BFSDetails);

    }
}
