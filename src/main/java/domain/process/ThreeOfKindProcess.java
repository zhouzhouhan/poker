package domain.process;


import domain.CompareSameHandsType;
import domain.JudgeHandsType;
import infrastructure.bean.Hands;

import static domain.tools.Utils.*;

/**
 * @author hansh
 */
public class ThreeOfKindProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        int result = compareSingList(getPointWithTheSizeOfNum(hands1, 3), getPointWithTheSizeOfNum(hands2, 3));
        return result != 0 ? result : compareSingList(getSingleList(hands1), getSingleList(hands2));
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return isThreeOfKind(hands);
    }
}
