package userinterface;

import application.GameResult;
import infrastructure.CommonException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerGameTest {
    @Test
    void should_compute_right_poker_hands_result() throws CommonException {
        String black = "2H 3D 5S 9C KD";
        String white = "2C 3H 4S 8C AH";

        PokerGame pokerGame = new PokerGame();
        GameResult result = pokerGame.playGame(black,white);

        assertEquals(GameResult.LOSS,result);
    }
}