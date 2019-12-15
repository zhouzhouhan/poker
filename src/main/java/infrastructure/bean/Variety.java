package infrastructure.bean;

import infrastructure.CommonException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hansh
 */

public enum Variety {
    /**
     * 红心
     */
    HEART("H"),
    /**
     * 方片
     */
    DIAMONDS("D"),
    /**
     * 黑桃
     */
    SPADE("S"),
    /**
     * 梅花
     */
    CLUB("C");

    @Getter
    private final String variety;

    Variety(String variety) {
        this.variety = variety;
    }

    public static boolean isVarietyValue(String pointString) {
        List<String> pointValues = Arrays.stream(values()).map(Variety::getVariety).collect(Collectors.toList());
        return pointValues.contains(pointString.toUpperCase());
    }

    public static Variety getVarietyInstance(String pointString) throws CommonException {
        for (Variety value : values()) {
            if (value.getVariety().equalsIgnoreCase(pointString)) {
                return value;
            }
        }
        throw new CommonException("Wrong variety type.");
    }

}
