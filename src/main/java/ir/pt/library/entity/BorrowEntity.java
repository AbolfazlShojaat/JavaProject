package ir.pt.library.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "shojaat", name = "Borrow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_borrow")
    @SequenceGenerator(name = "seq_borrow", initialValue = 1, allocationSize = 1)
    private Integer id;

    @ManyToOne
    private Book book;

    private Date rejDate;


    @ManyToOne
    private Person person;

    private Date receiveDate;



}
