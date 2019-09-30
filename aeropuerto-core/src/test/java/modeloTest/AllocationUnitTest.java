package modeloTest;

import exceptions.AllocationIncompleteException;
import exceptions.PassagerIncompleteException;
import exceptions.SeatIncompleteException;
import model.Allocation;
import model.Passager;
import model.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllocationUnitTest {

    @Test
    public void factoryAllocationWhenAllIsOk() throws AllocationIncompleteException, Exception {
        //arrange
        Seat seat = Seat.factorySeat(1, "001");
        Passager passager = Passager.factoryPassager(1,"20-55.927.856-41", "Zhu", "Jen", "559-278-5641");
        //Act
        Allocation allocation = Allocation.factoryAllocation(1, seat, passager);
        Assertions.assertNotNull(allocation);
    }

    @Test
    public void factoryAllocationWhenSeatIsNull() throws PassagerIncompleteException {
        //arrange
        Passager passager = Passager.factoryPassager(1,"20-55.927.856-41", "Zhu", "Jen", "559-278-5641");
        Assertions.assertThrows(AllocationIncompleteException.class, ()-> {
            Allocation allocation = Allocation.factoryAllocation(1, null, passager);
        });
    }

    @Test
    public void factoryAllocationWhenPassagerIsNull() throws SeatIncompleteException{
        //arrange
        Seat seat = Seat.factorySeat(1, "001");
        Assertions.assertThrows(AllocationIncompleteException.class, ()-> {
            Allocation allocation = Allocation.factoryAllocation(1, seat, null);
        });
    }
}
