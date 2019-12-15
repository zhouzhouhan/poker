package domain.process;


import domain.CompareSameHandsType;
import domain.JudgeHandsType;
import infrastructure.CommonException;
import infrastructure.bean.Hands;
import lombok.extern.slf4j.Slf4j;

import static domain.tools.Utils.*;

/**
 * 多付排一起玩时，可能会出现四条平局的牌型
 *
 * @author hansh
 */
@Slf4j
public class FourOfKindProcess implements CompareSameHandsType<Hands>, JudgeHandsType {
    @Override
    public int compare(Hands hands1, Hands hands2) throws CommonException {
        int result = compareSingList(getPointWithTheSizeOfNum(hands1, 4), getPointWithTheSizeOfNum(hands2, 4));
        return result != 0 ? result : compareSingList(getSingleList(hands1), getSingleList(hands2));
    }


    @Override
    public boolean isThisHandsType(Hands hands) {
        return isFourOfKind(hands);
    }
}
