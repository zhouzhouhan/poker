package infrastructure.bean;

import com.google.common.collect.Lists;
import domain.CompareSameHandsType;
import domain.JudgeHandsType;
import domain.process.*;
import infrastructure.CommonException;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author hansh
 */

public enum HandsType implements JudgeHandsType, CompareSameHandsType<Hands> {
    /**
     * 皇家同花顺
     */
    ROYAL_FLUSH {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new RoyalFlushProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new RoyalFlushProcess().isThisHandsType(hands);
        }
    },
    /**
     * 同花顺
     */
    FLUSH_STRAIGHT {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new FlushStraightProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new FlushStraightProcess().isThisHandsType(hands);
        }
    },
    /**
     * 四条
     */
    FOUR_OF_A_KIND {
        @Override
        public int compare(Hands hands1, Hands hands2) throws CommonException {
            return new FourOfKindProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new FourOfKindProcess().isThisHandsType(hands);
        }
    },
    /**
     * 三带二
     */
    THREE_WITH_TWO {
        @Override
        public int compare(Hands hands1, Hands hands2) throws CommonException {
            return new ThreeWithTwoProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new ThreeWithTwoProcess().isThisHandsType(hands);
        }
    },
    /**
     * 同花
     */
    FLUSH {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new FlushProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new FlushProcess().isThisHandsType(hands);
        }
    },
    /**
     * 顺子
     */
    STRAIGHT {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new StraightProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new StraightProcess().isThisHandsType(hands);
        }
    },
    /**
     * 三条
     */
    THREE_OF_A_KIND {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new ThreeOfKindProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new ThreeOfKindProcess().isThisHandsType(hands);
        }
    },
    /**
     * 两对
     */
    TWO_PAIR {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new TwoPairProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new TwoPairProcess().isThisHandsType(hands);
        }
    },
    /**
     * 一对
     */
    ONE_PAIR {
        @Override
        public int compare(Hands hands1, Hands hands2) throws CommonException {
            return new OnePairProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new OnePairProcess().isThisHandsType(hands);
        }
    },
    /**
     * 单牌
     */
    SINGLE {
        @Override
        public int compare(Hands hands1, Hands hands2) {
            return new SingleProcess().compare(hands1, hands2);
        }

        @Override
        public boolean isThisHandsType(Hands hands) {
            return new SingleProcess().isThisHandsType(hands);
        }
    };


    public static HandsType getHandsType(Hands hands) throws CommonException {
        ArrayList<HandsType> types = Lists.newArrayList(values());
        types.sort(Comparator.comparingInt(Enum::ordinal));
        for (HandsType type : types) {
            if (type.isThisHandsType(hands)) {
                return type;
            }
        }
        throw new CommonException("hands type exception.");
    }

}
