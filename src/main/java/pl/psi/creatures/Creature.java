package pl.psi.creatures;

import com.google.common.collect.Range;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import pl.psi.GameEngine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Creature implements PropertyChangeListener {
    @Getter
    private CreatureStats stats;
    @Setter(AccessLevel.PACKAGE)
    @Getter
    private int currentHp;
    private final DamageCalculateStrategyIf damageCalculator;

    public Creature(CreatureStats aStats) {
        this(aStats, new DefaultDamageCalculator());
    }

    Creature(CreatureStats aStats, DamageCalculateStrategyIf aDamageCalc) {
        stats = aStats;
        currentHp = stats != null ? stats.getHp() : 1;
        damageCalculator = aDamageCalc;
    }

    public void attack(Creature aDefender) {
        int dmgToDeal = damageCalculator.calculateDamage(this, aDefender);
        aDefender.receiveDmg(dmgToDeal);

        aDefender.counterAttack(this);
    }

    private void receiveDmg(int dmgToDeal) {
        setCurrentHp(getCurrentHp() - dmgToDeal);
    }

    private void counterAttack(Creature aDefender) {
        int dmgToDeal = damageCalculator.calculateDamage(this, aDefender);
        aDefender.receiveDmg(dmgToDeal);
    }

    public int getArmor() {
        return stats.getArmor();
    }

    public int getHp() {
        return currentHp;
    }

    public int getAttack() {
        return stats.getAttack();
    }

    public Range<Integer> getDamage() {
        return stats.getDamage();
    }

    public int getSpeed() {
        return stats.getSpeed();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(GameEngine.END_OF_TURN)) {
            endOfTurn();
        }
    }

    void endOfTurn() {
    }
}
