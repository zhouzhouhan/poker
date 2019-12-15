package userinterface;

import application.GameResult;
import application.PokerGameProcess;
import infrastructure.CommonException;

/**
 * @author hansh
 */
public class PokerGame {
    public GameResult playGame(String black, String white) throws CommonException {
        return new PokerGameProcess(black, white).process();
    }
}
