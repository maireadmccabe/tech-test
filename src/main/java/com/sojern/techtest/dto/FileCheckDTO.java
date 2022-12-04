package com.sojern.techtest.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class FileCheckDTO {

    private boolean value;
    private Instant dateCreated;
}
