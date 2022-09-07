package gtk.solid.liskov.vehicule.ok;

class Run {

    public static void main(String[] args) {
        Vehicule electricCar = new ElectricCar();
        Vehicule car = new Car();

        electricCar.start();

        car.start();
    }
}
