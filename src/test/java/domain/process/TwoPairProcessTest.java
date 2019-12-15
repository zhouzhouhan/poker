package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairProcessTest {
    @Test
    void should_return_true_if_is_two_pair() throws CommonException {
        String handsString = "10H 10D JS JC 9S";
        Hands hands = new Hands(handsString);

        boolean result = new TwoPairProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_two_pair() throws CommonException {
        String handsString = "10H 10D JS 6C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new TwoPairProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_1_if_black_win_two_pair_1_large() throws CommonException {
        String handsStringBlack = "10H 10D KH KD 9S";
        String handsStringWhite = "10s 10c QS QC 9C";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }

    @Test
    void should_return_1_if_black_win_two_pair_2_large() throws CommonException {
        String handsStringBlack = "10s 10c KS QC 9C";
        String handsStringWhite = "10H 10D 8H 8KD 9S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }


    @Test
    void should_return_negative_1_if_black_loss_two_pair_1_less() throws CommonException {
        String handsStringBlack = "10H 10D JH JD 9S";
        String handsStringWhite = "10s 10c QS QC 9C";

        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }

    @Test
    void should_return_negative_1_if_black_loss_two_pair_2_less() throws CommonException {
        String handsStringBlack = "10H 10D 8S 8C 9H";
        String handsStringWhite = "10H 10D 9S 9C JS";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }

    @Test
    void should_return_positive_number_if_black_loss_single_point_is_large() throws CommonException {
        String handsStringBlack = "JH JD 7S 7C 9C";
        String handsStringWhite = "JS JC 7H 7D 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }


    @Test
    void should_return_negative_number_if_black_loss_single_point_is_less() throws CommonException {
        String handsStringBlack = "JH JD 7S 7C 8C";
        String handsStringWhite = "JH JD 7H 7D 10S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }


    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "JH JD 6S 6C 8C";
        String handsStringWhite = "JS JC 6D 6H 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new TwoPairProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }
}