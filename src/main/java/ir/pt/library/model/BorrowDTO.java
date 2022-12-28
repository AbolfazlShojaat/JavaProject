package ir.pt.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDTO {
    private Integer id;
    private BookDTO book;
    private Date rejDate;
    private PersonDTO person;
    private Date receiveDate;
}
