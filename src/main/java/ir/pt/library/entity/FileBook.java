package ir.pt.library.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(schema = "shojaat", name = "FileBook")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileBook {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @OneToOne(mappedBy = "fileBook")
    private Book book;

    public FileBook(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public FileBook(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public FileBook(String name, String type, byte[] data, Book book) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.book = book;
    }

    public FileBook(String id, String name, String type, byte[] data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
