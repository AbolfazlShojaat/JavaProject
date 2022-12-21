package ir.pt.library.service.Impl;

import ir.pt.library.dao.FileRepo;
import ir.pt.library.entity.FileBook;
import ir.pt.library.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private FileRepo fileRepo;

    public FileServiceImpl(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    @Override
    public FileBook saveFile(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")){
                throw new Exception(" Filename contains invalid path sequence "+ fileName);
            }
            FileBook fileBook =
                    new FileBook(fileName,
                            file.getContentType(),
                            file.getBytes());
            return fileRepo.save(fileBook);
        }catch (Exception ex){
            throw new Exception("Could not save File: " + fileName);

        }
    }

    @Override
    public FileBook getFileBook(String fileId) throws Exception {
        return fileRepo.findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
}
