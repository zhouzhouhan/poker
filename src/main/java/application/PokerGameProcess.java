package application;

import infrastructure.CommonException;
import infrastructure.bean.Hands;

import static infrastructure.bean.HandsType.getHandsType;

/**
 * @author hansh
 */
public class PokerGameProcess {
    private String black = "";
    private String white = "";

    public PokerGameProcess(String black, String white) {
        this.black = black;
        this.white = white;
    }

    public GameResult process() throws CommonException {
        Hands handsBlack = new Hands(black);
        Hands handsWhite = new Hands(white);
        int result = getHandsType(handsWhite).compareTo(getHandsType(handsBlack));
        return GameResult.getInstance(result != 0 ? result : getHandsType(handsBlack).compare(handsBlack, handsWhite));
    }
}
