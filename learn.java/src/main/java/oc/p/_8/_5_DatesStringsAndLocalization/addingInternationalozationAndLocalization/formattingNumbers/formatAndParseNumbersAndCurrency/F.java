package oc.p._8._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.formattingNumbers.formatAndParseNumbersAndCurrency;

import java.text.NumberFormat;
import java.util.Locale;

class F {

    NumberFormat nf;
    Locale locale = Locale.getDefault();

    {
        nf = NumberFormat.getInstance();
        nf = NumberFormat.getInstance(locale);

        nf = NumberFormat.getNumberInstance();
        nf = NumberFormat.getNumberInstance(locale);

        nf = NumberFormat.getCurrencyInstance();
        nf = NumberFormat.getCurrencyInstance(locale);

        nf = NumberFormat.getPercentInstance();
        nf = NumberFormat.getPercentInstance(locale);
    }
}
