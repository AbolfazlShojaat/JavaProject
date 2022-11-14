package ir.pt.library.model;

public class PersonModel {
    private int id;
    private String fullName;
    private int nationalCode;

    public PersonModel() {
    }

    public PersonModel(String fullName, int nationalCode) {
        this.fullName = fullName;
        this.nationalCode = nationalCode;
    }

    public PersonModel(int id, String fullName, int nationalCode) {
        this.id = id;
        this.fullName = fullName;
        this.nationalCode = nationalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

