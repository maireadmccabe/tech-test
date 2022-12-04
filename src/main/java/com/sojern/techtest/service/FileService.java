package com.sojern.techtest.service;

import com.sojern.techtest.dto.FileCheckDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class FileService {

    @Value("${tmp.file.location:/tmp/ok}")
    private String filePath;

    @Value("${gif.file.name:/assets/1x1-gif-image.gif}")
    private String gifFilePath;

    private FileCheckDTO fileCheckDTO;

    /**
     * Assumption: File is stationary
     * Given the above assumption it is safe to cache the response so that only periodically (15 minutes)
     * we execute the check to ensure the file exists
     *
     * @return
     */
    public Boolean doesFileExist() {

        // is the record is expired check if file exists
        if (isExpiredRecord()) {

            if (!StringUtils.hasLength(filePath)) {
                return false;
            }

            boolean doesFileExist = false;

            File f = new File(filePath);
            if (f.exists() && !f.isDirectory()) {
                doesFileExist = true;
            }

            return doesFileExist;
        } else {
            // record has not expired return the cached value
            return fileCheckDTO.isValue();
        }
    }

    /**
     * Assume GIF doesn't change
     *
     * @return
     */
    @Cacheable("gif")
    public InputStream getGif() {
        return this.getClass().getResourceAsStream(gifFilePath);
    }

    private boolean isExpiredRecord() {

        if (fileCheckDTO == null || fileCheckDTO.getDateCreated() == null) {
            return true;
        }

        Instant now = Instant.now();
        Instant then = now.minus(15, ChronoUnit.MINUTES);

        return fileCheckDTO.getDateCreated().isBefore(then);
    }
}
