package ir.pt.library.entity;


import javax.persistence.*;

@Entity
@Table(schema = "shojaat", name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    @SequenceGenerator(name = "seq_category", initialValue = 1, allocationSize = 1)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(name = "national_code", length = 10)
    private int nationalCode;
    @Column(name = "id_num", length = 10)
    private String idNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, int nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }

    public Person(int id, String firstName, String lastName, int nationalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
