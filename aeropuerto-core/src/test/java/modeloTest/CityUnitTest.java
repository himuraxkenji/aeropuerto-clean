package modeloTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CityUnitTest {

    @Test
    public void factoryCityWhenAttributesAllOks(){
        City city = City.factoryCity(1, "Tokio", "120-0000");
        Assertions.assertNotNull(city);
    }


    @Test
    public void factoryCityWhenOneAttributeIsVoid(){
        Assertions.assertThrows(CityIncompleteException.class, ()->{
            City city = City.factoryCity(1, "", "120-0000");
        });
    }

    @Test
    public void factoryCityWhenOneAttributeIsNull() {
        Assertions.assertThrows(CityIncompleteException.class, () -> {
            City city = City.factoryCity(1, null, "120-0000");
        });
    }

}
