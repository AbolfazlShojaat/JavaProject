package ir.pt.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Table(schema = "shojaat", name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "book")
    private List<LibraryEntity> libraryEntities;

    @OneToMany(mappedBy = "book")
    private List<BorrowEntity> borrowEntities;

    @Column
    @Lob
    private byte[] cover;

    @Column
    @Lob
    private byte[] file;

    public Book(int id, String name, int shabak, Date printData, Category category) {
        this.id = id;
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
    }

    public Book(int id, String name, int shabak, Date printData, Category category, byte[] cover, byte[] file) {
        this.id = id;
        this.name = name;
        this.shabak = shabak;
        this.printData = printData;
        this.category = category;
        this.cover = cover;
        this.file = file;
    }
}
