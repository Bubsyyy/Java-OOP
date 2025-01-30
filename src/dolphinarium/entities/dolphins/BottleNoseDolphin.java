package dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin {

    private static final int BOTTLE_NOSE_DOLPHIN_ENERGY_DECREASE = 200;

    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        decreaseEnergy(BOTTLE_NOSE_DOLPHIN_ENERGY_DECREASE);
    }
}
