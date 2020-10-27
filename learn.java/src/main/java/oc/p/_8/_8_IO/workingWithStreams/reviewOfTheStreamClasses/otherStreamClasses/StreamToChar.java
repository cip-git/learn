package oc.p._8._8_IO.workingWithStreams.reviewOfTheStreamClasses.otherStreamClasses;

import utils.resources.files.ResourcesOld;

import java.io.*;

class StreamToChar {

    File f = ResourcesOld.Create.SrcMainResources.createFile(this.getClass().getPackage(), "f").toFile();

    public static void main(String[] args) throws IOException {
        StreamToChar streamToChar = new StreamToChar();
        streamToChar.write();
        streamToChar.read();
        ResourcesOld.clean();
    }

    void write() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)))) {
            bw.write("line \nline 2\n line 3");
        }
    }

    void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
            String s;
            while((s= br.readLine())!=null){
                System.out.println(s);
            }
        } catch(EOFException e) {

        }

    }
}
