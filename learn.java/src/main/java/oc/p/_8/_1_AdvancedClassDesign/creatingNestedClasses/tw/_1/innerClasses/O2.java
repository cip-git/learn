package oc.p._8._1_AdvancedClassDesign.creatingNestedClasses.tw._1.innerClasses;

class O2 {

    static int i = 0;

    static void m(){
        System.out.println(i);
        System.out.println(S.i);
        System.out.println(S.S2.i);
        System.out.println(S.S2.S3.i);
    }

    static class S{
        static int i = 1;

        static void m(){
            System.out.println(i);
            System.out.println(O2.i);
            System.out.println(S2.i);
            System.out.println(S2.S3.i);
        }

        static class S2{
            static int i = 2;

            static void m(){
                System.out.println(i);
                System.out.println(O2.i);
                System.out.println(S.i);
                System.out.println(S3.i);
            }

            static class S3{
                static void m(){
                    System.out.println(i);
                    System.out.println(O2.i);
                    System.out.println(S.i);
                    System.out.println(S2.i);
                }

                static int i = 3;
            }
        }
    }

    public static void main(String[] args) {
//        m();
//        S.m();
//        S.S2.m();
        S.S2.S3.m();
    }
}
