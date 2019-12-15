package domain.process;

import domain.CompareSameHandsType;
import infrastructure.bean.Hands;
import domain.JudgeHandsType;

import static domain.tools.Utils.getMaxPoint;
import static domain.tools.Utils.isStraight;


/**
 * @author hansh
 */
public class StraightProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        return getMaxPoint(hands1).compareTo(getMaxPoint(hands2));
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return isStraight(hands);
    }
}
