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
    @NotNull
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shabak=" + shabak +
                ", printData=" + printData +
                ", category=" + category +
                ", libraryEntities=" + libraryEntities +
                ", borrowEntities=" + borrowEntities +
                ", cover=" + Arrays.toString(cover) +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
