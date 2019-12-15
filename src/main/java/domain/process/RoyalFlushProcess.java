package domain.process;


import domain.CompareSameHandsType;
import infrastructure.bean.Hands;
import domain.JudgeHandsType;

import static domain.tools.Utils.*;
import static infrastructure.bean.Point.A;

/**
 * 皇家同花顺
 *
 * @author hansh
 */
public class RoyalFlushProcess implements CompareSameHandsType<Hands>, JudgeHandsType {

    @Override
    public int compare(Hands hands1, Hands hands2) {
        return 0;
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return isFlush(hands) && isStraight(hands) && A.equals(getMaxPoint(hands));
    }
}
