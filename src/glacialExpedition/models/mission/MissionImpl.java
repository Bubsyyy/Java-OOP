package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;

public class MissionImpl implements Mission {


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayList<String> stateExhibits = (ArrayList<String>) state.getExhibits();
        for (Explorer explorer :
                explorers) {
            while (explorer.canSearch() && !stateExhibits.isEmpty()) {
                String exhibit = stateExhibits.iterator().next();
                explorer.getSuitcase().getExhibits().add(exhibit);
                stateExhibits.remove(exhibit);
                explorer.search();
            }
        }
    }
}