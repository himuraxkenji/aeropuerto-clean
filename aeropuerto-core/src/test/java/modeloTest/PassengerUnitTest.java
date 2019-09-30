package modeloTest;

import exceptions.PassagerIncompleteException;
import model.Passager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassengerUnitTest {

    @Test
    public void factoryPassagerWhenAllAttributesIsOk()throws PassagerIncompleteException {
        Passager passager = Passager.factoryPassager(1,"20-55.927.856-41", "Zhu", "Jen", "559-278-5641");
        Assertions.assertNotNull(passager);
    }

    @Test
    public void factoryPassagerWhenOneAttributesIsVoid(){
        Assertions.assertThrows(PassagerIncompleteException.class, ()-> {
            Passager passager = Passager.factoryPassager(1, "", "Zhu", "Jen", "559-278-5641");
        });
    }
    @Test
    public void factoryPassagerWhenOneAttributesIsNull(){
        Assertions.assertThrows(PassagerIncompleteException.class, ()-> {
            Passager passager = Passager.factoryPassager(1, null, "Zhu", "Jen", "559-278-5641");
        });
    }

}
