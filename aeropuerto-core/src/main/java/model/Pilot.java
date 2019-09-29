package model;

import exceptions.PilotIncompleteException;

import java.time.LocalDate;

public class Pilot {


    private Integer id;
    private String lastName;
    private String firstName;
    private String dni;
    private LocalDate dateOfBirth;


    private Pilot(Integer id, String lastName, String firstName, String dni, LocalDate dateOfBirth) {
        this.id = id;
        this.lastName = lastName;
        this.firstName= firstName;
        this.dni = dni;
        this.dateOfBirth = dateOfBirth;
    }

    public static Pilot factoryPilot(Integer id, String lastName, String firstName, String dni, LocalDate dateOfBirth) throws PilotIncompleteException {

        if(lastName == null || lastName =="")
            throw new PilotIncompleteException("Pilot: Last name incomplete or null");

        if(firstName == null || firstName == "")
            throw new PilotIncompleteException("Pilot: First name incomplete or null");

        if(dni == null || dni == "")
            throw new PilotIncompleteException("Pilot: Dni incomplete or null");

        if(dateOfBirth == null)
            throw new PilotIncompleteException("Pilot: Date of Birth incomplete or null");

        return new Pilot(id, lastName, firstName, dni, dateOfBirth);
    }


}
