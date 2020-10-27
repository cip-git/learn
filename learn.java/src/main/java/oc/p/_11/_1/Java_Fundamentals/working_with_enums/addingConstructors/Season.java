package oc.p._11._1.Java_Fundamentals.working_with_enums.addingConstructors;

enum Season {

    WINTER("Low"),
    SPRING("Medium"),
    SUMMER("High"),
    FALL("Medium");

    private final String expectedVisitors;


    /**
     * All enum constructors are implicitly private, with the modifier being optional.
     */
    /*private*/ Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}


