package ar.edu.undec.crud;

import ar.edu.undec.entities.PilotEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotCrud extends CrudRepository<PilotEntity, Integer> {
    PilotEntity findByDni(String dni);
}
