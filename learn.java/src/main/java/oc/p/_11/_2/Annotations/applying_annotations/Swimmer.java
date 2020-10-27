package oc.p._11._2.Annotations.applying_annotations;

import oc.p._11._2.Annotations.POC;
import oc.p._11._2.Annotations.Rule;

@POC("mixing required and optional elements")
@Rule("All required values must be provided")
@interface Swimmer {
    int armLength = 10;
    String stroke();
    String name();
    String favoriteStrike() default "Backstroke";
}


@Swimmer(stroke = "stroke", name = "amphibian")
class Amphibian{

}

