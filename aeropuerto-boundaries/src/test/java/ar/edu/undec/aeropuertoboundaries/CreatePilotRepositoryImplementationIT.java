package ar.edu.undec.aeropuertoboundaries;

import ar.edu.undec.repositoryImplementation.CreatePilotRepositoryImplementation;
import exceptions.PilotIncompleteException;
import model.Pilot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePilotRepositoryImplementationIT {

    @Autowired
    private CreatePilotRepositoryImplementation implementation;


    @Test
    @SqlGroup({
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:createPilots.sql" ),
    })
    public void savePilot_PilotSaved_ReturnTrue() throws PilotIncompleteException {
        Pilot pilot = Pilot.factoryPilot(null,"Prieto", "Juanfer","38562765", LocalDate.of(2012,8,10));
        boolean result = implementation.save(pilot);
        Assert.assertTrue(result);

    }

}
