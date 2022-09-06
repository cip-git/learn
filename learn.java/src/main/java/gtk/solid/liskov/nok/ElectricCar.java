package gtk.solid.liskov.nok;

class ElectricCar implements Vehicule{

    @Override
    public void start() {
        System.out.println("Electric car started");
    }

    @Override
    public void shift() {
        throw new RuntimeException("Electric cars don't have gears");
    }
}
