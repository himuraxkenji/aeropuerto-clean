package interactorTest;

import exceptions.PilotExistException;
import exceptions.PilotIncompleteException;
import interactor.CreatePilotUseCase;
import interactor.IRepositoryCreatePilot;
import mockito.MockitoExtension;
import model.Pilot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CreatePilotUseCaseUnitTest {

    @Mock
    IRepositoryCreatePilot createPilotGateway;

    @Test
    public void createPilotWhenThenNoExist()throws PilotIncompleteException, PilotExistException {

        Pilot pilot = Pilot.factoryPilot(1,"Takeda", "Himura", "38.681.666", LocalDate.of(1994, 2,10));
        Mockito.when(createPilotGateway.save(pilot)).thenReturn(true);
        Mockito.when(createPilotGateway.findByDni("39.681.666")).thenReturn(null);

        CreatePilotUseCase createPilotUseCase = new CreatePilotUseCase(createPilotGateway);
        boolean result = createPilotUseCase.createPilot(pilot);
        Assertions.assertTrue(result);

    }

    @Test
    public void createPilotWhenThenExist()throws PilotIncompleteException {

        Pilot pilot = Pilot.factoryPilot(1,"Takeda", "Himura", "38.681.666", LocalDate.of(1994, 2,10));
        Mockito.when(createPilotGateway.findByDni("38.681.666")).thenReturn(Pilot.factoryPilot(2,"Jekada", "Tukada", "38.681.666", LocalDate.of(1994, 2,10)));

        CreatePilotUseCase createPilotUseCase = new CreatePilotUseCase(createPilotGateway);
        Assertions.assertThrows(PilotExistException.class, ()-> createPilotUseCase.createPilot(pilot));

    }
}
