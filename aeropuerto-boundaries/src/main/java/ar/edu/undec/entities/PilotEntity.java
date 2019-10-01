package ar.edu.undec.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "pilots")
@SequenceGenerator(name = "pilots_id_seq", initialValue = 1, sequenceName = "pilots_id_seq", allocationSize = 1)
public class PilotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pilots_id_seq")
    private Integer id;

    private String lastName;
    private String firstName;
    private String dni;
    private LocalDate dateOfBirth;

    public PilotEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
