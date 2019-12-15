package domain.process;


import domain.CompareSameHandsType;
import domain.JudgeHandsType;
import infrastructure.bean.Hands;

import static domain.tools.Utils.*;

/**
 * 多付牌时可能会出现三条相等的情况，所以包含处理
 *
 * @author hansh
 */
public class ThreeWithTwoProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        int result = compareSingList(getPointWithTheSizeOfNum(hands1, 3), getPointWithTheSizeOfNum(hands2, 3));

        return result != 0 ? result : compareSingList(getPointWithTheSizeOfNum(hands1, 2), getPointWithTheSizeOfNum(hands2, 2));
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return isThreeWithTwo(hands);
    }


}
