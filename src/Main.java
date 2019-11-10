import Exceptions.IllegalMoveException;
import Game.Actions;
import Game.State;
import PuzzleProbem.BlocksWorldTilePuzzle;
import PuzzleProbem.Puzzle;
import SearchAlgorithm.BFS;
import SearchAlgorithm.SearchAlgorithm;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static Utils.Utils.print;

public class Main {


    public static void main(String[] args) throws IllegalMoveException {

        BFS bfs = new BFS();

        Puzzle puzzle = new BlocksWorldTilePuzzle();

        State goal = puzzle.goalState();
        State start = puzzle.startState();

        Actions actions = puzzle.actions();


        SearchAlgorithm.Node root = new SearchAlgorithm.Node(start);

        SearchAlgorithm.Node n1 = new SearchAlgorithm.Node(start);



      print(puzzle.goalState().Ascii());


      bfs.start();
        LinkedList<SearchAlgorithm.Node> linkedList = bfs.search(puzzle);
bfs.end();
        print("------------Solution--------------------");

        int i = 0;
        for (SearchAlgorithm.Node m: linkedList) {

            print("Step " + i++);
            print(m.getState().Ascii());
        }
        print("------------END--------------------");

        print(bfs.toString());

    }


}
