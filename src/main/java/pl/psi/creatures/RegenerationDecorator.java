package pl.psi.creatures;

import pl.psi.GameEngine;

import java.beans.PropertyChangeEvent;

class RegenerationDecorator extends AbstractCreatureDecorator {
    public RegenerationDecorator(Creature aCreature) {
        super(aCreature);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(GameEngine.END_OF_TURN)) {
            endOfTurn();
        }
    }

    @Override
    void endOfTurn() {
        decorated.setCurrentHp(decorated.getStats().getHp());
    }
}
