package interactor;

import exceptions.PilotNotFoundException;
import model.Pilot;
import repository.IRepositoryUpdatePilot;

public class UpdatePilotUseCase {

    private IRepositoryUpdatePilot updatePilot;

    public UpdatePilotUseCase(IRepositoryUpdatePilot updatePilot) {
        this.updatePilot = updatePilot;
    }

    public boolean update(Pilot updated) throws PilotNotFoundException {
        if( findPilot(updated.getId()) == null)
            throw new PilotNotFoundException("PilotNotFoundException: The pilot don't exist");
        return updatePilot.update(updated);
    }

    private Pilot findPilot(Integer idPilot){
        return updatePilot.findById(idPilot);
    }

}
