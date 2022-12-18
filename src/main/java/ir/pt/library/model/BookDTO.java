package ir.pt.library.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;

public class BookDTO {
    private int id;
    private String name;
    private int shabak;
    private Date printData;
    private CategoryDTO category;
    @NotNull
    private MultipartFile cover;


    public BookDTO() {
    }

    public BookDTO(String name, int shabak, Date printData, CategoryDTO category) {
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
    }

    public BookDTO(int id, String name, int shabak, Date printData, CategoryDTO category) {
        this.id = id;
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
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
