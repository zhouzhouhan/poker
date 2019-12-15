package domain.process;

import infrastructure.CommonException;
import infrastructure.bean.Hands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnePairProcessTest {
    @Test
    void should_return_true_if_is_one_pair() throws CommonException {
        String handsString = "10H 10D QS JC 9S";
        Hands hands = new Hands(handsString);

        boolean result = new OnePairProcess().isThisHandsType(hands);

        assertTrue(result);
    }

    @Test
    void should_return_false_if_is_not_one_pair() throws CommonException {
        String handsString = "10H QD JS 6C 9S";
        Hands hands = new Hands(handsString);

        boolean result = new OnePairProcess().isThisHandsType(hands);

        assertFalse(result);
    }

    @Test
    void should_return_positive_if_black_win_one_pair_large() throws CommonException {
        String handsStringBlack = "10H 10D QH KD 9S";
        String handsStringWhite = "10s 9D JS QC 9C";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new OnePairProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }




    @Test
    void should_return_negative_if_black_loss_one_pair_less() throws CommonException {
        String handsStringBlack = "10H 10D KH JD 9S";
        String handsStringWhite = "Ks Kc 5S QC 9C";

        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new OnePairProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }


    @Test
    void should_return_positive_number_if_black_loss_single_point_is_large() throws CommonException {
        String handsStringBlack = "JH JD 8S 7C 9C";
        String handsStringWhite = "JS JC 6H 7D 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new OnePairProcess().compare(handsBlack, handsWhite);

        assertTrue(result > 0);
    }


    @Test
    void should_return_negative_number_if_black_loss_single_point_is_less() throws CommonException {
        String handsStringBlack = "JH JD 5S 7C 8C";
        String handsStringWhite = "JH JD 5H 7D 10S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new OnePairProcess().compare(handsBlack, handsWhite);

        assertTrue(result < 0);
    }


    @Test
    void should_return_0_if_draw() throws CommonException {
        String handsStringBlack = "JH JD 6S 7C 8C";
        String handsStringWhite = "JS JC 6D 7H 8S";
        Hands handsBlack = new Hands(handsStringBlack);
        Hands handsWhite = new Hands(handsStringWhite);

        int result = new OnePairProcess().compare(handsBlack, handsWhite);

        assertEquals(0, result);
    }
}