package com.sojern.techtest.service;

import com.sojern.techtest.dto.FileCheckDTO;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileServiceTest {

    private FileService fileService = new FileService();

    @Test
    public void testTrueWhenFileExists() {

        FileCheckDTO dto = new FileCheckDTO();
        dto.setDateCreated(Instant.now().minus(30, ChronoUnit.MINUTES));
        ReflectionTestUtils.setField(fileService, "fileCheckDTO", dto);
        ReflectionTestUtils.setField(fileService, "filePath",
                getClass().getResource("/tmp/.keep").getPath());
        assertTrue(fileService.doesFileExist());
    }

    @Test
    public void testFalseWhenDirectory() {
        FileCheckDTO dto = new FileCheckDTO();
        dto.setDateCreated(Instant.now().minus(30, ChronoUnit.MINUTES));
        ReflectionTestUtils.setField(fileService, "fileCheckDTO", dto);
        ReflectionTestUtils.setField(fileService, "filePath",
                getClass().getResource("/tmp/").getPath());
        assertFalse(fileService.doesFileExist());
    }

    @Test
    public void testFalseFileDoesNotExists() {
        FileCheckDTO dto = new FileCheckDTO();
        dto.setDateCreated(Instant.now().minus(30, ChronoUnit.MINUTES));
        ReflectionTestUtils.setField(fileService, "fileCheckDTO", dto);
        ReflectionTestUtils.setField(fileService, "filePath", "foo");
        assertFalse(fileService.doesFileExist());
    }

    @Test
    public void testFalseFilePropertyNotSet() {
        FileCheckDTO dto = new FileCheckDTO();
        dto.setDateCreated(Instant.now().minus(30, ChronoUnit.MINUTES));
        ReflectionTestUtils.setField(fileService, "fileCheckDTO", dto);
        assertFalse(fileService.doesFileExist());
    }

    @Test
    public void testTrueWithCachedResponse() {

        FileCheckDTO dto = new FileCheckDTO();
        dto.setDateCreated(Instant.now().minus(2, ChronoUnit.MINUTES));
        dto.setValue(true);
        ReflectionTestUtils.setField(fileService, "fileCheckDTO", dto);

        assertTrue(fileService.doesFileExist());
    }

    @Test
    public void testFalseWithCachedResponse() {

        FileCheckDTO dto = new FileCheckDTO();
        dto.setDateCreated(Instant.now().minus(2, ChronoUnit.MINUTES));
        dto.setValue(false);
        ReflectionTestUtils.setField(fileService, "fileCheckDTO", dto);

        assertFalse(fileService.doesFileExist());
    }
}
