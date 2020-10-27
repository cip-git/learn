package oc.p._8._9_NIO2.introducingNIO2.creatingPaths.workingWithLegacyFileInstead;

import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class Legacy {

    public static void main(String[] args) {
        Legacy l = new Legacy();
        l.m();

    }

    void m() {
        String stringPath = ResourcesOld.LocationOf.SrcMainResources.dir(this.getClass().getPackage());

        File file = new File(stringPath + File.separator + "cuddly.png");
        Path path = file.toPath();

        System.out.println(file);
        System.out.println(path);
        Print.Delimitators.equal();


        path = Paths.get(stringPath, "cuddle_2.png");
        file = path.toFile();
        System.out.println(path);
        System.out.println(file);
    }

}
