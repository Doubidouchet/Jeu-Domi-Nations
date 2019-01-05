package jeu;

import java.util.Collections;
import java.util.List;

public class Points {
    public static void CountPoints(List<Tuile> tuiles) {
        Collections.sort(tuiles,
                (o1, o2) -> o1.getType1() == o2.getType1() ? 1 : -1);
        Collections.sort(tuiles,
                (o1, o2) -> o1.getType2() == o2.getType2() ? 1 : -1);
        Collections.sort(tuiles,
                (o1,o2) -> o1.getNbCouronne1() > o2.getNbCouronne1() ? 1 : -1);
        Collections.sort(tuiles,
                (o1,o2) -> o1.getNbCouronne2() > o2.getNbCouronne2() ? 1 : -1);

    }

}
