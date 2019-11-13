import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import SearchAlgorithm.BFS;
import SearchAlgorithm.DFS;
import SearchAlgorithm.IDS;


import SearchAlgorithm.SearchAlgorithm;
import Utils.Utils;

import java.awt.*;

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
        SearchAlgorithm dfs = new DFS();
        SearchAlgorithm ids = new IDS();
        //SearchAlgorithm bfs = new BFS();


        //String BFSDetails = bfs.searchDebug(problem);
       //String DFSDetails = dfs.searchDebug(problem);
        //String IDSDetails = ids.searchDebug(problem);
        //String BFSDetails = bfs.searchDebug(problem);

       //print(BFSDetails);
       //print(DFSDetails);
       //print(IDSDetails);


        Point a = new Point(0, 0);
        Point b = new Point(0, 2);

        System.out.print(a.distance(b));



    }
}
