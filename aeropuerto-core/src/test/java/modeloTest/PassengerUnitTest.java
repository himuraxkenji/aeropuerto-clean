package modeloTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassengerUnitTest {

    @Test
    public void factoryPassagerWhenAllAttributesIsOk()throws PasajeroIncompleteException{
        Passager passager = factoryPassager(1,"20-55.927.856-41", "Zhu", "Jen", "559-278-5641");
        Assertions.assertNotNull(passager);
    }

    @Test
    public void factoryPassagerWhenOneAttributesIsVoid(){
        Assertions.assertThrows(PasajeroIncompleteException.class, ()-> {
            Passager passager = factoryPassager(1, "", "Zhu", "Jen", "559-278-5641");
        });
    }
    @Test
    public void factoryPassagerWhenOneAttributesIsNull(){
        Assertions.assertThrows(PasajeroIncompleteException.class, ()-> {
            Passager passager = factoryPassager(1, null, "Zhu", "Jen", "559-278-5641");
        });
    }

}
