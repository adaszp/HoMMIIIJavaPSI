package pl.psi;

import lombok.Getter;
import pl.psi.creatures.Creature;

import java.util.List;

@Getter
public class Hero {

    private List<Creature> creatures;

    public Hero(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
