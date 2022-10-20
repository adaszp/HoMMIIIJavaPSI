import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Segment {
    private Point p1;
    private Point p2;

    public Point getP2() {
        return new Point(p2);
    }
}
