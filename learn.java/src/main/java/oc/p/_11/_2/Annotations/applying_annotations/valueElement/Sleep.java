package oc.p._11._2.Annotations.applying_annotations.valueElement;

@interface Sleep {
    int value();
    String hours();
}

@interface Wake{
    String hours();
}

@Sleep(value = 2, hours = "h")
@Wake(hours = "2")
class A{

}