import Exceptions.IllegalMoveException;
import Game.Actions;
import Game.State;

import static Utils.Utils.print;

public class Main {


    public static void main(String[] args) {
        BlocksWorldTilePuzzle blocksWorldTilePuzzle = new BlocksWorldTilePuzzle();

        State start = BlocksWorldTilePuzzle.START_STATE;

        print(BlocksWorldTilePuzzle.START_STATE.toString());

        Actions actions = blocksWorldTilePuzzle.getActions();

        try {
            actions.moveAgent(Actions.AgentMoves.UP, BlocksWorldTilePuzzle.START_STATE.getBoard());
            print(BlocksWorldTilePuzzle.START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.RIGHT, BlocksWorldTilePuzzle.START_STATE.getBoard());
            print(start.toString());
            actions.moveAgent(Actions.AgentMoves.RIGHT, start.getBoard());
            print(start.toString());
            actions.moveAgent(Actions.AgentMoves.DOWN, start.getBoard());
            print(start.toString());

        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }


    }
}
