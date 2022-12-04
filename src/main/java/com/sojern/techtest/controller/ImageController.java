package com.sojern.techtest.controller;

import com.sojern.techtest.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ImageController {

    @Autowired
    private FileService fileService;

    @GetMapping(value = "/img")
    @ResponseBody
    public ResponseEntity<byte[]> getImage() throws IOException {

        InputStream gif = fileService.getGif();
        return ResponseEntity.ok().body(IOUtils.toByteArray(gif));
    }
}
