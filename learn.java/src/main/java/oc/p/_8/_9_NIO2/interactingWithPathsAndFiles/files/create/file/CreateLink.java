package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.create.file;

import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.resources.files.ResourcesOld.clean;

class CreateLink {
    String loc = ResourcesOld.LocationOf.SrcMainResources.dir(this.getClass().getPackage());

    Path existingDir = Paths.get(loc, "existingDir");
    Path linkDir = Paths.get(loc, "linkDir");

    Path existing = Paths.get(existingDir.toString(), "existing");
    Path link = Paths.get(linkDir.toString(), "link");

    public static void main(String[] args) {
        clean();

        CreateLink csl = new CreateLink();
        csl.createSymbolicLink();
    }

    void init() throws IOException {
        existingDir = Files.createDirectories(existingDir);
        linkDir = Files.createDirectories(linkDir);
        existing = Files.createFile(existing);

        ResourcesOld.Populate.file(existing);
    }

    void createSymbolicLink() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(link);
        try {
//            link = Files.createLink(link, existing);
            link = Files.createSymbolicLink(link, existing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
