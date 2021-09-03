package tw;

class R {


    static void m() {
        boolean a = false;
        boolean b = true;

        for (int i = 0; i < 5; i++) {
            if (a) {
                System.out.println("a");
                return;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (b) {
                System.out.println("b");
                return;
            }
        }

        System.out.println("after");
    }

    public static void main(String[] args) {
        m();
    }
}
