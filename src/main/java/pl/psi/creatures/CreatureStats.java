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
    private Range<Integer> damage;
}
