package ir.pt.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {

    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}
