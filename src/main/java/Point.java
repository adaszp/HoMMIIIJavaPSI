import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
class Point {
    private int x;
    private int y;

    public Point(Point s1p2) {
        x = s1p2.getX();
        y = s1p2.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
}