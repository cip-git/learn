package oc.p._8._4_FunctionalProgramming.usingStreams.usingCommonTerminalOperations.collect.tw;

import static utils.print.Print.print;

import java.awt.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import utils.resources.files.Location;

class C {

    static Path p  = Path.of(Location.SRC_MAIN_JAVA.asPath(), "iq");

    static void m() throws IOException {
        final ArrayList<Path> collect = Files
                .walk(p)
                .map(Path::getFileName)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        print(collect);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
