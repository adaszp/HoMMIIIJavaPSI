package pl.psi.packageshow;

import org.junit.jupiter.api.Test;
import pl.psi.GameEngine;
import pl.psi.creatures.Creature;
import pl.psi.Hero;
import pl.psi.creatures.NecropolisCreatureFactory;

import java.util.ArrayList;
import java.util.List;

public class Start {

    @Test
    void start(){
        List<Creature> creatureList = new ArrayList<>();
        Hero hero1 = new Hero(getCreatures(true));
        Hero hero2 = new Hero(getCreatures(false));
        new GameEngine(hero1, hero2);
    }

    List<Creature> getCreatures(boolean aUpgraded) {
        NecropolisCreatureFactory creatureFactory = new NecropolisCreatureFactory();
        List<Creature> creatureList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            creatureList.add(creatureFactory.create(i, aUpgraded));
        }
        return creatureList;
    }
}
