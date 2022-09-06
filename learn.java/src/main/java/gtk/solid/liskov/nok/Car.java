package gtk.solid.liskov.nok;

class Car implements Vehicule{

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void shift() {
        System.out.println("Car shifted");
    }
}
