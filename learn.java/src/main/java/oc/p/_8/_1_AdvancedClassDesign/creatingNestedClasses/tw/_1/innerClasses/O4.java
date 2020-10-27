package oc.p._8._1_AdvancedClassDesign.creatingNestedClasses.tw._1.innerClasses;

class O4 {

    static int o4 = 0;

    static void m(){
        System.out.println(o4);
        System.out.println(O4.o4);

        System.out.println(S.s);
        System.out.println(O4.S.s);

        System.out.println(S.S2.s2);
        System.out.println(O4.S.S2.s2);

        System.out.println(S.S2.S3.s3);
    }

    static class S{
        static int s = 1;

        static void m(){
            System.out.println(o4);
        }

        static class S2{
            static void m(){
                System.out.println(o4);
                System.out.println(s);
                System.out.println(s2);
                System.out.println(S3.s3);
            }

            static int s2 = 2;

            static class S3{

                static void m(){
                    System.out.println(o4);
                    System.out.println(s);
                    System.out.println(s2);
                    System.out.println(s3);
                }

                static int s3 = 3;
            }
        }
    }

    public static void main(String[] args) {
        S.S2.S3.m();
    }
}
