package ir.pt.library.util;

import org.springframework.core.io.UrlResource;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {
    private Path foundFile;

    public Resource getFileAsResource(String fileName) throws IOException {
        Path uploadDirector = Paths.get("Files-Upload");
        Files.list(uploadDirector).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileName)) {
                foundFile = file;
                return;
            }
        });
        if (foundFile != null) {
            return (Resource) new UrlResource(foundFile.toUri());
        }
        return null;
    }
}
