package modeloTest;

import exceptions.CityIncompleteException;
import model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AirportUnitTest {

    @Test
    public void factoryAirportWhenAllAttributesAreOkAndCityComplete()throws AirportIncompleteException{
        City city = City.factoryCity(1,"Tokyo",  "120-000");
        Airport airport = Airport.factoryAirport(1, "TokyoFly", city, "TF.T.1");
    }

    @Test
    public void factoryAirportWhenOneAttributeIsVoidAndCityIsComplete()throws CityIncompleteException{
        City city = City.factoryCity(1,"Tokyo",  "120-000");
        Assertions.assertThrows(AirportIncompleteException.class, ()->{
            Airport airport = Airport.factoryAirport(1, "", city, "TF.T.1");
        });
    }

    @Test
    public void factoryAirportWhenOneAttributeIsNullAndCityIsComplete()throws CityIncompleteException{
        City city = City.factoryCity(1,"Tokyo",  "120-000");
        Assertions.assertThrows(AirportIncompleteException.class, ()->{
            Airport airport = Airport.factoryAirport(1, null, city, "TF.T.1");
        });
    }

    @Test
    public void factoryAirportWhenOneAttributeIsOkButCityIsNull()throws CityIncompleteException{
        Assertions.assertThrows(AirportIncompleteException.class, ()->{
            Airport airport = Airport.factoryAirport(1, "Tokyo", null, "TF.T.1");
        });
    }

}
