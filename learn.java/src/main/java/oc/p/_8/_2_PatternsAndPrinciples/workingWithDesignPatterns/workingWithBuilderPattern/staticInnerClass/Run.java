package oc.p._8._2_PatternsAndPrinciples.workingWithDesignPatterns.workingWithBuilderPattern.staticInnerClass;

class Run {

    public static void main(String[] args) {
//        Pizza test = new Pizza ();  //compiler error: the constructor is private
        Pizza p = new Pizza.PizzaBuilder ( "dbType", 2 ).sauce ( "sauce" ).extracheese ( true ).extraMeet ( true ).build ( );
    }
}
