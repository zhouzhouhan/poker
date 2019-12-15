package application;

import infrastructure.CommonException;
import lombok.Getter;

/**
 * @author hansh
 */


public enum GameResult {
    /*
    输了
     */
    LOSS,
    /*
     赢了
     */
    WIN,
    /*
     平局，也是巧了
     */
    DRAW;


    public static GameResult getInstance(int resultValue) throws CommonException {
        if (resultValue < 0) {
            return LOSS;
        }

        if (resultValue > 0) {
            return WIN;
        }
        return DRAW;
    }
}
