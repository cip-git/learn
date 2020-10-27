package oc.p._8._8_IO.introducingStreams.commonStreamOperations.flush;

import utils.resources.files.ResourcesOld;

import java.io.*;
import java.nio.file.Path;

class Flush {

    Path p = ResourcesOld.Create.SrcMainResources.createDirectories(this.getClass().getPackage());
    String loc = p.toString();

    void m() throws IOException {
        try(OutputStream os = new FileOutputStream(loc + File.separator + "is")){
            os.flush();
        }
    }

    void m2() throws IOException {
        try (Writer w = new FileWriter(loc + File.separator + "w")){
            w.flush();
        }
    }


    void m3(){
//        OutputStream os = new FileOutputStream(loc + File.separator + )
    }

    public static void main(String[] args) throws IOException {
        ResourcesOld.clean();
        Flush f = new Flush();

//        f.m();
        f.m2();
    }
}
