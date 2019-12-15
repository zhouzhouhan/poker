package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourOfKindProcessTest {
    @Test
    void should_return_true_if_is_four_of_kind() throws CommonException {
        String handsString = "10H 10D 10S 10C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new FourOfKindProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_four_of_kind() throws CommonException {
        String handsString = "10H 10D 10S 9C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new FourOfKindProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_1_if_black_win_four_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S 10C 9S";
        String handsStringWhite = "8H 8D 8S 8C 9C";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FourOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_1_if_black_win_single_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S 10C 9S";
        String handsStringWhite = "10H 10D 10S 10C 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FourOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_negative_1_if_black_loss_four_point_is_less() throws CommonException {
        String handsStringBlack = "10H 10D 10S 10C 9S";
        String handsStringWhite = "10H 10D 10S 10C JS";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FourOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }

    @Test
    void should_return_negative_number_if_black_loss_single_point_is_less() throws CommonException {
        String handsStringBlack = "JH JD JS JC 4C";
        String handsStringWhite = "JH JD JS JC 7S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FourOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }


    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "JH JD JS JC 8C";
        String handsStringWhite = "JH JD JS JC 8C";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new FourOfKindProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }
}