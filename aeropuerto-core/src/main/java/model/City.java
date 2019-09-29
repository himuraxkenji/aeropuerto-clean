package model;

import exceptions.CityIncompleteException;

public class City {

    private Integer id;
    private String name;
    private String zipCode;

    private City(Integer id, String name, String zipCode) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
    }

    public static City factoryCity(Integer id, String name, String zipCode) throws CityIncompleteException {
        if(name == "")
            throw new CityIncompleteException("CityIncompleteException: Void Name");

        if(name == null)
            throw new CityIncompleteException("CityIncompleteException: Null Name");

        if(zipCode == "")
            throw new CityIncompleteException("CityIncompleteException: Void Zipcode");

        if(zipCode == null)
            throw new CityIncompleteException("CityIncompleteException: Null Name");

        return new City(id, name, zipCode);
    }
}
