package ir.pt.library.model;

import javax.validation.constraints.NotNull;

public class PersonDTO {
    private int id;
    @NotNull(message = "firstName.validation")
    private String firstName;
    private String lastName;
    private int nationalCode;
    private int idNO;

    public PersonDTO() {
    }


    public PersonDTO(String firstName, String lastName, int nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }

    public PersonDTO(int id, String firstName, String lastName, int nationalCode, int idNO) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.idNO = idNO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getIdNO() {
        return idNO;
    }

    public void setIdNO(int idNO) {
        this.idNO = idNO;
    }
}
