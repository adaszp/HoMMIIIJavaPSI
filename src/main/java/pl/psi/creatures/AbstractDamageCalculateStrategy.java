package pl.psi.creatures;

import java.util.Random;

class AbstractDamageCalculateStrategy implements DamageCalculateStrategyIf {

    private final Random rand;
    public AbstractDamageCalculateStrategy(Random aRandom) {
        rand = aRandom;
    }

    public int calculateDamage(Creature aAttacker, Creature aDefender) {
        double randValue = rand.nextDouble();
        double dmg = randValue * (aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint()) + aAttacker.getDamage().lowerEndpoint();

        double factor = 1;
        if (aAttacker.getAttack() > getArmor(aDefender)) {
            factor = 1 + (aAttacker.getAttack() - getArmor(aDefender)) * 0.05;
        } else if (getArmor(aDefender) > aAttacker.getAttack()) {
            factor = 1 - (getArmor(aDefender) - aAttacker.getAttack()) * 0.025;
        }

        return (int) (factor * dmg);
    }

    int getArmor(Creature aDefender) {
        return aDefender.getArmor();
    }
}
