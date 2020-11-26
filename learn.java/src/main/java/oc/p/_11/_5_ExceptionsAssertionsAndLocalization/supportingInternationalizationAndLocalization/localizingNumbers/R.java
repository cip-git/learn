package oc.p._11._5_ExceptionsAssertionsAndLocalization.supportingInternationalizationAndLocalization.localizingNumbers;

import java.text.NumberFormat;
import java.util.Locale;

class R {

    static Locale locale =  Locale.getDefault();

    static void generalPurpose(){

        final NumberFormat instance = NumberFormat.getInstance();
        final NumberFormat instance2 = NumberFormat.getInstance(locale);
    }

    static void number(){
        final NumberFormat numberFormat = NumberFormat.getNumberInstance();
        final NumberFormat numberFormat2 = NumberFormat.getNumberInstance(locale);
    }

    static void monetaryAmounts(){
        NumberFormat.getCurrencyInstance();
        NumberFormat.getCurrencyInstance(locale);
    }

    static void percentages(){
        NumberFormat.getPercentInstance();
        NumberFormat.getPercentInstance(locale);
    }

    static void roundsDecimalValuesBeforeDisplaying(){
        NumberFormat.getIntegerInstance();
        NumberFormat.getIntegerInstance(locale);
    }
}
