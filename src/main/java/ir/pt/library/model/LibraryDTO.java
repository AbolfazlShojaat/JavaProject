package ir.pt.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {
    private Integer id;
    private BookDTO book;
    private Integer number;
    private Integer existNum;
    private Boolean isBorrowAble;

}
