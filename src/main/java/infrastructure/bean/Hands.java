package infrastructure.bean;

import infrastructure.CommonException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hansh
 */
public class Hands {
    @Getter
    List<Point> pointList = new ArrayList<>();
    @Getter
    List<Variety> varietyList = new ArrayList<>();

    public Hands(String handsPokerString) throws CommonException {
        Pattern numberPattern = Pattern.compile("[0-9]{1,2}");
        Matcher numberMatcher = numberPattern.matcher(handsPokerString);
        while (numberMatcher.find()) {
            pointList.add(Point.getPointInstance(numberMatcher.group()));
        }
        Pattern stringPattern = Pattern.compile("[a-zA-Z]");
        Matcher stringMatcher = stringPattern.matcher(handsPokerString);
        while (stringMatcher.find()) {
            String stringValue = stringMatcher.group();
            if (Variety.isVarietyValue(stringValue)) {
                varietyList.add(Variety.getVarietyInstance(stringValue));
                continue;
            }
            pointList.add(Point.getPointInstance(stringValue));
        }
    }
}
