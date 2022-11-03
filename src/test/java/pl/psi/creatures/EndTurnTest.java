package pl.psi.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.psi.GameEngine;
import pl.psi.Hero;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EndTurnTest {

    @Test
    void shouldNotHealCreatureAfterEndOfTurn() {
        Creature attacker = new Creature(CreatureStats.builder().damage(Range.closed(10, 10)).hp(100).build());
        Creature toTest = new Creature(CreatureStats.builder().hp(100).build());
        GameEngine gameEngine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(toTest)));

        attacker.attack(toTest);
        assertThat(toTest.getHp()).isEqualTo(90);
        gameEngine.pass();
        gameEngine.pass();

        assertThat(toTest.getHp()).isEqualTo(90);
    }

    @Test
    void shouldHealCreatureAfterEndOfTurn() {
        Creature attacker = new Creature(CreatureStats.builder().damage(Range.closed(10, 10)).hp(100).build());
        Creature toTest = new RegenerationDecorator(new Creature(CreatureStats.builder().hp(100).build()));
        GameEngine gameEngine = new GameEngine(new Hero(List.of(attacker)), new Hero(List.of(toTest)));

        attacker.attack(toTest);
        assertThat(toTest.getHp()).isEqualTo(90);
        gameEngine.pass();
        gameEngine.pass();

        assertThat(toTest.getHp()).isEqualTo(100);
    }
}