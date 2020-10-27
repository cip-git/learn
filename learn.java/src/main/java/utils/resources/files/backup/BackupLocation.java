package utils.resources.files.backup;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.resources.files.ResourcesOld.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.FILE_SEPARATOR;

enum BackupLocation {
    IQ_NESPRESSO_NAVAL_BATTLE("iq.nespresso.naval.battle"),
    IQ_NESPRESSO_TOURNAMENT("iq.nespresso.tournament");

    String location;

    BackupLocation(final String srcMainJavaLocation) {
        this.location = srcMainJavaLocation;
    }

    Path toSrcMainJavaPackagePath() {
        return Paths.get(FILE_SEPARATOR.separationOf(SRC_MAIN_JAVA), FILE_SEPARATOR.separationOf(location));
    }

    String toSrcMainJavaLocation() {
        return FILE_SEPARATOR.separationOf(SRC_MAIN_JAVA) + File.separator + FILE_SEPARATOR.separationOf(location);
    }
}
