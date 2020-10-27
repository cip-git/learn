package oc.p._11._2.Annotations.creating_custom_annotations.rmb;

import java.util.concurrent.TimeUnit;

class SwitchStmt {

    static void primitives(int i){
        switch (i){
        }
    }

    static void wrapper(Integer i){
        switch (i){

        }
    }

    static void string(String s){
        switch (s){
        }
    }

    static void enums(TimeUnit tu){
        switch (tu){}
    }


    static void clazz(Class c){
//        switch (c){ }  //CE: incompatible type
    }


    public static void main(String[] args) {
        primitives(23);
        System.out.println("done");
    }
}
