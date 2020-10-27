package tw;

class D {
    static void m(){
        String s = "com.ibm.ega.consent.api";
        s = s.replace('.', '/');
        System.out.println(s);

    }

    public static void main(String[] args) {
        m();
    }
}
