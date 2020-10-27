package oc.p._11._2.Annotations.creating_custom_annotations;

import oc.p._11._2.Annotations.POC;

@POC("adding a constant value")
@interface ElectricitySource {

    int voltage();

    int MIN_VOLTAGE = 2;

    public  static final int MAX_VOLTAGE = 18;
}

@ElectricitySource(voltage = ElectricitySource.MAX_VOLTAGE)
class Charger{

}
