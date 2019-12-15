package domain.process;

import domain.CompareSameHandsType;
import infrastructure.bean.Hands;
import domain.JudgeHandsType;
import domain.tools.Utils;
import infrastructure.CommonException;
import infrastructure.bean.Point;

import static domain.tools.Const.COMPARE_RESULT_SAME;
import static domain.tools.Utils.*;
import static domain.tools.Utils.getSingleList;

/**
 * @author hansh
 */

public class OnePairProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) throws CommonException {
        int result = compareSingList(getPointWithTheSizeOfNum(hands1, 2), getPointWithTheSizeOfNum(hands2, 2));

        return result != 0 ? result : compareSingList(getSingleList(hands1), getSingleList(hands2));
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return isOnePair(hands);
    }
}
