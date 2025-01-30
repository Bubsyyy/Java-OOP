package dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin {

    private static final int SPOTTED_DOLPHIN_ENERGY_DECREASE = 100;

    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        decreaseEnergy(SPOTTED_DOLPHIN_ENERGY_DECREASE);
    }
}
