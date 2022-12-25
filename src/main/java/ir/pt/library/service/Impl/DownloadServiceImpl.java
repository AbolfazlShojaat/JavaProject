package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public byte[] downloadFile(Integer id) {
        return bookRepo.findById(id).get().getFile();
    }
}
