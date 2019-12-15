package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoyalFlushProcessTest {
    @Test
    void should_return_true_if_is_royal_flush() throws CommonException {
        String handsString = "QS 10S JS KS AS";
        Hands hands = new Hands(handsString);

        boolean result = new RoyalFlushProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_royal_flush() throws CommonException {
        String handsString = "10D JS KS QS AS";
        Hands hands = new Hands(handsString);

        boolean result = new RoyalFlushProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void royal_should_be_draw() throws CommonException {
        String handsStringBlack = "10S QS KS JS AS";
        String handsStringWhite = "10D KD JD QD AD";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new RoyalFlushProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }

}