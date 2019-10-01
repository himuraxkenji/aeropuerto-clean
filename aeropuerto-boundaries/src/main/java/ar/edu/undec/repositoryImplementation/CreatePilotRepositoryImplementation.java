package ar.edu.undec.repositoryImplementation;

import ar.edu.undec.crud.PilotCrud;
import ar.edu.undec.entities.PilotEntity;
import exceptions.PilotIncompleteException;
import model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IRepositoryCreatePilot;

@Service
public class CreatePilotRepositoryImplementation implements IRepositoryCreatePilot {

    @Autowired
    private PilotCrud pilotCrud;

    @Override
    public boolean save(Pilot pilot) {
        PilotEntity pilotEntity = new PilotEntity();
        pilotEntity.setFirstName(pilot.getFirstName());
        pilotEntity.setLastName(pilot.getLastName());
        pilotEntity.setDni(pilot.getDni());
        pilotEntity.setDateOfBirth(pilot.getDateOfBirth());

        return pilotCrud.save(pilotEntity) != null;
    }

    @Override
    public Pilot findByDni(String dni) {
        PilotEntity pilotEntity = pilotCrud.findByDni(dni);
        Pilot pilot = null;
        try {
            pilot = Pilot.factoryPilot(pilotEntity.getId(),
                    pilotEntity.getLastName(), pilotEntity.getFirstName(),
                    pilotEntity.getDni(),pilotEntity.getDateOfBirth());
        } catch (PilotIncompleteException e) {
            e.printStackTrace();
        }

        return pilot;
    }
}
