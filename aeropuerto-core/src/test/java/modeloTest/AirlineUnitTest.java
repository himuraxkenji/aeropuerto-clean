package modeloTest;

import exceptions.AirlineIncompleteException;
import model.Airline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AirlineUnitTest {

    @Test
    public void factoryAirlineWhenAtributesIsOk() throws AirlineIncompleteException {
        Airline airline = Airline.factoryAirline(1, "American");
        Assertions.assertNotNull(airline);
    }

    @Test
    public void factoryAirlineWhenAtributesIsVoid(){
        Assertions.assertThrows(AirlineIncompleteException.class, ()->{
            Airline airline = Airline.factoryAirline(1, "");
        });
    }


    @Test
    public void factoryAirlineWhenAtributesIsNull(){
        Assertions.assertThrows(AirlineIncompleteException.class, ()->{
            Airline airline = Airline.factoryAirline(1, null);
        });
    }
}
