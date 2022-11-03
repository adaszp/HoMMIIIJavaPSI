package pl.psi.creatures;

import java.util.Random;

class DefaultDamageCalculator extends AbstractDamageCalculateStrategy {

    public DefaultDamageCalculator() {
        this(new Random());
    }

    public DefaultDamageCalculator(Random aRandom) {
        super(aRandom);
    }
}
