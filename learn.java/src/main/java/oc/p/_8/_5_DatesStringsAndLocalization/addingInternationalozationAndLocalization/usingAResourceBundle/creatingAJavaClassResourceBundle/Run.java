package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle;

import utils.print.Print;
import utils.resources.files.ResourcesOld;

import java.util.*;

class Run {

    String location = ResourcesOld.LocationOf.ListResourceBundle.bundle(this.getClass().getPackage(), "Locale");
    ResourceBundle rb;

    {
        System.out.println("location: " + location);
        Print.Delimitators.newLine();
    }

    public static void main(String[] args) {
        Run r = new Run();

//        r.m();
//        r.m2();
        r.m3();
    }

    void m() {
        rb = ResourceBundle.getBundle(location, new Locale("de", "De"));

        rb.keySet().forEach(System.out::println);

        final String s = rb.getString("s");
        System.out.println(s);

        final Object l = rb.getObject("l");
        System.out.println(l);

        final String[] sas = rb.getStringArray("sa");
        System.out.println(Arrays.toString(sas));

        Print.Delimitators.newLine();
    }

    void m2() {
        ListResourceBundle lrb = (ListResourceBundle)
                ResourceBundle.getBundle(location, new Locale.Builder().setLanguage("de").setRegion("DE").build());

        lrb.keySet().forEach(System.out::println);

        final String s = lrb.getString("s");
        System.out.println(s);

        final Object l = lrb.getObject("l");
        System.out.println(l);

        final String[] sas = lrb.getStringArray("sa");
        System.out.println(Arrays.toString(sas));

        final Object l2 = lrb.handleGetObject("l");
        System.out.println(l2);

        Print.Delimitators.newLine();
    }

    void m3() {
        ResourceBundle rb = ResourceBundle.getBundle(location, new Locale("DE", "de"));
        Properties p = new Properties();

        rb.keySet().forEach(k -> p.put(k, rb.getObject(k)));

        p.forEach((k, v) -> System.out.println(k + " -> " + v));

        final String s = p.getProperty("s");
        System.out.println(s);

        final String s2 = p.getProperty("ne", "not existent");
        System.out.println(s2);

        final Object l = p.get("l");  //this methos comes from Hashtable
        System.out.println(l);

        final Object ne = p.getOrDefault("ne", "not existent");
        System.out.println(ne);

    }
}
