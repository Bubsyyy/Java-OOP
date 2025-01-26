package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int exploredStates=0;

    public ControllerImpl(){
        this.explorerRepository=new ExplorerRepository();
        this.stateRepository=new StateRepository();
    }
    @Override
    public String addExplorer(String type, String explorerName) {

        switch (type){
            case "AnimalExplorer":
                this.explorerRepository.add(new AnimalExplorer(explorerName));
                break;
            case "GlacierExplorer":
                this.explorerRepository.add(new GlacierExplorer(explorerName));
                break;
            case "NaturalExplorer":
                this.explorerRepository.add(new NaturalExplorer(explorerName));
                break;
            default: throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state=new StateImpl(stateName);
        Collection<String> Exhibits=state.getExhibits();
        Collections.addAll(Exhibits,exhibits);
        this.stateRepository.add(state);
        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer=this.explorerRepository.byName(explorerName);
        if(explorer==null)
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));

        this.explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        Collection<Explorer> explorers=new ArrayList<>();
        explorerRepository
                .getCollection()
                .stream()
                .filter(e->e.getEnergy()>50)
                .forEach(explorers::add);
        if(explorers.isEmpty())
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);

        State ExploredState=this.stateRepository.byName(stateName);
        Mission mission=new MissionImpl();
        mission.explore(ExploredState,explorers);
        int retired= (int) explorers.stream().filter(e->e.getEnergy()==0).count();
        exploredStates++;
        return String.format(STATE_EXPLORER,stateName,retired);
    }

    @Override
    public String finalResult() {
        StringBuilder result=new StringBuilder();
        result.append(String.format(FINAL_STATE_EXPLORED,this.exploredStates));
        result.append(System.lineSeparator());
        result.append(FINAL_EXPLORER_INFO);
        for (Explorer explorer: this.explorerRepository.getCollection()){
            result.append((System.lineSeparator()));
            result.append(String.format(FINAL_EXPLORER_NAME,explorer.getName()));
            result.append((System.lineSeparator()));
            result.append(String.format(FINAL_EXPLORER_ENERGY,explorer.getEnergy()));
            result.append((System.lineSeparator()));
            if(explorer.getSuitcase().getExhibits().isEmpty()){
                result.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,"None"));
            }else
                result.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,explorer.getSuitcase().getExhibits())));
        }
        return result.toString().trim();
    }
}
