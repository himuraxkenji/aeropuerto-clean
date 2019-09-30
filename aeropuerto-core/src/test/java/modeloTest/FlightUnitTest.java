package modeloTest;

import exceptions.FlightIncompleteException;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightUnitTest {

    @Test
    public void factoryFlightWhenAllAttributesIsOk() throws FlightIncompleteException {

        //Arrange

        City cityOut = null;
        City cityIn = null;
        Airport airportOut = null;
        LocalDate outputTime = null;
        Airport airportIn = null;
        LocalDate inputTime = null;
        Airline airline = null;
        List<Pilot> pilots = null;
        Pilot pilotOne = null;
        Pilot pilotTwo = null;
        Airplane airplane = null;
        List<Seat> seats = null;
        Passager passagerOne = null;
        Passager passagerTwo = null;
        List<Passager> passagers = null;

        try{
            cityOut = City.factoryCity(1,"Tokio","120-000");
            airportOut = Airport.factoryAirport(1, "TokioFly", cityOut,"TKF");
            outputTime = LocalDate.of(1994,6,12);

            cityIn = City.factoryCity(2,"Akihabara","100-000");
            airportIn = Airport.factoryAirport(1, "AkihabaraFly", cityOut,"AKF");
            inputTime = LocalDate.of(1994,6,13);

            airline = Airline.factoryAirline(1, "TokioAiline");

            pilotOne = Pilot.factoryPilot(1, "Kakashi", "Sasuke","38.465.697", LocalDate.of(1971,02,10));
            pilotTwo = Pilot.factoryPilot(2, "Tomode", "Takada","36.545.767", LocalDate.of(1970,02,10));
            pilots.add(pilotOne);
            pilots.add(pilotTwo);

            seats = new ArrayList<Seat>();
            seats.add(Seat.factorySeat(1,"001"));
            seats.add(Seat.factorySeat(2,"002"));

            airplane = Airplane.factoryAirplane(1,"MX8","MKTK", seats);

            passagerOne = Passager.factoryPassager(1, "20-39.654.123-7", "Tekada", "Motesuma", "12-654");
            passagerTwo = Passager.factoryPassager(2, "20-38.246.953-2", "Madoka", "Homura", "92-675");
            passagers.add(passagerOne);
            passagers.add(passagerTwo);

        }catch (Exception e){
            e.printStackTrace();
        }

        // Act
        Flight flight = Flight.factoryFlight(1, "TK-AK", airportOut, outputTime, airportIn, inputTime, airline, pilots, airplane, passagers);

        //Assert

        Assertions.assertNotNull(flight);
    }


    @Test
    public void factoryFlightWhenOneAttributeIsNull() {

        Assertions.assertThrows(FlightIncompleteException.class, ()-> {
            Flight flight = Flight.factoryFlight(1, null, null, null, null, null, null, null, null, null);
        });
    }



}
