package oc.p._11._2.Annotations.creating_custom_annotations;

@interface ApplyingElementModifier {

}

@interface Fluffy{
    int cuteness();

    public abstract int softness() default 11;

//    protected Material material();  //CE

//    private String frindly ();  //CE

//    final boolean isBunny();  //CE

}

enum Material{

}
