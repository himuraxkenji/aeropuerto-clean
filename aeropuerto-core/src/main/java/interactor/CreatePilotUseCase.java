package interactor;

import exceptions.PilotExistException;
import model.Pilot;
import repository.IRepositoryCreatePilot;

public class CreatePilotUseCase {

    public IRepositoryCreatePilot createPilotGateway;

    public CreatePilotUseCase(IRepositoryCreatePilot createPilotGateway) {
        this.createPilotGateway = createPilotGateway;
    }

    public boolean createPilot(Pilot pilot) throws PilotExistException {
        if(!existePilot(pilot))
            return this.createPilotGateway.save(pilot);

        throw new PilotExistException("PilotExistException: The pilot exist");
    }

    private boolean existePilot(Pilot pilot) {
        return createPilotGateway.findByDni(pilot.getDni()) != null;
    }
}
