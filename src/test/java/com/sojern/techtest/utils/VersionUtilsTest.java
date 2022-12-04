package com.sojern.techtest.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionUtilsTest {

    @Test
    public void testVersions() {
        // version 2 is greater than version 1. -1 expected
        assertEquals(-1, VersionUtils.compareVersions("0.1", "1.1"));
        // version 2 is greater than version 1. -1 expected
        assertEquals(-1, VersionUtils.compareVersions("1.2", "1.2.9.9.9.9"));
        // version 1 is greater than version2. 1 expected
        assertEquals(1, VersionUtils.compareVersions("1.3", "1.2.9.9.9.9"));
        // versions are equal. 0 expected
        assertEquals(0, VersionUtils.compareVersions("1.0.0-RELEASE", "1.0.0-RELEASE"));
    }
}
