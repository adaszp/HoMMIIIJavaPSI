package pl.psi.creatures;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;

abstract class AbstractCreatureDecorator extends Creature {

    final Creature decorated;

    public AbstractCreatureDecorator(Creature aCreature) {
        super(null);
        decorated = aCreature;
    }

    @Override
    public CreatureStats getStats() {
        return decorated.getStats();
    }

    @Override
    void setCurrentHp(int currentHp) {
        decorated.setCurrentHp(currentHp);
    }

    @Override
    public int getCurrentHp() {
        return decorated.getCurrentHp();
    }

    @Override
    public void attack(Creature aDefender) {
        decorated.attack(aDefender);
    }

    @Override
    public int getArmor() {
        return decorated.getArmor();
    }

    @Override
    public int getHp() {
        return decorated.getHp();
    }

    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public Range<Integer> getDamage() {
        return decorated.getDamage();
    }

    @Override
    public int getSpeed() {
        return decorated.getSpeed();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        decorated.propertyChange(evt);
    }

    @Override
    void endOfTurn() {
        decorated.endOfTurn();
    }
}
