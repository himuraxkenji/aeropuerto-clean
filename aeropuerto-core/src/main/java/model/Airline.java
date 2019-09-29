package model;

import exceptions.AirlineIncompleteException;

public class Airline {

    private String name;
    private Integer id;

    private Airline(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Airline factoryAirline(Integer id, String name) throws AirlineIncompleteException {
        if(name == "")
            throw new AirlineIncompleteException("AirlineIncompleteException: Void Name");
        if(name == null)
            throw new AirlineIncompleteException("AirlineIncompleteException: Null Name");

        return new Airline(id, name);
    }
}
