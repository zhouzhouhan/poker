package infrastructure.bean;


import infrastructure.CommonException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hansh
 */

public enum Point  {
    /**
     * 2点
     */
    TWO("2"),
    /**
     * 3点
     */
    THREE("3"),
    /**
     * 4点
     */
    FOUR("4"),
    /**
     * 5点
     */
    FIVE("5"),
    /**
     * 6点
     */
    SIX("6"),
    /**
     * 7点
     */
    SEVEN("7"),
    /**
     * 8点
     */
    EIGHT("8"),
    /**
     * 9点
     */
    NINE("9"),
    /**
     * 10点
     */
    TEN("10"),
    /**
     * J
     */
    J("J"),
    /**
     * Q
     */
    Q("Q"),
    /**
     * K
     */
    K("K"),
    /**
     * A
     */
    A("A");

    @Getter
    private final String pointValue;

    Point(String value) {
        pointValue = value;
    }


    public static Point getPointInstance(String pointString) throws CommonException {
        for (Point value : values()) {
            if (value.getPointValue().equalsIgnoreCase(pointString)) {
                return value;
            }
        }
        throw new CommonException("Wrong point data.");
    }

}
