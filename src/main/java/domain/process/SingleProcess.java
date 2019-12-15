package domain.process;

import domain.CompareSameHandsType;
import domain.JudgeHandsType;
import infrastructure.bean.Hands;

import static domain.tools.Utils.compareSingList;


/**
 * @author hansh
 */
public class SingleProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) {
        return compareSingList(hands1.getPointList(), hands2.getPointList());
    }

    @Override
    public boolean isThisHandsType(Hands hands) {
        return true;
    }
}
