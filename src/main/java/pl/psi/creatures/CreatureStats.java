package pl.psi.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatureStats {

    private int hp;
    private int attack;
    private int armor;
    private int speed;
    @Builder.Default
    private Range<Integer> damage = Range.closed(0,0);
    @Builder.Default
    private String name = "";
}
