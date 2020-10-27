package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes.ex._22;


class C {

    public C(String s) {
        System.out.println( this.getClass().getSimpleName() + ": " + s);
    }
}
