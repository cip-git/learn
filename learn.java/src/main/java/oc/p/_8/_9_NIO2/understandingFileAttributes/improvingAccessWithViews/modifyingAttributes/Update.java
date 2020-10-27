package oc.p._8._9_NIO2.understandingFileAttributes.improvingAccessWithViews.modifyingAttributes;

import oc.p._8._9_NIO2.util.TestPath;
import utils.print.Print;
import utils.resources.files.ResourcesOld;
import utils.resources.files.ResourcesData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * static <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options)
 *
 * Returns a file attribute view of a given type
 *
 * Beware!!! This method is among the few which doesn't throw a IOException
 *
 * void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException;
 */
class Update {
    Path path = ResourcesOld.Create.Populate.SrcMainResources.file(this.getClass().getPackage(), "file");

    Function <BasicFileAttributeView, BasicFileAttributes> READ_ATTRIBUTES = bfav -> {
        try {
            return bfav.readAttributes();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    };
    BiConsumer<BasicFileAttributeView, FileTime> SET_TIMES = (bfav, ft)-> {
        try {
            bfav.setTimes(ft, ft, ft);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    Function<BasicFileAttributeView, String> NAME = BasicFileAttributeView::name;

    void m(BasicFileAttributeView bfav){
        List<Object> lst = Arrays.asList(READ_ATTRIBUTES, SET_TIMES);
        lst.forEach( o->{
            if(o instanceof Function){
                Function f = (Function)o;
                System.out.println("f: " + f.apply(bfav));
            }else{
                BiConsumer bc = (BiConsumer)o;
                bc.accept(bfav, ResourcesData.THIS_MONTH.fileTime());
                System.out.println("accepted");
            }
        });
    }

    void mm(){
//        m(Files.getFileAttributeView(path, BasicFileAttributeView.class));
        Print.Delimitators.equal();
        m(Files.getFileAttributeView(TestPath.RELATIVE_WINDOWS_PATH, BasicFileAttributeView.class));
    }

    public static void main(String[] args) {
        ResourcesOld.clean();
        Update u = new Update();

        u.mm();
    }
}
