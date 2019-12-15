package application;

import infrastructure.CommonException;
import org.junit.jupiter.api.Test;

import static application.GameResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerGameProcessTest {
    String ROYAL_FLUSH = "10D QD KD AD JD";
    String FLUSH_STRAIGHT = "2H 3H 5H 6H 4H";
    String FOUR_OF_A_KIND = "3H 3D 3S 3C KD";
    String THREE_WITH_TWO = "2H 2D 2S 3C 3D";
    String FLUSH = "7D 3D 5D 6D AD";

    String STRAIGHT = "7H 3D 5S 6C 4D";
    String THREE_OF_A_KIND = "3H 3D 3S 9C KD";
    String TWO_PAIR = "2H 3D 2S 3C AD";
    String ONE_PAIR = "5H 3D 5S 6C KD";
    String SINGLE = "2H 3D 5S 9C KD";

    @Test
    void ROYAL_FLUSH_hand_type_test() throws CommonException {
        assertEquals(DRAW, new PokerGameProcess(ROYAL_FLUSH, ROYAL_FLUSH).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, FLUSH_STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, FOUR_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, THREE_WITH_TWO).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, FLUSH).process());

        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(ROYAL_FLUSH, SINGLE).process());
    }

    @Test
    void FLUSH_STRAIGHT_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(FLUSH_STRAIGHT, ROYAL_FLUSH).process());
        assertEquals(DRAW, new PokerGameProcess(FLUSH_STRAIGHT, FLUSH_STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, FOUR_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, THREE_WITH_TWO).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, FLUSH).process());

        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH_STRAIGHT, SINGLE).process());
    }

    @Test
    void FOUR_OF_A_KIND_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(FOUR_OF_A_KIND, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(FOUR_OF_A_KIND, FLUSH_STRAIGHT).process());
        assertEquals(DRAW, new PokerGameProcess(FOUR_OF_A_KIND, FOUR_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, THREE_WITH_TWO).process());
        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, FLUSH).process());

        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(FOUR_OF_A_KIND, SINGLE).process());
    }

    @Test
    void THREE_WITH_TWO_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(THREE_WITH_TWO, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(THREE_WITH_TWO, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(THREE_WITH_TWO, FOUR_OF_A_KIND).process());
        assertEquals(DRAW, new PokerGameProcess(THREE_WITH_TWO, THREE_WITH_TWO).process());
        assertEquals(WIN, new PokerGameProcess(THREE_WITH_TWO, FLUSH).process());

        assertEquals(WIN, new PokerGameProcess(THREE_WITH_TWO, STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(THREE_WITH_TWO, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(THREE_WITH_TWO, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(THREE_WITH_TWO, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(THREE_WITH_TWO, SINGLE).process());
    }

    @Test
    void FLUSH_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(FLUSH, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(FLUSH, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(FLUSH, FOUR_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(FLUSH, THREE_WITH_TWO).process());
        assertEquals(DRAW, new PokerGameProcess(FLUSH, FLUSH).process());

        assertEquals(WIN, new PokerGameProcess(FLUSH, STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(FLUSH, SINGLE).process());
    }

    @Test
    void STRAIGHT_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(STRAIGHT, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(STRAIGHT, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(STRAIGHT, FOUR_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(STRAIGHT, THREE_WITH_TWO).process());
        assertEquals(LOSS, new PokerGameProcess(STRAIGHT, FLUSH).process());

        assertEquals(DRAW, new PokerGameProcess(STRAIGHT, STRAIGHT).process());
        assertEquals(WIN, new PokerGameProcess(STRAIGHT, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(STRAIGHT, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(STRAIGHT, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(STRAIGHT, SINGLE).process());
    }

    @Test
    void THREE_OF_A_KIND_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(THREE_OF_A_KIND, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(THREE_OF_A_KIND, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(THREE_OF_A_KIND, FOUR_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(THREE_OF_A_KIND, THREE_WITH_TWO).process());
        assertEquals(LOSS, new PokerGameProcess(THREE_OF_A_KIND, FLUSH).process());

        assertEquals(LOSS, new PokerGameProcess(THREE_OF_A_KIND, STRAIGHT).process());
        assertEquals(DRAW, new PokerGameProcess(THREE_OF_A_KIND, THREE_OF_A_KIND).process());
        assertEquals(WIN, new PokerGameProcess(THREE_OF_A_KIND, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(THREE_OF_A_KIND, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(THREE_OF_A_KIND, SINGLE).process());
    }

    @Test
    void TWO_PAIR_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, FOUR_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, THREE_WITH_TWO).process());
        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, FLUSH).process());

        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(TWO_PAIR, THREE_OF_A_KIND).process());
        assertEquals(DRAW, new PokerGameProcess(TWO_PAIR, TWO_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(TWO_PAIR, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(TWO_PAIR, SINGLE).process());
    }

    @Test
    void ONE_PAIR_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, FOUR_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, THREE_WITH_TWO).process());
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, FLUSH).process());

        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, THREE_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(ONE_PAIR, TWO_PAIR).process());
        assertEquals(DRAW, new PokerGameProcess(ONE_PAIR, ONE_PAIR).process());
        assertEquals(WIN, new PokerGameProcess(ONE_PAIR, SINGLE).process());
    }

    @Test
    void SINGLE_hand_type_test() throws CommonException {
        assertEquals(LOSS, new PokerGameProcess(SINGLE, ROYAL_FLUSH).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, FLUSH_STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, FOUR_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, THREE_WITH_TWO).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, FLUSH).process());

        assertEquals(LOSS, new PokerGameProcess(SINGLE, STRAIGHT).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, THREE_OF_A_KIND).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, TWO_PAIR).process());
        assertEquals(LOSS, new PokerGameProcess(SINGLE, ONE_PAIR).process());
        assertEquals(DRAW, new PokerGameProcess(SINGLE, SINGLE).process());
    }

}