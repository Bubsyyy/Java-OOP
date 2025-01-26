package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ExceptionMessages.*;

public abstract class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy){
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    //Tell us if the energy more than zero.
    @Override
    public boolean canSearch() {
        if (this.energy > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        //TODO
        //•	The method decreases the explorer's energy by 15 units.
        //•	The energy value should not drop below zero.
        //•	Set the value to be zero, if the energy value goes below zero.
        double newEnergy = this.energy - 15;
        if (newEnergy < 0){
            this.setEnergy(0);
        } else {
            this.setEnergy(newEnergy);
        }

    }
}
