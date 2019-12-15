package domain.process;


import domain.CompareSameHandsType;
import infrastructure.bean.Hands;
import domain.JudgeHandsType;
import domain.tools.Utils;

import static domain.tools.Utils.compareSingList;

/**
 * FLUSH_STRAIGHT
 *
 * @author hansh
 */
public class FlushProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        return compareSingList(hands1.getPointList(), hands2.getPointList());
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return Utils.isFlush(hands);
    }
}
