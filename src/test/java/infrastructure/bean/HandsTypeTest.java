package infrastructure.bean;

import infrastructure.CommonException;
import org.junit.jupiter.api.Test;

import static infrastructure.bean.HandsType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HandsTypeTest {
    @Test
    void should_return_ROYAL_FLUSH() throws CommonException {
        String handsString = "10D AD QD JD KD";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(ROYAL_FLUSH,result);
    }

    @Test
    void should_return_FLUSH_STRAIGHT() throws CommonException {
        String handsString = "10D 6D 9D 8D 7D";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(FLUSH_STRAIGHT,result);

    }
    @Test
    void should_return_FOUR_OF_A_KIND() throws CommonException {
        String handsString = "5H 5D 5S 5C 9S";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(FOUR_OF_A_KIND,result);

    }
    @Test
    void should_return_THREE_WITH_TWO() throws CommonException {
        String handsString = "5H 5D 5S JC JS";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(THREE_WITH_TWO,result);

    }
    @Test
    void should_return_FLUSH() throws CommonException {
        String handsString = "6D 5D 3D 8D JD";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(FLUSH,result);

    }
    @Test
    void should_return_STRAIGHT() throws CommonException {
        String handsString = "6H 5D 7S 8C 4S";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(STRAIGHT,result);

    }
    @Test
    void should_return_THREE_OF_A_KIND() throws CommonException {
        String handsString = "7H 7D 7S JC 9S";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(THREE_OF_A_KIND,result);

    }
    @Test
    void should_return_TWO_PAIR() throws CommonException {
        String handsString = "7H 9D 7S JC 9S";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(TWO_PAIR,result);

    }
    @Test
    void should_return_ONE_PAIR() throws CommonException {
        String handsString = "JH 5D 7S JC 9S";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(ONE_PAIR,result);

    }
    @Test
    void should_return_SINGLE() throws CommonException {
        String handsString = "10H 5D 7S JC 9S";
        Hands hands = new Hands(handsString);

        HandsType result = HandsType.getHandsType(hands);

        assertEquals(SINGLE,result);

    }
}