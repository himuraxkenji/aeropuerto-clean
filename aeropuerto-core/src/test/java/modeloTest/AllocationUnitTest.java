package modeloTest;

import exceptions.PassagerIncompleteException;
import exceptions.SeatIncompleteException;
import model.Passager;
import model.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllocationUnitTest {

    @Test
    public void factoryAllocationWhenAllIsOk() throws AllocationIncompleteException {
        //arrange
        Seat seat = null;
        try {
            seat = Seat.factorySeat(1, "001");
        } catch (SeatIncompleteException e) {
            e.printStackTrace();
        }
        Passager passager = null;
        try {
            passager = Passager.factoryPassager(1,"20-55.927.856-41", "Zhu", "Jen", "559-278-5641");
        } catch (PassagerIncompleteException e) {
            e.printStackTrace();
        }

        //Act
        Allocation allocation = factoryAllocation(1, seat, passager);
        Assertions.assertNotNull(allocation);
    }

    @Test
    public void factoryAllocationWhenSeatIsNull() throws PassagerIncompleteException {
        //arrange
        Passager passager = Passager.factoryPassager(1,"20-55.927.856-41", "Zhu", "Jen", "559-278-5641");
        Assertions.assertThrows(AllocationIncompleteException.class, ()-> {
            Allocation allocation = factoryAllocation(1, null, passager);
        });
    }

    @Test
    public void factoryAllocationWhenPassagerIsNull() throws SeatIncompleteException{
        //arrange
        Seat seat = Seat.factorySeat(1, "001");
        Assertions.assertThrows(AllocationIncompleteException.class, ()-> {
            Allocation allocation = factoryAllocation(1, null, passager);
        });
    }
}
