package pl.psi.creatures;

import com.google.common.collect.Range;

import java.util.Random;

public class Creature {
    private CreatureStats stats;
    private int currentHp;
    private final Random rand;

    public Creature(CreatureStats aStats) {
        this(aStats, new Random());
    }

    Creature(CreatureStats aStats, Random aRand) {
        stats = aStats;
        currentHp = stats.getHp();
        rand = aRand;
    }

    public void attack(Creature aDefender) {
        int dmgToDeal = calculateDamage(aDefender);
        aDefender.receiveDmg(dmgToDeal);

        aDefender.counterAttack(this);
    }

    private void receiveDmg(int dmgToDeal) {
        currentHp = currentHp - dmgToDeal;
    }

    private void counterAttack(Creature aDefender) {
        int dmgToDeal = calculateDamage(aDefender);
        aDefender.receiveDmg(dmgToDeal);
    }

    private int calculateDamage(Creature defender) {
        double randValue = rand.nextDouble();
        double dmg = randValue * (getDamage().upperEndpoint() - getDamage().lowerEndpoint()) + getDamage().lowerEndpoint();

        double factor = 1;
        if (getAttack() > defender.getArmor()) {
            factor = 1 + (getAttack() - defender.getArmor()) * 0.05;
        } else if (defender.getArmor() > getAttack()) {
            factor = 1 - (defender.getArmor() - getAttack()) * 0.025;
        }

        return (int) (factor * dmg);
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
}
