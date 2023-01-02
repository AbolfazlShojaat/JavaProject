package ir.pt.library.service;

import ir.pt.library.entity.FileBook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileStorageService {
    FileBook save(MultipartFile file) throws IOException;

    FileBook getFile(String id);

    Stream<FileBook> getAllFiles();
}
