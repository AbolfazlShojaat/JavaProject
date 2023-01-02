package ir.pt.library.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static String saveBookFile(String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get("Files-Upload");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        try (InputStream inputStream = (InputStream) multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileCode + "_" + fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);


        } catch (IOException ioe) {
            throw new IOException("could not save file" + fileName, ioe);
        }
        return fileCode;
    }
}

