package concepts.cloneable;

class A implements Cloneable{

    private int i;
    private String s;

    public A(int i, String s) {
        this.i = i;
        this.s = s;
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1, "s");
        System.out.println(a);
        final Object clone = a.clone();
        a.s = "7";

        A a2 = (A)clone;
        System.out.println(a2);
    }
}
