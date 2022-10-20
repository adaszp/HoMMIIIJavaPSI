package pl.psi.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreatureTest {

    @ParameterizedTest
    @MethodSource("properlyAttackArgs")
    void shouldAttackProperly(Creature aAttacker, Creature aDefender, int aHp) {
        //when
        aAttacker.attack(aDefender);
        //then
        assertThat(aDefender.getHp()).isEqualTo(aHp);
    }

    private static Stream<Arguments> properlyAttackArgs() {
        return Stream.of(
                Arguments.of(new Creature(CreatureStats.builder().hp(1).damage(Range.closed(10, 10)).build()),//
                        new Creature(CreatureStats.builder().hp(100).damage(Range.closed(0, 0)).build()), 90),//
                Arguments.of(new Creature(CreatureStats.builder().hp(1).attack(2).damage(Range.closed(10, 10)).build()),//
                        new Creature(CreatureStats.builder().hp(100).damage(Range.closed(0, 0)).build()), 89),//
                Arguments.of(new Creature(CreatureStats.builder().hp(1).damage(Range.closed(10, 10)).build()),//
                        new Creature(CreatureStats.builder().hp(100).armor(4).damage(Range.closed(0, 0)).build()), 91),
                Arguments.of(new Creature(CreatureStats.builder().hp(1).damage(Range.closed(0, 10)).build()),//
                        new Creature(CreatureStats.builder().hp(100).damage(Range.closed(0, 0)).build()), 90)//
        );
    }

    @Test
    void shouldRetailateProperly() {
        Random randomMock = mock(Random.class);
        when(randomMock.nextDouble()).thenReturn(0.3);
        Creature attacker = new Creature(CreatureStats.builder().hp(100).damage(Range.closed(0, 0)).build());
        Creature defender = new Creature(CreatureStats.builder().hp(100).damage(Range.closed(0, 10)).build(), randomMock);
        //when
        attacker.attack(defender);
        //then
        assertThat(attacker.getHp()).isEqualTo(90);
    }
}
