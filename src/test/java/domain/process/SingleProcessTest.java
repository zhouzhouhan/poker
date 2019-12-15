package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleProcessTest {
    @Test
    void should_return_true_if_single() throws CommonException {
        String handsString = "10H 5D 7S JC 9S";
        Hands hands = new Hands(handsString);

        boolean result = new SingleProcess().isThisHandsType(hands);

        assertTrue(result);
    }


    @Test
    void should_return_positive_if_black_is_large() throws CommonException {
        String handsStringBlack = "10H 4D KH JD 9S";
        String handsStringWhite = "10s Jc 3S 5C 9C";

        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new SingleProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_negative_if_black_is_less() throws CommonException {
        String handsStringBlack = "10H 4D 6H 7D 9S";
        String handsStringWhite = "10s Jc 3S 6C 9C";

        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new SingleProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }

    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "10H 4D KH JD 9S";
        String handsStringWhite = "10s Jc KS 4C 9C";

        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new SingleProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }

}