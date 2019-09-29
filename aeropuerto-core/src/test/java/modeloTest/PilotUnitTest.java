package modeloTest;

import exceptions.PilotIncompleteException;
import model.Pilot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

public class PilotUnitTest {

    @Test
    public void factoryPilotWhenAtributesIsOk()throws PilotIncompleteException {
        LocalDate dateOfBirth = LocalDate.of(2019,9, 03);
        Pilot pilot = Pilot.factoryPilot(1, "Perez", "Juan", "38.440.761", dateOfBirth);
        Assertions.assertNotNull(pilot);
    }

    @Test
    public void factoryPilotWhenAtributeIsVoid(){
        LocalDate dateOfBirth = LocalDate.of(2019,9, 03);
        Assertions.assertThrows(PilotIncompleteException.class, ()->{
            Pilot pilot = Pilot.factoryPilot(1, "", "Juan", "38.440.761", dateOfBirth);
        });

    }

    @Test
    public void factoryPilotWhenAtributeIsNull(){
        LocalDate dateOfBirth = LocalDate.of(2019,9, 03);
        Assertions.assertThrows(PilotIncompleteException.class, ()->{
            Pilot pilot = Pilot.factoryPilot(1, null, "Juan", "38.440.761", dateOfBirth);
        });

    }
}
