package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlushStraightProcessTest {
    @Test
    void should_return_true_if_is_flush_straight() throws CommonException {
        String handsString = "QS 10S JS KS 9S";
        Hands hands = new Hands(handsString);

        boolean result = new FlushStraightProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_flush_straight() throws CommonException {
        String handsString = "10D JS KS QS 9S";
        Hands hands = new Hands(handsString);

        boolean result = new FlushStraightProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_1_if_black_win() throws CommonException {
        String handsStringBlack = "10S QS KS JS AS";
        String handsStringWhite = "10D KD JD QD 9D";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FlushStraightProcess().compare(handsBlack, handsWhite);

        assertEquals(1, result);
    }

    @Test
    void should_return_negative_1_if_black_loss() throws CommonException {
        String handsStringBlack = "10S QS KS JS 9S";
        String handsStringWhite = "10D KD JD QD AD";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FlushStraightProcess().compare(handsBlack, handsWhite);

        assertEquals(-1, result);
    }

    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "10S QS KS JS AS";
        String handsStringWhite = "10D KD JD QD AD";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FlushStraightProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }
}