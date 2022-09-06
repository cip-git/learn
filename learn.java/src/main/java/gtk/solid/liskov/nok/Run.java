package gtk.solid.liskov.nok;

class Run {

    public static void main(String[] args) {
        Vehicule electricCar = new ElectricCar();
        Vehicule car = new Car();

        electricCar.start();
        electricCar.shift();

        car.start();
        car.shift();
    }
}
