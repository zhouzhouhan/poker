package domain;


import infrastructure.bean.Hands;

/**
 * @author hansh
 */
public interface JudgeHandsType {
    /***
     * @param hands
     * @return boolean
     */
    boolean isThisHandsType(Hands hands);
}
