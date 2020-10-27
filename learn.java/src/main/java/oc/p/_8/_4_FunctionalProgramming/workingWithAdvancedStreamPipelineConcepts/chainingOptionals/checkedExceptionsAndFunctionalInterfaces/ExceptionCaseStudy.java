package oc.p._8._4_FunctionalProgramming.workingWithAdvancedStreamPipelineConcepts.chainingOptionals.checkedExceptionsAndFunctionalInterfaces;

import java.io.IOException;
import java.util.List;

class ExceptionCaseStudy {

    static List<String> create() throws IOException {
        throw new IOException();
    }

    static List<String> createSafe() {
        try {
            return create();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
