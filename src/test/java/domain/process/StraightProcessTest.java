package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightProcessTest {
    @Test
    void should_return_true_if_is_straight() throws CommonException {
        String handsString = "QS 10D JH 8C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new StraightProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_straight() throws CommonException {
        String handsString = "10D JS 7S QS 9S";
        Hands hands = new Hands(handsString);

        boolean result = new StraightProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_positive_if_black_win() throws CommonException {
        String handsStringBlack = "10S QH KS JC AS";
        String handsStringWhite = "10D KD JC QD 9D";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new StraightProcess().compare(handsBlack, handsWhite);

        assertTrue(0 < result);
    }

    @Test
    void should_return_negative_if_black_loss() throws CommonException {
        String handsStringBlack = "10S QH KS JC 9S";
        String handsStringWhite = "10D KD JD QC AD";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new StraightProcess().compare(handsBlack, handsWhite);

        assertTrue(0 > result);
    }

    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "10S QS KS JS 9S";
        String handsStringWhite = "10K KD JS Qc 9D";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new StraightProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }
}