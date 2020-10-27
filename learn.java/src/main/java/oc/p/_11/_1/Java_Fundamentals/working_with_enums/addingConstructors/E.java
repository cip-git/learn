package oc.p._11._1.Java_Fundamentals.working_with_enums.addingConstructors;

enum E {

    A(1){
        @Override
        int getSomeNb(int a) {
            return 0;
        }
    },
    B(2){
        @Override
        int getSomeNb(int a) {
            return 0;
        }
    },
    C(3){
        @Override
        int getSomeNb(int a) {
            return 0;
        }
    };

    final int nb;

    //implicitly private:
    E(int nb) {
        this.nb = nb;
    }

    abstract int getSomeNb(int a);
}
