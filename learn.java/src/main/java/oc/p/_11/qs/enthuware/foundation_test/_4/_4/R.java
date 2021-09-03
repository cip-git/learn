package oc.p._11.qs.enthuware.foundation_test._4._4;

interface House {

    public default String getAddress() {
        return "101 Main Str";
    }
}

interface Bungalow extends House {

    public default String getAddress() {
        return "101 Smart Str";
    }
}

class MyHouse implements Bungalow, House {

}

class R {
    public static void main(String[] args) {
        House ci = new MyHouse();
        System.out.println(ci.getAddress());
    }
}
