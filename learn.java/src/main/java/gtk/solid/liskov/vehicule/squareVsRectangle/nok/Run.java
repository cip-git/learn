package gtk.solid.liskov.vehicule.squareVsRectangle.nok;

import org.junit.Assert;

public class Run {

    static void set(Rectangle r, int width){
        r.setWidth(width);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 20);
        Rectangle r2 = new Square(10);


        set(r, 100);
        set(r2, 100);

        Assert.assertEquals(r.area(), 10);
        Assert.assertEquals(r2.getHeight(), 10);
    }
}
