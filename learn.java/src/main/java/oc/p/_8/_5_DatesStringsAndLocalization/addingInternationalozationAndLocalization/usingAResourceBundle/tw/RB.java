package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

class RB {

    static void rb(){
        ResourceBundle rb = null;


        /**
         * NPE if key null
         * MissingResourceException (RE) if no value for key
         */
        final String key = rb.getString("key");
        final String[] keys = rb.getStringArray("key");
        final Object object = rb.getObject("key");

        final Enumeration<String> enumeration = rb.getKeys();
        final Set<String> strings = rb.keySet();

        final boolean containsKey = rb.containsKey("key");

        final String baseBundleName = rb.getBaseBundleName();
        final Locale locale = rb.getLocale();

        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        final Iterator<String> iterator = enumeration.asIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        iterator.forEachRemaining(System.out::println);
    }

    static void lrb(){
        ListResourceBundle lrb = null;

        /**
         * NPE if key null
         * null if no value for key
         */
        final Object object = lrb.handleGetObject("key");
    }

    static void prb(){
        PropertyResourceBundle prb = null;

        /**
         * NPE if key null
         * null if no value for key
         */
        final Object object = prb.handleGetObject("key");
    }

    static void props(){
        Properties p = null;

        Object key=null;

        //null if no value found
        final String property = p.getProperty("key");
        final String property2 = p.getProperty("key", "default");

        //null if no value found
        final Object o = p.get(key);
        final Object object2 = p.getOrDefault(key, new Object());
    }
}
