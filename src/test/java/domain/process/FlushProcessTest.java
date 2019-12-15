package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlushProcessTest {
    @Test
    void should_return_true_if_is_flush() throws CommonException {
        String handsString = "QS 2S JS K5S AS";
        Hands hands = new Hands(handsString);

        boolean result = new FlushProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_flush() throws CommonException {
        String handsString = "3D 8S 10S QS AS";
        Hands hands = new Hands(handsString);

        boolean result = new FlushProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void royal_should_return_positive_if_black_is_win() throws CommonException {
        String handsStringBlack = "6S QS JS 10S AS";
        String handsStringWhite = "10D KD JD 7D 8D";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FlushProcess().compare(handsBlack, handsWhite);

        assertTrue(0 < result);
    }

    @Test
    void royal_should_return_negative_if_black_is_loss() throws CommonException {
        String handsStringBlack = "10S QS KS JS 8S";
        String handsStringWhite = "2D 3D 4D 5D AD";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FlushProcess().compare(handsBlack, handsWhite);

        assertTrue(0 > result);
    }


    @Test
    void royal_should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "10S QS KS JS 8S";
        String handsStringWhite = "10D KD JD QD 8D";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FlushProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }

}