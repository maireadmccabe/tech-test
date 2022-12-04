package com.sojern.techtest.utils;

import org.apache.maven.artifact.versioning.ComparableVersion;

public class VersionUtils {

    /**
     * Is version 1 greater than version 2
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersions(String version1, String version2) {
        ComparableVersion version1toCompare = new ComparableVersion(version1);
        ComparableVersion version2toCompare = new ComparableVersion(version2);

        return version1toCompare.compareTo(version2toCompare);
    }
}
