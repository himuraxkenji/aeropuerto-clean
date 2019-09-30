package model;

import exceptions.AirportIncompleteException;

public class Airport {

    private final Integer id;
    private final String name;
    private final City city;
    private final String code;

    public Airport(Integer id, String name, City city, String code) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.code = code;
    }

    public static Airport factoryAirport(Integer id, String name, City city, String code) throws AirportIncompleteException {
        if(name == "")
            throw new AirportIncompleteException("AirportIncompleteException: Void Name");
        if(name == null)
            throw new AirportIncompleteException("AirportIncompleteException: Null Name");
        if(code == "")
            throw new AirportIncompleteException("AirportIncompleteException: Void Code");
        if(code == null)
            throw new AirportIncompleteException("AirportIncompleteException: Null Code");
        if(city == null)
            throw new AirportIncompleteException("AirportIncompleteException: Null City");

        return new Airport(id, name, city, code );
    }
}
