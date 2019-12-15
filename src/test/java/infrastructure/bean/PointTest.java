package infrastructure.bean;

import infrastructure.CommonException;
import org.junit.jupiter.api.Test;

import static infrastructure.bean.Point.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PointTest {
    @Test
    void should_two_return_for_string_2() throws CommonException {
        String pointString = "2";

        Point result = Point.getPointInstance(pointString);

        assertEquals(TWO, result);
    }

    @Test
    void should_three_return_for_string_3() throws CommonException {
        String pointString = "3";

        Point result = Point.getPointInstance(pointString);

        assertEquals(THREE, result);
    }

    @Test
    void should_four_return_for_string_4() throws CommonException {
        String pointString = "4";

        Point result = Point.getPointInstance(pointString);

        assertEquals(FOUR, result);
    }

    @Test
    void should_five_return_for_string_5() throws CommonException {
        String pointString = "5";

        Point result = Point.getPointInstance(pointString);

        assertEquals(FIVE, result);
    }

    @Test
    void should_six_return_for_string_6() throws CommonException {
        String pointString = "6";

        Point result = Point.getPointInstance(pointString);

        assertEquals(SIX, result);
    }

    @Test
    void should_seven_return_for_string_7() throws CommonException {
        String pointString = "7";

        Point result = Point.getPointInstance(pointString);

        assertEquals(SEVEN, result);
    }

    @Test
    void should_eight_return_for_string_8() throws CommonException {
        String pointString = "8";

        Point result = Point.getPointInstance(pointString);

        assertEquals(EIGHT, result);
    }

    @Test
    void should_nine_return_for_string_9() throws CommonException {
        String pointString = "9";

        Point result = Point.getPointInstance(pointString);

        assertEquals(NINE, result);
    }

    @Test
    void should_ten_return_for_string_10() throws CommonException {
        String pointString = "10";

        Point result = Point.getPointInstance(pointString);

        assertEquals(TEN, result);
    }

    @Test
    void should_J_return_for_string_J() throws CommonException {
        String pointString = "j";

        Point result = Point.getPointInstance(pointString);

        assertEquals(J, result);
    }

    @Test
    void should_Q_return_for_string_Q() throws CommonException {
        String pointString = "Q";

        Point result = Point.getPointInstance(pointString);

        assertEquals(Q, result);
    }

    @Test
    void should_K_return_for_string_K() throws CommonException {
        String pointString = "K";

        Point result = Point.getPointInstance(pointString);

        assertEquals(K, result);
    }


    @Test
    void should_A_return_for_string_A() throws CommonException {
        String pointString = "A";

        Point result = Point.getPointInstance(pointString);

        assertEquals(A, result);
    }

    @Test
    void should_return_exception_if_invalid_String() {
        String pointString = "B";

        try {
            Point result = Point.getPointInstance(pointString);
            fail();
        } catch (CommonException e) {
            assertEquals("Wrong point data.", e.getMessage());
        }
    }

}