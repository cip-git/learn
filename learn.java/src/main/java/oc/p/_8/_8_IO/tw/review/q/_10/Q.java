package oc.p._8._8_IO.tw.review.q._10;

import utils.resources.files.ResourcesOld;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Q {
    final Path base = ResourcesOld.Create.SrcMainResources.createDirectories(this.getClass().getPackage());

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();
        Q q = new Q();
        q.m();
        q.deleteTree(q.base.toFile());
    }

    void deleteTree(File file) {
        if (!file.isFile()) {
            for (File f : file.listFiles()) {
                deleteTree(f);
            }
        } else file.delete();
    }

    void m() throws IOException {

        Path a = Paths.get(base.toString(), "a");
        a = Files.createDirectories(a);

        Path f = Paths.get(base.toString(), "f");
        f = Files.createFile(f);

        Path b = Files.createDirectories(Paths.get(a.toString(), "b"));

        Path f2 = Files.createFile(Paths.get(a.toString(), "f2"));

        Path c = Files.createDirectories(Paths.get(b.toString(), "c"));

        Path f3 = Files.createFile(Paths.get(b.toString(), "f3"));
    }


}
