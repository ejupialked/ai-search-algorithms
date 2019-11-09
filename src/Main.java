import Exceptions.IllegalMoveException;
import Game.Actions;
import Game.BlocksWorldTilePuzzle;

import static Game.BlocksWorldTilePuzzle.START_STATE;
import static Utils.Utils.print;

public class Main {


    public static void main(String[] args) {
        BlocksWorldTilePuzzle blocksWorldTilePuzzle = new BlocksWorldTilePuzzle();


        print(START_STATE.toString());

        Actions actions = blocksWorldTilePuzzle.getActions();

        try {
            actions.moveAgent(Actions.AgentMoves.UP, START_STATE.getBoard());
            print(START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.RIGHT, START_STATE.getBoard());
            print(START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.RIGHT, START_STATE.getBoard());
            print(START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.DOWN, START_STATE.getBoard());
            print(START_STATE.toString());

        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }


    }
}
