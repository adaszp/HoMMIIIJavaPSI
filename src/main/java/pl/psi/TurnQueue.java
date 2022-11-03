package pl.psi;

import pl.psi.creatures.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TurnQueue {
    private final Queue<Creature> queue;
    private final List<Creature> allCreatures;
    private Creature currentCreature;

    private PropertyChangeSupport support;

    public TurnQueue(Collection<Creature> aCreatures1, Collection<Creature> aCreatures2) {
        this.queue = new LinkedList<>();
        allCreatures = Stream.concat(aCreatures1.stream(), aCreatures2.stream()).sorted(Comparator.comparingInt(Creature::getSpeed)).collect(Collectors.toList());
        queue.addAll(allCreatures);
        support = new PropertyChangeSupport(this);
        next();
    }

    void next() {
        if (queue.isEmpty()) {
            endOfTurn();
        }
        currentCreature = queue.poll();
    }

    public void addObservator(PropertyChangeListener aObserver) {
        support.addPropertyChangeListener(aObserver);
    }

    private void endOfTurn() {
        support.firePropertyChange(GameEngine.END_OF_TURN, 0, 1);
    }
}
