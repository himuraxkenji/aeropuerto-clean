package modeloTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeatUnitTest {

    @Test
    public void factorySeatWhenAllAttributesIsOk()throws SeatIncompleteException{
        Seat seat = factorySeat(1, "001");
        Assertions.assertNotNull(seat);
    }

    @Test
    public void factorySeatWhenOneAttributesIsVoid(){
        Assertions.assertThrows(SeatIncompleteException.class, ()-> {
            Seat seat = factorySeat(1, "");
        });
    }

    @Test
    public void factorySeatWhenOneAttributesIsNull(){
        Assertions.assertThrows(SeatIncompleteException.class, ()-> {
            Seat seat = factorySeat(1, null);
        });
    }



}
