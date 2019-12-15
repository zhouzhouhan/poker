package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeWithTwoProcessTest {

    @Test
    void should_return_true_if_is_three_with_two() throws CommonException {
        String handsString = "10H 10D 10S 9C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new ThreeWithTwoProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_three_with_two() throws CommonException {
        String handsString = "10H 10D JS 9C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new ThreeWithTwoProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_1_if_black_win_three_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S 9C 9S";
        String handsStringWhite = "8H 8D 8S 9C 9C";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeWithTwoProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_1_if_black_win_two_point_is_large() throws CommonException {
        String handsStringBlack = "10H 10D 10S 9C 9S";
        String handsStringWhite = "10H 10D 10S 8C 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeWithTwoProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_negative_1_if_black_loss_three_point_is_less() throws CommonException {
        String handsStringBlack = "10H 10D 10S 9C 9S";
        String handsStringWhite = "QH QD QS 9C JS";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeWithTwoProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }

    @Test
    void should_return_negative_number_if_black_loss_two_point_is_less() throws CommonException {
        String handsStringBlack = "JH JD JS QC QS";
        String handsStringWhite = "JH JD JS KC KS";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeWithTwoProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }


    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "JH JD JS 8C 8S";
        String handsStringWhite = "JH JD JS 8C 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new ThreeWithTwoProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }

}