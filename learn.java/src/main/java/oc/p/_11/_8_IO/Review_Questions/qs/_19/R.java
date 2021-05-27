package oc.p._11._8_IO.Review_Questions.qs._19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class R {

    File root = new File("src/main/resources/root");
    final File src = new File(root, "src");
    final File dst = new File(root, "dst");
    final File file = new File(src, "src.txt");
    final File file2 = new File(dst, "dst.txt");

    void prepare() throws IOException {
        final boolean mkdirs = root.mkdirs();
        src.mkdir();
        dst.mkdir();


        file.createNewFile();
        file2.createNewFile();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("a line");
            bw.newLine();
            bw.write("second line");
        }
    }

    void copy(File file, File file2) throws  Exception{
        var reader = new InputStreamReader(new FileInputStream(file));

        try(var writer = new FileWriter(file2)){
            char[] buffer = new char[10];
            while (reader.read(buffer) != -1){
                writer.write(buffer);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        var r = new R();
        r.prepare();

        r.copy(r.file, r.file2);
    }
}
