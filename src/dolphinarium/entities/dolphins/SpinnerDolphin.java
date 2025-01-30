package dolphinarium.entities.dolphins;

public class SpinnerDolphin extends BaseDolphin {

    private static final int SPINNER_DOLPHIN_ENERGY_DECREASE = 50;

    public SpinnerDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        decreaseEnergy(SPINNER_DOLPHIN_ENERGY_DECREASE);
    }
}
