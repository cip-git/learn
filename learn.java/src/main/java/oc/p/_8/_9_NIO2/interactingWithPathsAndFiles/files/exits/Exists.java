package oc.p._8._9_NIO2.interactingWithPathsAndFiles.files.exits;

import utils.resources.files.ResourcesOld;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static boolean exists(Path file, LinkOption... options)
 */
class Exists {

    Package pkg = this.getClass().getPackage();

    Path e = ResourcesOld.Create.SrcMainResources.createFile(pkg, "e");
    Path ne = Paths.get(ResourcesOld.LocationOf.SrcMainResources.dir(pkg), "ne");

    void m(){
        System.out.println(Files.exists(e));  //true
        System.out.println(Files.exists(ne));  //false
    }

    public static void main(String[] args) {
        ResourcesOld.clean();
        Exists e = new Exists();
        e.m();
    }
}
