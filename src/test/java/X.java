import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class X {

    @Test
    void objectVSprimitive() {
        assertThat(1 == 1).isTrue();
        assertThat(1).isEqualTo(1);

        assertThat(new Integer(1) == new Integer(1)).isFalse();
        assertThat(new Integer(1)).isEqualTo(new Integer(1));
    }

    @Test
    void point(){
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point copyPoint1 = point1;

        assertThat(point1).isEqualTo(point2);
        assertThat(copyPoint1).isEqualTo(point2);
        assertThat(copyPoint1).isEqualTo(point1);

        Set<Point> magic = new HashSet<>();

        magic.add(point1);
        assertThat(magic).size().isEqualTo(1);

        point1.setX(5);
        assertThat(point1).isNotEqualTo(point2);
        assertThat(copyPoint1).isNotEqualTo(point2);
        assertThat(copyPoint1).isEqualTo(point1);

        magic.add(point1);
        assertThat(magic).size().isEqualTo(1);
    }

    @Test
    void segment(){
        Point s1p1 = new Point(0,0);
        Point s1p2 = new Point(5,0);
        Segment s1 = new Segment(s1p1, s1p2);

        Point s2p1 = new Point(0,0);
        Point s2p2 = new Point(s1p2);
        Segment s2 = new Segment(s2p1, s2p2);

        assertThat(s1).isEqualTo(s2);

        s1.getP1().setY(2);
        assertThat(s1).isNotEqualTo(s2);

        s2.getP1().setY(2);
        assertThat(s1).isEqualTo(s2);

        s2.getP2().setY(4);
        assertThat(s1).isNotEqualTo(s2);
    }
}
