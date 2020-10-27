package oc.p._8._1_AdvancedClassDesign.creatingNestedClasses.tw._1.innerClasses;

class O {
    int i = 0;
    int v = 4;

    void m() {
        System.out.println(i);
        System.out.println(new I().i);
        System.out.println(new I().new I2().i);
        System.out.println(new I().new I2().new I3().i);
    }

    class I {
        int i = 1;

        void m() {
            System.out.println(this.i);
            System.out.println(O.this.i);
            System.out.println(new I2().i);
            System.out.println(new I2().new I3().i);
        }

        class I2 {
            int i = 2;

            void m() {
                System.out.println(this.i);
                System.out.println(O.this.i);
                System.out.println(I.this.i);
                System.out.println(new I3().i);
                System.out.println(v);
            }

            class I3 {
                int i = 3;

                void m() {
                    System.out.println(this.i);
                    System.out.println(O.this.i);
                    System.out.println(I.this.i);
                    System.out.println(I2.this.i);
                }
            }
        }
    }
}

class R {
    public static void main(String[] args) {
//        new O().m();
//        new O().new I().m();
//        new O().new I(). new I2().m();
        new O().new I().new I2().new I3().m();
    }
}