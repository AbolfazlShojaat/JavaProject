package ir.pt.library.model;

import java.util.Date;

public class BookDTO {
    private int id;
    private String name;
    private int shabak;
    private Date printData;
    private CategoryDTO category;
    private byte[] cover;
    private ResponseFile fileBook;
//    private byte[] file;


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

    public BookDTO(int id, String name, int shabak, Date printData, CategoryDTO category, ResponseFile fileBook) {
        this.id = id;
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
        this.fileBook = fileBook;
    }

    public BookDTO(int id, String name, int shabak, Date printData, CategoryDTO category, byte[] cover,
                   ResponseFile fileBook) {
        this.id = id;
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
        this.cover = cover;
        this.fileBook = fileBook;
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

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public ResponseFile getFileBook() {
        return fileBook;
    }

    public void setFileBook(ResponseFile fileBook) {
        this.fileBook = fileBook;
    }

    //
//    public byte[] getFile() {
//        return file;
//    }
//
//    public void setFile(byte[] file) {
//        this.file = file;
//    }
}
