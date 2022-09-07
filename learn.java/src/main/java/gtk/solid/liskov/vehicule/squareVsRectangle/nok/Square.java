package gtk.solid.liskov.vehicule.squareVsRectangle.nok;

class Square  extends Rectangle{

    public Square(int l) {
        super(l, l);
    }

    @Override
    public void setHeight(int l) {
        super.setHeight(l);
        super.setHeight(l);
    }

    @Override
    public void setWidth(int l) {
        super.setHeight(l);
        super.setHeight(l);
    }

}
