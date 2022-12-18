package iq;

public class R {

    public static void main(String[] args) {

        String a = "";
        for(int i = 0; i < 100000; i++) {
            a = a + i;
        }
        System.out.println(a);


    }
}
