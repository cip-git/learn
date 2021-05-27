package oc.p._11._8_IO.Review_Questions.qs._11;

import java.io.File;
import java.io.IOException;

import utils.resources.src.Src;

class R {

    File root = new File("src/main/resources/root");

    void prepare() throws IOException {
        final boolean mkdirs = root.mkdirs();

        final File folder = new File(root, "folder");
        folder.mkdir();

        final File ra = new File(root, "ra");
        ra.createNewFile();

        final File rb = new File(root, "rb");
        rb.createNewFile();

        final File fa = new File(folder, "fa");
        fa.createNewFile();

        final File fb = new File(folder, "fb");
        fb.createNewFile();
    }

    void deleteTree(File file){
        if(!file.isFile()){
            for(File f: file.listFiles()){
                deleteTree(f);
            }
        }else{
            final boolean delete = file.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        var r = new R();

        r.prepare();

        r.deleteTree(r.root);

        clean(r);
    }

    private static void clean(R r) {
        new File(r.root, "folder").delete();
        r.root.delete();
    }
}
