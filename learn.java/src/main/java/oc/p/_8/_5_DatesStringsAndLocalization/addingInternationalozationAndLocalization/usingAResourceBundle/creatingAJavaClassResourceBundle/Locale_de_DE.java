package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle;

import java.util.ListResourceBundle;
import java.util.Locale;

/**
 * These classes which extend the ListResourceBundle need to be public classes
 */
public class Locale_de_DE extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] arr = new Object[3][];
        arr[0] = new Object[]{"s", this.getClass().getSimpleName()};  //getString("s")
        arr[1] = new Object[]{"l", Locale.GERMANY};  //getObject("c")
        arr[2] = new Object[]{"sa", new String[]{"this", "is", "a", "String"}};  //getStringArray("sa")

        return arr;
    }
}
