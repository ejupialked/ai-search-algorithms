package TreeSearchAlgorithm;

import BlocksWorld.Board;
import BlocksWorld.Cell;

public interface Heuristic {

    /**
     * Path cost from start node to {@code n}
     */
    int g();

    /**
     * estimated cost of the cheapest path from {@code n} to goal
     */
    int h(Board goal);

    /**
     * estimated cost of the cheapest path from {@code n} to goal
     */
    int hImproved(Board goal);




   



    /**
     *  estimated cost of the cheapest solution through {@code n}
     */
    int calculateEstimatedCost(int g, int h);
}
