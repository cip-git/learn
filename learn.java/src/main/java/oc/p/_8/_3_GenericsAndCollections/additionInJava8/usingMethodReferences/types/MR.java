package oc.p._8._3_GenericsAndCollections.additionInJava8.usingMethodReferences.types;

class MR {

    private String mr;

    public MR(String mr) {
        this.mr = mr;
    }

    public MR() {
    }

    static void sm(StaticMethods.A sma) {
    }

    boolean instanceMethodOnAParticularInstance(String s) {
        return mr.contains(s);
    }

    boolean instanceMethodOnInstanceToBeDeterminedAtRuntime() {
        return true;
    }
}
