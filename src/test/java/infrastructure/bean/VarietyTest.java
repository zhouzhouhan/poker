package infrastructure.bean;

import infrastructure.CommonException;
import org.junit.jupiter.api.Test;

import static infrastructure.bean.Variety.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class VarietyTest {
    @Test
    void should_two_return_for_string_H() throws CommonException {
        String pointString = "h";

        Variety result = Variety.getVarietyInstance(pointString);

        assertEquals(HEART, result);
    }

    @Test
    void should_three_return_for_string_D() throws CommonException {
        String pointString = "d";

        Variety result = Variety.getVarietyInstance(pointString);

        assertEquals(DIAMONDS, result);
    }

    @Test
    void should_four_return_for_string_S() throws CommonException {
        String pointString = "s";

        Variety result = Variety.getVarietyInstance(pointString);

        assertEquals(SPADE, result);
    }

    @Test
    void should_five_return_for_string_C() throws CommonException {
        String pointString = "c";

        Variety result = Variety.getVarietyInstance(pointString);

        assertEquals(CLUB, result);
    }


    @Test
    void should_return_exception_if_invalid_String() {
        String pointString = "M";

        try {
            Variety.getVarietyInstance(pointString);
            fail();
        } catch (CommonException e) {
            assertEquals("Wrong variety type.", e.getMessage());
        }
    }
}