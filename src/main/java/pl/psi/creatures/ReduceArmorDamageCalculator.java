package pl.psi.creatures;

import java.util.Random;

class ReduceArmorDamageCalculator extends AbstractDamageCalculateStrategy {

    private final double factor;

    public ReduceArmorDamageCalculator(double aFactor) {
        this(aFactor, new Random());
    }

    public ReduceArmorDamageCalculator(double aFactor, Random aRandom) {
        super(aRandom);
        factor = aFactor;
    }

    @Override
    int getArmor(Creature aDefender) {
        return (int) (super.getArmor(aDefender) * factor);
    }
}
