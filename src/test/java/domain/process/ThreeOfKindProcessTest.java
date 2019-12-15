package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeOfKindProcessTest {
    @Test
    void should_return_true_if_is_three_of_kind() throws CommonException {
        String handsString = "10H 10D 10S JC 9S";
        Hands hands = new Hands(handsString);

        boolean result = new ThreeOfKindProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_three_of_kind() throws CommonException {
        String handsString = "10H 10D JS 9C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new ThreeOfKindProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_1_if_black_win_three_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S KC 9S";
        String handsStringWhite = "8H 8D 8S 7C 9C";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_1_if_black_win_single_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S 7C 9S";
        String handsStringWhite = "10H 10D 10S 7C 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_positive_1_if_black_loss_three_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S 6C QS";
        String handsStringWhite = "10H 10D 10S 9C JS";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_negative_number_if_black_loss_single_point_is_less() throws CommonException {
        String handsStringBlack = "JH JD JS 8C 4C";
        String handsStringWhite = "JH JD JS 10C 7S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeOfKindProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }


    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "JH JD JS 10C 8C";
        String handsStringWhite = "JH JD JS 10H 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeOfKindProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }
}