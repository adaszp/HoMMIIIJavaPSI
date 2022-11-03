package pl.psi;

public class GameEngine {
    public final static String END_OF_TURN = "END_OF_TURN";
    private final TurnQueue turnQueue;

    public GameEngine(Hero aHero1, Hero aHero2) {
        turnQueue = new TurnQueue(aHero1.getCreatures(), aHero2.getCreatures());
        aHero1.getCreatures().forEach(turnQueue::addObservator);
        aHero2.getCreatures().forEach(turnQueue::addObservator);
    }

    public void pass() {
        turnQueue.next();
    }
}
