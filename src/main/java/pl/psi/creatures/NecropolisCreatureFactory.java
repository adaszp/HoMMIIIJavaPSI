package pl.psi.creatures;

public class NecropolisCreatureFactory {
    public Creature create(int i, boolean aUpgraded) {
        if (aUpgraded)
        switch (i){
            case 1:
                return new Creature(CreatureStats.builder().build());
            case 2:
                return new Creature(CreatureStats.builder().build());
            case 3:
                return new Creature(CreatureStats.builder().build());
            case 4:
                return new Creature(CreatureStats.builder().build());
            case 5:
                return new Creature(CreatureStats.builder().build());
            default:
                throw new UnsupportedOperationException();
        }
        else{
            throw new UnsupportedOperationException();
        }
    }
}
