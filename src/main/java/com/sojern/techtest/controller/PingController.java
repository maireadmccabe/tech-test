package com.sojern.techtest.controller;

import com.sojern.techtest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Autowired
    private FileService fileService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {

        final Boolean doesFileExist = fileService.doesFileExist();
        if (doesFileExist) {
            return ResponseEntity.ok().body("OK");
        } else {
            return ResponseEntity.internalServerError().body("File Not Found");
        }
    }
}
