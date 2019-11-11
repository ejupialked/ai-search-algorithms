import Exceptions.IllegalMoveException;
import Problem.BlocksWorldTilePuzzle;
import Problem.Puzzle;
import SearchAlgorithm.BFS;


import static Utils.Utils.print;

public class Main {


    public static void main(String[] args) throws IllegalMoveException {

        BFS bfs = new BFS();

        Puzzle puzzle = new BlocksWorldTilePuzzle();

       String BFSDetails = bfs.searchDebug(puzzle);

       print(BFSDetails);

    }


}
