package domain.process;

import domain.CompareSameHandsType;
import infrastructure.bean.Hands;
import domain.JudgeHandsType;

import static domain.tools.Utils.*;


/**
 * @author hansh
 */
public class FlushStraightProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        return getMaxPoint(hands1).compareTo(getMaxPoint(hands2));
    }


    @Override
    public boolean isThisHandsType(Hands hands) {
        return isFlush(hands) && isStraight(hands);
    }
}
