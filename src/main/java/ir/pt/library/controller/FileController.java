package ir.pt.library.controller;

import ir.pt.library.FileDTO;
import ir.pt.library.entity.FileBook;
import ir.pt.library.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public FileDTO uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        FileBook fileBook = null;
        String downloadURL = "";
        fileBook = fileService.saveFile(file);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileBook.getId())
                .toUriString();
        return new FileDTO(file.getOriginalFilename(),
                downloadURL,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/download/{fileid}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        FileBook fileBook = null;
        fileBook = fileService.getFileBook(fileId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileBook.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "fileBook; filename=\"" + fileBook.getFileName()
                                + "\"")
                .body(new ByteArrayResource(fileBook.getData()));
    }
}
