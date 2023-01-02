package ir.pt.library.service.Impl;

import ir.pt.library.dao.FileBookRepo;
import ir.pt.library.entity.FileBook;
import ir.pt.library.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileBookRepo fileBookRepo;

    @Override
    public FileBook save(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileBook fileBook = new FileBook(fileName, file.getContentType(), file.getBytes());
        return fileBookRepo.save(fileBook);
    }

    @Override
    public FileBook getFile(String id) {
        return fileBookRepo.findById(id).get(); }

    @Override
    public Stream<FileBook> getAllFiles() {
        return fileBookRepo.findAll().stream();
    }
}
