package repository;

import model.Pilot;

public interface IRepositoryUpdatePilot {

    boolean update(Pilot updated);

    Pilot findById(Integer id);
}
