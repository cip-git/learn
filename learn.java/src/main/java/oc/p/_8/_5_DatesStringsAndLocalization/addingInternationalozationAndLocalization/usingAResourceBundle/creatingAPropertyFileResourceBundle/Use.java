package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle;

import utils.delimitators.Delimitators;
import utils.resources.files.ResourcesOld;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

class Use {

    String loc = ResourcesOld.LocationOf.PropertyResourceBundle.bundle(this.getClass().getPackage(), "Locale");

    {
        Path path = ResourcesOld.Create.PropertyResourceBundle.bundle(this.getClass().getPackage(), "Locale_de_DE");
        try {
            if(Files.size(path) == 0){
                try(BufferedWriter  bw = Files.newBufferedWriter(path)){
                    bw.write("a: propA");
                    bw.newLine();
                    bw.write("b = propB");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void m(){
        ResourceBundle rb = ResourceBundle.getBundle(loc, new Locale("De", "De"));
        rb.keySet().forEach(System.out::println);

        final String a = rb.getString("a");
        System.out.println(a);

        final Object b = rb.getObject("b");
        System.out.println(b);

        Delimitators.newLine();
    }

    void m2(){
        PropertyResourceBundle prb = (PropertyResourceBundle)ResourceBundle.getBundle(loc, Locale.GERMANY);
        prb.keySet().forEach(System.out::println);

        final String a = prb.getString("a");
        System.out.println(a);

        final Object b = prb.getObject("b");
        System.out.println(b);
    }

    void m3(){
        Properties p = new Properties();
        ResourceBundle rb = ResourceBundle.getBundle(loc, new Locale("de", "de"));

        rb.keySet().forEach((k->p.put(k, rb.getObject(k))));

        p.forEach((k, v)-> System.out.println(k + " -> " + v));
    }

    public static void main(String[] args) {
        final Use use = new Use();

//        use.m();
//        use.m2();
        use.m3();
    }
}
