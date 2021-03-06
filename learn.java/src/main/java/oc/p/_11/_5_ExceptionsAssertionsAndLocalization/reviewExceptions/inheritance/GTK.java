package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewExceptions.inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;

import oc.p._11._2.Annotations.Inheritance;

class GTK {

    @Inheritance(
            base = IOException.class,
            childs = {
                    FileNotFoundException.class,
                    NotSerializableException.class})
    void checked() {
    }

    @Inheritance(
            base = IllegalArgumentException.class,
            childs = {
                    NumberFormatException.class
            }
    )
    void unchecked(){

    }
}
