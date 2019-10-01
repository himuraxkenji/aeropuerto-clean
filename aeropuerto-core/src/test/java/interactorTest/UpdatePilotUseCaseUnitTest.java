package interactorTest;

import exceptions.PilotIncompleteException;
import exceptions.PilotNotFoundException;
import interactor.UpdatePilotUseCase;
import mockito.MockitoExtension;
import model.Pilot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.IRepositoryUpdatePilot;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UpdatePilotUseCaseUnitTest {

    @Mock
    IRepositoryUpdatePilot updatePilot;

    @Test()
    public void updatePilotWhenAllAttributesAreOk() throws PilotIncompleteException, PilotNotFoundException {
        Pilot pilot = Pilot.factoryPilot(1,"Takeda", "Himura", "38.681.666", LocalDate.of(1994, 2,10));
        Pilot updated = Pilot.factoryPilot(1,"Tanaka", "Kamura", "38.681.666", LocalDate.of(1994, 2,10));

        Mockito.when(updatePilot.update(updated)).thenReturn(true);
        Mockito.when(updatePilot.findById(1)).thenReturn(pilot);

        UpdatePilotUseCase updatePilotUseCase = new UpdatePilotUseCase(updatePilot);

        boolean result = updatePilotUseCase.update(updated);

        Assertions.assertTrue(result);

    }

    @Test()
    public void updatePilotWhenNotFoundPilot() throws PilotIncompleteException  {
        Pilot pilot = Pilot.factoryPilot(1,"Takeda", "Himura", "38.681.666", LocalDate.of(1994, 2,10));
        Pilot updated = Pilot.factoryPilot(1,"Tanaka", "Kamura", "38.681.666", LocalDate.of(1994, 2,10));

        Mockito.when(updatePilot.findById(1)).thenReturn(null);

        UpdatePilotUseCase updatePilotUseCase = new UpdatePilotUseCase(updatePilot);

        Assertions.assertThrows(PilotNotFoundException.class, ()-> updatePilotUseCase.update(updated));
    }


}
