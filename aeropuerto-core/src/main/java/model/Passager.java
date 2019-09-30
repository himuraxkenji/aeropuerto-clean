package model;

import exceptions.PassagerIncompleteException;

public class Passager {

    private Integer id;
    private String cuil;
    private String firstName;
    private String lastName;
    private String phone;

    private Passager(Integer id, String cuil, String firstName, String lastName, String phone) {
        this.id = id;
        this.cuil = cuil;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;

    }

    public static Passager factoryPassager(Integer id, String cuil, String firstName, String lastName, String phone) throws PassagerIncompleteException {
        if(cuil == "" || cuil==null)
            throw new PassagerIncompleteException("PassagerIncompleteException: Cuil Incomplete");
        if(firstName == "" || firstName==null)
            throw new PassagerIncompleteException("PassagerIncompleteException: FirstName Incomplete");
        if(lastName == "" || lastName==null)
            throw new PassagerIncompleteException("PassagerIncompleteException: LastName Incomplete");
        if(phone == "" || phone==null)
            throw new PassagerIncompleteException("PassagerIncompleteException: Phone Incomplete");

        return new Passager(id, cuil, firstName, lastName, phone);
    }
}
