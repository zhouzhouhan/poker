package domain.tools;

import infrastructure.bean.Hands;
import infrastructure.bean.Point;
import infrastructure.bean.Variety;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hansh
 */
public class Utils {
    public static boolean isFlush(Hands hands) {
        Set<Variety> varietySet = new HashSet<>(hands.getVarietyList());
        return varietySet.size() == 1;
    }

    public static boolean isStraight(Hands hands) {
        List<Point> points = hands.getPointList();
        Collections.sort(points);
        for (int index = 0; index < points.size() - 1; index++) {
            if (points.get(index + 1).ordinal() != (points.get(index).ordinal() + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFourOfKind(Hands hands) {
        return comparePointNumAndSize(hands, 2, 4, 1);
    }

    public static List<Point> getSingleList(Hands hands) {
        List<Point> points = hands.getPointList();
        Map<Point, Long> groupByPoint = points.stream().collect(Collectors.groupingBy(point -> point, Collectors.counting()));

        return groupByPoint.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public static int compareSingList(List<Point> singleList1, List<Point> singleList2) {
        reverseSorted(singleList1);
        reverseSorted(singleList2);
        for (int index = 0; index < singleList1.size(); index++) {
            int compareResult = singleList1.get(index).compareTo(singleList2.get(index));
            if (compareResult != 0) {
                return compareResult;
            }
        }
        return 0;
    }

    private static void reverseSorted(List<Point> singleList1) {
        Collections.sort(singleList1);
        Collections.reverse(singleList1);
    }


    public static boolean isThreeWithTwo(Hands hands) {
        return comparePointNumAndSize(hands, 2, 2, 2);
    }

    public static boolean isTwoPair(Hands hands) {
        return comparePointNumAndSize(hands, 3, 2, 2);
    }

    public static boolean isOnePair(Hands hands) {
        return comparePointNumAndSize(hands, 4, 2, 1);
    }

    private static boolean comparePointNumAndSize(Hands hands, int pointNum, int sameSize, int sameSzeNum) {
        List<Point> points = hands.getPointList();
        Map<Point, Long> groupByPoint = points.stream().collect(Collectors.groupingBy(point -> point, Collectors.counting()));
        if (groupByPoint.size() != pointNum) {
            return false;
        }
        return groupByPoint.entrySet().stream().filter(entry -> entry.getValue() >= sameSize).count() >= sameSzeNum;
    }


    public static List<Point> getPointWithTheSizeOfNum(Hands hands1, int number) {
        Map<Point, Long> groupByPoint1 = hands1.getPointList().stream().collect(Collectors.groupingBy(point -> point, Collectors.counting()));
        return groupByPoint1.entrySet().stream().filter(entry -> entry.getValue() == number)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }


    public static boolean isThreeOfKind(Hands hands) {
        List<Point> points = hands.getPointList();
        Map<String, List<Point>> groupByPoint = points.stream().collect(Collectors.groupingBy(Point::getPointValue));
        return groupByPoint.entrySet().stream().filter(entry -> entry.getValue().size() >= 3).count() >= 1;
    }


    public static Point getMaxPoint(Hands hands) {
        List<Point> points = hands.getPointList();
        return Collections.max(points);
    }

}
