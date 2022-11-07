package ir.pt.library.model;

import java.util.Date;

public class Book {
    private int id;
    private String name;
    //    private String Category;
    Category category = new Category();
    private int shabak;
    private Date printData;


    public Book(int id, String name /*String category*/, int shabak, Date printData) {
        this.id = id;
        this.name = name;
//        Category = category;
        this.shabak = shabak;
        this.printData = printData;
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

//    public String getCategory() {
//        return Category;
//    }
//
//    public void setCategory(String category) {
//        Category = category;
//    }

    public Category getCategory() {
        category.getId();
        category.getName();
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
