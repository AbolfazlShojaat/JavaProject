package ir.pt.library.service;

import ir.pt.library.entity.FileBook;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileBook saveFile(MultipartFile file) throws Exception;

    FileBook getFileBook(String fileId) throws Exception;
}
