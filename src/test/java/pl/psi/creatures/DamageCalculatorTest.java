package pl.psi.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DamageCalculatorTest {

    @Test
    void shouldReduceOpponentArmor() {
        ReduceArmorDamageCalculator calc = new ReduceArmorDamageCalculator(0.2);
        Creature attacker = new Creature(CreatureStats.builder().attack(2).damage(Range.closed(10, 10)).build(), calc);
        Creature defender = new Creature(CreatureStats.builder().armor(10).build(), calc);

        int dmgToDeal = calc.calculateDamage(attacker, defender);

        assertThat(dmgToDeal).isEqualTo(10);
    }
}