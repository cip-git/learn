package gtk.solid.liskov.ok;

class Car implements CombustionEngineVehicule{

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void shift() {
        System.out.println("Shift");
    }
}
