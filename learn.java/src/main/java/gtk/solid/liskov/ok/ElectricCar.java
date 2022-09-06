package gtk.solid.liskov.ok;

class ElectricCar implements ElectricVehicule{

    @Override
    public void start() {
        System.out.println("Electric catr started");
    }
}
