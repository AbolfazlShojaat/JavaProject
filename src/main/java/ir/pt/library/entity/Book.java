package ir.pt.library.entity;

import ir.pt.library.model.CategoryDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "Shojaat", name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_book")
    @SequenceGenerator(name = "seq_book", initialValue = 1, allocationSize = 1)
    private int id;
    private String name;
    private int shabak;
    private Date printData;

    @ManyToOne
    private Category category;

    public Book() {
    }

    public Book(int id, String name, int shabak, Date printData, Category category) {
        this.id = id;
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
    }

    public Book(String name, int shabak, Date printData, Category category) {
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getShabak() {
        return shabak;
    }

    public void setShabak(int shabak) {
        this.shabak = shabak;
    }

    public Date getPrintData() {
        return printData;
    }

    public void setPrintData(Date printData) {
        this.printData = printData;
    }
}
