package modeloTest;

import exceptions.AirplaneIncompleteException;
import exceptions.SeatIncompleteException;
import model.Airplane;
import model.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AirplaneUnitTest {

    @Test
    public void factoryAirplaneWhenAllAttributesIsOkAndSeatsNotNull() throws AirplaneIncompleteException, SeatIncompleteException {
        // Arrange
        Seat seat01 = Seat.factorySeat(1,"001");
        Seat seat02 = Seat.factorySeat(1,"002");
        Seat seat03 = Seat.factorySeat(1,"003");
        List<Seat> seats= new ArrayList<Seat>();
        seats.add(seat01);
        seats.add(seat02);
        seats.add(seat03);

        // Act
        Airplane airplane = Airplane.factoryAirplane(1, "MAX 8", "MW8383", seats);

        //Assert
        Assertions.assertNotNull(airplane);
    }

    @Test
    public void factoryAirplaneWhenOneAttributeIsVoidAndSeatsNotNull() throws SeatIncompleteException {
        // Arrange
        Seat seat01 = Seat.factorySeat(1,"001");
        List<Seat> seats= new ArrayList<Seat>();
        seats.add(seat01);

        // Act and assert
        Assertions.assertThrows(AirplaneIncompleteException.class, ()->{
            Airplane airplane = Airplane.factoryAirplane(1, "", "MW8383", seats);
        });
    }

    @Test
    public void factoryAirplaneWhenOneAttributeIsNullAndSeatsNotNull() throws SeatIncompleteException {
        // Arrange
        Seat seat01 = Seat.factorySeat(1,"001");
        List<Seat> seats= new ArrayList<Seat>();
        seats.add(seat01);

        // Act and assert
        Assertions.assertThrows(AirplaneIncompleteException.class, ()->{
            Airplane airplane = Airplane.factoryAirplane(1, null, "MW8383", seats);
        });
    }

    @Test
    public void factoryAirplaneWhenAllAttributesIsOkAndSeatsNull() throws SeatIncompleteException {

        Assertions.assertThrows(AirplaneIncompleteException.class, ()->{
            Airplane airplane = Airplane.factoryAirplane(1, "MAX 8", "MW8383", null);
        });
    }
}
