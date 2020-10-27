package oc.p._8._9_NIO2.understandingFileAttributes.improvingAccessWithViews.understantingViews;


import utils.resources.files.ResourcesOld;
import utils.resources.files.print.Print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * static <A extends BasicFileAttributes> A	readAttributes(Path path, Class<A> type, LinkOption... options)
 */
class Views {

    static Path path = null;

    static void m() {
        try {
            /**
             * Only this for exam
             */
            BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(bfa);

            FileTime ft = bfa.creationTime();

            Print.NIO.print(bfa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        m();

        ResourcesOld.clean();
    }
}
