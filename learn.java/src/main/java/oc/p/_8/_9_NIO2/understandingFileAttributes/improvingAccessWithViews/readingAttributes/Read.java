package oc.p._8._9_NIO2.understandingFileAttributes.improvingAccessWithViews.readingAttributes;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

/**
 * static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException
 */
class Read {
    Path path = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "file");

    Predicate <BasicFileAttributes> IS_DIRECTORY = BasicFileAttributes::isDirectory;
    Predicate <BasicFileAttributes> IS_REGULAR_FILE = BasicFileAttributes::isRegularFile;
    Predicate <BasicFileAttributes> IS_SYMBOLIC_LINK = BasicFileAttributes::isSymbolicLink;
    Predicate <BasicFileAttributes> IS_OTHER = BasicFileAttributes::isOther;

    ToLongFunction <BasicFileAttributes> SIZE = BasicFileAttributes::size;

    Function <BasicFileAttributes, Object> FILE_KEY = BasicFileAttributes::fileKey;

    void m(BasicFileAttributes bfa){
        List<Object> lst = Arrays.asList(IS_DIRECTORY, IS_REGULAR_FILE, IS_SYMBOLIC_LINK, IS_OTHER, SIZE, FILE_KEY);


        lst.forEach(o->{
            if(o instanceof Predicate){
                Predicate pred = (Predicate)o;
                System.out.println(pred.test(bfa));
            }
            if( o instanceof  ToLongFunction){
                ToLongFunction f = (ToLongFunction)o;
                System.out.println(f.applyAsLong(bfa));
            }
            if(o instanceof Function){
                Function f = (Function)o;
                System.out.println(f.apply(bfa));
            }
        });
    }

    void mm(Path p) throws IOException {
        BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
        m(bfa);
    }

    void mmm() throws IOException {
        mm(path);
        Print.Delimitators.equal();
        mm(TestPath.RELATIVE_WINDOWS_PATH);
    };

    public static void main(String[] args) throws IOException {
        Read r = new Read();
        r.mmm();
    }
}
