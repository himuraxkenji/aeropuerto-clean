package model;

import exceptions.FlightIncompleteException;

import java.time.LocalDate;
import java.util.List;

public class Flight {

    private Integer id;
    private String codeFlight;
    private Airport airportOut;
    private LocalDate outputTime;
    private Airport airportIn;
    private LocalDate inputTime;
    private Airline airline;
    private List<Pilot> pilots;
    private Airplane airplane;
    private List<Passager> passagers;

    private Flight(Integer id, String codeFlight, Airport airportOut, LocalDate outputTime,
                   Airport airportIn, LocalDate inputTime, Airline airline, List<Pilot> pilots,
                   Airplane airplane, List<Passager> passagers) {
        this.id = id;
        this.codeFlight = codeFlight;
        this.airportOut = airportOut;
        this.outputTime = outputTime;
        this.airportIn = airportIn;
        this.inputTime = inputTime;
        this.airline = airline;
        this.pilots = pilots;
        this.airplane = airplane;
        this.passagers = passagers;
    }

    public static Flight factoryFlight(Integer id, String codeFlight, Airport airportOut,
                                       LocalDate outputTime, Airport airportIn, LocalDate inputTime,
                                       Airline airline, List<Pilot> pilots, Airplane airplane,
                                       List<Passager> passagers) throws FlightIncompleteException {

        if(codeFlight == "" || codeFlight == null)
            throw new FlightIncompleteException("FlightIncompleteException: Codefligth Null");
        if(airportOut == null)
            throw new FlightIncompleteException("FlightIncompleteException: Airport Out Null");
        if(outputTime == null)
            throw new FlightIncompleteException("FlightIncompleteException: Out Time  Null");
        if(airportIn == null)
            throw new FlightIncompleteException("FlightIncompleteException: Airport In Null");
        if(inputTime == null)
            throw new FlightIncompleteException("FlightIncompleteException: In Time Null");
        if(airline == null)
            throw new FlightIncompleteException("FlightIncompleteException: Airline Null");
        if(pilots == null)
            throw new FlightIncompleteException("FlightIncompleteException: Pilots  Null");
        if(airplane == null)
            throw new FlightIncompleteException("FlightIncompleteException: Airplane Null");
        if(passagers == null)
            throw new FlightIncompleteException("FlightIncompleteException: Passagers Null");

        return new Flight(id, codeFlight, airportOut,
                outputTime, airportIn, inputTime,
                airline, pilots, airplane,
               passagers);
    }
}
