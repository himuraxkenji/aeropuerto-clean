package model;

import exceptions.AirplaneIncompleteException;

import java.util.List;

public class Airplane {
    private Integer id;
    private String model;
    private String plate;
    private List<Seat> seats;

    public Airplane(Integer id, String model, String plate, List<Seat> seats) {
        this.id = id;
        this.model = model;
        this.plate = plate;
        this.seats = seats;
    }

    public static Airplane factoryAirplane(Integer id, String model, String plate, List<Seat> seats) throws AirplaneIncompleteException {
        if(model == "")
            throw new AirplaneIncompleteException("AirplaneIncompleteException: Void Model");
        if(model == null)
            throw new AirplaneIncompleteException("AirplaneIncompleteException: Null Model");
        if(plate == "")
            throw new AirplaneIncompleteException("AirplaneIncompleteException: Void Plate");
        if(plate == null)
            throw new AirplaneIncompleteException("AirplaneIncompleteException: Null Plate");
        if(seats == null)
            throw new AirplaneIncompleteException("AirplaneIncompleteException: Null Seats");

        return new Airplane(id, model, plate, seats);


    }
}
