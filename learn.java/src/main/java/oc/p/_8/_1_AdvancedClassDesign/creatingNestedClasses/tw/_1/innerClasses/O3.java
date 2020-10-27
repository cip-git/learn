package oc.p._8._1_AdvancedClassDesign.creatingNestedClasses.tw._1.innerClasses;

class O3 {
    int o3 = 0;

    void m() {
        System.out.println(o3);
        System.out.println(new I().i);
        System.out.println(new I().new I2().i2);
        System.out.println(new I().new I2().new I3().i3);
    }

    class I {
        int i = 1;

        void m() {
            System.out.println(o3);
            System.out.println(O3.this.o3);

            System.out.println(i);
            System.out.println(I.this.i);
            System.out.println(this.i);

            System.out.println(new I2().i2);
            System.out.println(new I2().new I3().i3);
        }

        class I2 {
            int i2 = 2;

            void m() {
                System.out.println(o3);
                System.out.println(O3.this.o3);

                System.out.println(i);
                System.out.println(I.this.i);

                System.out.println(i2);
                System.out.println(I2.this.i2);
            }

            class I3 {
                int i3 = 3;

                void m() {
                    System.out.println(o3);
                    System.out.println(O3.this.o3);

                    System.out.println(I.this.i);
                    System.out.println(i);

                    System.out.println(I2.this.i2);
                    System.out.println(i2);

                    System.out.println(I3.this.i3);
                    System.out.println(i3);
                    System.out.println(this.i3);
                }
            }
        }
    }
}
