package oc.p._11.qs.enthuware.foundation_test._3._4;

class R {

    static void m(){
        if (true);
        System.out.println("if true");
//        else System.out.println("else");  //CE

        int i = 1;
        int j = 2;
        while (i<j)
        System.out.println("i: " + i++);

        System.out.println();

        for(int k =0; k<2; k++);
        System.out.println("k: ");
    }

    public static void main(String[] args) {
        m();
    }
}
