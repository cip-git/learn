package oc.p._8._1_AdvancedClassDesign.creatingNestedClasses.tw._1;

class LIC {

    int n = 10;
    {
        n = 100;
    }

    void m(){
        int lic = 1;

        class A{
            int a;

            A(final int a) {
                this.a = a;
            }

            void m(){

                class B{
                    int b;

                    B(final int b) {
                        this.b = b;
                    }

                    void m(){
                        System.out.println(b + a + lic + LIC.this.n);
                    }
                }

                new B(3).m();
            }
        }
        new A(2).m();
    }

    public static void main(String[] args) {
        new LIC().m();
    }
}
