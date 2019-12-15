package domain.process;

import domain.CompareSameHandsType;
import infrastructure.bean.Hands;
import domain.JudgeHandsType;

import static domain.tools.Utils.*;

/**
 * @author hansh
 */
public class TwoPairProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        int result = compareSingList(getPointWithTheSizeOfNum(hands1, 2), getPointWithTheSizeOfNum(hands2, 2));

        return result != 0 ? result : compareSingList(getSingleList(hands1), getSingleList(hands2));
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return isTwoPair(hands);
    }
}
