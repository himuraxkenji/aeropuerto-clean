package interactor;

import model.Pilot;

public interface IRepositoryCreatePilot {
    boolean save(Pilot pilot);

    Pilot findByDni(String dni);
}
